package com.myspring.Art.common.Reply.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.Art.common.Reply.DAO.ReplyDAO;
import com.myspring.Art.common.Reply.VO.ReplyVO;

@Service("replyService")
@Transactional(propagation = Propagation.REQUIRED)
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public List<ReplyVO> readReply(int goods_id)throws Exception{
		return replyDAO.readReply(goods_id);
	}
	
	@Override
	public int writeReply(ReplyVO vo)throws Exception{
		return replyDAO.writeReply(vo);
	}
	
	@Override
	public void updateReply(ReplyVO vo)throws Exception{
		replyDAO.modifyReply(vo);
	}
	
	@Override
	public void deleteReply(ReplyVO vo)throws Exception{
		replyDAO.deleteReply(vo);
	}
	
	@Override
	public ReplyVO selectReply(int rno)throws Exception{
		return replyDAO.selectReply(rno);
	}
}
