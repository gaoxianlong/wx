package com.jcxa.safe.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;















import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcxa.safe.entity.Order;
import com.jcxa.safe.entity.Wxorder;
import com.jcxa.safe.service.VipService;

@Controller
public class huiwxController {

	protected Logger log = Logger.getLogger(huiwxController.class);

	@Autowired
	private VipService vipService;
	
 
	
	@RequestMapping(value="/notifyServlet")
	
	public void NotifyServlet(HttpServletRequest request,HttpServletResponse response,Map<String, Object> maps) throws IOException {
		log.info("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
			while((line = br.readLine())!=null){
			    sb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(sb+"0000");
        
 
        Map<String,Object> map = new HashMap<String,Object>();  
        Document doc;  
        try {  
            doc = DocumentHelper.parseText(sb.toString());  
            Element root = doc.getRootElement();    
            List children = root.elements();    
            if(children != null && children.size() > 0) {    
                for(int i = 0; i < children.size(); i++) {    
                    Element child = (Element)children.get(i);    
                    map.put(child.getName(), child.getTextTrim());    
                }    
            }    
        } catch (DocumentException e) {  
            e.printStackTrace();  
        } 
        
      
       String  str=(String) map.get("attach");
       //截取字符串
       String[] strs=str.split(",");
       String uid=strs[0].toString();
       String viporp=strs[1].toString();
       String seriesid=strs[2].toString();
       String statu=strs[3].toString();
       String xinprice=strs[4].toString();
       String check=strs[5].toString();
       
       //订单价格
//       String price=(String) map.get("total_fee");
//       int Pii = Integer.parseInt(price);
//       int pio=Pii/100;
//       String ppc = String.valueOf(pio);
       
       //订单号
       String transaction_id=(String) map.get("transaction_id");
       String outtradeno=(String) map.get("out_trade_no");
       
       
       String vpsort=null;
       
       
       int ud = Integer.parseInt(uid);
       int serid = Integer.parseInt(seriesid);
       
       Format f = new SimpleDateFormat("yyyy-MM-dd");
       Calendar c = Calendar.getInstance(); 
       java.sql.Date nowSql = new java.sql.Date(System.currentTimeMillis());
       
      
       if(viporp.equals("vip")){
    	   //是会员，进行会员保存
    	   
    	   
    	   if(check.equals("1"))
           {
        	   vpsort="3";
        	   c.setTime(nowSql);  
               c.add(Calendar.DAY_OF_MONTH, 30);// 今天+1天 
           }else if(check.equals("2")){
        	   vpsort="2";
        	   c.setTime(nowSql);  
               c.add(Calendar.DAY_OF_MONTH, 90);// 今天+1天 
           }else if(check.equals("3")){
        	   vpsort="1";
        	   c.setTime(nowSql);  
               c.add(Calendar.DAY_OF_MONTH, 180);// 今天+1天 
           }
    	   Date now = new Date(); 
    	   Long dat=now.getTime();
    	   
    	   Long ove = (long) 1;
    	   if(vipService.judvip(ud)){
    		   
    		Wxorder wx=vipService.getwxorder(ud);
   			Date over=wx.getOvertime();
   			
   			
   			 ove=over.getTime();
    	   }
    	   
           //VIP是否存在
           if(vipService.judvip(ud)&&dat<ove){
        	  
        	   System.out.println(dat+"999999999999999999999999999999999999999999999999999");
        	   System.out.println(ove+"3333333333333333333333333333333333333333333333333");
        	   
        	   String returnxml = "<xml>" +
                       "   <return_code><![CDATA[SUCCESS]]></return_code>" +
                       "   <return_msg><![CDATA[OK]]></return_msg>" +
                       "</xml>";

               response.getWriter().write(returnxml);
               response.getWriter().flush();
        	   return;
        	      
           }else{
        	   boolean tr=true;
        	   boolean tt=false;
        	   
        	   System.out.println("7777777777777777777777777777777777777777");
        	   
        	   tt=vipService.judvip(ud);
        	   System.out.println("33333333333333333333333333333333333333333333333");
        	   
        	   System.out.println(tt+"22222222222222222222222222222222222222222222222");
        	   if(tt){
        		   try {
        			   tr= vipService.deletevip(ud);
				} catch (Exception e) {
					// TODO: handle exception
					
					System.out.println("44444444444444444444444444444444444");
					}
        	   	}
        	   System.out.println("555555555555555555555555555555555");
        	  System.out.println(tr+"66666666666666666666666666666");
        	   if(tr){
        		   
        	  System.out.println("true"+"0000000000000000000000000000000000000000000");
        	  Wxorder wo=new Wxorder();
        	  
        	  wo.setCreateTime(nowSql);
        	  
        	  Date cc=c.getTime();
        	  long a=cc.getTime();
        	  long star=nowSql.getTime();
        	  wo.setExp(a);
        	  long mills=cc.getTime();
        	  java.sql.Date ccc = new java.sql.Date(mills);
        	  wo.setOvertime(ccc);
        	  wo.setStarda(star);
        	  wo.setPrice(xinprice);
        	  wo.setOrderno(transaction_id);
        	  wo.setVipsort(vpsort);
        	  wo.setUid(ud);
        	  wo.setVip("1");
        	  wo.setOuttradeno(outtradeno);
        	  vipService.addvip(wo);
        	  
        	  String returnxml = "<xml>" +
                      "   <return_code><![CDATA[SUCCESS]]></return_code>" +
                      "   <return_msg><![CDATA[OK]]></return_msg>" +
                      "</xml>";

              response.getWriter().write(returnxml);
              response.getWriter().flush();
              
        	  
        	   
      			}else{
      				 String returnxml = "<xml>" +
      	                      "   <return_code><![CDATA[SUCCESS]]></return_code>" +
      	                      "   <return_msg><![CDATA[OK]]></return_msg>" +
      	                      "</xml>";

      	              response.getWriter().write(returnxml);
      	              response.getWriter().flush();
      			}
        	   
           }
    	   
    	   
       }else if(viporp.equals("orde")){
    	   //是普通购买，进入订单保存
    	   Date now = new Date(); 
    	   Long dat=now.getTime();
    	   
    	   Long ove = (long) 1;
    	   if(vipService.getoornotnull(ud,serid)){
    		   
    		Order or=vipService.getOrders(ud,serid);
   			Date over=or.getOvertime();
   			ove=over.getTime();
    	   }
    	   
    	   if(vipService.getpuorder(statu)){
        	   
    		   String returnxml = "<xml>" +
                       "   <return_code><![CDATA[SUCCESS]]></return_code>" +
                       "   <return_msg><![CDATA[OK]]></return_msg>" +
                       "</xml>";

               response.getWriter().write(returnxml);
               response.getWriter().flush();
        	   return;
        	      
           }else{
        	   if(vipService.getoornotnull(ud,serid)&&dat<ove){
        		   System.out.println(dat+"111111111111111111111111111111111111111111111111111111111111111111111111");
            	   System.out.println(ove+"5555555555555555555555555555555555555555555555555555555555555555555555555");  
            	   
            	   
            	   
            	   String returnxml = "<xml>" +
                           "   <return_code><![CDATA[SUCCESS]]></return_code>" +
                           "   <return_msg><![CDATA[OK]]></return_msg>" +
                           "</xml>";

                   response.getWriter().write(returnxml);
                   response.getWriter().flush();
        		   
        	   }
        	   
        	   else{
        		   
        		   boolean  tr=true;
            	   if(vipService.getoornotnull(ud,serid)){
            		   
            		  tr= vipService.deleteorder(ud);
            		  
            		  
            	   }
            		  
        		   if(tr){
        		   
            	   Order od=new Order();
            	   od.setOrderNO(transaction_id);
            	   od.setPrice(xinprice);
            	   od.setUserID(ud);
            	   od.setSeriesID(serid);
            	   od.setCreateTime(nowSql);
            	   
            	   
            	   c.setTime(nowSql);
            	   c.add(Calendar.DAY_OF_MONTH, 90);
            	   Date cc=c.getTime();
             	  long mills=cc.getTime();
             	  java.sql.Date ccc = new java.sql.Date(mills);
             	  od.setOvertime(ccc);
             	  od.setStatu(statu);
             	  od.setOuttradeno(outtradeno);
             	 vipService.addorder(od);
             	 
             	 String returnxml = "<xml>" +
                         "   <return_code><![CDATA[SUCCESS]]></return_code>" +
                         "   <return_msg><![CDATA[OK]]></return_msg>" +
                         "</xml>";

                 response.getWriter().write(returnxml);
                 response.getWriter().flush();
                 
        		   		
            	   }
        	   }
        	   
           }  
       }	
	}
	
}
