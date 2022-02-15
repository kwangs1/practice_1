package com.myspring.Art.common.Rating.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.Member.VO.MemberVO;
import com.myspring.Art.common.Rating.Service.RatingService;
import com.myspring.Art.common.Rating.VO.RatingVO;
import com.myspring.Art.common.base.BaseController;

@Controller("ratingController")
@RequestMapping(value="/rating")
public class RatingControllerImpl extends BaseController implements RatingController{
	private static final Logger logger = LoggerFactory.getLogger(RatingControllerImpl.class);
	@Autowired
	private RatingService ratingService;
	
	@Override
	@RequestMapping(value="/ratingWrite.do", method=RequestMethod.POST)
	public ModelAndView ratingWrite(@ModelAttribute("rating")RatingVO vo,
			RedirectAttributes rttr,HttpServletRequest request, HttpServletResponse response)throws Exception {
		ratingService.writeRating(vo);	
				
		rttr.addAttribute("goods_id", vo.getGoods_id());
		
		ModelAndView mav = new ModelAndView("redirect:/collectible/collectibleDetail.do");
		return mav;
	}
	

}
