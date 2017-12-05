package com.jcxa.safe.entity;

import java.sql.Date;

public class Wxorder {

	private int id;
	private int uid;
	private String vip;
	private String vipsort;
	private String price;
	private String orderno;
	private String outtradeno;
	private Date createTime;
	private Date overtime;
	private long exp;
	private long starda;
	
	
	
	
	public String getOuttradeno() {
		return outtradeno;
	}
	public void setOuttradeno(String outtradeno) {
		this.outtradeno = outtradeno;
	}
	public long getStarda() {
		return starda;
	}
	public void setStarda(long starda) {
		this.starda = starda;
	}
	public long getExp() {
		return exp;
	}
	public void setExp(long exp) {
		this.exp = exp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public String getVipsort() {
		return vipsort;
	}
	public void setVipsort(String vipsort) {
		this.vipsort = vipsort;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getOvertime() {
		return overtime;
	}
	public void setOvertime(Date overtime) {
		this.overtime = overtime;
	}
	
	
	
	
}
