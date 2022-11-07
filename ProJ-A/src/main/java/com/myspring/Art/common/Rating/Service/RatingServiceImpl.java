package com.myspring.Art.common.Rating.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Art.common.Rating.DAO.RatingDAO;
import com.myspring.Art.common.Rating.VO.RatingVO;

@Service("ratingService")
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingDAO ratingDAO;
	
	@Override
	public double ratingAvg() {
		Double ratingAvg = ratingDAO.ratingAvg();
		if(ratingAvg == null) {
			ratingAvg = 0.0;
		}
		
		ratingAvg = (double)(Math.round(ratingAvg*10));
		ratingAvg = ratingAvg/10;
		return ratingAvg;
	}
	
	@Override
	public void RatingCheck(RatingVO rating)throws Exception{
		
		ratingDAO.RatingCheck(rating);
	}	
	
	@Override
	public int getRating(int rating_type) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rating_type", rating_type);
		
		return ratingDAO.getRating(map);
	}
	
	@Override
	public int findRating(int rating_type,String member_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rating_type", rating_type);
		map.put("member_id", member_id);
		
		return ratingDAO.findRating(map);
	}
}
