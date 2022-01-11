package com.myspring.Art.Admin.notice.Service;

import java.util.List;
import java.util.Map;

import com.myspring.Art.Admin.notice.VO.NoticeVO;

public interface NoticeService {
	List NoticeList(String startDate, String endDate) throws Exception;

	int addNewNotice(NoticeVO notice) throws Exception;

	NoticeVO NoticeDetail(int bno) throws Exception;
	
	int removeNotice(int bno) throws Exception;

	int modifyNotice(NoticeVO vo) throws Exception;
}
