package com.myspring.Art.Admin.notice.DAO;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.Admin.notice.VO.NoticeVO;

@Repository("noticeDAO")
public class NoticeDAOImpl implements NoticeDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllNoticeList() throws DataAccessException{
		List<NoticeVO> NoticeList = null;
		NoticeList = sqlSession.selectList("mapper.admin.notice.selectAllNoticeList");
		return NoticeList;
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
}
