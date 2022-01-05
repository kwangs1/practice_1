package com.myspring.Art.Admin.notice.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Art.Admin.notice.Service.NoticeService;
import com.myspring.Art.Admin.notice.VO.NoticeVO;


@RequestMapping(value="/admin/notice")
@Controller("noticeController")
public class NoticeControllerImpl implements NoticeController{
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	@Autowired
	private NoticeService noticeService;

	@Override
	@RequestMapping(value= "/noticeList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView noticeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List noticeList = noticeService.NoticeList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("noticeList", noticeList);
		return mav;
		
	}
	
	// 게시판 글 작성 화면
	@RequestMapping(value = "/writeView.do", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
		
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String write(NoticeVO noticeVO) throws Exception{
		logger.info("write");
		
		noticeService.write(noticeVO);
		
		return "redirect:/";
	}
}
