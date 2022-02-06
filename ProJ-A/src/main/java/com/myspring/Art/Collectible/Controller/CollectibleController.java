package com.myspring.Art.Collectible.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.Reply.VO.ReplyVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface CollectibleController {

	ModelAndView replyWrite(ReplyVO vo,RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView modifyReply(ReplyVO vo, RedirectAttributes rttr,  HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	ModelAndView removeReply(ReplyVO vo, RedirectAttributes rttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	ModelAndView collectibleList(SearchCriteria scri, HttpServletRequest request, HttpServletResponse response)
		throws Exception;

	ModelAndView collectibleDetail(int goods_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
}
