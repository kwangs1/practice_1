package com.myspring.Art.common.Rating.DAO;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.common.Rating.VO.RatingVO;

@Repository("ratingDAO")
public class RatingDAOImpl implements RatingDAO{
	@Autowired
	private SqlSession session;
	
    @Override
	public Double ratingAvg() {
		return session.selectOne("mapper.rating.ratingAvg");
	}

	@Override
	public void RatingCheck(RatingVO rating)throws DataAccessException{
		session.insert("mapper.rating.RatingCheck",rating);
	}
	
	@Override
	public int getRating(Map<String, Object>data)throws DataAccessException{
		 return  session.selectOne("mapper.rating.getRating",data);
	}
	@Override
	public int findRating(Map<String, Object>data)throws DataAccessException{
		return  session.selectOne("mapper.rating.findRating",data);
	}
	
}
