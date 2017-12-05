package com.jcxa.safe.entity;

import java.util.List;

public class Type implements java.io.Serializable {
/*
 * 目录
 * 
 * 
 * 
 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String TypeName;//目录名称
	private int ParentID;//父类ID
	private String Sort;//目录级别
	private String Identify;//0：无三级菜单 1：有
	private List<Type> children;
	 
	
	public List<Type> getChildren() {
		return children;
	}
	public void setChildren(List<Type> children) {
		this.children = children;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	public int getParentID() {
		return ParentID;
	}
	public void setParentID(int parentID) {
		ParentID = parentID;
	}
	public String getSort() {
		return Sort;
	}
	public void setSort(String sort) {
		Sort = sort;
	}
	public String getIdentify() {
		return Identify;
	}
	public void setIdentify(String identify) {
		Identify = identify;
	}
	
	
	
}
