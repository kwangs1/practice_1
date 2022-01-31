package com.myspring.Art.Admin.goods.Service;

import java.util.List;
import java.util.Map;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface AdminGoodsService {

	int addNewGoods(Map newGoodsMap) throws Exception;

	List<CollectibleVO> listNewGoods(SearchCriteria scri) throws Exception;

	void removeGoods(int goods_id) throws Exception;

	Map goodsDetail(int goods_id) throws Exception;

	void modifyGoodsInfo(Map goodsMap) throws Exception;

	void modifyGoodsImage(List<ImageFileVO> imageFileList) throws Exception;

	int countListTotal(SearchCriteria scri);
}
