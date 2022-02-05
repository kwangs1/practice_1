package com.myspring.Art.Admin.video.VO;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("videoVO")
public class videoVO {
	private int vno;
	private String v_title;
	private String v_note;
	private String v_addr;
	
	public int getVno() {
		return vno;
	}
	public void setVno(int vno) {
		this.vno = vno;
	}
	public String getV_title() {
		return v_title;
	}
	public void setV_title(String v_title) {
		this.v_title = v_title;
	}
	public String getV_note() {
		return v_note;
	}
	public void setV_note(String v_note) {
		this.v_note = v_note;
	}
	public String getV_addr() {
		return v_addr;
	}
	public void setV_addr(String v_addr) {
		this.v_addr = v_addr;
	}

	
	
	
}
