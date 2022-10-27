package com.myspring.Art.common.Reply.Service;

import java.util.List;

import com.myspring.Art.common.Reply.VO.ReplyVO;

public interface ReplyService {

	List<ReplyVO> readReply(int goods_id) throws Exception;

	int writeReply(ReplyVO vo) throws Exception;

	int updateReply(ReplyVO vo) throws Exception;

	ReplyVO getUpdateReply(int rno);

	void deleteReply(ReplyVO vo) throws Exception;

}
