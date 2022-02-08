package com.myspring.Art.Collectible.Controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.Collectible.Service.CollectibleService;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.Reply.Service.ReplyService;
import com.myspring.Art.common.Reply.VO.ReplyVO;
import com.myspring.Art.common.base.BaseController;
import com.myspring.Art.common.domain.PageMaker;
import com.myspring.Art.common.domain.SearchCriteria;

@Controller("collectibleController")
@RequestMapping(value="/collectible")
public class CollectibleControllerImpl extends BaseController implements CollectibleController{
	private static final Logger logger = LoggerFactory.getLogger(CollectibleControllerImpl.class);
	@Autowired
	private CollectibleService collectibleService;
	@Autowired
	private CollectibleVO collectibleVO;
	@Autowired
	private ReplyService replyService;


	
	@Override
	@RequestMapping(value="/collectibleList.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView collectibleList(@ModelAttribute("scri") SearchCriteria scri,
			                           HttpServletRequest request, HttpServletResponse response)  throws Exception {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(collectibleService.countListTotal(scri));

		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		List<CollectibleVO> collectibleList=collectibleService.collectibleList(scri);
		mav.addObject("collectible", collectibleList);
		mav.addObject("pageMaker",pageMaker);
	

		return mav;
	}
	
	@Override
	@RequestMapping(value="/collectibleDetail.do", method=RequestMethod.GET)
	public ModelAndView collectibleDetail(@RequestParam("goods_id") int goods_id,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		String viewName=(String)request.getAttribute("viewName");
		collectibleVO= collectibleService.collectibleDetail(goods_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("collectible",collectibleVO); 
		
		//¥Ò±€±‚¥…
		List<ReplyVO> replyList = replyService.readReply(collectibleVO.getGoods_id());
		mav.addObject("replyList",replyList);
		
//		int result = 0;
//		result =collectibleService.likehit(goods_id);

		return mav;
	}

	//¥Ò±€¿€º∫
	@Override
	@RequestMapping(value="/replyWrite.do", method=RequestMethod.POST)
	public ModelAndView replyWrite(@ModelAttribute("reply")ReplyVO vo,
			RedirectAttributes rttr,HttpServletRequest request, HttpServletResponse response)throws Exception {

		replyService.writeReply(vo);	
		rttr.addAttribute("goods_id", vo.getGoods_id());
		
		ModelAndView mav = new ModelAndView("redirect:/collectible/collectibleDetail.do");
		return mav;
	}
	//¥Ò±€ ºˆ¡§∫‰
	@RequestMapping(value="/modifyReplyForm.do", method = RequestMethod.GET)
	public ModelAndView modifyReplyForm(@ModelAttribute("reply")ReplyVO vo, @RequestParam("goods_id") int goods_id,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		String viewName = (String)request.getAttribute("viewName");
		collectibleVO = collectibleService.collectibleDetail(goods_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("collectible",collectibleVO);
		mav.addObject("reply",replyService.selectReply(vo.getRno()));
		
		return mav;	
	}
	//¥Ò±€ ºˆ¡§ µ•¿Ã≈Õ∫Œ∫–
	@Override
	@RequestMapping(value="/modifyReply.do", method = RequestMethod.POST)
	public ModelAndView modifyReply(@ModelAttribute("reply")ReplyVO vo, RedirectAttributes rttr,
			HttpServletRequest request, HttpServletResponse response)throws Exception{

		replyService.updateReply(vo);		
		ModelAndView mav = new ModelAndView("redirect:/collectible/collectibleDetail.do");

		rttr.addAttribute("goods_id", vo.getGoods_id());
		return mav;
	}
	
	//¥Ò±€ªË¡¶
	@Override
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
