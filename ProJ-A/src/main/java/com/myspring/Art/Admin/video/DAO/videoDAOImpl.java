package com.myspring.Art.Admin.video.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.Admin.video.VO.videoVO;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.domain.SearchCriteria;

@Repository("videoDAO")
public class videoDAOImpl implements videoDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertNewVideo(Map newVideoMap)throws DataAccessException{
		sqlSession.insert("mapper.admin.video.insertNewVideo",newVideoMap);
		return Integer.parseInt((String)newVideoMap.get("vno"));
	}
	
	@Override
	public void insertNewVideoFile(List fileList)throws DataAccessException{
		for(int i=0; i<fileList.size(); i++) {
			videoVO videoVO = (videoVO)fileList.get(i);
			sqlSession.insert("mapper.admin.goods.insertGoodsImageFile", videoVO);
		}
	}
	
	@Override
	public List<videoVO>selectVideoList(SearchCriteria scri) throws DataAccessException {
		ArrayList<videoVO>  list=(ArrayList)sqlSession.selectList("mapper.admin.video.selectVideoList",scri);
		return list;
	}
	
	@Override
	public int countList(SearchCriteria scri){
	    return (Integer) sqlSession.selectOne("mapper.admin.video.countList",scri);
	}
}
