package com.myspring.Art.Admin.goods.Service;

import java.util.List;
import java.util.Map;

import com.myspring.Art.Collectible.VO.CollectibleVO;

public interface AdminGoodsService {

	int addNewGoods(Map newGoodsMap) throws Exception;

	List<CollectibleVO> listNewGoods(Map condMap) throws Exception;
}
