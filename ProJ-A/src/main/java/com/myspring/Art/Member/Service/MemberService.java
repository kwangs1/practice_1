package com.myspring.Art.Member.Service;

import java.util.Map;

import com.myspring.Art.Member.VO.MemberVO;

public interface MemberService {

	void addMember(MemberVO memberVO) throws Exception;

	int idCheck(String id) throws Exception;

	void MemberModify(MemberVO memberVO) throws Exception;

	MemberVO login(MemberVO vo) throws Exception;

	void selectMemberInfo(String member_id) throws Exception;

	void MemberModify_Pw(MemberVO memberVO) throws Exception;

}
