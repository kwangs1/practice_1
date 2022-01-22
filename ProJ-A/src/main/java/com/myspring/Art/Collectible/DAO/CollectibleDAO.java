package com.myspring.Art.Collectible.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;

public interface CollectibleDAO {

	CollectibleVO selectCollectibleDetail(int goods_id) throws DataAccessException;

	List<CollectibleVO> selectAllCollectibleList(Map condMap) throws DataAccessException;


}
