package com.myspring.Art.Admin.notice.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.Admin.notice.VO.NoticeVO;
import com.myspring.Art.common.domain.Criteria;
import com.myspring.Art.common.domain.SearchCriteria;

public interface NoticeController {

	ModelAndView addNewNotice(NoticeVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView NoticeDetail(int bno, SearchCriteria scri,HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView removerNotice(int bno, SearchCriteria scri, RedirectAttributes redAttr,HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView modifyNotice(NoticeVO vo, SearchCriteria scri,RedirectAttributes redAttr,HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView NoticeList(SearchCriteria scri,  HttpServletRequest request, HttpServletResponse response) throws Exception;
}
