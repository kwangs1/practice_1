package com.myspring.Art.Collectible.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Art.Collectible.Service.CollectibleService;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.base.BaseController;

@Controller("collectibleController")
@RequestMapping(value="/collectible")
public class CollectibleControllerImpl extends BaseController implements CollectibleController{
	@Autowired
	private CollectibleService collectibleService;
	@Autowired
	private CollectibleVO collectibleVO;
	
	@Override
	@RequestMapping(value="/collectibleList.do", method= RequestMethod.GET)
	public ModelAndView collectibleList(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = getViewName(request);
		
		List collectibleList = collectibleService.collectibleList();
		ModelAndView mav = new ModelAndView(viewName);
		
		mav.addObject("collectibleList",collectibleList);
		return mav;		
	}
	
	@Override
	@RequestMapping(value="collectibleDetail.do", method=RequestMethod.GET)
	public ModelAndView collectibleDetail(@RequestParam("goods_id") int goods_id, 
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName=(String)request.getAttribute("viewName");
		collectibleVO = collectibleService.collectibleDetail(goods_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("collectible",collectibleVO);
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
}
