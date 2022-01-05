package com.myspring.Art.Admin.notice.Service;

import java.util.List;

import com.myspring.Art.Admin.notice.VO.NoticeVO;

public interface NoticeService {

	List<NoticeVO> NoticeList() throws Exception;

	void write(NoticeVO noticeVO) throws Exception;

}
