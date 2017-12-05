package com.jcxa.safe.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcxa.safe.dao.VipDao;
import com.jcxa.safe.entity.Order;
import com.jcxa.safe.entity.Wxorder;



@Service
public class VipService {
	@Autowired
	private VipDao vipDao;
	
	public Wxorder getwxorder(@Param("uid")Integer uid){
		
		return vipDao.getwxorder(uid);
		
	}
	
	public Order getOrders(@Param("uid")Integer uid,@Param("seid")Integer seid){
		
		return vipDao.getoor(uid,seid);
	}
	
	public boolean  judvip(@Param("uid")Integer uid) {

		return vipDao.getwxorder(uid) != null;

	}
	
	public boolean  getpuorder(@Param("statu")String statu) {

		return vipDao.getpuorder(statu) != null;

	}
	
	public boolean getoor(@Param("uid")Integer uid,@Param("seid")Integer seid){
		
		return vipDao.getoor(uid,seid) == null;
	}
	
	
	public boolean getoornotnull(@Param("uid")Integer uid,@Param("seid")Integer seid){
		
		return vipDao.getoor(uid,seid) != null;
	}
	public boolean  getTephone(@Param("ID")Integer ID) {
		
		return vipDao.getTephone(ID) != null;

	}
	
	public void addvip(Wxorder wxorder){
		
		 vipDao.addvip(wxorder);
	}

	public void addorder(Order order){
		
		vipDao.addorder(order);
	}
	
	public boolean deletevip(int id){
		return vipDao.deletevip(id);
	}
	
	public boolean deleteorder(int id){
		return vipDao.deleteorder(id);
	}
}

