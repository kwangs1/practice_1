package com.myspring.Art.Collectible.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface CollectibleController {

	ModelAndView collectibleDetail(int goods_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView collectibleList(Map<String, String> dateMap, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}
