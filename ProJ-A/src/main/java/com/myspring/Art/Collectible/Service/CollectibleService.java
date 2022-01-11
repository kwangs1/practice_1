package com.myspring.Art.Collectible.Service;

import java.util.List;
import java.util.Map;

import com.myspring.Art.Collectible.VO.CollectibleVO;

public interface CollectibleService {
	List collectibleList() throws Exception;

	CollectibleVO collectibleDetail(int goods_id) throws Exception;

}
