package com.myspring.Art.common.Reply.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.Collectible.Controller.CollectibleControllerImpl;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.Reply.Service.ReplyService;
import com.myspring.Art.common.Reply.VO.ReplyVO;
import com.myspring.Art.common.base.BaseController;

@Controller("replyController")
@RequestMapping(value="/reply")
public class ReplyControllerImpl extends BaseController implements ReplyController{
	
	private static final Logger logger = LoggerFactory.getLogger(CollectibleControllerImpl.class);

	@Autowired
	private ReplyService replyService;
	
	
	//¥Ò±€¿€º∫
	@ResponseBody
	@RequestMapping(value="/replyWrite.do", method=RequestMethod.POST )
	public Map<String,Object> replyWrite(@RequestBody ReplyVO replyVO) {
		Map<String, Object> result = new HashMap<>();

		try {
			replyService.writeReply(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "false");
		}
		return result;
	}
	
	
	//¥Ò±€ªË¡¶
	@RequestMapping(value="/removeReply.do", method = RequestMethod.POST)
	public ModelAndView removeReply(@ModelAttribute("reply")ReplyVO vo, RedirectAttributes rttr,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		logger.info("reply delete");
		
		replyService.deleteReply(vo);
		
		rttr.addAttribute("goods_id", vo.getGoods_id());
		ModelAndView mav = new ModelAndView("redirect:/collectible/collectibleDetail.do");

		return mav;
	}
	
	//¥Ò±€ ºˆ¡§
	@ResponseBody
	@RequestMapping(value="/updateReply.do", method = RequestMethod.POST)
	public void replyModifyPost(@RequestBody ReplyVO vo) {
		replyService.updateReply(vo);
	}
	


	
}
