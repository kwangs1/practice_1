package com.myspring.Art.common.Reply.DAO;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.common.Reply.VO.ReplyVO;

public interface ReplyDAO {

	List<ReplyVO> readReply(int goods_id) throws DataAccessException;

	int writeReply(ReplyVO vo) throws DataAccessException;

	void modifyReply(ReplyVO vo) throws DataAccessException;

	void deleteReply(ReplyVO vo) throws DataAccessException;

	ReplyVO selectReply(int rno) throws DataAccessException;

}
