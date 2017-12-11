package com.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;
import com.jcxa.safe.service.LoginService;

public class MyHandler implements HandlerInterceptor{

	@Autowired
	private LoginService loginService;

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("我是afterCompletion+1");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("我是postHandle+2");
		 //String url=request.getRequestURI(); 
		 //request.getRequestDispatcher(url).forward(request, response);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("我是preHandle+3");
		String url=request.getRequestURI();
		String par=request.getQueryString();
		
		if(url.indexOf("wxshare")>=0){
			return true;
		}
		//截取url
		url=url.substring(3);
		HttpSession session=request.getSession();
		url=url+"?"+par;
		session.setAttribute("url", url);
		WxUser user=(WxUser) session.getAttribute("wxuser");
		Users users=(Users) session.getAttribute("user");
		if(user!=null || users!=null){
			//Users u=loginService.selectWxOpenidService(user.getID()); 
			//session.setAttribute("url", url);
			System.out.println("MyHandler.preHandle()++++我是session中以保存的");
			return true;
		}
	
		System.out.println("MyHandler.preHandle()++++我要去授权登录啦");
		request.getRequestDispatcher("wxshare").forward(request, response);
		return false;
	}

}
