package com.jcxa.safe.dao;

import org.apache.ibatis.annotations.Param;

import com.jcxa.safe.entity.Order;
import com.jcxa.safe.entity.Wxorder;





public interface VipDao {

	
	//public boolean judvip(@Param("uid")Integer uid);
	
	//得到VIP订单的信息
	public Wxorder getwxorder(@Param("uid")Integer uid);
	//得普通订单的信息
	public Order getpuorder(@Param("statu")String statu);
	
	public Order getoor(@Param("uid")Integer uid,@Param("seid")Integer seid);
	//判断用户手机号是否为空
	public String getTephone(@Param("ID")Integer ID);
	public void addvip(Wxorder wxorder);
	public void addorder(Order order);
	public boolean deletevip(int id);
	public boolean deleteorder(int id);
}
