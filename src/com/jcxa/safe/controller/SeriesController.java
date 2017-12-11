package com.jcxa.safe.controller;

import java.util.Date;
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
import com.jcxa.safe.service.LoginService;
import com.jcxa.safe.service.ProlocutorService;
import com.jcxa.safe.service.SeriesService;



@Controller
public class SeriesController {
	protected Logger log = Logger.getLogger(SeriesController.class);

		
	    @Autowired
		private SeriesService seriesService;
		
	    @Autowired
		private ProlocutorService prolocutorService;
	    @Autowired
	    private LoginService loginService;
	//查询二级菜单视频
		
		@RequestMapping(value="/wxserold")
		public String backselserieser(Map<String, Object> map,@RequestParam(value="id") int id,
				@RequestParam(value="prolocutor",required = false,defaultValue="a") String prolocutor,HttpSession session,
				@RequestParam(value="sort",required = false,defaultValue="xx") String sort
				) {
			
			int sid=0;
			String eqq=null;
			//取出用户信息
			Users user = (Users) session.getAttribute("user");
			WxUser wxuser = (WxUser) session.getAttribute("wxuser");
			String prolocutorindex="a";
			if(user!=null){
				//当用户不为null时 通过用户的id查询参数
				prolocutorindex=prolocutorService.selspro(user.getID());
				System.out.println("user!=null时，prolocutorindex="+prolocutor);
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
		
						List<Series> series=null;
						List<Series> hobby=null;
						List<Series> vphigh=null;
						List<Series> ff=null;
						//免费专区
						List<Series> free=null;
						List<Series> freetwo=null;
						
						if("xq".equals(sort)){
							series=seriesService.getSerieserxq(id);
						}else{
							series=seriesService.getSerieser(id);
						}
							
						 Integer point=id;
						 map.put("point", point);
						
						 hobby=seriesService.gethobby("hobby");
						 vphigh=seriesService.gethobby("vphigh");
						 ff=seriesService.gethobby("ff");
						 //免费专区
						 free=seriesService.getfree("free");
						 freetwo=seriesService.getfree("freetwo");
						 map.put("menupoint", 1);
						 map.put("free", free);
						 map.put("freetwo", freetwo);
						 //map.put("vphigh", vphigh);
						 // map.put("ff", ff);
						 // map.put("hobby", hobby);
						 map.put("series", series);
			 
						 map.put("sort", sort);
						 map.put("prolocutorindex", prolocutorindex);
						 return "index.jsp";
		}
}
