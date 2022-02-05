package com.myspring.Art.Admin.video.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Art.Admin.notice.VO.NoticeVO;
import com.myspring.Art.Admin.video.DAO.videoDAO;
import com.myspring.Art.Admin.video.VO.videoVO;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.domain.SearchCriteria;

@Service("videoService")
public class videoServiceImpl implements videoService{
	@Autowired
	private videoDAO videoDAO;
	
	@Override
	public int youtubeInsert(videoVO videoVO)throws Exception{
		return videoDAO.youtubeInsert(videoVO);
	}
	//관리자
	@Override
	public List<videoVO> selectVideoList(SearchCriteria scri) throws Exception{
		return videoDAO.selectVideoList(scri);
	}
	//사용자
	@Override
	public List<videoVO> selectVideoView(SearchCriteria scri) throws Exception{
		return videoDAO.selectVideoView(scri);
	}
	@Override
	public int countListTotal(SearchCriteria scri) {
	    return videoDAO.countList(scri);
	}
	
	@Override
	public videoVO videoDetail(int vno)throws Exception{
		videoVO vo = videoDAO.selectVideoDetail(vno);
		return vo;
	}
	
	@Override
	public int removeVideo(int vno)throws Exception{
		return videoDAO.deleteVideoList(vno);
	}
	
	@Override
	public int modifyVideo(videoVO vo) throws Exception {
		return videoDAO.modifyVideo(vo);
	}
}
