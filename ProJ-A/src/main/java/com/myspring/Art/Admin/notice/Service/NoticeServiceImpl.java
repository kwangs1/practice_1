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
	public List NoticeList() throws Exception{
		List NoticeList = null;
		NoticeList = noticeDAO.selectAllNoticeList();
		return NoticeList;
	}	
	
	@Override
	public int addNewNotice(NoticeVO notice)throws Exception{
		return noticeDAO.insertNoticeList(notice);
	}	
	
	@Override
	public NoticeVO NoticeDetail(int bno)throws Exception{
		NoticeVO noticeVO = noticeDAO.selectNoticeDetail(bno);
		return noticeVO;
	}
}
