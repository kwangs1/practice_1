package com.myspring.Art.Member.DAO;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Member.VO.MemberVO;

public interface MemberDAO {

	void insertNewMember(MemberVO memberVO) throws DataAccessException;

	int idCheck(String id) throws DataAccessException;

	void MemberModify(MemberVO memberVO) throws DataAccessException;
	
	MemberVO login(MemberVO vo) throws Exception;

	void selectMemberInfo(String member_id) throws DataAccessException;

	void MemberModify_Pw(MemberVO memberVO) throws DataAccessException;

}
