package com.myspring.Art.Member.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.Art.Member.DAO.MemberDAO;
import com.myspring.Art.Member.VO.MemberVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberVO login(Map loginMap)throws Exception{
		return memberDAO.login(loginMap);
	}
	
	@Override
	public void addMember(MemberVO memberVO) throws Exception{
		memberDAO.insertNewMember(memberVO);
	}
	
	@Override
	public String overlapped(String id) throws Exception{
		return memberDAO.selectOverlappedID(id);
	}
	
	@Override
	public MemberVO memberInfo()throws Exception{
		MemberVO vo = memberDAO.selectMemberInfo();
		return vo;
	}
	
	@Override
	public MemberVO modifyMyInfo(Map memberMap)throws Exception{
		String member_id = (String)memberMap.get("member_id");
		memberDAO.modifyMyInfo(memberMap);
		return memberDAO.selectMemberInfo();
	}
	
	@Override
	public void memberSearch(MemberVO memberVO)throws Exception{
		memberDAO.selectMemberSearch(memberVO);
	}
}
