package com.jcxa.safe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jcxa.safe.entity.Percentage;
import com.jcxa.safe.entity.Profit;
import com.jcxa.safe.entity.Prolocutor;
import com.jcxa.safe.entity.Tixian;
import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;


public interface ProlocutorDao {


		public Integer openidsel(Integer openid);
		public Integer openidzhu(String openid);
		//根据代言码查询自己的WXopenid
		public Integer selproopenidd(String prolocutor);
		//根据user的WXopenid查询wxuser的Openid
		public String wxuseropenidd(Integer id);
		//通过WXopendID查询prolocutor
		public String wxprolocutor(Integer WXopendID);
		public boolean tixianmoney(Tixian tixian);
		public Prolocutor onlydaiyan(String openid);
		public boolean adddaiyan(Prolocutor prolocutor);
		//查询是否成为代言人
		public String seldaiyan(Integer ID);
		//成为代言人，生成UUID
		public boolean become(Users user);
		public List<Prolocutor> selxiaxian(String prolocutor);
		public boolean nowdaiyatime(Users user);
		public List<Users> seluserdaiyan(@Param("ls")List ls);
		public Integer moneyorder(Integer ID);
		public Integer moneyvip(Integer ID);
		public Integer notmoneyorder(Integer ID);
		public Integer notmoneyvip(Integer ID);
		public Percentage selper();
		public Integer selprofit(Integer ID);
		public Integer profitold(Integer ID);
		public boolean insertprofit(Profit profit);
		public boolean updateprofit(Profit profit);
		public Integer selproid(String prolocutor);
		public String selspro(Integer ID);
		/**通过id查询微信用户*/
		public List<WxUser> selectWxUser(Integer id);
	
}
