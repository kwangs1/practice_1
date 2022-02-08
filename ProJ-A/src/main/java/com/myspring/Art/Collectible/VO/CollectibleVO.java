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
	private String goods_status;
	private String goods_note;
	private int goods_year;
	private String goods_fileName;
	private String goods_regDate;
	private int likehit;

	
	public int getLikehit() {
		return likehit;
	}
	public void setLikehit(int likehit) {
		this.likehit = likehit;
	}
	public String getGoods_fileName() {
		return goods_fileName;
	}
	public void setGoods_fileName(String goods_fileName) {
		this.goods_fileName = goods_fileName;
	}
	public int getGoods_year() {
		return goods_year;
	}
	public void setGoods_year(int goods_year) {
		this.goods_year = goods_year;
	}
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
	
	public String getGoods_status() {
		return goods_status;
	}
	public void setGoods_status(String goods_status) {
		this.goods_status = goods_status;
	}
	public String getGoods_note() {
		return goods_note;
	}
	public void setGoods_note(String goods_note) {
		this.goods_note = goods_note;
	}
	public String getGoods_regDate() {
		return goods_regDate;
	}
	public void setGoods_regDate(String goods_regDate) {
		this.goods_regDate = goods_regDate;
	}
	
	
}
