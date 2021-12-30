package com.myspring.Art.Collectible.DAO;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;

public interface CollectibleDAO {

	List<CollectibleVO> selectCollectibleList(String goodsStatus) throws DataAccessException;

	CollectibleVO selectCollectibleDetail(String goods_id) throws DataAccessException;

	List<ImageFileVO> selectCollectibleDetailImage(String goods_id) throws DataAccessException;

}
