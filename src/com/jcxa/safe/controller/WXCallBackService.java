package com.jcxa.safe.controller;

import com.jcxa.safe.entity.WxUser;
import com.jcxa.safe.service.LoginService;
import com.utils.AuthUtil;
import com.utils.NickNameFilter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WXCallBackService
  extends HttpServlet{
  @Autowired
  private HttpSession session;
  @Autowired
  private LoginService loginService;
  
  @Override
@RequestMapping("/callBack")
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException{
	  System.out.println("我是callback");
    String code = req.getParameter("code");
    System.out.println("////////////" + code);
    String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx1d42fa2fba520d22&secret=caf5381cc5b63cb108c0fece2324834c&code=" + 
      code + 
      "&grant_type=authorization_code";
    JSONObject jsonObject = AuthUtil.doGetJson(url);
    System.out.println(jsonObject + "777777777777");
    String openid = jsonObject.getString("openid");
    System.out.println("openid============" + openid);
    String token = jsonObject.getString("access_token");
    System.out.println("*********************" + token);
    String info = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token + 
      "&openid=" + openid + "&lang=zh_CN";
    JSONObject userInfo = AuthUtil.doGetJson(info);
    System.out.println(userInfo);
    
    String nickname = userInfo.getString("nickname");
    Integer sex = Integer.valueOf(userInfo.getInt("sex"));
    String HeadUrl = userInfo.getString("headimgurl");
    String City1 = userInfo.getString("city");
    String City2 = userInfo.getString("country");
    String Unionid = userInfo.getString("unionid");
    nickname=NickNameFilter.filterEmoji(nickname);
    WxUser users = loginService.selectOpenidService(openid);
    if (users == null)
    {
    WxUser user = new WxUser();
      user.setCity1(City1);
      user.setCity2(City2);
      user.setNickName(nickname);
      user.setSex(sex.intValue() == 1 ? "男" : "女");
      user.setHeadUrl(HeadUrl);
      user.setUnionid(Unionid);
      user.setOpenid(openid);
      user.setRegistertime(new Date());
      loginService.addWxUserService(user);
      
      user = loginService.selectOpenidService(openid);
      session.setAttribute("user", user);
      session.setMaxInactiveInterval(43200);
      System.out.println("第一次登陆的用户" + user.toString());
    }
    else
    {
      users = loginService.selectOpenidService(openid);
      session.setAttribute("user", users);
      session.setMaxInactiveInterval(43200);
      System.out.println("已保存过的用户" + users.toString());
    }
    req.getRequestDispatcher("wxser?id=191").forward(req, resp);
  }
}
