package com.myspring.Art.common.Rating.Service;

import java.util.List;

import com.myspring.Art.common.Rating.VO.RatingVO;

public interface RatingService {

	void writeRating(RatingVO vo) throws Exception;

	List<RatingVO> selectRating(int goods_id) throws Exception;
}
