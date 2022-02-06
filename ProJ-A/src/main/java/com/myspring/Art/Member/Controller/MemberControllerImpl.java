package com.myspring.Art.Member.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Art.Member.Service.MemberService;
import com.myspring.Art.Member.VO.MemberVO;
import com.myspring.Art.common.base.BaseController;

@Controller("memberController")
@RequestMapping(value ="/member")
public class MemberControllerImpl extends BaseController implements MemberController{
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	
	@Override
	@RequestMapping(value="/login.do" ,method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> loginMap, //id, pw 를 map에 저장합니다
							HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(loginMap);//sql문으로 전달
		if(memberVO !=null && memberVO.getMember_id() != null) {
			//조회한 회원 정보를 가져와 isLogOn 속성을 true 설정하고 memberInfo 속성으로 회원 정보를 저장
			HttpSession session = request.getSession();
			session = request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("memberInfo", memberVO);
			
			String action=(String)session.getAttribute("action");
			if(action!=null && action.equals("/")) {
				mav.setViewName("redirect:" + action);
			}else {
				mav.setViewName("redirect:/main/main.do");
			}
		}else {
			String message = "아이디나 비밀번호가 틀립니다. 다시 로그인 해주세요";
			mav.addObject("message",message);
			mav.setViewName("/member/loginForm");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/logout.do", method =  RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		logger.info("bye logout success");

		return "redirect:/main/main.do";
	}
	
	@Override
	@RequestMapping(value="/addMember.do" ,method = RequestMethod.POST)
	public ResponseEntity  addMember(@ModelAttribute("memberVO") MemberVO _memberVO,//회원 가입창에서 전송된 회원 정보를 _memberVO에 설정
			                HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
		    memberService.addMember(_memberVO);//회원정보를 sql문으로 전달
		    message  = "<script>";	
		    message +=" alert('회원 가입을 마쳤습니다.로그인창으로 이동합니다.');";
		    message += " location.href='"+request.getContextPath()+"/member/loginForm.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/member/memberForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	@Override
	@RequestMapping(value= "/overlapped.do", method = RequestMethod.POST)
	public ResponseEntity overlapped(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		String result = memberService.overlapped(id); //id중복검사
		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	
	@RequestMapping(value="/memberInfo.do" ,method = RequestMethod.GET)
	public ModelAndView membefInfo(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		memberVO = memberService.memberInfo();
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("memberInfo",memberVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/modifyMyInfo.do", method= RequestMethod.POST)
	public ResponseEntity modifyMyInfo(@RequestParam("attribute")String attribute, @RequestParam("value")String value,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Map<String,String> memberMap = new HashMap<String,String>();
		String val[]=  null;
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("memberInfo");
		String member_id = memberVO.getMember_id();
		if(attribute.equals("member_birth")) {
			val = value.split(",");
			memberMap.put("member_birth_y", val[0]);
			memberMap.put("member_birth_y", val[1]);
			memberMap.put("member_birth_y", val[2]);
			memberMap.put("member_birth_gn", val[3]);
		}else if(attribute.equals("tel")) {
			val = value.split(",");
			memberMap.put("tel1", val[0]);
			memberMap.put("tel2", val[1]);
			memberMap.put("tel3", val[2]);
		}else if(attribute.equals("hp")) {
			val=value.split(",");
			memberMap.put("hp1",val[0]);
			memberMap.put("hp2",val[1]);
			memberMap.put("hp3",val[2]);
			memberMap.put("smssts_yn", val[3]);
		}else if(attribute.equals("email")) {
			val=value.split(",");
			memberMap.put("email1",val[0]);
			memberMap.put("email2",val[1]);
			memberMap.put("emailsts_yn", val[2]);
		}else if(attribute.equals("address")) {
			val=value.split(",");
			memberMap.put("zipcode",val[0]);
			memberMap.put("roadAddress",val[1]);
			memberMap.put("jibunAddress", val[2]);
			memberMap.put("namujiAddress", val[3]);
		}else {
			memberMap.put(attribute, value);
		}
		memberMap.put("member_id",member_id);
		
		memberVO = (MemberVO)memberService.modifyMyInfo(memberMap);
		session.removeAttribute("memberInfo");
		session.setAttribute("memberInfo", memberVO);
		
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		message = "mod_success";
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	@Override
	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

}
