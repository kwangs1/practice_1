package com.myspring.Art.Admin.video.Service;

import java.util.List;
import java.util.Map;

import com.myspring.Art.Admin.video.VO.videoVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface videoService {

	int addNewVideo(Map newVideoMap) throws Exception;

	List<videoVO> selectVideoList(SearchCriteria scri) throws Exception;

	int countListTotal(SearchCriteria scri);

}
