package com.myspring.Art.Admin.notice.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.myspring.Art.Admin.notice.Service.NoticeService;
import com.myspring.Art.Admin.notice.VO.NoticeVO;
import com.myspring.Art.common.base.BaseController;
import com.myspring.Art.common.domain.PageMaker;
import com.myspring.Art.common.domain.SearchCriteria;



@RequestMapping(value="/admin/notice")
@Controller("noticeController")
public class NoticeControllerImpl extends BaseController implements NoticeController{
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private NoticeVO noticeVO;

	
	//게시글 목록
	@Override
	@RequestMapping(value="/noticeList.do", method = RequestMethod.GET)
	public ModelAndView NoticeList(@ModelAttribute("scri") SearchCriteria scri,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(noticeService.countNoticeListTotal(scri));
		
		String viewName = getViewName(request);		
		List<Map<String,Object>>list = noticeService.NoticeList(scri);
		ModelAndView mav = new ModelAndView(viewName);
		
		mav.addObject("list",list);
		mav.addObject("pageMaker",pageMaker);

		return mav;		
	}
	//글 상세보기
	@Override
	@RequestMapping(value="NoticeDetail.do", method=RequestMethod.GET)
	public ModelAndView NoticeDetail(@RequestParam("bno") int bno,@ModelAttribute("scri") SearchCriteria scri,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName=(String)request.getAttribute("viewName");
		noticeVO = noticeService.NoticeDetail(bno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("notice",noticeVO);
		mav.addObject("scri",scri);
		
		int result = 0;
		
		
		//게시글 상세보기를 누를 때 마다 조회수가 올라가지 않기 위해 쿠키를 생성하여 조회수가 계속 올라가는것을 방지하고자 만듬.
		Cookie viewCookie=null;
		Cookie[] cookies=request.getCookies();

		System.out.println("cookie : "+cookies);
		
        
        if(cookies !=null) {

			for (int i = 0; i < cookies.length; i++) {
				//System.out.println("쿠키 이름 : "+cookies[i].getName());
                
                //만들어진 쿠키들을 확인하며, 만약 들어온 적 있다면 생성되었을 쿠키가 있는지 확인
				if(cookies[i].getName().equals("|"+bno+"|")) {
					System.out.println("if문 쿠키 이름 : "+cookies[i].getName());
				
                //찾은 쿠키를 변수에 저장
					viewCookie=cookies[i];
				}
			}
			
		}else {
			System.out.println("cookies 확인 로직 : 쿠키가 없습니다.");
		}


		//만들어진 쿠키가 없음을 확인
		if(viewCookie==null) {
        
          	System.out.println("viewCookie 확인 로직 : 쿠키 없습니다");
			
            try {
            
            	//이 페이지에 왔다는 증거용(?) 쿠키 생성
				Cookie newCookie=new Cookie("|"+bno+"|","readCount");
				response.addCookie(newCookie);
                
                //쿠키가 없으니 증가 로직 진행
				result =noticeService.boardHit(bno);
                
			} catch (Exception e) {
				System.out.println("쿠키 넣을때 오류 나나? : "+e.getMessage());
				e.getStackTrace();

			}
		
        //만들어진 쿠키가 있으면 증가로직 진행하지 않음
		}else {
			System.out.println("viewCookie 확인 로직 : 쿠키 있습니다");
			String value=viewCookie.getValue();
			System.out.println("viewCookie 확인 로직 : 쿠키 value : "+value);
		}
		return mav;
	}
	
	//등록뷰에서 데이터넣기
	@Override
	@RequestMapping(value="/addNewNotice.do", method = RequestMethod.POST)
	public ModelAndView addNewNotice(@ModelAttribute("Notice")NoticeVO vo, HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = noticeService.addNewNotice(vo);
		ModelAndView mav = new ModelAndView("redirect:/admin/notice/noticeList.do");
		return mav;
	}
	//등록뷰 가기
	@RequestMapping(value="/addNewNoticeForm.do", method = RequestMethod.GET)
	public ModelAndView addNewNotice(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		return mav;
	}
	
	//글 삭제
	@Override
	@RequestMapping(value="/removeNotice.do", method=RequestMethod.GET)
	public ModelAndView removerNotice(@RequestParam("bno")int bno,@ModelAttribute("scri") SearchCriteria scri, RedirectAttributes redAttr,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		noticeService.removeNotice(bno);
		
		redAttr.addAttribute("page", scri.getPage());
	    redAttr.addAttribute("perPagNum", scri.getPerPageNum());
	    redAttr.addAttribute("searchType",scri.getSearchType());
	    redAttr.addAttribute("keyword",scri.getKeyword());
	    
	    ModelAndView mav = new ModelAndView("redirect:/admin/notice/noticeList.do");
		return mav;
	}
	
	//수정뷰 가기
	@RequestMapping(value="/modifyNoticeForm.do", method = RequestMethod.GET)
		public ModelAndView modifyNotice(@RequestParam("bno") int bno,@ModelAttribute("scri") SearchCriteria scri,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName=(String)request.getAttribute("viewName");
		noticeVO = noticeService.NoticeDetail(bno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("notice",noticeVO);
		
		mav.addObject("scri", scri);
		return mav;
	}
	
	//수정 데이터부분
	@Override
	@RequestMapping(value="/modifyNotice.do", method=RequestMethod.POST)
	public ModelAndView modifyNotice(@ModelAttribute("notice")NoticeVO vo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes redAttr,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = noticeService.modifyNotice(vo);
		ModelAndView mav = new ModelAndView("redirect:/admin/notice/noticeList.do");
		
		redAttr.addAttribute("page", scri.getPage());
	    redAttr.addAttribute("perPagNum", scri.getPerPageNum());
	    redAttr.addAttribute("searchType",scri.getSearchType());
	    redAttr.addAttribute("keyword",scri.getKeyword());

		return mav;
	}
}
