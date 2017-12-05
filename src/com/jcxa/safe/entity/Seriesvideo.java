package com.jcxa.safe.entity;

import java.util.Date;

public class Seriesvideo {
/*
 * 
 * 
 * 具体的课程
 * 
 * 
 */
	private int ID;
	private int SID;//seriesid
	private String Title;//标题
	private String FileName;//文件名
	private String VideoURL;//视频url
	private int ClickRate;//点击数
	private int ZanCts;//赞
	private int IsValid;//是否有效
	private int IsPrice;//是否收费
	private int Sort;//排序
    private Date CreateTime;//创建时间
    private int TeacherID;//教师
	private int shoucts;//收藏数
	private int buycts;//购买数
	private String des;//视频的描述
	private int fupin;//1:扶贫 0：未扶贫
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getVideoURL() {
		return VideoURL;
	}
	public void setVideoURL(String videoURL) {
		VideoURL = videoURL;
	}
	public int getClickRate() {
		return ClickRate;
	}
	public void setClickRate(int clickRate) {
		ClickRate = clickRate;
	}
	public int getZanCts() {
		return ZanCts;
	}
	public void setZanCts(int zanCts) {
		ZanCts = zanCts;
	}
	public int getIsValid() {
		return IsValid;
	}
	public void setIsValid(int isValid) {
		IsValid = isValid;
	}
	public int getIsPrice() {
		return IsPrice;
	}
	public void setIsPrice(int isPrice) {
		IsPrice = isPrice;
	}
	public int getSort() {
		return Sort;
	}
	public void setSort(int sort) {
		Sort = sort;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public int getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(int teacherID) {
		TeacherID = teacherID;
	}
	public int getShoucts() {
		return shoucts;
	}
	public void setShoucts(int shoucts) {
		this.shoucts = shoucts;
	}
	public int getBuycts() {
		return buycts;
	}
	public void setBuycts(int buycts) {
		this.buycts = buycts;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getFupin() {
		return fupin;
	}
	public void setFupin(int fupin) {
		this.fupin = fupin;
	}
	
	
	
	
   
	
	
	
}
