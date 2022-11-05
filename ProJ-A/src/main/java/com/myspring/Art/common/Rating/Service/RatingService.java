package com.myspring.Art.common.Rating.Service;

import com.myspring.Art.common.Rating.VO.RatingVO;

public interface RatingService {

	double ratingAvg();

	int getRating(int rating_type);

	int findRating(int rating_type,String id);

	int RatingCheck(RatingVO rating) throws Exception;

}
