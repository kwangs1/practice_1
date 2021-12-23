package com.myspring.Art.Member.DAO;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Member.VO.MemberVO;

public interface MemberDAO {

	MemberVO login(Map loginMap) throws DataAccessException;

}
