package com.jcxa.safe.entity;

public class Percentage {

	private int id;
	private double order;
	private double vip;
	private double allow;
	
	public double getAllow() {
		return allow;
	}
	public void setAllow(double allow) {
		this.allow = allow;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getOrder() {
		return order;
	}
	public void setOrder(double order) {
		this.order = order;
	}
	public double getVip() {
		return vip;
	}
	public void setVip(double vip) {
		this.vip = vip;
	}
	
	
}
