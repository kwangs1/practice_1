package com.myspring.Art.Admin.video.Controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Art.Admin.video.Service.videoService;
import com.myspring.Art.Admin.video.VO.videoVO;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Member.VO.MemberVO;
import com.myspring.Art.common.base.BaseController;
import com.myspring.Art.common.domain.PageMaker;
import com.myspring.Art.common.domain.SearchCriteria;

@Controller("videoController")
@RequestMapping("/admin/video")
public class videoControllerImpl extends BaseController implements videoController{
	private static final String CURR_VIDEO_REPO_PATH = "C:\\gallery\\video_repo";
	@Autowired
	private videoService videoService;
	
	@Override
	@RequestMapping(value="/addNewVideo.do" , method = RequestMethod.POST)
	public ResponseEntity addNewVideo(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)throws Exception{
		multipartRequest.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String movieFileName = null;
		
		Map newVideoMap = new HashMap();
		Enumeration enu = multipartRequest.getParameterNames();
		
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			newVideoMap.put(name, value);
		}
		
		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
		String reg_id = memberVO.getMember_id();
		
		List<videoVO> movieFileList = VideoUpload(multipartRequest);
		if(movieFileList != null && movieFileList.size() != 0) {
			for(videoVO videoVO : movieFileList) {
				videoVO.setReg_id(reg_id);
			}
			newVideoMap.put("movieFileList", movieFileList);
		}
		
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int vno = videoService.addNewVideo(newVideoMap);
			if(movieFileList != null && movieFileList.size() != 0) {
				for(videoVO videoVO : movieFileList) {
					movieFileName = videoVO.getMovieFileName();
					File srcFile = new File(CURR_VIDEO_REPO_PATH + "\\" + "temp" + "\\" + movieFileName);
					File destDir = new File(CURR_VIDEO_REPO_PATH + "\\" + vno);
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
			}
			message = "<script>";
			message += "alert('등록 완료');";
			message += "location.href='"+ multipartRequest.getContextPath()+"/admin/video/addNewVideo.do';";
			message += "</script>";
		}catch(Exception e) {
			if(movieFileList != null && movieFileList.size() != 0) {
				for(videoVO videoVO: movieFileList) {
					movieFileName = videoVO.getMovieFileName();
					File srcFile = new File(CURR_VIDEO_REPO_PATH +"\\" +"temp"+"\\"+movieFileName);
					srcFile.delete();
				}
			}
			message="<script>";
			message +=" alert('오류가 발생했습니다. 다시 시도해 주세요');";
			message +=" location.href='"+multipartRequest.getContextPath()+"/admin/video/addNewVideo.do';";
			message +="</script>)";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
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
}
