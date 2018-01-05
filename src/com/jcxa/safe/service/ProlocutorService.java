package com.jcxa.safe.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcxa.safe.dao.ProlocutorDao;
import com.jcxa.safe.entity.Percentage;
import com.jcxa.safe.entity.Profit;
import com.jcxa.safe.entity.Prolocutor;
import com.jcxa.safe.entity.Tixian;
import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;
import com.jcxa.safe.entity.OrderandSeries;


@Service
public class ProlocutorService {

	@Autowired
	private ProlocutorDao prolocutorDao;
	
	//根据代言码查询自己的WXopenid
	public Integer selproopenidd(String prolocutor){
		return prolocutorDao.selproopenidd(prolocutor);
	}
	//根据user的WXopenid查询wxuser的Openid
	public String wxuseropenidd(Integer id){
		return 	prolocutorDao.wxuseropenidd(id);
	}
		
	//通过WXopendID查询prolocutor
	public String wxprolocutor(Integer WXopendID){
		return 	prolocutorDao.wxprolocutor(WXopendID);
	}
	
	public Integer openidsel(Integer openid){
		return prolocutorDao.openidsel(openid);
	}
	
	public Integer openidzhu(String openid){
		return prolocutorDao.openidzhu(openid);
		
	}
	public boolean tixianmoney(Tixian tixian){
		return prolocutorDao.tixianmoney(tixian);
	}
	
	public String selspro(Integer ID){
		
		return prolocutorDao.selspro(ID);
	}

	public List<WxUser> selectWxUserService(Integer ls){
		return prolocutorDao.selectWxUser(ls);
	}

//	public Prolocutor duidaiyan(Integer uid){
//		
//		return prolocutorDao.onlydaiyan(uid);
//	}
	
	public boolean  onlydaiyan(String openid) {

		return prolocutorDao.onlydaiyan(openid) == null;

	}
	
	public boolean adddaiyan(Prolocutor prolocutor){
		
		return prolocutorDao.adddaiyan(prolocutor);
	}
	
	//查询是否成为代言人
	public boolean seldaiyan(Integer ID){
		
		return prolocutorDao.seldaiyan(ID) == null;
	}
	//成为代言人，生成UUID
	public boolean become(Users user){
		return prolocutorDao.become(user);
	}
	//查询自己的下线
	public List<Prolocutor> selxiaxian(String prolocutor){
		return prolocutorDao.selxiaxian(prolocutor);
		
	}
	
	public boolean nowdaiyatime(Users user){
		
		return prolocutorDao.nowdaiyatime(user);
	}
	
	public  List<Users> seluserdaiyan(List ls){
		return prolocutorDao.seluserdaiyan(ls);
	}
	
	public Integer moneyorder(Integer ID){
		return prolocutorDao.moneyorder(ID);
		
	}
	public Integer moneyvip(Integer ID){
		
		return prolocutorDao.moneyvip(ID);
	}
	
	
	public Integer notmoneyorder(Integer ID){
		return prolocutorDao.notmoneyorder(ID);
		
	}
	public Integer notmoneyvip(Integer ID){
		
		return prolocutorDao.notmoneyvip(ID);
	}
	public Percentage selper(){
		return prolocutorDao.selper();
		
	}
	//查询余额
	public Integer selprofit(Integer ID){
		
		return prolocutorDao.selprofit(ID);
	}
	//查询余额账户是否已存在
	public boolean profitold(Integer ID){
		
		return prolocutorDao.selprofit(ID) == null;
	}
	
	public boolean insertprofit(Profit profit){
		return prolocutorDao.insertprofit(profit);
	}

	public boolean updateprofit(Profit profit){
		return prolocutorDao.updateprofit(profit);
	}
	
	public Integer selproid(String prolocutor){
		
		return prolocutorDao.selproid(prolocutor);
	}

	//查询用户自己单个购买的课程订单
	public List<OrderandSeries> selorderandk(Integer id){
		return prolocutorDao.selorderandk(id);
	}
}
