package com.myspring.Art.Admin.notice.Service;

import java.util.List;

import com.myspring.Art.Admin.notice.VO.NoticeVO;

public interface NoticeService {

	List NoticeList() throws Exception;

	int addNewNotice(NoticeVO notice) throws Exception;

	NoticeVO NoticeDetail(int bno) throws Exception;

}
