package com.myspring.Art.Member.DAO;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Art.Member.VO.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return sqlSession.selectOne("mapper.member.login", vo);
	}
	@Override
	public void insertNewMember(MemberVO memberVO) throws DataAccessException{
		sqlSession.insert("mapper.member.insertNewMember",memberVO);
	}

	@Override
	public int idCheck(String id)throws DataAccessException{
		int result = sqlSession.selectOne("mapper.member.idCheck",id);
		return result;
	}
	
	@Override
	public void selectMemberInfo(String member_id)throws DataAccessException{
		 sqlSession.selectOne("mapper.member.selectMemberInfo",member_id);
	}

	@Override
	public void MemberModify(MemberVO memberVO)throws DataAccessException{
		sqlSession.update("mapper.member.MemberModify",memberVO);
	}
	
	//modify(ºñ¹ø)
	@Override
	public void MemberModify_Pw(MemberVO memberVO)throws DataAccessException{
		sqlSession.update("mapper.member.MemberModify_Pw",memberVO);
	}
}
