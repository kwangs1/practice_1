package com.myspring.Art.Admin.notice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.Art.Admin.notice.DAO.NoticeDAO;
import com.myspring.Art.Admin.notice.VO.NoticeVO;

@Service("noticeService")
@Transactional(propagation = Propagation.REQUIRED)
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public List<NoticeVO> NoticeList() throws Exception{
		List<NoticeVO> NoticeList = noticeDAO.selectAllNoticeList();	
		return NoticeList;
	}
	
	@Override
	public void write(NoticeVO noticeVO) throws Exception {
		noticeDAO.write(noticeVO);
	}
}
