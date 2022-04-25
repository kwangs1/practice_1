package com.myspring.Art.Admin.video.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.Admin.notice.VO.NoticeVO;
import com.myspring.Art.Admin.video.Service.videoService;
import com.myspring.Art.Admin.video.VO.videoVO;
import com.myspring.Art.common.base.BaseController;
import com.myspring.Art.common.domain.PageMaker;
import com.myspring.Art.common.domain.SearchCriteria;

@Controller("videoController")
@RequestMapping("/admin/video")
public class videoControllerImpl extends BaseController implements videoController{
	private static final Logger log = LoggerFactory.getLogger(videoControllerImpl.class);
	@Autowired
	private videoService videoService;
	@Autowired
	private videoVO videoVO;

	//YouTube에 등록된 영상을 볼 수 있게 하였음.
	
	//관리자 화면 목록
	@Override
	@RequestMapping(value="/adminVideoMain.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView adminVideoMain(@ModelAttribute("scri") SearchCriteria scri,
			                           HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String viewName=(String)request.getAttribute("viewName");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(videoService.countListTotal(scri));
		
		ModelAndView mav = new ModelAndView(viewName);		
		
		List<videoVO> list=videoService.selectVideoList(scri);
		mav.addObject("list", list);
		mav.addObject("pageMaker",pageMaker);
		
		return mav;
	}
	
	//사용자 목록페이지
	@Override
	@RequestMapping(value="/videoListView.do" , method=RequestMethod.GET)
	public ModelAndView VideoList(@ModelAttribute("scri") SearchCriteria scri,
				HttpServletRequest request,HttpServletResponse response)throws Exception{
		String viewName=(String)request.getAttribute("viewName");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(videoService.countListTotal(scri));
		
		ModelAndView mav = new ModelAndView(viewName);		
		
		List<videoVO> videolist=videoService.selectVideoView(scri);
		mav.addObject("videolist", videolist);
		mav.addObject("pageMaker",pageMaker);
		
		return mav;
	}
	
	//등록 post
	@Override
	@RequestMapping(value="/youtube/addAction.do" , method = RequestMethod.POST)
	public ModelAndView createAction(@ModelAttribute("videoVO")videoVO videoVO, MultipartHttpServletRequest multiRequest,
				BindingResult bindingResult)throws Exception{
		
		int result = 0;
		//영상 등록 시 YouTube 동영상 URL에 대한 값을 가져오기 위해
		videoVO.setV_addr("https://youtu.be/" + videoVO.getV_addr());
		result =videoService.youtubeInsert(videoVO);
		
		//영상 등록이 완료되면 영상 메인페이지로 redirect하게 함.
		ModelAndView mav = new ModelAndView("redirect:/admin/video/adminVideoMain.do");
		return mav;
	}
	//등록 get
	@RequestMapping(value="/addNewVideoForm.do", method = RequestMethod.GET)
	public ModelAndView addNewNotice(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		return mav;
	}
	//상세페이지
	@Override
	@RequestMapping(value="/adminVideoDetail.do" , method=RequestMethod.GET)
	public ModelAndView adminVideoDetail(@RequestParam("vno")int vno,
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		videoVO = videoService.videoDetail(vno);
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("video",videoVO);
		
		return mav;
	}
	//삭제
	@Override
	@RequestMapping(value="/removeVideo.do" ,method=RequestMethod.GET)
	public ModelAndView removeVideo(@RequestParam("vno")int vno, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes redAttr,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		videoService.removeVideo(vno);
		
		redAttr.addAttribute("page", scri.getPage());
	    redAttr.addAttribute("perPagNum", scri.getPerPageNum());
	    redAttr.addAttribute("searchType",scri.getSearchType());
	    redAttr.addAttribute("keyword",scri.getKeyword());
	    
	    ModelAndView mav = new ModelAndView("redirect:/admin/video/adminVideoMain.do");
		return mav;
	}
	//수정 get
	@RequestMapping(value="/modifyVideoForm.do", method = RequestMethod.GET)
	public ModelAndView modifyVideoForm(@RequestParam("vno")int vno,@ModelAttribute("scri") SearchCriteria scri,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName=(String)request.getAttribute("viewName");
		videoVO = videoService.videoDetail(vno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("video",videoVO);
		
		mav.addObject("scri", scri);
		return mav;
}
	//수정 post
	@Override
	@RequestMapping(value="/modifyVideo.do", method=RequestMethod.POST)
	public ModelAndView modifyVideo(@ModelAttribute("video")videoVO vo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes redAttr,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = videoService.modifyVideo(vo);
		ModelAndView mav = new ModelAndView("redirect:/admin/video/adminVideoMain.do");
		
		redAttr.addAttribute("page", scri.getPage());
	    redAttr.addAttribute("perPagNum", scri.getPerPageNum());
	    redAttr.addAttribute("searchType",scri.getSearchType());
	    redAttr.addAttribute("keyword",scri.getKeyword());

		return mav;
	}
}
