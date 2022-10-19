package com.myspring.Art.Collectible.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.common.Reply.VO.ReplyVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface CollectibleController {

	ModelAndView modifyReply(ReplyVO vo, RedirectAttributes rttr,  HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	ModelAndView removeReply(ReplyVO vo, RedirectAttributes rttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	ModelAndView collectibleList(SearchCriteria scri, HttpServletRequest request, HttpServletResponse response)
		throws Exception;

	ModelAndView replyWrite(ReplyVO vo, RedirectAttributes rttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	ModelAndView collectibleDetail(int goods_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}
