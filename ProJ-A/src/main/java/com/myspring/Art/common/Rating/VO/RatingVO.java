package com.myspring.Art.common.Rating.VO;

import org.springframework.stereotype.Component;

@Component("ratingVO")
public class RatingVO {
	private int rseq;
	private int good;
	private int usually;
	private int bad;
	private String member_id;
	private int goods_id;

	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getUsually() {
		return usually;
	}
	public void setUsually(int usually) {
		this.usually = usually;
	}
	public int getBad() {
		return bad;
	}
	public void setBad(int bad) {
		this.bad = bad;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	@Override
	public String toString() {
		return "RatingVO [rseq=" + rseq + ", good=" + good + ", usually=" + usually + ", bad=" + bad + ", member_id="
				+ member_id + ", goods_id=" + goods_id + "]";
	}	
	
	
}
