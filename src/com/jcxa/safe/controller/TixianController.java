package com.jcxa.safe.controller;


import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
















import com.jcxa.safe.entity.Users;
import com.jcxa.safe.service.LoginService;
import com.jcxa.safe.service.VipService;
import com.utils.Sha1Util;

@Controller
public class TixianController {

	protected Logger log = Logger.getLogger(TixianController.class);
	
	
	@Autowired
	private VipService vipService;
	@Autowired
	private LoginService loginService;
	@RequestMapping(value="/tixianMainServlet")
	@ResponseBody
	public void  mai(HttpSession session,HttpServletResponse response,
			@RequestParam(value = "pric",required = false) String pric
			) {
		Users user = (Users) session.getAttribute("user");
		
		Integer idd=user.getID();
		String uidd = String.valueOf(idd);
		//共账号及商户相关参数
		String appid = "wx1d42fa2fba520d22";
		String backUri = "http://www.shoutike.com/wx/tixiantopayServlet";
		String price=pric;

		//授权后要跳转的链接所需的参数一般有会员号，金额，订单号之类，
		//最好自己带上一个加密字符串将金额加上一个自定义的key用MD5签名或者自己写的签名,
		//比如 Sign = %3D%2F%CS% 
		String orderNo=appid+Sha1Util.getTimeStamp();
		backUri = backUri+"?orderNo="+orderNo+"&describe=test&money="+price;
		//URLEncoder.encode 后可以在backUri 的url里面获取传递的所有参数
		backUri = URLEncoder.encode(backUri);
		//scope 参数视各自需求而定，这里用scope=snsapi_base 不弹出授权页面直接授权目的只获取统一支付接口的openid
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
				"appid=" + appid+
				"&redirect_uri=" +
				 backUri+
				"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
