package com.myspring.Art.common.Rating.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.Rating.VO.RatingVO;

public interface RatingController {


	ModelAndView ratingWrite(RatingVO vo, RedirectAttributes rttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

}
