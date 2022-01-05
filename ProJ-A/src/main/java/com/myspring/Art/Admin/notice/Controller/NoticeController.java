package com.myspring.Art.Admin.notice.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface NoticeController {

	ModelAndView noticeList(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
