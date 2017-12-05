package com.jcxa.safe.entity;

import java.util.Date;



public class Seriesmp {
/*
 * 
 * 
 * 课程的封面
 * 
 */
	private int ID;
	private String TypeValue;
	private String Type2Value;
	private String Type3Value;
	private String Title;
	private String PicURL;
	private String PicURL2;
	private String ThuPicURL;
	private Date PublishTime;
	private String Remark;//描述
	private int TeacherID;//讲师
	private int VideoCount;//视频总数
	private int Collection;//收藏数
	private int ClickRate;//播放数
	private int PmtsTot;//购买总数
	private int IsValid;//是否有效
	private int IsPrice;//是否收费
	private int Price;//原始价格
	private int IsDiscount;//是否打折
	private int RealPrice;//实际价格
	private Date CreateTime;//创建时间
	private int TimeLimit;//购买有效天数
	private int fupin;//1:扶贫 0：未扶贫
	private String search;
	private String fullname;
	private String publi;
	private String ta;
	private String tb;
	private String tc;
	private  String writer;
	private  String bg;
	
	
	
	
	
	
	
	
	public String getBg() {
		return bg;
	}
	public void setBg(String bg) {
		this.bg = bg;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTa() {
		return ta;
	}
	public void setTa(String ta) {
		this.ta = ta;
	}
	public String getTb() {
		return tb;
	}
	public void setTb(String tb) {
		this.tb = tb;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getPubli() {
		return publi;
	}
	public void setPubli(String publi) {
		this.publi = publi;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTypeValue() {
		return TypeValue;
	}
	public void setTypeValue(String typeValue) {
		TypeValue = typeValue;
	}
	public String getType2Value() {
		return Type2Value;
	}
	public void setType2Value(String type2Value) {
		Type2Value = type2Value;
	}
	public String getType3Value() {
		return Type3Value;
	}
	public void setType3Value(String type3Value) {
		Type3Value = type3Value;
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
	public String getPicURL2() {
		return PicURL2;
	}
	public void setPicURL2(String picURL2) {
		PicURL2 = picURL2;
	}
	public String getThuPicURL() {
		return ThuPicURL;
	}
	public void setThuPicURL(String thuPicURL) {
		ThuPicURL = thuPicURL;
	}

	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public int getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(int teacherID) {
		TeacherID = teacherID;
	}
	public int getVideoCount() {
		return VideoCount;
	}
	public void setVideoCount(int videoCount) {
		VideoCount = videoCount;
	}
	public int getCollection() {
		return Collection;
	}
	public void setCollection(int collection) {
		Collection = collection;
	}
	public int getClickRate() {
		return ClickRate;
	}
	public void setClickRate(int clickRate) {
		ClickRate = clickRate;
	}
	public int getPmtsTot() {
		return PmtsTot;
	}
	public void setPmtsTot(int pmtsTot) {
		PmtsTot = pmtsTot;
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
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getIsDiscount() {
		return IsDiscount;
	}
	public void setIsDiscount(int isDiscount) {
		IsDiscount = isDiscount;
	}
	public int getRealPrice() {
		return RealPrice;
	}
	public void setRealPrice(int realPrice) {
		RealPrice = realPrice;
	}
	
	public Date getPublishTime() {
		return PublishTime;
	}
	public void setPublishTime(Date publishTime) {
		PublishTime = publishTime;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public int getTimeLimit() {
		return TimeLimit;
	}
	public void setTimeLimit(int timeLimit) {
		TimeLimit = timeLimit;
	}
	public int getFupin() {
		return fupin;
	}
	public void setFupin(int fupin) {
		this.fupin = fupin;
	}
	@Override
	public String toString() {
		return "Series [ID=" + ID + ", TypeValue=" + TypeValue
				+ ", Type2Value=" + Type2Value + ", Type3Value=" + Type3Value
				+ ", Title=" + Title + ", PicURL=" + PicURL + ", PicURL2="
				+ PicURL2 + ", ThuPicURL=" + ThuPicURL + ", PublishTime="
				+ PublishTime + ", Remark=" + Remark + ", TeacherID="
				+ TeacherID + ", VideoCount=" + VideoCount + ", Collection="
				+ Collection + ", ClickRate=" + ClickRate + ", PmtsTot="
				+ PmtsTot + ", IsValid=" + IsValid + ", IsPrice=" + IsPrice
				+ ", Price=" + Price + ", IsDiscount=" + IsDiscount
				+ ", RealPrice=" + RealPrice + ", CreateTime=" + CreateTime
				+ ", TimeLimit=" + TimeLimit + ", fupin=" + fupin + ", search="
				+ search + ", fullname=" + fullname + ", publi=" + publi + "]";
	}
	
	
	public Seriesmp(){
		
		
	}
	
}
