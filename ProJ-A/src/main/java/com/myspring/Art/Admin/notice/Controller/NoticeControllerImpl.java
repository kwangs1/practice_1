package com.myspring.Art.Admin.notice.Controller;

import java.util.List;
import java.util.Map;

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
import com.myspring.Art.common.domain.Criteria;
import com.myspring.Art.common.domain.PageMaker;
import com.myspring.Art.common.domain.SearchCriteria;



@RequestMapping(value="/admin/notice")
@Controller("noticeController")
public class NoticeControllerImpl extends BaseController implements NoticeController{
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private NoticeVO noticeVO;
	
	//글 목록
	@Override
	@RequestMapping(value="/noticeList.do", method = RequestMethod.GET)
	public ModelAndView NoticeList(@ModelAttribute("scri") SearchCriteria scri,HttpServletRequest request, HttpServletResponse response)throws Exception{
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
	public ModelAndView NoticeDetail(@RequestParam("bno") int bno, Criteria cri,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName=(String)request.getAttribute("viewName");
		noticeVO = noticeService.NoticeDetail(bno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("notice",noticeVO);
		mav.addObject("cri",cri);
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
	public ModelAndView removerNotice(@RequestParam("bno")int bno,Criteria cri, RedirectAttributes redAttr,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		noticeService.removeNotice(bno);
		ModelAndView mav = new ModelAndView("redirect:/admin/notice/noticeList.do");
		redAttr.addAttribute("page", cri.getPage());
	     redAttr.addAttribute("perPagNum", cri.getPerPageNum());
		return mav;
	}
	//수정뷰 가기
	@RequestMapping(value="/modifyNoticeForm.do", method = RequestMethod.GET)
		public ModelAndView modifyNotice(@RequestParam("bno") int bno,Criteria cri,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName=(String)request.getAttribute("viewName");
		noticeVO = noticeService.NoticeDetail(bno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("notice",noticeVO);
		
		mav.addObject("cri", cri);
		return mav;
	}
	//수정 데이터부분
	@Override
	@RequestMapping(value="/modifyNotice.do", method=RequestMethod.POST)
	public ModelAndView modifyNotice(@ModelAttribute("notice")NoticeVO vo, Criteria cri, RedirectAttributes redAttr,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = noticeService.modifyNotice(vo);
		ModelAndView mav = new ModelAndView("redirect:/admin/notice/noticeList.do");
		
		 redAttr.addAttribute("page", cri.getPage());
	     redAttr.addAttribute("perPagNum", cri.getPerPageNum());

		return mav;
	}
}
