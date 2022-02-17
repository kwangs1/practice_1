package com.myspring.Art.Admin.goods.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Art.Admin.goods.Service.AdminGoodsService;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;
import com.myspring.Art.Member.VO.MemberVO;
import com.myspring.Art.common.base.BaseController;
import com.myspring.Art.common.domain.Criteria;
import com.myspring.Art.common.domain.PageMaker;
import com.myspring.Art.common.domain.SearchCriteria;

@Controller("adminGoodsController")
@RequestMapping(value="/admin/goods")
public class AdminGoodsControllerImpl extends BaseController implements AdminGoodsController{
	private static final String CURR_IMAGE_REPO_PATH = "C:\\gallery\\file_repo";
	@Autowired
	private AdminGoodsService adminGoodsService;
	@Autowired
	private CollectibleVO colVO;
	
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
	public ModelAndView adminGoodsMain(@ModelAttribute("scri") SearchCriteria scri,
			                           HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String viewName=(String)request.getAttribute("viewName");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(adminGoodsService.countListTotal(scri));
		
		ModelAndView mav = new ModelAndView(viewName);		
		
		List<CollectibleVO> newGoodsList=adminGoodsService.listNewGoods(scri);
		mav.addObject("newGoodsList", newGoodsList);
		mav.addObject("pageMaker",pageMaker);
		
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

	  //수정화면만
	  @RequestMapping(value="/modifyGoodsForm.do", method=RequestMethod.GET)
	  public ModelAndView modifyGoods(@RequestParam("goods_id") int goods_id,@ModelAttribute("scri") SearchCriteria scri,
			  HttpServletRequest request, HttpServletResponse response)throws Exception{
			
		    String viewName=(String)request.getAttribute("viewName");
			ModelAndView mav = new ModelAndView(viewName);
			
			Map goodsMap=adminGoodsService.goodsDetail(goods_id);
			mav.addObject("goodsMap",goodsMap);
			mav.addObject("scri", scri);
			return mav;
	  }	 
		@RequestMapping(value="/modifyGoodsImageInfo.do" ,method={RequestMethod.POST})
		public void modifyGoodsImageInfo(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)  throws Exception {
			System.out.println("modifyGoodsImageInfo");
			multipartRequest.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String imageFileName=null;
			
			Map goodsMap = new HashMap();
			Enumeration enu=multipartRequest.getParameterNames();
			while(enu.hasMoreElements()){
				String name=(String)enu.nextElement();
				String value=multipartRequest.getParameter(name);
				goodsMap.put(name,value);
			}
			
			HttpSession session = multipartRequest.getSession();
			MemberVO memberVO = (MemberVO) session.getAttribute("memberInfo");
			String reg_id = memberVO.getMember_id();
			
			List<ImageFileVO> imageFileList=null;
			int goods_id=0;
			int image_id=0;
			try {
				imageFileList =upload(multipartRequest);
				if(imageFileList!= null && imageFileList.size()!=0) {
					for(ImageFileVO imageFileVO : imageFileList) {
						goods_id = Integer.parseInt((String)goodsMap.get("goods_id"));
						image_id = Integer.parseInt((String)goodsMap.get("image_id"));
						imageFileVO.setGoods_id(goods_id);
						imageFileVO.setImage_id(image_id);
						imageFileVO.setReg_id(reg_id);
					}
					
				    adminGoodsService.modifyGoodsImage(imageFileList);
					for(ImageFileVO  imageFileVO:imageFileList) {
						imageFileName = imageFileVO.getFileName();
						File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
						File destDir = new File(CURR_IMAGE_REPO_PATH+"\\"+goods_id);
						FileUtils.moveFileToDirectory(srcFile, destDir,true);
					}
				}
			}catch(Exception e) {
				if(imageFileList!=null && imageFileList.size()!=0) {
					for(ImageFileVO  imageFileVO:imageFileList) {
						imageFileName = imageFileVO.getFileName();
						File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
						srcFile.delete();
					}
				}
				e.printStackTrace();
			}
			
		}
 
		@RequestMapping(value="/modifyGoodsInfo.do" ,method={RequestMethod.POST})
		public ResponseEntity modifyGoodsInfo( @RequestParam("goods_id") String goods_id,
				                     @RequestParam("attribute") String attribute,
				                     @RequestParam("value") String value,
				HttpServletRequest request, HttpServletResponse response)  throws Exception {
			//System.out.println("modifyGoodsInfo");
			
			Map<String,String> goodsMap=new HashMap<String,String>();
			goodsMap.put("goods_id", goods_id);
			goodsMap.put(attribute, value);
			adminGoodsService.modifyGoodsInfo(goodsMap);
			
			String message = null;
			ResponseEntity resEntity = null;
			HttpHeaders responseHeaders = new HttpHeaders();
			message  = "mod_success";
			resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
			return resEntity;
		}

	
	

}
