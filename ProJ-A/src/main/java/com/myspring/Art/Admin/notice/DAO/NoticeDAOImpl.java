package com.myspring.Art.Admin.notice.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.Admin.notice.VO.NoticeVO;
import com.myspring.Art.common.domain.SearchCriteria;

@Repository("noticeDAO")
public class NoticeDAOImpl implements NoticeDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectAllNoticeList(SearchCriteria scri) {
	    return sqlSession.selectList("mapper.admin.notice.selectAllNoticeList", scri);
	}
	
	@Override
	public int countNoticeList(SearchCriteria scri){
	    return (Integer) sqlSession.selectOne("mapper.admin.notice.countNoticeList",scri);
	}


	@Override
	public int insertNoticeList(NoticeVO notice)throws DataAccessException{
		int result = sqlSession.insert("mapper.admin.notice.insertNoticeList",notice);
		return result;
	}
	
	@Override
	public NoticeVO selectNoticeDetail(int bno)throws DataAccessException{
		return sqlSession.selectOne("mapper.admin.notice.selectNoticeDetail",bno);
	}
	
	@Override
	public int deleteNoticeList(int bno)throws DataAccessException{
		int result = sqlSession.delete("mapper.admin.notice.deleteNoticeList",bno);
			return result;
	}
	
	@Override
	public int modifyNotice(NoticeVO vo) throws DataAccessException {
		int result = 0; 
		result = sqlSession.update("mapper.admin.notice.modifyNotice",vo);
		return result;
	}
	
	@Override
	public int boardHit(int bno) throws Exception {
		int result = sqlSession.update("mapper.admin.notice.boardHit", bno);
		return result;
	}
	

}
