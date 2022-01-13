package com.myspring.Art.Admin.goods.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;

@Repository("adminGoodsDAO")
public class AdminGoodsDAOImpl implements AdminGoodsDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertNewGoods(Map newGoodsMap)throws DataAccessException{
		sqlSession.insert("mapper.admin.goods.insertNewGoods", newGoodsMap);
		return Integer.parseInt((String)newGoodsMap.get("goods_id"));
	}
	
	@Override
	public void insertGoodsImageFile(List fileList)throws DataAccessException{
		for(int i=0; i<fileList.size(); i++) {
			ImageFileVO imageFileVO = (ImageFileVO)fileList.get(i);
			sqlSession.insert("mapper.admin.goods.insertGoodsImageFile",imageFileVO);
		}
	}
	
	@Override
	public List<CollectibleVO>selectNewGoodsList(Map condMap) throws DataAccessException {
		ArrayList<CollectibleVO>  goodsList=(ArrayList)sqlSession.selectList("mapper.admin.goods.selectNewGoodsList",condMap);
		return goodsList;
	}
	
	@Override
	public void deleteGoods(int goods_id) throws DataAccessException {
		sqlSession.delete("mapper.admin.goods.deleteGoods", goods_id);		
	}
}
