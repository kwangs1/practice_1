package com.myspring.Art.Admin.video.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Admin.video.VO.videoVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface videoDAO {

	int countList(SearchCriteria scri);

	List<videoVO> selectVideoList(SearchCriteria scri) throws DataAccessException;

	videoVO selectVideoDetail(int vno) throws DataAccessException;

	int youtubeInsert(videoVO videoVO) throws DataAccessException;

	List<videoVO> selectVideoView(SearchCriteria scri) throws DataAccessException;

	int deleteVideoList(int vno) throws DataAccessException;

	int modifyVideo(videoVO vo) throws DataAccessException;

}
