package com.myspring.Art.Admin.notice.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Art.Admin.notice.Service.NoticeService;
import com.myspring.Art.Admin.notice.VO.NoticeVO;


@RequestMapping(value="/admin/notice")
@Controller("noticeController")
public class NoticeControllerImpl implements NoticeController{
	private static final Logger logger = LoggerFactory.getLogger(NoticeControllerImpl.class);
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private NoticeVO noticeVO;
	
	@Override//목록
	@RequestMapping(value="/noticeList.do", method = RequestMethod.GET)
	public ModelAndView NoticeList(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = getViewName(request);		
		
		List NoticeList = noticeService.NoticeList();
		ModelAndView mav = new ModelAndView(viewName);
		
		mav.addObject("NoticeList",NoticeList);
		return mav;		
	}
	@Override//상세보기
	@RequestMapping(value="NoticeDetail.do", method=RequestMethod.GET)
	public ModelAndView NoticeDetail(@RequestParam("bno") int bno, 
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName=(String)request.getAttribute("viewName");
		noticeVO = noticeService.NoticeDetail(bno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("notice",noticeVO);
		return mav;
	}
	
	@Override//등록뷰에서 데이터넣기
	@RequestMapping(value="/addNewNotice.do", method = RequestMethod.POST)
	public ModelAndView addNewNotice(@ModelAttribute("Notice")NoticeVO vo, HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = noticeService.addNewNotice(vo);
		ModelAndView mav = new ModelAndView("redirect:/admin/notice/noticeList.do");
		return mav;
	}
	@RequestMapping(value="/addNewNoticeForm.do", method = RequestMethod.GET)//등록뷰 가기
	public ModelAndView addNewNotice(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}
	
	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
}
