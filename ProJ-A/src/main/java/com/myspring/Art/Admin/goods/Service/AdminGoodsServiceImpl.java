package com.myspring.Art.Admin.goods.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.Art.Admin.goods.DAO.AdminGoodsDAO;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;

@Service("adminGoodsService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminGoodsServiceImpl implements AdminGoodsService{
	@Autowired
	private AdminGoodsDAO adminGoodsDAO;
	
	@Override
	public int addNewGoods(Map newGoodsMap)throws Exception{
		int goods_id = adminGoodsDAO.insertNewGoods(newGoodsMap);
		ArrayList<ImageFileVO> imageFileList = (ArrayList)newGoodsMap.get("imageFileList");
		for(ImageFileVO imageFileVO:imageFileList) {
			imageFileVO.setGoods_id(goods_id);
		}
		adminGoodsDAO.insertGoodsImageFile(imageFileList);
		return goods_id;
	}
	
	@Override
	public List<CollectibleVO> listNewGoods(Map condMap) throws Exception{
		return adminGoodsDAO.selectNewGoodsList(condMap);
	}
}
