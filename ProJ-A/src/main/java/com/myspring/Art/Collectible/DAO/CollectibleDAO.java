package com.myspring.Art.Collectible.DAO;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;

public interface CollectibleDAO {
	List selectAllCollectibleList() throws DataAccessException;

	CollectibleVO selectCollectibleDetail(int goods_id) throws DataAccessException;


}
