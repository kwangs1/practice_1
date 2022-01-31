package com.myspring.Art.Admin.notice.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Admin.notice.VO.NoticeVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface NoticeDAO {

	int insertNoticeList(NoticeVO vo) throws DataAccessException;

	NoticeVO selectNoticeDetail(int bno) throws DataAccessException;

	int deleteNoticeList(int bno) throws DataAccessException;

	int modifyNotice(NoticeVO vo) throws DataAccessException;

	void boardHit(int bno) throws Exception;

	List<Map<String, Object>> selectAllNoticeList(SearchCriteria scri);

	int countNoticeList(SearchCriteria scri);

//	List<String> selectKeywordSearch(String keyword) throws DataAccessException;
//
//	ArrayList selectNoticeBySearchWord(String searchWord,Criteria cri) throws DataAccessException;

}
