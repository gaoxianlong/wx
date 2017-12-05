package com.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;

/**优惠码拦截*/
public class HelpCodeHandler implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("我是优惠码的拦截1");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("我是优惠码的拦截2");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("我是优惠码的拦截3");
		String url=request.getRequestURI();
		String par=request.getQueryString();
		url=url.substring(3);
		HttpSession session=request.getSession();
		url=url+"?"+par;
		session.setAttribute("urlcode", url);
		WxUser user=(WxUser) session.getAttribute("wxuser");
		Users users=(Users) session.getAttribute("user");
		String phone="";
		 try {
			 phone=users.getHelpCode();
			 System.out.println("我得优惠码是"+phone );
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(phone!=""&&phone!=null){
			return true;
		}else{
			System.out.println("优惠码没有");
			request.getRequestDispatcher("wxfpyzm.jsp").forward(request, response);
			return false;
		}
	}
		
}
