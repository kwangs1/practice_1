package com.myspring.Art.common.Reply.Controller;

import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.Collectible.Controller.CollectibleControllerImpl;
import com.myspring.Art.Collectible.Service.CollectibleService;
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
	@Autowired
	private CollectibleVO collectibleVO;
	@Autowired
	private CollectibleService collectibleService;
	
	//댓글작성
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
	
	//댓글 수정뷰
	@RequestMapping(value="/modifyReplyForm.do", method = RequestMethod.GET)
	public ModelAndView modifyReplyForm(@ModelAttribute("reply")ReplyVO vo, @RequestParam("goods_id") int goods_id,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		String viewName = (String)request.getAttribute("viewName");
		
		//댓글 수정 시 댓글을 적었던 게시판 글의 상세보기 값들을 jsp에서  같이 사용하기 위해 선언함
		collectibleVO = collectibleService.collectibleDetail(goods_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("collectible",collectibleVO);
		mav.addObject("reply",replyService.selectReply(vo.getRno()));
		
		return mav;	
	}
	
	//댓글 수정 데이터부분
	@RequestMapping(value="/modifyReply.do", method = RequestMethod.POST)
	public ModelAndView modifyReply(@ModelAttribute("reply")ReplyVO vo, RedirectAttributes rttr,
			HttpServletRequest request, HttpServletResponse response)throws Exception{

		replyService.updateReply(vo);		
		ModelAndView mav = new ModelAndView("redirect:/collectible/collectibleDetail.do");

		rttr.addAttribute("goods_id", vo.getGoods_id());
		return mav;
	}
	
	
	//댓글삭제
	@RequestMapping(value="/removeReply.do", method = RequestMethod.POST)
	public ModelAndView removeReply(@ModelAttribute("reply")ReplyVO vo, RedirectAttributes rttr,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		logger.info("reply delete");
		
		replyService.deleteReply(vo);
		
		rttr.addAttribute("goods_id", vo.getGoods_id());
		ModelAndView mav = new ModelAndView("redirect:/collectible/collectibleDetail.do");

		return mav;
	}
}
