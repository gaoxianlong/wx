package com.jcxa.safe.controller;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcxa.safe.entity.Shareentiy;
@Controller
public class SharewxController {

	protected Logger log = Logger.getLogger(SharewxController.class);

	public static String getAccessToken() {  
	    String access_token = "";  
	    String grant_type = "client_credential";//获取access_token填写client_credential   
	    //String AppId="wx585bd9f0557b5d92";//第三方用户唯一凭证  
	    //String secret="020e8787cf60ae39e20c78fd56389e9b";//第三方用户唯一凭证密钥，即appsecret   
	    String AppId="wxa16c9081b82d8353";
	    String secret="e4e082e8d1e590e62e6d915a15b8456a";
	    //这个url链接地址和参数皆不能变  
	    String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type="+grant_type+"&appid="+AppId+"&secret="+secret;  
	    try {  
	        URL urlGet = new URL(url);  
	        HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();  
	        http.setRequestMethod("GET"); // 必须是get方式请求  
	        http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
	        http.setDoOutput(true);  
	        http.setDoInput(true);  
	        System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒  
	        System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒  
	        http.connect();  
	        InputStream is = http.getInputStream();  
	        int size = is.available();  
	        byte[] jsonBytes = new byte[size];  
	        is.read(jsonBytes);  
	        String message = new String(jsonBytes, "UTF-8");  
	        JSONObject demoJson = JSONObject.fromObject(message);  
	        
	        access_token = demoJson.getString("access_token");  
	        is.close();  
	    } catch (Exception e) {  
	            e.printStackTrace();  
	    }  
	    return access_token;  
	}  
	
	public static String getTicket(String access_token) {  
	    String ticket = null;  
	    String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ access_token +"&type=jsapi";//这个url链接和参数不能变  
	    try {  
	        URL urlGet = new URL(url);  
	        HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();  
	        http.setRequestMethod("GET"); // 必须是get方式请求  
	        http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
	        http.setDoOutput(true);  
	        http.setDoInput(true);  
	        System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒  
	        System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒  
	        http.connect();  
	        InputStream is = http.getInputStream();  
	        int size = is.available();  
	        byte[] jsonBytes = new byte[size];  
	        is.read(jsonBytes);  
	        String message = new String(jsonBytes, "UTF-8");  
	        JSONObject demoJson = JSONObject.fromObject(message);  
	       
	        ticket = demoJson.getString("ticket");  
	        is.close();  
	    } catch (Exception e) {  
	            e.printStackTrace();  
	    }  
	    return ticket;  
	}  
	
	public static String SHA1(String decript) {  
	    try {  
	        MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");  
	        digest.update(decript.getBytes());  
	        byte messageDigest[] = digest.digest();  
	        // Create Hex String  
	        StringBuffer hexString = new StringBuffer();  
	        // 字节数组转换为 十六进制 数  
	            for (int i = 0; i < messageDigest.length; i++) {  
	                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);  
	                if (shaHex.length() < 2) {  
	                    hexString.append(0);  
	                }  
	                hexString.append(shaHex);  
	            }  
	            return hexString.toString();  
	   
	        } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	        }  
	        return "";  
	}  
	
	@RequestMapping(value="/shareServlet")
	@ResponseBody
	public Shareentiy shareServlet(HttpServletRequest request,HttpServletResponse response,@RequestParam(value = "url") String url) {
		 String AppId="wxa16c9081b82d8353";
		// String AppId="wx585bd9f0557b5d92";
		 // String AppId="wx1d42fa2fba520d22";
	    //1、获取AccessToken  
	    String accessToken = getAccessToken();  
	      
	    //2、获取Ticket  
	    String jsapi_ticket = getTicket(accessToken);  
	      
	    //3、时间戳和随机字符串  
	    String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//随机字符串  
	    String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//时间戳  
	    //4、获取url  
	    String urll=url;  
	    /*根据JSSDK上面的规则进行计算，这里比较简单，我就手动写啦 
	    String[] ArrTmp = {"jsapi_ticket","timestamp","nonce","url"}; 
	    Arrays.sort(ArrTmp); 
	    StringBuffer sf = new StringBuffer(); 
	    for(int i=0;i<ArrTmp.length;i++){ 
	        sf.append(ArrTmp[i]); 
	    } 
	    */  
	      
	    //5、将参数排序并拼接字符串  
	    String str = "jsapi_ticket="+jsapi_ticket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+urll;  
	    //6、将字符串进行sha1加密  
	    String signature =SHA1(str);  
	    Shareentiy share =new Shareentiy();
	    share.setAppId(AppId);
	    share.setTimeStamp(timestamp);
	    share.setNonceStr(noncestr);
	    share.setSignature(signature);
	    return share;
	}  
}
