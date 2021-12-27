package com.myspring.Art.Collectible.VO;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("collectibleVO")
public class CollectibleVO {
	private int goods_id;
	private String goods_title;
	private String goods_no;
	private String goods_author;
	private String goods_stuff;
	private String goods_standard;
	private String goods_note;
	private Date   goods_credate;
	
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_title() {
		return goods_title;
	}
	public void setGoods_title(String goods_title) {
		this.goods_title = goods_title;
	}
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	public String getGoods_author() {
		return goods_author;
	}
	public void setGoods_author(String goods_author) {
		this.goods_author = goods_author;
	}
	public String getGoods_stuff() {
		return goods_stuff;
	}
	public void setGoods_stuff(String goods_stuff) {
		this.goods_stuff = goods_stuff;
	}
	public String getGoods_standard() {
		return goods_standard;
	}
	public void setGoods_standard(String goods_standard) {
		this.goods_standard = goods_standard;
	}
	public String getGoods_note() {
		return goods_note;
	}
	public void setGoods_note(String goods_note) {
		this.goods_note = goods_note;
	}
	public Date getGoods_credate() {
		return goods_credate;
	}
	public void setGoods_credate(Date goods_credate) {
		this.goods_credate = goods_credate;
	}
	
	
}
