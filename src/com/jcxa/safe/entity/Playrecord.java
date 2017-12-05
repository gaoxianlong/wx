package com.jcxa.safe.entity;

import java.util.Date;
/**播放记录*/
public class Playrecord {

	private int id;
	private int uid;
	private int vid;
	private String addtimes;
	/**扩展属性*/
	private int Sort;//视频集数
	private String Title;//视频标题
	private String PicURL;//图片地址
	private int SID;
	
	
	
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public int getSort() {
		return Sort;
	}
	public void setSort(int sort) {
		Sort = sort;
	}
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPicURL() {
		return PicURL;
	}
	public void setPicURL(String picURL) {
		PicURL = picURL;
	}
	
	public String getAddtimes() {
		return addtimes;
	}
	public void setAddtimes(String addtimes) {
		this.addtimes = addtimes;
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
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	@Override
	public String toString() {
		return "Playrecord [id=" + id + ", uid=" + uid + ", vid=" + vid
				+ ", addtimes=" + addtimes + ", Sort=" + Sort + ", Title="
				+ Title + ", PicURL=" + PicURL + "]";
	}
	
	
	
	
	
	
}
