package com.myspring.Art.Admin.video.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Art.Admin.video.DAO.videoDAO;
import com.myspring.Art.Admin.video.VO.videoVO;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.domain.SearchCriteria;

@Service("videoService")
public class videoServiceImpl implements videoService{
	@Autowired
	private videoDAO videoDAO;
	
	@Override
	public int addNewVideo(Map newVideoMap)throws Exception{
		int vno = videoDAO.insertNewVideo(newVideoMap);
		ArrayList<videoVO> movieFileList = (ArrayList)newVideoMap.get("movieFileList");
		for(videoVO videoVO: movieFileList) {
			videoVO.setVno(vno);
		}
		videoDAO.insertNewVideoFile(movieFileList);
		return vno;
	}
	
	@Override
	public List<videoVO> selectVideoList(SearchCriteria scri) throws Exception{
		return videoDAO.selectVideoList(scri);
	}
	
	@Override
	public int countListTotal(SearchCriteria scri) {
	    return videoDAO.countList(scri);
	}
}
