package com.myspring.Art.Admin.notice.Service;

import java.util.List;
import java.util.Map;

import com.myspring.Art.Admin.notice.VO.Criteria;
import com.myspring.Art.Admin.notice.VO.NoticeVO;

public interface NoticeService {
	
	int addNewNotice(NoticeVO notice) throws Exception;

	NoticeVO NoticeDetail(int bno) throws Exception;
	
	int removeNotice(int bno) throws Exception;

	int modifyNotice(NoticeVO vo) throws Exception;

	List<Map<String, Object>> NoticeList(Criteria cri) throws Exception;

	int countNoticeListTotal();

	List<NoticeVO> searchNotice(String searchWord,Criteria cri) throws Exception;

	List<String> keywordSearch(String keyword) throws Exception;
}
