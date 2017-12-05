package com.jcxa.safe.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcxa.safe.entity.Prolocutor;
import com.jcxa.safe.entity.Series;
import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;
import com.jcxa.safe.service.ProlocutorService;
import com.jcxa.safe.service.SeriesService;
import com.jcxa.safe.entity.Type;



@Controller
public class FpSeriesController {
	protected Logger log = Logger.getLogger(FpSeriesController.class);

	    @Autowired
		private SeriesService seriesService;
	    @Autowired
		private ProlocutorService prolocutorService;
		//学前
	    //查询二级菜单视频			
		@RequestMapping(value="/wxfpserxueqian")
		public String wxfpserxueqian(Map<String, Object> map,@RequestParam(value="id") int id,
				HttpSession session,
				@RequestParam(value="prolocutor",required = false,defaultValue="a") String prolocutor) {
		
			List<Series> series=null;
			List<Series> seriespublic=null;
		
			//取出用户信息
			Users user = (Users) session.getAttribute("user");
			WxUser wxuser = (WxUser) session.getAttribute("wxuser");
			String prolocutorindex="a";
			if(user!=null){
				//当用户不为null时 通过用户的id查询参数
				prolocutorindex=prolocutorService.selspro(user.getID());	
			}
			if(!prolocutor.equals("a")){
				System.out.println("我得参数不为a");
				//当前自己的状态
				String openid=wxuser.getOpenid();
				//int proid=prolocutorService.selproid(prolocutor);
				int WXopenid=0;
				System.out.println(openid+"77777777777");
				try {
					//根据传的参数去查user 信息
					WXopenid=prolocutorService.selproopenidd(prolocutor);
					System.out.println("对方的id="+WXopenid);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				String Openidchuan="a";
				//传过来的状态
				if(WXopenid!=0){
					//查询微信表信息
					 Openidchuan=prolocutorService.wxuseropenidd(WXopenid);
				}
					if(openid != Openidchuan){		
						//自己是否已经成为了下级
						System.out.println("是不是自己本身");
					  if(prolocutorService.onlydaiyan(openid)){
						  //判断自己是否已经主动成为了代理人
						//String spro=prolocutorService.selspro(nowid);
						  System.out.println("判断自己是否已经主动成为了代理人");
						  int zhuid=prolocutorService.openidzhu(openid);
						  System.out.println("看看微信表的id"+zhuid);
						  String spro="a";
						  try {
							  //根据微信id查参数
							  spro=prolocutorService.wxprolocutor(zhuid);
							  System.out.println("根据微信id查参数"+spro);
							  if(spro==null){
								  spro="a";  
							  }
						} catch (Exception e) {
							// TODO: handle exception
							spro="a";
						}
							if("a".equals(spro)){
							java.sql.Date nowSql = new java.sql.Date(System.currentTimeMillis());
							System.out.println(spro+"保存时");
								Prolocutor ps=new Prolocutor();
							ps.setProlocutor(prolocutor);
							ps.setOpenid(openid);
							ps.setCreateTime(nowSql);
							prolocutorService.adddaiyan(ps);
							System.out.println("我已保存");
							}
						}
			
					}
	
			}
			series=seriesService.getSerieserxq(id);
			ArrayList<Integer> ids=new ArrayList<Integer>();
			ids.add(307);
			ids.add(308);
			ids.add(297);
			ids.add(298);
			ids.add(309);
			seriespublic=seriesService.selectfpseries(ids);
			 map.put("series", series);
			 map.put("seriespublic", seriespublic);
			 map.put("prolocutorindex", prolocutorindex);
			 map.put("menupoint", 2);
			 map.put("school", 0);
			 return "views/wxfp/wxfpindexxq.jsp";
		}
	    
	    
	    //学前
	    //查询二级菜单视频
		@RequestMapping(value="/wxfpser")
		public String wxfpser(Map<String, Object> map,@RequestParam(value="id") int id,
				HttpSession session,
				@RequestParam(value="prolocutor",required = false,defaultValue="a") String prolocutor) {
			List<Type> tysan=null;
			List<Series> series=null;
			List<Series> seriespublic=null;
			tysan=seriesService.wxgetMulvsan(id);
			//取出用户信息
			Users user = (Users) session.getAttribute("user");
			WxUser wxuser = (WxUser) session.getAttribute("wxuser");
			String prolocutorindex="a";
			if(user!=null){
				//当用户不为null时 通过用户的id查询参数
				prolocutorindex=prolocutorService.selspro(user.getID());
			}
			if(!prolocutor.equals("a")){
				System.out.println("我得参数不为a");
				//当前自己的状态
				String openid=wxuser.getOpenid();
				//int proid=prolocutorService.selproid(prolocutor);
				int WXopenid=0;
				System.out.println(openid+"77777777777");
				try {
					//根据传的参数去查user 信息
					WXopenid=prolocutorService.selproopenidd(prolocutor);
					System.out.println("对方的id="+WXopenid);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				String Openidchuan="a";
				//传过来的状态
				if(WXopenid!=0){
					//查询微信表信息
					 Openidchuan=prolocutorService.wxuseropenidd(WXopenid);
				}
					if(openid != Openidchuan){		
						//自己是否已经成为了下级
						System.out.println("是不是自己本身");
					  if(prolocutorService.onlydaiyan(openid)){
						  //判断自己是否已经主动成为了代理人
						//String spro=prolocutorService.selspro(nowid);
						  System.out.println("判断自己是否已经主动成为了代理人");
						  int zhuid=prolocutorService.openidzhu(openid);
						  System.out.println("看看微信表的id"+zhuid);
						  String spro="a";
						  try {
							  //根据微信id查参数
							  spro=prolocutorService.wxprolocutor(zhuid);
							  System.out.println("根据微信id查参数"+spro);
							  if(spro==null){
								  spro="a";  
							  }
						} catch (Exception e) {
							// TODO: handle exception
							spro="a";
						}
							if("a".equals(spro)){
							java.sql.Date nowSql = new java.sql.Date(System.currentTimeMillis());
							System.out.println(spro+"保存时");
								Prolocutor ps=new Prolocutor();
							ps.setProlocutor(prolocutor);
							ps.setOpenid(openid);
							ps.setCreateTime(nowSql);
							prolocutorService.adddaiyan(ps);
							System.out.println("我已保存");
							}
						}
			
					}
	
				}
			ArrayList<Integer> ids=new ArrayList<Integer>();
			ids.add(307);
			ids.add(308);
			ids.add(301);
			ids.add(302);
			ids.add(303);
			ids.add(304);
			ids.add(305);
			ids.add(306);
			ids.add(297);
			ids.add(298);
			ids.add(309);
			series=seriesService.getSerieser(id);
			seriespublic=seriesService.selectfpseries(ids);
			 Integer point=id;
			 Integer pointb=0;
			 Integer pointsan=1;
			 map.put("point", point);
			 map.put("pointb", "a");
			 map.put("series", series);
			 map.put("seriespublic", seriespublic);
			 map.put("tysan", tysan);
			 map.put("pointsan", pointsan);
			 map.put("prolocutorindex", prolocutorindex);
			 map.put("menupoint", 2);
			 map.put("school", 1);
			 return "views/wxfp/wxfpindex.jsp";
		}
		 //查询三级级菜单视频
		@RequestMapping(value="/wxfpright")
		public String wxfpright(Map<String, Object> map,@RequestParam(value="id") int id,@RequestParam(value="sanid") Integer sanid,
				HttpSession session,
				@RequestParam(value="prolocutor",required = false,defaultValue="a") String prolocutor
				) {
			List<Type> tysan=null;
			List<Series> series=null;
			//取出用户信息
			Users user = (Users) session.getAttribute("user");
			WxUser wxuser = (WxUser) session.getAttribute("wxuser");
			String prolocutorindex="a";
			if(user!=null){
				//当用户不为null时 通过用户的id查询参数
				prolocutorindex=prolocutorService.selspro(user.getID());	
			}
			if(!prolocutor.equals("a")){
				System.out.println("我得参数不为a");
				//当前自己的状态
				String openid=wxuser.getOpenid();
				//int proid=prolocutorService.selproid(prolocutor);
				int WXopenid=0;
				System.out.println(openid+"77777777777");
				try {
					//根据传的参数去查user 信息
					WXopenid=prolocutorService.selproopenidd(prolocutor);
					System.out.println("对方的id="+WXopenid);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				String Openidchuan="a";
				//传过来的状态
				if(WXopenid!=0){
					//查询微信表信息
					 Openidchuan=prolocutorService.wxuseropenidd(WXopenid);
				}
					if(openid != Openidchuan){		
						//自己是否已经成为了下级
						System.out.println("是不是自己本身");
					  if(prolocutorService.onlydaiyan(openid)){
						  //判断自己是否已经主动成为了代理人
						//String spro=prolocutorService.selspro(nowid);
						  System.out.println("判断自己是否已经主动成为了代理人");
						  int zhuid=prolocutorService.openidzhu(openid);
						  System.out.println("看看微信表的id"+zhuid);
						  String spro="a";
						  try {
							  //根据微信id查参数
							  spro=prolocutorService.wxprolocutor(zhuid);
							  System.out.println("根据微信id查参数"+spro);
							  if(spro==null){
								  spro="a";  
							  }
						} catch (Exception e) {
							// TODO: handle exception
							spro="a";
						}
							if("a".equals(spro)){
							java.sql.Date nowSql = new java.sql.Date(System.currentTimeMillis());
							System.out.println(spro+"保存时");
								Prolocutor ps=new Prolocutor();
							ps.setProlocutor(prolocutor);
							ps.setOpenid(openid);
							ps.setCreateTime(nowSql);
							prolocutorService.adddaiyan(ps);
							System.out.println("我已保存");
							}
				
						}
			
					}
	
				}
			tysan=seriesService.wxgetMulvsan(id);
			series=seriesService.getSeriessan(sanid);
				
			 Integer point=id;
			 Integer pointsan=sanid;
			 String pointb=seriesService.rightname(sanid);
			 map.put("point", point);
			 map.put("pointb", pointb);
			 map.put("pointsan", pointsan);
			 map.put("prolocutorindex", prolocutorindex);
			 map.put("series", series);
			 map.put("tysan", tysan);
			 map.put("menupoint", 2);
			 map.put("school", 1);
			 return "views/wxfp/wxfpindex.jsp";	 
		}	
		 //查询二级菜单视频
		@RequestMapping(value="/wxfprighthobby")
		public String wxfprighthobby(Map<String, Object> map,@RequestParam(value="id") int id,@RequestParam(value="erid") Integer erid,
				@RequestParam(value="sorid") Integer sorid,@RequestParam(value="pointding") Integer pointding,
				HttpSession session,
				@RequestParam(value="prolocutor",required = false,defaultValue="a") String prolocutor
				) {
			List<Type> tysan=null;
			List<Series> series=null;
			//取出用户信息
			Users user = (Users) session.getAttribute("user");
			WxUser wxuser = (WxUser) session.getAttribute("wxuser");
			String prolocutorindex="a";
			if(user!=null){
				//当用户不为null时 通过用户的id查询参数
				prolocutorindex=prolocutorService.selspro(user.getID());
			}
			if(!prolocutor.equals("a")){
				System.out.println("我得参数不为a");
				//当前自己的状态
				String openid=wxuser.getOpenid();
				//int proid=prolocutorService.selproid(prolocutor);
				int WXopenid=0;
				System.out.println(openid+"77777777777");
				try {
					//根据传的参数去查user 信息
					WXopenid=prolocutorService.selproopenidd(prolocutor);
					System.out.println("对方的id="+WXopenid);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				String Openidchuan="a";
				//传过来的状态
				if(WXopenid!=0){
					//查询微信表信息
					 Openidchuan=prolocutorService.wxuseropenidd(WXopenid);
				}
					if(openid != Openidchuan){		
						//自己是否已经成为了下级
						System.out.println("是不是自己本身");
					  if(prolocutorService.onlydaiyan(openid)){
						  //判断自己是否已经主动成为了代理人
						//String spro=prolocutorService.selspro(nowid);
						  System.out.println("判断自己是否已经主动成为了代理人");
						  int zhuid=prolocutorService.openidzhu(openid);
						  System.out.println("看看微信表的id"+zhuid);
						  String spro="a";
						  try {
							  //根据微信id查参数
							  spro=prolocutorService.wxprolocutor(zhuid);
							  System.out.println("根据微信id查参数"+spro);
							  if(spro==null){
								  spro="a";  
							  }
						} catch (Exception e) {
							// TODO: handle exception
							spro="a";
						}
						 
							if("a".equals(spro)){
							java.sql.Date nowSql = new java.sql.Date(System.currentTimeMillis());
							System.out.println(spro+"保存时");
								Prolocutor ps=new Prolocutor();
							ps.setProlocutor(prolocutor);
							ps.setOpenid(openid);
							ps.setCreateTime(nowSql);
							prolocutorService.adddaiyan(ps);
							System.out.println("我已保存");
							}
				
						}
			
					}
	
				}
			tysan=seriesService.wxgetMulvsan(id);
			
			if(sorid!=0){
				series=seriesService.getSerieser(erid);
			}
			if(sorid==0){
				ArrayList<Integer> ids=new ArrayList<Integer>();
				
				ids.add(301);
				ids.add(302);
				ids.add(303);
				ids.add(304);
				ids.add(305);
				ids.add(306);
				series=seriesService.selectfpseries(ids);
			}
			
			String pointdings=null;
			if(pointding==0){
				pointdings="趣味学习儿歌";
			}
			if(pointding==1){
				pointdings="学习方法";
			}
			if(pointding==2){
				pointdings="家庭教育";
			}
			if(pointding==3){
				pointdings="绘画";
			}
			if(pointding==4){
				pointdings="记忆法";
			}
			if(pointding==5){
				pointdings="国学";
			}
			if(pointding==6){
				pointdings="古诗词";
			}
			 Integer point=id;
			 Integer pointsan=erid;
			 map.put("point", point);
			 map.put("pointb", pointdings);
			 map.put("pointsan", pointsan);
			 map.put("prolocutorindex", prolocutorindex);
			 map.put("series", series);
			 map.put("tysan", tysan);
			 map.put("menupoint", 2);
			 map.put("school", 1);
			 return "views/wxfp/wxfpindex.jsp";
			 
		
		}
		

}
