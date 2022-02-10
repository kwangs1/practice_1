package com.myspring.Art.common.Rating.DAO;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.common.Rating.VO.RatingVO;

public interface RatingDAO {

	void writeRating(RatingVO vo) throws DataAccessException;

	List<RatingVO> readRating(int goods_id) throws DataAccessException;

}
