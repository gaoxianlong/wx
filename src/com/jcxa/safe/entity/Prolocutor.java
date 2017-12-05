package com.jcxa.safe.entity;

import java.util.Date;

public class Prolocutor {
	private int id;
	private String prolocutor;
	private String openid;
	private Date createTime;
	
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProlocutor() {
		return prolocutor;
	}
	public void setProlocutor(String prolocutor) {
		this.prolocutor = prolocutor;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((openid == null) ? 0 : openid.hashCode());
		result = prime * result
				+ ((prolocutor == null) ? 0 : prolocutor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prolocutor other = (Prolocutor) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id != other.id)
			return false;
		if (openid == null) {
			if (other.openid != null)
				return false;
		} else if (!openid.equals(other.openid))
			return false;
		if (prolocutor == null) {
			if (other.prolocutor != null)
				return false;
		} else if (!prolocutor.equals(other.prolocutor))
			return false;
		return true;
	}
	
	

	
}
