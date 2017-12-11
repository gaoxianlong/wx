package com.jcxa.safe.controller;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WXLoginController
  extends HttpServlet
{
  @Override
@RequestMapping("/wxLogin")
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
	  System.out.println("我是wxlogin");
	  String backurl = "http://www.shoutike.com/wx/callBack";
	  String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1d42fa2fba520d22&redirect_uri=" + 
      URLEncoder.encode(backurl) + "&response_type=code&scope=snsapi_userinfo&" + 
      "state=STATE#wechat_redirect";
    resp.sendRedirect(url);
  }
}
