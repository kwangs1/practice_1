package com.myspring.Art.common.Like.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Art.common.Like.DAO.LikeDAO;

@Service("likeService")
public class LikeServiceImpl implements LikeService{
	@Autowired
	private LikeDAO likeDAO;
	
	@Override
	public void likeUp(int goods_id, String member_id , int like_type) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("goods_id", goods_id);
		map.put("member_id", member_id);
		map.put("like_type", like_type);
		
		likeDAO.likeUp(map);
	}

	@Override
	public void likeDown(int goods_id, String member_id , int like_type) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("goods_id", goods_id);
		map.put("member_id", member_id);
		map.put("like_type", like_type);
		
		likeDAO.likeDown(map);
	}

	@Override
	public int findLike(int goods_id, String member_id ) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("goods_id", goods_id);
		map.put("member_id", member_id);
		
		return likeDAO.findLike(map);
	}
	
	@Override
	public int getLike(int goods_id , int like_type) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("goods_id", goods_id);
		map.put("like_type", like_type);
		
		return likeDAO.getLike(map);
	}
}
