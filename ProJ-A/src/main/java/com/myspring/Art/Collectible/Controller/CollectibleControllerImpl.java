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
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Art.Collectible.Service.CollectibleService;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.base.BaseController;

@Controller("collectibleController")
@RequestMapping(value="/collectible")
public class CollectibleControllerImpl extends BaseController implements CollectibleController{
	@Autowired
	private CollectibleService collectibleService;
	
	@RequestMapping(value="/collectible.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView collectible(HttpServletRequest request, HttpServletResponse response)throws Exception{
		HttpSession session;
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		Map<String, List<CollectibleVO>> goodsMap = collectibleService.listGoods();
		mav.addObject("goodsMap",goodsMap);
		return mav;
	}
}
