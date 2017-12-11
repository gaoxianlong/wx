package com.jcxa.safe.controller;


import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




import com.jcxa.safe.service.PlayService;
import com.utils.GetWxOrderno;
import com.utils.RequestHandler;
import com.utils.Sha1Util;
import com.utils.TenpayUtil;

@Controller
public class TixianpayController {

	protected Logger log = Logger.getLogger(TixianpayController.class);

	@Autowired
	private PlayService playService;

	@RequestMapping(value="/tixiantopayServlet")
	@ResponseBody
	public void topayServlet(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "pric",required = false) String pric,
			@RequestParam(value = "openid",required = false) String openid
			) {
	
						//商户相关资料 
						String appid = "wx1d42fa2fba520d22";
						String appsecret = "caf5381cc5b63cb108c0fece2324834c";
						String partner = "1393692002";
						String partnerkey = "caf5381cc5b63cb108c0fece2324834c";
						
						//网页授权后获取传递的参数
						String orderNo=appid+Sha1Util.getTimeStamp();
					
						String money = request.getParameter("pric");
						String code = request.getParameter("code");
						
						String desc="微信提现";
						
						//金额转化为分为单位
						float sessionmoney = Float.parseFloat(money);
						String finalmoney = String.format("%.2f", sessionmoney);
						finalmoney = finalmoney.replace(".", "");
				
						//获取openId后调用统一支付接口https://api.mch.weixin.qq.com/pay/unifiedorder
						String currTime = TenpayUtil.getCurrTime();
						//8位日期
						String strTime = currTime.substring(8, currTime.length());
						//四位随机数
						String strRandom = TenpayUtil.buildRandom(4) + "";
						//10位序列号,可以自行调整。
						String strReq = strTime + strRandom;
						
						//商户号
						String mch_id = partner;
						//子商户号  非必输
						//String sub_mch_id="";
						//设备号   非必输
						String device_info="";
						//随机数 
						String nonce_str = strReq;
						
						//商户订单号
						String out_trade_no = orderNo;
						int intMoney = Integer.parseInt(finalmoney);
						
						//总金额以分为单位，不带小数点
						int total_fee = intMoney;
						//订单生成的机器 IP
						String spbill_create_ip = request.getRemoteAddr();						
						
						//非必输
//						String product_id = "";
						SortedMap<String, String> packageParams = new TreeMap<String, String>();
						packageParams.put("appid", appid);  
						packageParams.put("mch_id", mch_id);  
						packageParams.put("nonce_str", nonce_str);  
						packageParams.put("out_trade_no", out_trade_no);  
						
						//这里写的金额为1 分到时修改
						//packageParams.put("total_fee", "1");  
						packageParams.put("amount", finalmoney);  
						packageParams.put("spbill_create_ip", spbill_create_ip);  
						packageParams.put("openid", openid);  
						packageParams.put("check_name", "FORCE_CHECK");
						packageParams.put("desc", desc);
						RequestHandler reqHandler = new RequestHandler(request, response);
						reqHandler.init(appid, appsecret, partnerkey);
						
						String sign = reqHandler.createSign(packageParams);
						String xml="<xml>"+
								"<appid>"+appid+"</appid>"+
								"<mch_id>"+mch_id+"</mch_id>"+
								"<nonce_str>"+nonce_str+"</nonce_str>"+
								"<sign>"+sign+"</sign>"+
								"<out_trade_no>"+out_trade_no+"</out_trade_no>"+
								//金额，这里写的1 分到时修改
								//"<total_fee>"+1+"</total_fee>"+
								"<amount>"+finalmoney+"</amount>"+
								"<check_name>"+"FORCE_CHECK"+"</check_name>"+
								"<desc>"+desc+"</desc>"+
								"<spbill_create_ip>"+spbill_create_ip+"</spbill_create_ip>"+
							
								"<openid>"+openid+"</openid>"+
								"</xml>";
						System.out.println(xml);
						
						String allParameters = "";
						try {
					
							allParameters =  reqHandler.genPackage(packageParams);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String createOrderURL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
						Map map=null;
						try {
							
							new GetWxOrderno();
							map = GetWxOrderno.tixian(createOrderURL, xml);	
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}				
	}
	
}
