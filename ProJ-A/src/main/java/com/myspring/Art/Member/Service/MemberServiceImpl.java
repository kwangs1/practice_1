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
	public MemberVO login(MemberVO vo) throws Exception {
		return memberDAO.login(vo);
	}
	
	@Override
	public void addMember(MemberVO memberVO) throws Exception{
		memberDAO.insertNewMember(memberVO);
	}
	
	@Override
	public int idCheck(String id)throws Exception{
		return memberDAO.idCheck(id);
	}
	
	@Override
	public void selectMemberInfo(String member_id)throws Exception{
		memberDAO.selectMemberInfo(member_id);
	}
	
	//정보 수정
	@Override
	public void MemberModify(MemberVO memberVO)throws Exception{
		memberDAO.MemberModify(memberVO);
	}
	
	//정보 수정(비번)
	@Override
	public void MemberModify_Pw(MemberVO memberVO)throws Exception{
		memberDAO.MemberModify_Pw(memberVO);
	}
}
