package com.myspring.Art.Admin.video.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Art.common.domain.SearchCriteria;

public interface videoController {

	ResponseEntity addNewVideo(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;

	ModelAndView adminVideoMain(SearchCriteria scri, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}
