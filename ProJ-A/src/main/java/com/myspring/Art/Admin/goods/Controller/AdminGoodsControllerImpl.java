package com.myspring.Art.Admin.goods.Controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Art.Admin.goods.Service.AdminGoodsService;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;
import com.myspring.Art.Member.VO.MemberVO;
import com.myspring.Art.common.base.BaseController;

@Controller("adminGoodsController")
@RequestMapping(value="/admin/goods")
public class AdminGoodsControllerImpl extends BaseController implements AdminGoodsController{
	private static final String CURR_IMAGE_REPO_PATH = "C:\\gallery\\file_repo";
	@Autowired
	private AdminGoodsService adminGoodsService;
	
	@Override
	@RequestMapping(value="/addNewGoods.do" , method= RequestMethod.POST)
	public ResponseEntity addNewGoods(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)throws Exception{
		multipartRequest.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String imageFileName = null;
		
		Map newGoodsMap = new HashMap();
		Enumeration enu = multipartRequest.getParameterNames();
		
		while(enu.hasMoreElements()){
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			newGoodsMap.put(name, value);
		}
		
		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
		String reg_id = memberVO.getMember_id();
		
		List<ImageFileVO> imageFileList = upload(multipartRequest);
		if(imageFileList != null && imageFileList.size() != 0) {
			for(ImageFileVO imageFileVO : imageFileList) {
				imageFileVO.setReg_id(reg_id);
			}
			newGoodsMap.put("imageFileList", imageFileList);
		}
		
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int goods_id = adminGoodsService.addNewGoods(newGoodsMap);
			if(imageFileList != null && imageFileList.size() != 0) {
				for(ImageFileVO imageFileVO:imageFileList) {
					imageFileName = imageFileVO.getFileName();
					File srcFile = new File(CURR_IMAGE_REPO_PATH +"\\" + "temp" + "\\" +  imageFileName);
					File destDir = new File(CURR_IMAGE_REPO_PATH +"\\"+goods_id);
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
			}
			message = "<script>";
			message += "alert('작품 등록완료!');";
			message += "location.href='"+multipartRequest.getContextPath()+"/admin/goods/adminGoodsMain.do';";
			message += "</script>";
		}catch(Exception e) {
			if(imageFileList != null && imageFileList.size() != 0) {
				for(ImageFileVO imageFileVO:imageFileList) {
					imageFileName = imageFileVO.getFileName();
					File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
					srcFile.delete();
				}
			}
			message="<script>";
			message +=" alert('오류가 발생했습니다. 다시 시도해 주세요');";
			message +=" location.href='"+multipartRequest.getContextPath()+"/admin/goods/addNewGoodsForm.do';";
			message +="</script>)";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	@Override
	@RequestMapping(value="/adminGoodsMain.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView adminGoodsMain(@RequestParam Map<String, String> dateMap,
			                           HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		String section = dateMap.get("section");
		String pageNum = dateMap.get("pageNum");
		
		Map<String,Object> condMap=new HashMap<String,Object>();
		if(section== null) {
			section = "1";
		}
		condMap.put("section",section);
		if(pageNum== null) {
			pageNum = "1";
		}
		condMap.put("pageNum",pageNum);
		List<CollectibleVO> newGoodsList=adminGoodsService.listNewGoods(condMap);
		mav.addObject("newGoodsList", newGoodsList);
		
		mav.addObject("section", section);
		mav.addObject("pageNum", pageNum);
		return mav;
		
	}
	
	  @Override
	  @RequestMapping(value="/removeGoods.do" ,method = RequestMethod.POST)
	  @ResponseBody
	  public ResponseEntity  removeGoods(@RequestParam("goods_id") int goods_id,
	                              HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt=null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			adminGoodsService.removeGoods(goods_id);
			File destDir = new File(CURR_IMAGE_REPO_PATH +"\\"+goods_id);
			FileUtils.deleteDirectory(destDir);
			
			message = "<script>";
			message += " alert('글을 삭제했습니다.');";
			message += " location.href='"+request.getContextPath()+"/admin/goods/adminGoodsMain.do';";
			message +=" </script>";
		    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		       
		}catch(Exception e) {
			message = "<script>";
			message += " alert('작업중 오류가 발생했습니다.다시 시도해 주세요.');";
			message += " location.href='"+request.getContextPath()+"/admin/goods/adminGoodsMain.do';";
			message +=" </script>";
		    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		    e.printStackTrace();
		}
		return resEnt;
	  }
	  
	  @Override
	  @RequestMapping(value="/modifyGoods.do" , method = RequestMethod.POST)
	  @ResponseBody
	  public ResponseEntity modifyGoods(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)throws Exception{
		  multipartRequest.setCharacterEncoding("utf-8");
		  Map<String,Object> goodsMap = new HashMap<String,Object>();
		  Enumeration enu = multipartRequest.getParameterNames();
		  while(enu.hasMoreElements()) {
			  String name = (String)enu.nextElement();
			  String value = multipartRequest.getParameter(name);
			  goodsMap.put(name, value);
		  }
		  	List<ImageFileVO> imageFileName = upload(multipartRequest);
		  	goodsMap.put("imageFileName", imageFileName);
		  	
		  	String goods_id = (String)goodsMap.get("goods_id");
		  	String message;
		  	ResponseEntity resEnt = null;
		  	HttpHeaders responseHeaders = new HttpHeaders();
		  	responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
		      adminGoodsService.modifyGoods(goodsMap);
		       if(imageFileName!=null && imageFileName.length()!=0) {
		         File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
		         File destDir = new File(CURR_IMAGE_REPO_PATH+"\\"+goods_id);
		         FileUtils.moveFileToDirectory(srcFile, destDir, true);
		         
		         String originalFileName = (String)goodsMap.get("originalFileName");
		         File oldFile = new File(CURR_IMAGE_REPO_PATH+"\\"+goods_id+"\\"+originalFileName);
		         oldFile.delete();
		}
		       message = "<script>";
			   message += " alert('글을 수정했습니다.');";
			   message += " location.href='"+multipartRequest.getContextPath()+"/admin/goods/modifyGoods.do?goods_id="+goods_id+"';";
			   message +=" </script>";
		       resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	  }catch(Exception e) {
		  File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
	      srcFile.delete();
	      message = "<script>";
		  message += " alert('오류가 발생했습니다.다시 수정해주세요');";
		  message += " location.href='"+multipartRequest.getContextPath()+"/admin/goods/modifyGoods.do?articleNO="+goods_id+"';";
		  message +=" </script>";
	      resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	  }
		return resEnt;
	  }
	  @RequestMapping(value="/modifyGoodsForm.do", method=RequestMethod.GET)
	  public ModelAndView modifyGoods(@RequestParam("goods_id") int goods_id,
			  HttpServletRequest request, HttpServletResponse response)throws Exception{
			
		    String viewName=(String)request.getAttribute("viewName");
			ModelAndView mav = new ModelAndView(viewName);
			
			Map goodsMap=adminGoodsService.goodsDetail(goods_id);
			mav.addObject("goodsMap",goodsMap);
			
			return mav;
	  }	  
	@RequestMapping(value = "/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
}
