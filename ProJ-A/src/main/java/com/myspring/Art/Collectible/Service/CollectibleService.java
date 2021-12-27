package com.myspring.Art.Collectible.Service;

import java.util.List;
import java.util.Map;

import com.myspring.Art.Collectible.VO.CollectibleVO;

public interface CollectibleService {

	Map<String, List<CollectibleVO>> listGoods() throws Exception;

}
