package com.myspring.Art.Admin.notice.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Art.Admin.notice.VO.NoticeVO;

public interface NoticeController {

	ModelAndView NoticeList(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView addNewNotice(NoticeVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView NoticeDetail(int bno, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
