package com.myspring.Art.Admin.video.Service;

import java.util.List;
import java.util.Map;

import com.myspring.Art.Admin.video.VO.videoVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface videoService {

	List<videoVO> selectVideoList(SearchCriteria scri) throws Exception;

	int countListTotal(SearchCriteria scri);

	videoVO videoDetail(int vno) throws Exception;

	int youtubeInsert(videoVO videoVO) throws Exception;

	List<videoVO> selectVideoView(SearchCriteria scri) throws Exception;

	int removeVideo(int vno) throws Exception;

	int modifyVideo(videoVO vo) throws Exception;

}
