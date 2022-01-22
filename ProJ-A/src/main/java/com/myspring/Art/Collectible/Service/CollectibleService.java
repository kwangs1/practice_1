package com.myspring.Art.Collectible.Service;

import java.util.List;
import java.util.Map;

import com.myspring.Art.Collectible.VO.CollectibleVO;

public interface CollectibleService {

	CollectibleVO collectibleDetail(int goods_id) throws Exception;

	List<CollectibleVO> collectibleList(Map condMap) throws Exception;

}
