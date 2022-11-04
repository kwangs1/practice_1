package com.myspring.Art.common.Rating.Service;

import com.myspring.Art.common.Rating.VO.RatingVO;

public interface RatingService {

	int RatingCheck(RatingVO rating) throws Exception;

	double ratingAvg();

	int findRating(int rating_type);
}
