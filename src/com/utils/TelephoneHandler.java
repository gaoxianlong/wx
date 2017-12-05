package com.utils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jcxa.safe.dao.LoginDao;
import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;

public class TelephoneHandler implements HandlerInterceptor{
	 @Resource
	 private LoginDao loginDao;
	
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
		
//		if(url.indexOf("wxshare")>=0){
//			return true;
//		}
		//截取url
		url=url.substring(3);
		HttpSession session=request.getSession();
		url=url+"?"+par;
		session.setAttribute("urlphone", url);
		WxUser user=(WxUser) session.getAttribute("wxuser");
		Users users=(Users) session.getAttribute("user");
		 int openid=0;
		 try {
			 openid=users.getWXopendID();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		
		 if(users!=null&&openid !=0){
			 return true;
			}else {
				System.out.println("电话号没有");
				request.getRequestDispatcher("materphone.jsp").forward(request, response);
				return false;
			}
		
		

		
		
	}

}
