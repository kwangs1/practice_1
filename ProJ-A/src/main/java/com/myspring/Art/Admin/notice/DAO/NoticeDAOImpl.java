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
	public List selectAllNoticeList(String startDate, String endDate) throws DataAccessException,Exception{
		List<NoticeVO> NoticeList = null;
		if(startDate != null && startDate !=  "" && endDate != null && endDate != "") {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date start = new Date(sdf.parse(startDate).getTime());
			Date end = new Date(sdf.parse(endDate).getTime());
			System.out.println(start);
			NoticeVO vo = new NoticeVO();
			vo.setStartDate(start);
			vo.setEndDate(end);
			NoticeList = sqlSession.selectList("mapper.admin.notice.selectAllNoticeList", vo);
		}else {
			NoticeList = sqlSession.selectList("mapper.admin.notice.selectAllNoticeList");
		}
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
}
