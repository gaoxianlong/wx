package com.jcxa.safe.entity;

import java.sql.Date;

public class Order {

	private int ID;
	private String OrderNO;
	private int PayMode;
	private String PayNO;
	private int UserID;
	private int SeriesID;
	private String Price;
	private int Status;
	private Date CreateTime;
	private Date PayTime;
	private Date overtime;
	private String statu;
	
	private String outtradeno;
	
	
	
	
	
	
	public String getOuttradeno() {
		return outtradeno;
	}
	public void setOuttradeno(String outtradeno) {
		this.outtradeno = outtradeno;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public Date getOvertime() {
		return overtime;
	}
	public void setOvertime(Date overtime) {
		this.overtime = overtime;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getOrderNO() {
		return OrderNO;
	}
	public void setOrderNO(String orderNO) {
		OrderNO = orderNO;
	}
	public int getPayMode() {
		return PayMode;
	}
	public void setPayMode(int payMode) {
		PayMode = payMode;
	}
	public String getPayNO() {
		return PayNO;
	}
	public void setPayNO(String payNO) {
		PayNO = payNO;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getSeriesID() {
		return SeriesID;
	}
	public void setSeriesID(int seriesID) {
		SeriesID = seriesID;
	}
	
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public Date getPayTime() {
		return PayTime;
	}
	public void setPayTime(Date payTime) {
		PayTime = payTime;
	}
	
	
	
}
