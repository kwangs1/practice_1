package com.myspring.Art.Collectible.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Art.Collectible.DAO.CollectibleDAO;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.common.domain.SearchCriteria;

@Service("collectibleService")
public class CollectibleServiceImpl implements CollectibleService{
	@Autowired
	private CollectibleDAO collectibleDAO;

	
	@Override
	public List<CollectibleVO> collectibleList(SearchCriteria scri) throws Exception{
		return collectibleDAO.selectAllCollectibleList(scri);
	}
	
	@Override
	public int countListTotal(SearchCriteria scri) {
	    return collectibleDAO.countList(scri);
	}
	
	@Override
	public CollectibleVO collectibleDetail(int goods_id)throws Exception{
		CollectibleVO collectibleVO = collectibleDAO.selectCollectibleDetail(goods_id);
		return collectibleVO;
	}
	
//	@Override
//	public int likehit(int goods_id)throws Exception{
//		return collectibleDAO.updateLikeHit(goods_id);
//	}
}
