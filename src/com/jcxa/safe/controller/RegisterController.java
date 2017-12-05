package com.jcxa.safe.controller;

import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.jcxa.safe.entity.HelpCodes;
import com.jcxa.safe.entity.OrderSms;
import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;
import com.jcxa.safe.service.LoginService;
import com.utils.HttpSenderUtils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController{
  @Autowired
  private LoginService loginService;
  
  @ModelAttribute
  public void getType(@RequestParam(value="ID", required=false) Integer ID, Map<String, Object> map){
    if (ID != null) {
      map.put("users",loginService.selectUserService(ID));
    }
  }
  
  @RequestMapping("/SendCodeSMS")
  @ResponseBody
  public String SendCodeSMS(String telephone, HttpServletRequest request, HttpSession session)
    throws Exception
  {
    System.out.println("短信验证码");
    String vcode = HttpSenderUtils.createRandomVcode();
    session.setAttribute("vcode", vcode);
    OrderSms sms = new OrderSms();
    
    System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
    System.setProperty("sun.net.client.defaultReadTimeout", "10000");
    
    String product = "Dysmsapi";
    String domain = "dysmsapi.aliyuncs.com";
    
    String accessKeyId = "aJjWwUSjpYtA25g3";
    String accessKeySecret = "naQPJcccQEYDoBJlRnO3TcmojNrCRL";
    
    IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", 
      "aJjWwUSjpYtA25g3", "naQPJcccQEYDoBJlRnO3TcmojNrCRL");
    DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", 
      "dysmsapi.aliyuncs.com");
    IAcsClient acsClient = new DefaultAcsClient(profile);
    
    SendSmsRequest request1 = new SendSmsRequest();
    
    request1.setMethod(MethodType.POST);
    
    request1.setPhoneNumbers(telephone);
    
    request1.setSignName("手提课");
    
    request1.setTemplateCode("SMS_97010046");
    request1.setTemplateParam("{\"code\":\"" + vcode + "\"}");
    BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
    
    smsReceiverParams.setParam("code", vcode);
    
    request1.setOutId("yourOutId");
    
    SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request1);
    if ((sendSmsResponse.getCode() != null) && 
      (sendSmsResponse.getCode().equals("OK"))) {
      return "true";
    }
    System.out.println("随机数+" + vcode);
    System.out.println("session保存随机数+" + session.getAttribute("vcode"));
    return null;
  }
  
  @RequestMapping("/CheckVcode")
  @ResponseBody
  public String CheckVcode(String vcode, HttpSession session)
  {
    System.out.println("前台获取验证码" + vcode);
    
    String vcode1 = (String)session.getAttribute("vcode");
    
    System.out.println("后台验证码" + vcode1);
    if (vcode.equals(vcode1)) {
      return "true";
    }
    return "false";
  }
  
  @RequestMapping("/addphone")
  public String addphone(String telephone, HttpSession session){
	  //绑定过手机号不会进去这个方法
	  System.out.println("我是增加手机号方法");
    Users user1 = loginService.selectPhoneServicde(telephone);
    WxUser user = (WxUser) session.getAttribute("wxuser");
    //查询手机号   为空说明PC端没有绑定将微信信息放到user中
    if (user1 == null){
    	System.out.println("在用户信息表中创建新的信息  +****************************");
    	Users u=new Users();
    	u.setCity1(user.getCity1());
    	u.setCity2(user.getCity2());
    	u.setNickName(user.getNickName());
    	u.setHeadUrl(user.getHeadUrl());
    	u.setRegistertime(user.getRegistertime());
    	u.setTelephone(telephone);
    	u.setWXopendID(user.getID());
    	u.setSex(user.getSex());
    	u.setUnionid(user.getUnionid());
     
      loginService.addUserphoneService(u);
      System.out.println("更改openid的手机号+1111111111111");
      user.setTelephone(telephone);
      loginService.addWxUserPhoneService(user);
      Users userss=loginService.selectWxOpenidService(user.getID());
      session.setAttribute("user", userss);
      System.out.println("保存用户手机号*/");
    }else{

    	System.out.println("更改用户表中信息+78978978979");
    	user1.setWXopendID(user.getID());
    	user1.setCity1(user.getCity1());
    	user1.setCity2(user.getCity2());
    	user1.setNickName(user.getNickName());
    	user1.setHeadUrl(user.getHeadUrl());
    	user1.setSex(user.getSex());
    	user1.setUnionid(user.getUnionid());
       loginService.updateUsersService(user1);
       System.out.println("更改openid的手机号+122222222222222");
       user.setTelephone(telephone);
       loginService.addWxUserPhoneService(user);

       //loginService.deleteUsersService(user1.getID());
       Users user2 = loginService.selectPhoneServicde(telephone);
       session.setAttribute("user", user2);
       System.out.println("手机号已存在/");
    }
    //return "views/wxmaterial.jsp";
    String url2=(String) session.getAttribute("urlphone");
	  System.out.println(url2);
	  return url2;
  }
  
  
 
  @RequestMapping("/addUser")
	public String addUser(Users users, HttpSession session) {
		System.out.println("我是修改信息+777777777777777");
		String str = users.getDemo1();
		System.out.println(str + "地址");
		String[] sourceStrArray = str.split(",");
		String City1 = ""; 
		String City2 = "";
		String City3 = "";
		if (str != null) {
			if (sourceStrArray.length == 3) {
				for (int i = 0; i < sourceStrArray.length; i++){
					System.out.println(sourceStrArray[i]);
					City1 = sourceStrArray[0];
					City2 = sourceStrArray[1];
					City3 = sourceStrArray[2];
				}
			} else if (sourceStrArray.length == 2) {
				for (int i = 0; i < sourceStrArray.length; i++) {
					System.out.println(sourceStrArray[i]);
					City1 = sourceStrArray[0];
					City2 = sourceStrArray[1];
					City3 = "";
				}
			}
		}

		// 存在tuser信息中
		System.out.println("我得信息在用户表中哦、、、、、、、、、、、、、、、、");
		Users u=(Users) session.getAttribute("user");
		u.setCity1(City1);
		u.setCity2(City2);
		u.setCity3(City3);
		loginService.addUser(users);
		Users user1 = loginService.selectUserService(users.getID());
		session.setAttribute("user", user1);
		//return "wxser?id=191";
		return "selectWxUser";
	}
  //查询手机号 
  @RequestMapping("/selectPhone")
  public  String selectPhone(@RequestParam(value = "telephone") String telephone,HttpSession session){
	  Users user=loginService.selectPhoneServicde(telephone);
	  session.setAttribute("user", user);
	  System.out.println("我是查询手机奥玛+88888888888888888888888888");
	  String url2=(String) session.getAttribute("urlphone");
	    System.out.println(url2);
	    
	   // req.getRequestDispatcher(url2).forward(req, resp);
	return url2;
	  
  }
	/** 刷新用户信息 */
	@RequestMapping("/selectWxUser")
	public String selectWxUser(HttpSession session, Map<String, Object> map) {
		Users user = (Users) session.getAttribute("user");
		Users u = loginService.selectUserService(user.getID());
		session.setAttribute("user", u);
		map.put("user", u);
		map.put("menupoint", 4);
		return "views/wxmaterial.jsp";
	}
	/**优惠码查询*/
	@RequestMapping("/selectHelpCode")
	@ResponseBody
	public String selectHelpCode(String HelpCode){
		System.out.println("优惠码为+"+HelpCode);
		HelpCodes helpCodes=loginService.selectCodeService(HelpCode);
		if(helpCodes!=null){
			System.out.println("RegisterController.selectHelpCode()"+"对");
			return "true";
		}else{ 
			System.out.println("RegisterController.selectHelpCode()"+"错");

			return "false";

		}
	}
	/**优惠码的绑定*/
	@RequestMapping("/addHelpCode")
	public String addHelpCode(HttpSession session,String HelpCode){
		System.out.println("优惠码为+"+HelpCode+"//////////");
		HelpCodes helpCodes=loginService.selectCodeService(HelpCode);
		if(helpCodes.getNum()!=0){
		Integer code=helpCodes.getNum();
		code=code-1;
		System.out.println("RegisterController.addHelpCode()"+code);
		helpCodes.setNum(code);
		loginService.updateNumService(helpCodes);
		//用户表中更改
		Users user=(Users) session.getAttribute("user");
		user.setHelpCode(HelpCode);
		loginService.updateHlepCode(user);
		user=loginService.selectUserService(user.getID());
		System.out.println("RegisterController.addHelpCode()"+user.toString());
		session.setAttribute("user", user);
		}
		String url2=(String) session.getAttribute("urlcode");
	    System.out.println(url2);
	    
	    //req.getRequestDispatcher(url2).forward(req, resp);
	  //  return url2;
	return "views/wxfp/wxyzmok.jsp";
	}
	@RequestMapping("/selectCode")
	public String selectCode(){
		
		return "wxfpyzm.jsp";
	}
	
}
