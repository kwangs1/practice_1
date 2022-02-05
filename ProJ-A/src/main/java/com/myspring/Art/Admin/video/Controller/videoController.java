package com.myspring.Art.Admin.video.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.Admin.video.VO.videoVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface videoController {

	ModelAndView adminVideoMain(SearchCriteria scri, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView adminVideoDetail(int vno, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView createAction(videoVO videoVO, MultipartHttpServletRequest multiRequest, BindingResult bindingResult)
			throws Exception;

	ModelAndView VideoList(SearchCriteria scri, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView removeVideo(int vno, SearchCriteria scri, RedirectAttributes redAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	ModelAndView modifyVideo(videoVO vo, SearchCriteria scri, RedirectAttributes redAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
