package com.myspring.Art.Collectible.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.Reply.VO.ReplyVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface CollectibleController {

	ModelAndView collectibleList(SearchCriteria scri, HttpServletRequest request, HttpServletResponse response)
		throws Exception;

	ModelAndView collectibleDetail(int goods_id, String member_id, ReplyVO reply, HttpServletRequest request)
			throws Exception;

}
