package com.myspring.Art.Admin.notice.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.Art.Admin.notice.DAO.NoticeDAO;
import com.myspring.Art.Admin.notice.VO.NoticeVO;
import com.myspring.Art.common.domain.Criteria;
import com.myspring.Art.common.domain.SearchCriteria;

@Service("noticeService")
@Transactional(propagation = Propagation.REQUIRED)
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public List<Map<String,Object>> NoticeList(SearchCriteria scri) throws Exception{
		return noticeDAO.selectAllNoticeList(scri);
	}	

	@Override
	public int countNoticeListTotal(SearchCriteria scri) {
	    return noticeDAO.countNoticeList(scri);
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
	
	@Override
	public int removeNotice(int bno)throws Exception{
		return noticeDAO.deleteNoticeList(bno);
	}

	@Override
	public int modifyNotice(NoticeVO vo) throws Exception {
		return noticeDAO.modifyNotice(vo);
	}
	@Override
	public int boardHit(int bno)throws Exception{
		return noticeDAO.boardHit(bno);
	}

}
