package com.myspring.Art.common.Reply.Service;

import java.util.List;

import com.myspring.Art.common.Reply.VO.ReplyVO;

public interface ReplyService {

	List<ReplyVO> readReply(int goods_id) throws Exception;

	void writeReply(ReplyVO vo) throws Exception;

	void updateReply(ReplyVO vo) throws Exception;

	void deleteReply(ReplyVO vo) throws Exception;

	ReplyVO selectReply(int rno) throws Exception;

}
