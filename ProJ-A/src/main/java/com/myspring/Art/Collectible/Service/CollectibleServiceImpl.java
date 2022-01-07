package com.myspring.Art.Collectible.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Art.Collectible.DAO.CollectibleDAO;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;

@Service("collectibleService")
public class CollectibleServiceImpl implements CollectibleService{
	@Autowired
	private CollectibleDAO collectibleDAO;

	@Override
	public Map<String, List<CollectibleVO>> listCollectible() throws Exception{
		Map<String, List<CollectibleVO>> collectibleMap = new HashMap<String,List<CollectibleVO>>();
		List<CollectibleVO> CollectibleList = collectibleDAO.selectCollectibleList("collectible");
		collectibleMap.put("collectible", CollectibleList);
		return collectibleMap;
	}
	
	@Override
	public Map collectibleDetail(String _goods_id)throws Exception{
		Map collectibleMap = new HashMap();
		CollectibleVO collectibleVO = collectibleDAO.selectCollectibleDetail(_goods_id);
		collectibleMap.put("collectibleVO",collectibleVO);
		return collectibleMap;
	}

}
