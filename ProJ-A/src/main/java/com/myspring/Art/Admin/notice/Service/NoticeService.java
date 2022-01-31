package com.myspring.Art.Admin.notice.Service;

import java.util.List;
import java.util.Map;

import com.myspring.Art.Admin.notice.VO.NoticeVO;
import com.myspring.Art.common.domain.Criteria;
import com.myspring.Art.common.domain.SearchCriteria;

public interface NoticeService {
	
	int addNewNotice(NoticeVO notice) throws Exception;

	NoticeVO NoticeDetail(int bno) throws Exception;
	
	int removeNotice(int bno) throws Exception;

	int modifyNotice(NoticeVO vo) throws Exception;

	List<Map<String, Object>> NoticeList(SearchCriteria scri) throws Exception;

	int countNoticeListTotal(SearchCriteria scri);

}
