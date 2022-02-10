package com.myspring.Art.Collectible.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.domain.SearchCriteria;

@Repository("collectibleDAO")
public class CollectibleDAOImpl implements CollectibleDAO{
	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<CollectibleVO>selectAllCollectibleList(SearchCriteria scri) throws DataAccessException {
		ArrayList<CollectibleVO>  CollectibleList=(ArrayList)sqlSession.selectList("mapper.collectible.selectAllCollectibleList",scri);
		return CollectibleList;
	}
	
	@Override
	public int countList(SearchCriteria scri){
	    return (Integer) sqlSession.selectOne("mapper.collectible.countList",scri);
	}

	
	@Override
	public CollectibleVO selectCollectibleDetail(int goods_id)throws DataAccessException{
		return sqlSession.selectOne("mapper.collectible.selectCollectibleDetail",goods_id);
	}

}
