package com.jcxa.safe.entity;

import java.util.Date;

/**优惠码*/
public class HelpCodes {
	private Integer ID;
	private String  Schools;
	private String HelpCode;
	private Integer Num;
	private String CreateBy;
	private Date CreateTime;
	private Integer Valid;
	private Integer GiveCount;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getSchools() {
		return Schools;
	}
	public void setSchools(String schools) {
		Schools = schools;
	}
	public String getHelpCode() {
		return HelpCode;
	}
	public void setHelpCode(String helpCode) {
		HelpCode = helpCode;
	}
	
	public Integer getNum() {
		return Num;
	}
	public void setNum(Integer num) {
		Num = num;
	}
	public String getCreateBy() {
		return CreateBy;
	}
	public void setCreateBy(String createBy) {
		CreateBy = createBy;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public Integer getValid() {
		return Valid;
	}
	public void setValid(Integer valid) {
		Valid = valid;
	}
	public Integer getGiveCount() {
		return GiveCount;
	}
	public void setGiveCount(Integer giveCount) {
		GiveCount = giveCount;
	}
}
