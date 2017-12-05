package com.jcxa.safe.entity;

import java.util.Date;

/**
 * @author Seven
 *
 */
public class WxUser {
	private Integer ID;
	private String openid;
	private String unionid;
	private String nickName;
	private String city1;
	private String city2;
	private String sex;
	private String headUrl;
	private Date registertime;
	private String Telephone;
	private String city3;
	private String School;
	private String Grade;
	private String wxclass;
	private String demo1;
	private String qqid;
	 private String RealName;
	 
	public String getQqid() {
		return qqid;
	}
	public void setQqid(String qqid) {
		this.qqid = qqid;
	}
	public String getRealName() {
		return RealName;
	}
	public void setRealName(String realName) {
		RealName = realName;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getCity2() {
		return city2;
	}
	public void setCity2(String city2) {
		this.city2 = city2;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	public Date getRegistertime() {
		return registertime;
	}
	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getCity3() {
		return city3;
	}
	public void setCity3(String city3) {
		this.city3 = city3;
	}
	public String getSchool() {
		return School;
	}
	public void setSchool(String school) {
		School = school;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public String getWxclass() {
		return wxclass;
	}
	public void setWxclass(String wxclass) {
		this.wxclass = wxclass;
	}
	public String getDemo1() {
		return demo1;
	}
	public void setDemo1(String demo1) {
		this.demo1 = demo1;
	}
	@Override
	public String toString() {
		return "WxUser [ID=" + ID + ", openid=" + openid + ", unionid="
				+ unionid + ", nickName=" + nickName + ", city1=" + city1
				+ ", city2=" + city2 + ", sex=" + sex + ", headUrl=" + headUrl
				+ ", registertime=" + registertime + ", Telephone=" + Telephone
				+ ", city3=" + city3 + ", School=" + School + ", Grade="
				+ Grade + ", wxclass=" + wxclass + ", demo1=" + demo1 + "]";
	}

	
	
	
	
}
