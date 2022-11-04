package com.myspring.Art.common.Rating.VO;

import org.springframework.stereotype.Component;

@Component("ratingVO")
public class RatingVO {
	private int brno;
	private int rating;
	private String member_id;
	private int rating_type;
	
	
	public int getRating_type() {
		return rating_type;
	}
	public void setRating_type(int rating_type) {
		this.rating_type = rating_type;
	}
	public int getBrno() {
		return brno;
	}
	public void setBrno(int brno) {
		this.brno = brno;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
}
