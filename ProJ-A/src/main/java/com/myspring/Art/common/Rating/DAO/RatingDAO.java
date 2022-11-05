package com.myspring.Art.common.Rating.DAO;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.common.Rating.VO.RatingVO;

public interface RatingDAO {

	int RatingCheck(RatingVO rating) throws DataAccessException;

	Double ratingAvg();

	int getRating(Map<String, Object>data) throws DataAccessException;

	int findRating(Map<String, Object> data) throws DataAccessException;
}
