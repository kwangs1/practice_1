package com.myspring.Art.Admin.video.VO;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("videoVO")
public class videoVO {
	private int vno;
	private String title;
	private String note;
	private String movieName;
	private Date regDate;
	private String reg_id;
	private String movieFileName;
	
	public int getVno() {
		return vno;
	}
	public void setVno(int vno) {
		this.vno = vno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getMovieFileName() {
		return movieFileName;
	}
	public void setMovieFileName(String movieFileName) {
		this.movieFileName = movieFileName;
	}
	
	
}
