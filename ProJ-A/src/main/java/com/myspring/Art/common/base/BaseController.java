package com.myspring.Art.common.base;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Art.Collectible.VO.ImageFileVO;

public abstract class BaseController {
	private static final String CURR_IMAGE_REPO_PATH = "C:\\gallery\\file_repo";

	protected List<ImageFileVO> upload(MultipartHttpServletRequest multipartRequest) throws Exception {
		List<ImageFileVO> fileList = new ArrayList<ImageFileVO>();// 파일 정보를 저장할 fileList 선언
		Iterator<String> fileNames = multipartRequest.getFileNames();
		// 상품 등록창에서 전송된 파일들의 정보를 filelist에 저장
		while (fileNames.hasNext()) {
			ImageFileVO imageFileVO = new ImageFileVO();
			String fileName = fileNames.next();
			imageFileVO.setFileType(fileName);
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String originalFileName = mFile.getOriginalFilename();
			imageFileVO.setFileName(originalFileName);
			fileList.add(imageFileVO);

			File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);
			if (mFile.getSize() != 0) {// file null check
				if (!file.exists()) {// 경로상에 파일이 존재하지 않는경우
					if (file.getParentFile().mkdirs()) {// 경로에 해당하는 디렉토리 생성
						file.createNewFile();// 이후 파일생성
					}
				}
				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + originalFileName));// 임시로 정장된
																											// 멀티파트파일을
																											// 실제파일로 전송
			}
		}
		return fileList;
	}
	
	protected String upload2(MultipartHttpServletRequest multipartRequest) throws Exception{
		String imageFileName= null;
		Iterator<String> fileNames = multipartRequest.getFileNames();
		
		while(fileNames.hasNext()){
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			imageFileName=mFile.getOriginalFilename();
			File file = new File(CURR_IMAGE_REPO_PATH +"\\"+"temp"+"\\" + fileName);
			if(mFile.getSize()!=0){ //File Null Check
				if(!file.exists()){ //경로상에 파일이 존재하지 않을 경우
					file.getParentFile().mkdirs();  //경로에 해당하는 디렉토리들을 생성
					mFile.transferTo(new File(CURR_IMAGE_REPO_PATH +"\\"+"temp"+ "\\"+imageFileName)); //임시로 저장된 multipartFile을 실제 파일로 전송
				}
			}
			
		}
		return imageFileName;
	}

	private void deleteFile(String fileName) {
		File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);
		try {
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/*.do", method = { RequestMethod.POST, RequestMethod.GET })
	protected ModelAndView viewForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	protected String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}
}
