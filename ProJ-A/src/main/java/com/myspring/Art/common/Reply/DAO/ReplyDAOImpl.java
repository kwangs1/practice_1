package com.myspring.Art.common.Reply.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.common.Reply.VO.ReplyVO;

@Repository("replyDAO")
public class ReplyDAOImpl implements ReplyDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ReplyVO> readReply(int goods_id)throws DataAccessException{
		return sqlSession.selectList("mapper.reply.readReply",goods_id);
	}
	
	@Override
	public int writeReply(ReplyVO vo)throws DataAccessException{
		return sqlSession.insert("mapper.reply.writeReply",vo);

	}
	
	@Override
	public void deleteReply(ReplyVO vo)throws DataAccessException{
		sqlSession.delete("mapper.reply.deleteReply", vo);
	}
	
	@Override
	public ReplyVO selectReply(int rno)throws DataAccessException{
		return sqlSession.selectOne("mapper.reply.selectReply",rno);
	}
	
	@Override
	public int updateReply(ReplyVO vo) {
		return sqlSession.update("mapper.reply.updateReply",vo);
	}
	
//	´ñ±Û¼öÁ¤ºä
	@Override
	public ReplyVO getUpdateReply(int rno) {
		return sqlSession.selectOne("mapper.reply.getUpdateReply",rno);
	}
}
