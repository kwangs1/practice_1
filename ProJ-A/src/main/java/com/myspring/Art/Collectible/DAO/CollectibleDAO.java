package com.myspring.Art.Collectible.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface CollectibleDAO {

	CollectibleVO selectCollectibleDetail(int goods_id) throws DataAccessException;

	int countList(SearchCriteria scri);

	List<CollectibleVO> selectAllCollectibleList(SearchCriteria scri) throws DataAccessException;
}
