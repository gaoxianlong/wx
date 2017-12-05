package com.jcxa.safe.dao;

import com.jcxa.safe.entity.HelpCodes;
import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;

public  interface LoginDao
{
  public  WxUser selectid(String openid);
  
  public  void addWxUser(WxUser user);
  
  public  void updatePhone(Users user);
  
  public  Users selectUser(Integer id);
  
  public  void addUser(Users user);
  
  public  Users selectPhone(String telephone);
  
  public  void updateUsers(Users user);
  
  public  void deleteUsers(Integer id);
  public void addUserphone(Users user);
  public void addWxUserPhone(WxUser wxu);
  public WxUser selectWxUser(Integer id);
  public Users selectWxOpenid(Integer openid);
  public void addWxUser2(WxUser u);
  /**优惠码查询*/
  public HelpCodes selectCode(String HlepCode);
  /**更改优惠码数量*/
  public void updateNum(HelpCodes helpCodes);
  /**更改用户表优惠码信息*/
  public void updateHlepCode(Users user);
  
  public WxUser selectUnionid(String Unionid);
}
