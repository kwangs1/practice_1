package com.myspring.Art.common.Like.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.Art.common.Like.Service.LikeService;
import com.myspring.Art.common.Like.VO.LikeVO;
import com.myspring.Art.common.base.BaseController;

@RestController
@RequestMapping(value="/like")
public class LikeControllerImpl extends BaseController implements LikeController{
	@Autowired
	private LikeService likeService;

	
	@RequestMapping(value="/likeUp.do" , method = RequestMethod.POST)
	public void likeUp(@RequestBody LikeVO like) throws Exception {
		likeService.likeUp(like.getGoods_id(),like.getMember_id(),like.getLike_type());
	}
	
	@RequestMapping(value="/likeDown.do" , method = RequestMethod.POST)
	public void likeDown(@RequestBody LikeVO like) {
		likeService.likeDown(like.getGoods_id(),like.getMember_id(),like.getLike_type());
	}
}
