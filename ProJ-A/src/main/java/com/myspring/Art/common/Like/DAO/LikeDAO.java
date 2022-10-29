package com.myspring.Art.common.Like.DAO;

import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface LikeDAO {

	void likeUp(Map<String, Object> data);

	void likeDown(Map<String, Object> data);

	int findLike(Map<String, Object> data) throws DataAccessException;

	int getLike(Map<String, Object> data) throws DataAccessException;

}
