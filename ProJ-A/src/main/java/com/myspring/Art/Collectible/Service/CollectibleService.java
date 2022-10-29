package com.myspring.Art.Collectible.Service;

import java.util.List;
import java.util.Map;

import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.domain.SearchCriteria;

public interface CollectibleService {

	CollectibleVO collectibleDetail(int goods_id) throws Exception;

	int countListTotal(SearchCriteria scri);

	List<CollectibleVO> collectibleList(SearchCriteria scri) throws Exception;

	void UpdateLikeCount(int goods_id) throws Exception;

	void UpdateReplyCount(int goods_id) throws Exception;

}
