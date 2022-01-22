package com.myspring.Art.Collectible.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Art.Admin.notice.VO.NoticeVO;
import com.myspring.Art.Collectible.DAO.CollectibleDAO;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;

@Service("collectibleService")
public class CollectibleServiceImpl implements CollectibleService{
	@Autowired
	private CollectibleDAO collectibleDAO;

	
	@Override
	public List<CollectibleVO> collectibleList(Map condMap) throws Exception{
		return collectibleDAO.selectAllCollectibleList(condMap);
	}
	
	@Override
	public CollectibleVO collectibleDetail(int goods_id)throws Exception{
		CollectibleVO collectibleVO = collectibleDAO.selectCollectibleDetail(goods_id);
		return collectibleVO;
	}
}
