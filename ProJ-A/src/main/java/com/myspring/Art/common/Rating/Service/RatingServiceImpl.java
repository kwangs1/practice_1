package com.myspring.Art.common.Rating.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.Art.common.Rating.DAO.RatingDAO;
import com.myspring.Art.common.Rating.VO.RatingVO;

@Service("ratingService")
@Transactional(propagation = Propagation.REQUIRED)
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingDAO ratingDAO;
	
	@Override
	public void writeRating(RatingVO vo)throws Exception{
		ratingDAO.writeRating(vo);
	}
	
	@Override
	public List<RatingVO>selectRating(int goods_id)throws Exception{
		return ratingDAO.selectRating(goods_id);
	}

}
