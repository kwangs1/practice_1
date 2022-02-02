package com.myspring.Art.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class videoDownloadController {
	private static final Logger logger = LoggerFactory.getLogger(videoDownloadController.class);
	private static String CURR_VIDEO_REPO_PATH = "C:\\gallery\\video_repo";

	@RequestMapping("/Videodownload")
	protected void renderMergedOutputModel(@RequestParam("moveiName") String movieName,@RequestParam("vno") String vno,
			HttpServletRequest request, HttpServletResponse response)throws IOException{
		logger.debug("************** class = {}, function = {}", this.getClass().getName(), new Object(){}.getClass().getEnclosingMethod().getName()); 
		
		String fileFullPath = CURR_VIDEO_REPO_PATH +"\\"+ vno + "\\" + movieName; 
		File downFile = new File(fileFullPath); 
		if(downFile.isFile()){ 
		int fSize = (int)downFile.length(); 
		
		response.setBufferSize(fSize); 
		response.setContentType("application/octet-stream"); 
		response.setHeader("Content-Disposition", "attachment; movieName="+movieName+";"); 
		response.setContentLength(fSize); 
		
		FileInputStream in = new FileInputStream(downFile); 
		ServletOutputStream out = response.getOutputStream(); 
		
		try { 
			byte[] buf=new byte[8192];
			 int bytesread = 0, bytesBuffered = 0; 
			 while((bytesread = in.read( buf )) > -1 ) { 
				 out.write( buf, 0, bytesread ); bytesBuffered += bytesread;
				 if (bytesBuffered > 1024 * 1024) { 
					 bytesBuffered = 0; out.flush(); 
					 } 
				 }
			 } finally { 
				 if (out != null) { 
					 out.flush(); out.close();
					 } 
			 if (in != null) { 
				 in.close();
				 } 
			 } 
		}
	}
}
