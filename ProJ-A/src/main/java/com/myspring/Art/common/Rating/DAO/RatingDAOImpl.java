package com.myspring.Art.common.Rating.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.common.Rating.VO.RatingVO;

@Repository("ratingDAO")
public class RatingDAOImpl implements RatingDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void writeRating(RatingVO vo)throws DataAccessException{
		sqlSession.insert("mapper.rating.writeRating",vo);

	}
}
