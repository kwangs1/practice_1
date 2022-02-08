package com.myspring.Art.common.Rating.DAO;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.common.Rating.VO.RatingVO;

public interface RatingDAO {

	void writeRating(RatingVO vo) throws DataAccessException;

}
