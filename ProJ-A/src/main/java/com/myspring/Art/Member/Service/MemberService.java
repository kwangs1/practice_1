package com.myspring.Art.Member.Service;

import java.util.Map;

import com.myspring.Art.Member.VO.MemberVO;

public interface MemberService {

	MemberVO login(Map loginMap) throws Exception;

}
