package com.myspring.Art.Admin.goods.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.Admin.notice.VO.NoticeVO;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;
import com.myspring.Art.common.domain.SearchCriteria;

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
	public List<CollectibleVO>selectNewGoodsList(SearchCriteria scri) throws DataAccessException {
		ArrayList<CollectibleVO>  listNewGoods=(ArrayList)sqlSession.selectList("mapper.admin.goods.selectNewGoodsList",scri);
		return listNewGoods;
	}
	
	@Override
	public int countList(SearchCriteria scri){
	    return (Integer) sqlSession.selectOne("mapper.admin.goods.countList",scri);
	}
	
	@Override
	public void deleteGoods(int goods_id) throws DataAccessException {
		sqlSession.delete("mapper.admin.goods.deleteGoods", goods_id);		
	}
	
	@Override
	public CollectibleVO selectGoodsDetail(int goods_id) throws DataAccessException{
		CollectibleVO colVO = new CollectibleVO();
		colVO=(CollectibleVO)sqlSession.selectOne("mapper.admin.goods.selectGoodsDetail",goods_id);
		return colVO;
	}
	
	@Override
	public List selectGoodsImageFileList(int goods_id) throws DataAccessException {
		List imageList=new ArrayList();
		imageList=(List)sqlSession.selectList("mapper.admin.goods.selectGoodsImageFileList",goods_id);
		return imageList;
	}

	@Override
	public void updateGoodsImage(List<ImageFileVO> imageFileList) throws DataAccessException {
		
		for(int i=0; i<imageFileList.size();i++){
			ImageFileVO imageFileVO = imageFileList.get(i);
			sqlSession.update("mapper.admin.goods.updateGoodsImage",imageFileVO);	
		}
		
	}
	
	@Override
	public void updateGoodsInfo(Map goodsMap) throws DataAccessException{
		sqlSession.update("mapper.admin.goods.updateGoodsInfo",goodsMap);
	}
}