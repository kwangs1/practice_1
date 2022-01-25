package com.myspring.Art.Admin.notice.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Admin.notice.VO.Criteria;
import com.myspring.Art.Admin.notice.VO.NoticeVO;

public interface NoticeDAO {

	int insertNoticeList(NoticeVO vo) throws DataAccessException;

	NoticeVO selectNoticeDetail(int bno) throws DataAccessException;

	int deleteNoticeList(int bno) throws DataAccessException;

	int modifyNotice(NoticeVO vo) throws DataAccessException;

	void boardHit(int bno) throws Exception;

	List<Map<String, Object>> selectAllNoticeList(Criteria cri);

	int countNoticeList();
}
