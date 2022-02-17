package com.myspring.Art.Member.Service;

import java.util.Map;

import com.myspring.Art.Member.VO.MemberVO;

public interface MemberService {

	MemberVO login(Map loginMap) throws Exception;

	void addMember(MemberVO memberVO) throws Exception;

	String overlapped(String id) throws Exception;

	MemberVO modifyMyInfo(Map memberMap) throws Exception;

	MemberVO memberInfo() throws Exception;

	void memberSearch(MemberVO memberVO) throws Exception;

}
