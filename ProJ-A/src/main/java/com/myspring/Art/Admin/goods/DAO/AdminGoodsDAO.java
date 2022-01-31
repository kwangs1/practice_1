package com.myspring.Art.Admin.goods.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface AdminGoodsDAO {

	int insertNewGoods(Map newGoodsMap) throws DataAccessException;

	void insertGoodsImageFile(List fileList) throws DataAccessException;

	void deleteGoods(int goods_id) throws DataAccessException;

	CollectibleVO selectGoodsDetail(int goods_id) throws DataAccessException;

	void updateGoodsInfo(Map goodsMap) throws DataAccessException;

	void updateGoodsImage(List<ImageFileVO> imageFileList) throws DataAccessException;

	List selectGoodsImageFileList(int goods_id) throws DataAccessException;

	List<CollectibleVO> selectNewGoodsList(SearchCriteria scri) throws DataAccessException;

	int countList(SearchCriteria scri);
}
