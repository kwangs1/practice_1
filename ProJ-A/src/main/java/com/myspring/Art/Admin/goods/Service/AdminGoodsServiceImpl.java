package com.myspring.Art.Admin.goods.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.Art.Admin.goods.DAO.AdminGoodsDAO;
import com.myspring.Art.Collectible.VO.CollectibleVO;
import com.myspring.Art.Collectible.VO.ImageFileVO;
import com.myspring.Art.common.domain.SearchCriteria;

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
	public List<CollectibleVO> listNewGoods(SearchCriteria scri) throws Exception{
		return adminGoodsDAO.selectNewGoodsList(scri);
	}
	
	@Override
	public int countListTotal(SearchCriteria scri) {
	    return adminGoodsDAO.countList(scri);
	}
	
	@Override
	public void removeGoods(int goods_id) throws Exception {
		adminGoodsDAO.deleteGoods(goods_id);
	}
	
	@Override
	public Map goodsDetail(int goods_id)throws Exception{
		Map goodsMap = new HashMap();
		CollectibleVO colVO = adminGoodsDAO.selectGoodsDetail(goods_id);
		List imageFileList =adminGoodsDAO.selectGoodsImageFileList(goods_id);
		goodsMap.put("goods", colVO);
		goodsMap.put("imageFileList", imageFileList);
		return goodsMap;
	}

	@Override
	public void modifyGoodsInfo(Map goodsMap) throws Exception{
		adminGoodsDAO.updateGoodsInfo(goodsMap);
		
	}	
	@Override
	public void modifyGoodsImage(List<ImageFileVO> imageFileList) throws Exception{
		adminGoodsDAO.updateGoodsImage(imageFileList); 
	}

}
