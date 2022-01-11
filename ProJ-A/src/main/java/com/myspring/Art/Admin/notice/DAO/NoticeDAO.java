package com.myspring.Art.Admin.notice.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Admin.notice.VO.NoticeVO;

public interface NoticeDAO {

	List selectAllNoticeList(String startDate, String endDate) throws DataAccessException,Exception;

	int insertNoticeList(NoticeVO vo) throws DataAccessException;

	NoticeVO selectNoticeDetail(int bno) throws DataAccessException;

	int deleteNoticeList(int bno) throws DataAccessException;

	int modifyNotice(NoticeVO vo) throws DataAccessException;
}
