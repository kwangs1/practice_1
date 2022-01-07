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
	@RequestMapping(value="/collectibleList.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView collectible(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		Map<String, List<CollectibleVO>> collectibleMap = collectibleService.listCollectible();
		mav.addObject("collectibleMap",collectibleMap);
		return mav;
	}
	
	@Override
	@RequestMapping(value ="/collectibleDetail.do" , method= RequestMethod.GET)
	public ModelAndView collectibleDetail(@RequestParam("goods_id") String goods_id,
            HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String viewName=(String)request.getAttribute("viewName");
		Map collectibleMap=collectibleService.collectibleDetail(goods_id);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("collectible", collectibleMap);
		return mav;
	}
}
