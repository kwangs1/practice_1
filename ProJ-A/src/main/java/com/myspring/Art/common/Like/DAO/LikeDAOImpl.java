package com.myspring.Art.common.Like.DAO;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("likeDAO")
public class LikeDAOImpl implements LikeDAO{

	@Autowired
	private SqlSession session;
	
	
	@Override
	public void likeUp(Map<String, Object> data) {
		session.insert("mapper.like.likeUp", data);
	};

	@Override
	public void likeDown(Map<String, Object> data) {
		session.delete("mapper.like.likeDown", data);
	};

	@Override
	public int findLike(Map<String, Object>data)throws DataAccessException{
		 return  session.selectOne("mapper.like.findLike",data);
	}

	@Override
	public int getLike(Map<String, Object>data)throws DataAccessException{
		 return  session.selectOne("mapper.like.getLike",data);
	}
}
