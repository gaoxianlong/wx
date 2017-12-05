package com.jcxa.safe.service;

import com.jcxa.safe.dao.LoginDao;
import com.jcxa.safe.entity.HelpCodes;
import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class LoginService
{
	  @Autowired
	  private LoginDao loginDao;
	  
	  public WxUser selectOpenidService(String openid)
	  {
		  WxUser users = loginDao.selectid(openid);
	    return users;
	  }
	  
	  public void addWxUserService(WxUser u)
	  {
	    loginDao.addWxUser(u);
	  }
	  
	  public void updatePhoneService(Users u)
	  {
	    loginDao.updatePhone(u);
	  }
	  
	  public Users selectUserService(Integer id)
	  {
	    return loginDao.selectUser(id);
	  }
	  
	  public void addUser(Users u)
	  {
	    loginDao.addUser(u);
	  }
	  
	  public Users selectPhoneServicde(String telephone)
	  {
	    return loginDao.selectPhone(telephone);
	  }
	  
	  public void updateUsersService(Users u)
	  {
	    loginDao.updateUsers(u);
	  }
	  
	  public void deleteUsersService(Integer id)
	  {
	    loginDao.deleteUsers(id);
	  }
	  public void addUserphoneService(Users user){
		 loginDao.addUserphone(user);
	  }
	  public void addWxUserPhoneService(WxUser wxu){
		  loginDao.addWxUserPhone(wxu);
	  }
	  public WxUser selectWxUserService(Integer id){
		 return  loginDao.selectWxUser(id);
	  }
	  public Users selectWxOpenidService(Integer openid){
		  return loginDao.selectWxOpenid(openid);
	  }
	  public void addWxUserService2(WxUser u){
		  loginDao.addWxUser2(u);
	  }
	  /**优惠码查询*/
	  public HelpCodes selectCodeService(String HlepCode){
		  return loginDao.selectCode(HlepCode);
	  }
	  /**更改优惠码数量*/
	  public void updateNumService(HelpCodes num){
		  loginDao.updateNum(num);
	  }
	  /**更改用户表优惠码信息*/
	  public void updateHlepCode(Users user){
		  loginDao.updateHlepCode(user);
	  }
	  
	  /**通过Unionid查询用户*/
	  public WxUser selectUnionidService(String Unionid){
		  return loginDao.selectUnionid(Unionid);
	  }
}
