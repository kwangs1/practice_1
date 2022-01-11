package com.myspring.Art.Collectible.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface CollectibleController {
	ModelAndView collectibleList(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView collectibleDetail(int goods_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}
