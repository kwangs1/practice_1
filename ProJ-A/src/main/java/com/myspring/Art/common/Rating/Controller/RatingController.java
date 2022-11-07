package com.myspring.Art.common.Rating.Controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Art.common.Rating.Service.RatingService;
import com.myspring.Art.common.Rating.VO.RatingVO;
import com.myspring.Art.common.base.BaseController;

@RestController
@RequestMapping(value="/rating")
public class RatingController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(RatingController.class);
	@Autowired
	private RatingService ratingService;
	
	@RequestMapping(value = "/RatingCheck.do", method = RequestMethod.POST)
	public Map<String, Object> RatingCheck(RatingVO rating) throws Exception {
		Map<String, Object> result = new HashMap<>();
		ModelAndView mav = new ModelAndView();
		try {
			rating.setRating_type(1);
			ratingService.RatingCheck(rating);
			logger.info("평가 데이터 :" + rating.getBrno() + "\\" + rating.getMember_id() +"\\"+ rating.getRating() +"\\"+
					rating.getRating_type());

			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "false");
		}

		return result;
	}
}
