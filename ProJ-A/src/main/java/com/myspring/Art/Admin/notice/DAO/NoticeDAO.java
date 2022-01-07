package com.myspring.Art.Admin.notice.DAO;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Admin.notice.VO.NoticeVO;

public interface NoticeDAO {

	List selectAllNoticeList() throws DataAccessException;

	int insertNoticeList(NoticeVO vo) throws DataAccessException;

	NoticeVO selectNoticeDetail(int bno) throws DataAccessException;

}
