package com.myspring.Art.common.Like.Service;

public interface LikeService {

	void likeUp(int goods_id, String member_id, int like_type);

	void likeDown(int goods_id, String member_id, int like_type);

	int getLike(int goods_id, int like_type);

	int findLike(int goods_id, String member_id);

}
