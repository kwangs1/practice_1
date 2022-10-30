package com.myspring.Art.Member.Controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.Member.Service.MemberService;
import com.myspring.Art.Member.VO.MemberVO;
import com.myspring.Art.common.base.BaseController;

@Controller("memberController")
@RequestMapping(value ="/member")
public class MemberControllerImpl extends BaseController implements MemberController{
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;

	
	//로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute MemberVO memberVO,RedirectAttributes rAttr,
			HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = req.getSession();
		MemberVO vo = memberService.login(memberVO);		
		
		if(vo != null) {
			session.setAttribute("memberInfo", vo);
			mav.setViewName("redirect:/main/main.do");
		}else {
			rttr.addFlashAttribute("result",0); 
			mav.setViewName("redirect:/member/loginForm.do");
		}
		return mav;
	}
	
	//로그아웃
	@Override
	@RequestMapping(value = "/logout.do", method =  RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		logger.info("bye logout success");

		return "redirect:/main/main.do";
	}
	
	//회원가입
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
	

	//id 중복검사
	@RequestMapping(value="IdCheck.do" , method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChk(String id)throws Exception{
		/* logger.info("진입"); */
		
		int result = memberService.idCheck(id); // memberService.idCheck의 결과를 int형 변수 result에 저장
		if(result != 0) { //id가 존재하면 '1' , 존재하지 않으면 '0' 반환
			return "fail";
		}else {
			return "success";
		}
	}
	
	//회원정보 페이지
	@RequestMapping(value="/memberInfo.do" ,method = RequestMethod.GET)
	public ModelAndView membefInfo(@RequestParam String member_id,
			HttpServletRequest request, HttpServletResponse response)throws Exception{	
		
		String viewName = (String)request.getAttribute("viewName");		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		memberService.selectMemberInfo(member_id);
		
		return mav;
	}
	
	//수정
	@RequestMapping(value="/MemberModify.do" , method = RequestMethod.POST)
	public ModelAndView MemberModify(@RequestParam String member_id,@ModelAttribute MemberVO memberVO,
			HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/memberInfo.do?member_id=" + memberVO.getMember_id());
		
		session.setAttribute("memberInfo", memberVO);		
		
		memberService.MemberModify(memberVO);
		
		return mav;
	}
	
	//modify(비번 post)
	@RequestMapping(value="/MemberModify_Pw.do" , method = RequestMethod.POST)
	public ModelAndView MemberModify_Pw(@RequestParam String member_id,
			@ModelAttribute MemberVO vo, HttpSession session)throws Exception{	
	
		memberService.MemberModify_Pw(vo);
		session.setAttribute("memberInfo", vo);
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/loginForm.do");
		
		return mav;
	}
}
