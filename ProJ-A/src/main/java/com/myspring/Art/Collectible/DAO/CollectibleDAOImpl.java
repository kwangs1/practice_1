package com.myspring.Art.Collectible.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;

@Repository("collectibleDAO")
public class CollectibleDAOImpl implements CollectibleDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CollectibleVO> selectCollectibleList(String goodsStatus) throws DataAccessException{
		List<CollectibleVO> CollectibleList = (ArrayList)sqlSession.selectList("mapper.collectible.selectCollectibleList",goodsStatus);
	return CollectibleList;
	}
	
	@Override
	public CollectibleVO selectCollectibleDetail(String goods_id)throws DataAccessException{
		CollectibleVO collectibleVO =(CollectibleVO)sqlSession.selectOne("mapper.collectible.selectCollectibleDetail",goods_id);
		return collectibleVO;
	}
	
	@Override
	public List<ImageFileVO> selectCollectibleDetailImage(String goods_id)throws DataAccessException{
		List<ImageFileVO> imageList = (ArrayList)sqlSession.selectList("mapper.collectible.selectCollectibleDetailImage",goods_id);
		return imageList;
	}
}
