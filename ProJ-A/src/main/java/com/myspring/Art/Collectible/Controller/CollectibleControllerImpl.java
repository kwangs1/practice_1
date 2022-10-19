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


	//이미지 게시판 목록
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
	
	//글 상세보기
	@Override
	@RequestMapping(value="/collectibleDetail.do", method=RequestMethod.GET)
	public ModelAndView collectibleDetail(@RequestParam("goods_id") int goods_id,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		String viewName=(String)request.getAttribute("viewName");
		collectibleVO= collectibleService.collectibleDetail(goods_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("collectible",collectibleVO); 

        

		//댓글기능
		List<ReplyVO> replyList = replyService.readReply(collectibleVO.getGoods_id());
		mav.addObject("replyList",replyList);
		//평가

		
		return mav;
	}

	//댓글작성
	@Override
	@RequestMapping(value="/replyWrite.do", method=RequestMethod.POST)
	public ModelAndView replyWrite(@ModelAttribute("reply")ReplyVO vo,
			RedirectAttributes rttr,HttpServletRequest request, HttpServletResponse response)throws Exception {

		replyService.writeReply(vo);	
		rttr.addAttribute("goods_id", vo.getGoods_id());
		
		//댓글 작성 완료시 해당글로 redirect하게 함
		ModelAndView mav = new ModelAndView("redirect:/collectible/collectibleDetail.do");
		return mav;
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
	@Override
	@RequestMapping(value="/modifyReply.do", method = RequestMethod.POST)
	public ModelAndView modifyReply(@ModelAttribute("reply")ReplyVO vo, RedirectAttributes rttr,
			HttpServletRequest request, HttpServletResponse response)throws Exception{

		replyService.updateReply(vo);		
		ModelAndView mav = new ModelAndView("redirect:/collectible/collectibleDetail.do");

		rttr.addAttribute("goods_id", vo.getGoods_id());
		return mav;
	}
	
	//댓글삭제
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
