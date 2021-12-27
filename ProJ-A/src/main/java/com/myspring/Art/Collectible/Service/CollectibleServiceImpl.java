package com.myspring.Art.Collectible.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Art.Collectible.DAO.CollectibleDAO;
import com.myspring.Art.Collectible.VO.CollectibleVO;

@Service("collectibleService")
public class CollectibleServiceImpl implements CollectibleService{
	@Autowired
	private CollectibleDAO collectibleDAO;
	
	@Override
	public Map<String, List<CollectibleVO>> listGoods() throws Exception{
		Map<String, List<CollectibleVO>> goodsMap = new HashMap<String,List<CollectibleVO>>();
		List<CollectibleVO> goodsList = collectibleDAO.selectGoodsList("collectible");
		goodsMap.put("collectible", goodsList);
		return goodsMap;
	}
}
