package com.myspring.Art.Admin.video.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.Admin.notice.VO.NoticeVO;
import com.myspring.Art.Admin.video.VO.videoVO;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.domain.SearchCriteria;

@Repository("videoDAO")
public class videoDAOImpl implements videoDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int youtubeInsert(videoVO videoVO)throws DataAccessException{
		int result = sqlSession.insert("mapper.admin.video.youtubeInsert",videoVO);
		return result;
	}
	//관리자
	@Override
	public List<videoVO>selectVideoList(SearchCriteria scri) throws DataAccessException {
		ArrayList<videoVO>  list=(ArrayList)sqlSession.selectList("mapper.admin.video.selectVideoList",scri);
		return list;
	}
	//사용자
	@Override
	public List<videoVO>selectVideoView(SearchCriteria scri) throws DataAccessException {
		ArrayList<videoVO>  list=(ArrayList)sqlSession.selectList("mapper.admin.video.selectVideoView",scri);
		return list;
	}
	@Override
	public int countList(SearchCriteria scri){
	    return (Integer) sqlSession.selectOne("mapper.admin.video.countList",scri);
	}
	
	@Override
	public videoVO selectVideoDetail(int vno)throws DataAccessException{
		return sqlSession.selectOne("mapper.admin.video.selectVideoDetail",vno);
	}
	
	@Override
	public int deleteVideoList(int vno)throws DataAccessException{
		int result = sqlSession.delete("mapper.admin.video.deleteVideoList",vno);
		return result;
	}
	
	@Override
	public int modifyVideo(videoVO vo) throws DataAccessException {
		int result = 0; 
		result = sqlSession.update("mapper.admin.video.modifyVideo",vo);
		return result;
	}
}
