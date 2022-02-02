package com.myspring.Art.Admin.video.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Admin.video.VO.videoVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface videoDAO {

	int insertNewVideo(Map newVideoMap) throws DataAccessException;

	void insertNewVideoFile(List fileList) throws DataAccessException;

	int countList(SearchCriteria scri);

	List<videoVO> selectVideoList(SearchCriteria scri) throws DataAccessException;

}
