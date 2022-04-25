package com.myspring.Art.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class fileDownloadController {
	//파일 저장 위치
	private static String CURR_IMAGE_REPO_PATH = "C:\\gallery\\file_repo";
	
	@RequestMapping("/download")
	protected void download(@RequestParam("fileName") String fileName,//다운로드할 이미지 파일 이름을 전달.
			@RequestParam("goods_id")String goods_id, HttpServletResponse response)throws Exception{
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH +"\\"+goods_id+"\\"+fileName;
		File image = new File(filePath);//다운로드할 파일 객체를 생성
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName);//헤더에 파일 이름을 설정
		FileInputStream in = new FileInputStream(image);
		byte[] buffer = new byte[1024*8];
		
		//buffer를 이용해 한 번에 8k byte씩 브라우저로 전송
		while(true) {
			int count = in.read(buffer);
			if(count == -1)
				break;
			out.write(buffer,0,count);
		}
		in.close();
		out.close();
	}
	
	@RequestMapping("/thumbnails.do")
	protected void thumbnails(@RequestParam("fileName") String fileName,
                            	@RequestParam("goods_id") String goods_id,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath=CURR_IMAGE_REPO_PATH+"\\"+goods_id+"\\"+fileName;
		File image=new File(filePath);
		
		//원본 이미지에 대한 썸네일 이미지를 생성한 후 OutputStream 객체 할당.
		if (image.exists()) { 
			Thumbnails.of(image).size(121,154).outputFormat("png").toOutputStream(out);
		}
		//썸네일 이미지를 OutputStream 객체를 이용해 브라우저로 전송.
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
	}
}
