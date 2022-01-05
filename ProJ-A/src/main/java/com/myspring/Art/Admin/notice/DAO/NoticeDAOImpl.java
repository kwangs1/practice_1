package com.myspring.Art.Admin.notice.DAO;

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
	public List selectAllNoticeList() throws DataAccessException {
		List<NoticeVO> NoticeList = NoticeList = sqlSession.selectList("mapper.admin.notice.selectAllNoticeList");
		return NoticeList;
	}
	
	@Override
	public void write(NoticeVO noticeVO) throws DataAccessException {
		sqlSession.insert("mapper.admin.notice.insertList", noticeVO);
		
	}
}
