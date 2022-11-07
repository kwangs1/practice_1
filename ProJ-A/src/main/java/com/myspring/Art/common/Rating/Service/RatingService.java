package com.myspring.Art.common.Rating.Service;

import com.myspring.Art.common.Rating.VO.RatingVO;

public interface RatingService {

	double ratingAvg();

	int getRating(int rating_type);

	void RatingCheck(RatingVO rating) throws Exception;

	int findRating(int rating_type, String member_id);

}
