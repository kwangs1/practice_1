package com.myspring.Art.Information;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("informationController")
@RequestMapping(value ="/information")
public class InformationController {
	@RequestMapping(value="/preview.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView information(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@RequestMapping(value="/navigator.do" , method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView navigator(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		String viewName =  (String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@RequestMapping(value="/grouptour.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView grouptour(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		return mav;
	}

}
