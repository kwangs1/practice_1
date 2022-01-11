package com.myspring.Art.Collectible.DAO;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.Admin.notice.VO.NoticeVO;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;

@Repository("collectibleDAO")
public class CollectibleDAOImpl implements CollectibleDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllCollectibleList() throws DataAccessException{
		List<CollectibleVO> CollectibleList = null;
		CollectibleList = sqlSession.selectList("mapper.collectible.selectCollectibleList");
		return CollectibleList;
	}

	@Override
	public CollectibleVO selectCollectibleDetail(int goods_id)throws DataAccessException{
		return sqlSession.selectOne("mapper.collectible.selectCollectibleDetail",goods_id);
	}
}
