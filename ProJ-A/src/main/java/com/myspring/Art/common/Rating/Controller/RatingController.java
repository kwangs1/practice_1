package com.myspring.Art.common.Rating.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.Art.common.Rating.Service.RatingService;
import com.myspring.Art.common.Rating.VO.RatingVO;

@RestController
@RequestMapping(value="/rating")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	
	@RequestMapping(value = "/RatingCheck.do", method = RequestMethod.POST)
	public Map<String, Object> RatingCheck(@RequestBody RatingVO rating) throws Exception {
		Map<String, Object> result = new HashMap<>();

		try {
			ratingService.RatingCheck(rating);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "false");
		}

		return result;
	}
}
