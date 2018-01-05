package com.jcxa.safe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.jcxa.safe.entity.OrderandSeries;
import com.jcxa.safe.entity.Percentage;
import com.jcxa.safe.entity.Profit;
import com.jcxa.safe.entity.Prolocutor;
import com.jcxa.safe.entity.Tixian;
import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;
import com.jcxa.safe.entity.Wxorder;
import com.jcxa.safe.service.ProlocutorService;
import com.jcxa.safe.service.VipService;
import com.utils.DateUtils;

import PubMethods.GetproListId;





@Controller
public class ProlocutorController {
	@Autowired
	private ProlocutorService prolocutorService;
	@Autowired
	private VipService vipService;
	
	//提现mopney
	
	@RequestMapping("tixianmoney")
	public String tixianmoney(HttpSession session,Map<String, Object> map,
			@RequestParam(value="money") String money
			){
			Users user = (Users) session.getAttribute("user");
			int uid=user.getID();
			int my = Integer.parseInt(money);
			
			
			int shengyu=prolocutorService.selprofit(uid);
			int totalsheng=shengyu+my;
			String name=user.getNickName();
			Tixian tx=new Tixian();
			tx.setMoney(my);
			tx.setUid(uid);
			tx.setName(name);
			tx.setAddtimes(DateUtils.getFormatDateYMDHMS());
			prolocutorService.tixianmoney(tx);
			Profit prs=new Profit();
			prs.setUid(uid);
			prs.setMoney(totalsheng);
			prolocutorService.updateprofit(prs);
			
			return "views/spokesman/wxtxover.jsp";
		
	}
	
	
	
	//成为代言人
	@RequestMapping("become")
	public String become(HttpSession session,Map<String, Object> map){
			Users user = (Users) session.getAttribute("user");
			int uid=user.getID();
			//int ID=20436;
			String prolocutor = UUID.randomUUID().toString();
			Users us=new Users();
			us.setProlocutor(prolocutor);
			us.setID(uid);
			prolocutorService.become(us);
			
			Profit pr=new Profit();
			pr.setUid(uid);
			pr.setMoney(0);
			
			if(prolocutorService.profitold(uid)){
				prolocutorService.insertprofit(pr);
			}
			
			return "views/spokesman/wxspokesok.jsp";
		
	}
	
	//代言人首页
	@RequestMapping("txindex")
	public String txindex(Map<String, Object> map,
			@RequestParam(value="page",required=false,defaultValue="1") Integer page,HttpSession session){
		
		//取出用户信息
		Users user = (Users) session.getAttribute("user");
		
		 
		 List<Users> userdaiyan=null;
		 List<WxUser> wxuser=null;
		 if(user != null){
			 String prolocutor=prolocutorService.selspro(user.getID());
	     if(prolocutor != null){
	    	//
	    	System.out.println("参数不为空");
	    	Integer xiaidzhu=0;
			Integer xiaid=0;
			ArrayList<Integer> xiaxianid=new ArrayList<Integer>();
			ArrayList<String> xiaxianopenid=new ArrayList<String>();
			ArrayList<Integer> xiaxianidzhu=new ArrayList<Integer>();

			List<Prolocutor> ls = null;
			if(prolocutor != null){
				System.out.println("代言人+"+prolocutor);
				 ls= prolocutorService.selxiaxian(prolocutor);
			}
			 
			if(ls.size()>0){
				
				for(int i=0;i<ls.size();i++){
					
					xiaxianopenid.add(ls.get(i).getOpenid());
					
				}
			}
		
		
			if(xiaxianopenid.size()>0){
				
				for(int i=0;i<xiaxianopenid.size();i++){
					xiaidzhu=prolocutorService.openidzhu(xiaxianopenid.get(i));
					
					xiaxianidzhu.add(xiaidzhu);
					//xiaxianid.xiaxianopenid(xiaxianopenid.get(i).getOpenid());
				}
			}
			PageInfo<Object> pageInfo = null;
			List<Object> lsuser=null;
			List<Object> olist=new ArrayList<Object>();
			if(xiaxianidzhu.size()>0){
				for(int i=0;i<xiaxianidzhu.size();i++){
					
					wxuser=prolocutorService.selectWxUserService(xiaxianidzhu.get(i));
					olist.add(wxuser);
				}
				pageInfo = new PageInfo<Object>(olist);
				System.out.println(wxuser+"我是微信列表");
				 lsuser = pageInfo.getList();
				 map.put("info", pageInfo);
				 map.put("userss", olist);
				}
	    	}	
		}
		return "views/spokesman/wxmydaiyr.jsp";
		
	}
	//首页金额
		@RequestMapping("money")
		public String money(Map<String, Object> map,HttpSession session){
		
			String alows="0.0";
			String noos="0.0";
			String name=".";
			double alow=0.0;
			double noo=0.0;
			int money=0;
			int total=0;
			
			Users user = (Users) session.getAttribute("user");
			WxUser wxuser = (WxUser) session.getAttribute("wxuser");
			String prolocutor="a";
			try {
			  prolocutor=prolocutorService.selspro(user.getID());
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				 name=user.getNickName();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			if(user != null){
				if(prolocutor != null){
					int id=user.getID();
						try {
							money=prolocutorService.selprofit(id);
						} catch (Exception e) {
							// TODO: handle exception
						}
		    
			List<Prolocutor> ls = null;
			Percentage ps=prolocutorService.selper();
			
			Integer xiaidzhu=0;
			Integer xiaid=0;
			ArrayList<Integer> xiaxianid=new ArrayList<Integer>();
			ArrayList<Integer> xiaxianidzhu=new ArrayList<Integer>();
			ArrayList<String> xiaxianopenid=new ArrayList<String>();
			
			if(prolocutor != null){	
				 ls= prolocutorService.selxiaxian(prolocutor);
			}
			 
			if(ls.size()>0){
				
				for(int i=0;i<ls.size();i++){
					xiaxianopenid.add(ls.get(i).getOpenid());
				}
			}
			if(xiaxianopenid.size()>0){
				
				for(int i=0;i<xiaxianopenid.size();i++){
					xiaidzhu=prolocutorService.openidzhu(xiaxianopenid.get(i));
					
					xiaxianidzhu.add(xiaidzhu);
					//xiaxianid.xiaxianopenid(xiaxianopenid.get(i).getOpenid());
				}
			}
			
			if(xiaxianidzhu.size()>0){
				for(int i=0;i<xiaxianidzhu.size();i++){
					xiaid=prolocutorService.openidsel(xiaxianidzhu.get(i));
					
					xiaxianid.add(xiaid);
					//xiaxianid.xiaxianopenid(xiaxianopenid.get(i).getOpenid());
				}
			}
			
				double torder=0;
				double vip=0;
				
				double nottorder=0;
				double notvip=0;
				
				if(xiaxianid.size()>0){
					//kaishi
					for(int i=0;i<xiaxianid.size();i++){
						try {
							try {
								torder=(double) (torder+prolocutorService.moneyorder(xiaxianid.get(i))*ps.getOrder());
							} catch (Exception e) {
								// TODO: handle exception
							}
							nottorder=(double) (nottorder+prolocutorService.notmoneyorder(xiaxianid.get(i))*ps.getOrder());
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					for(int i=0;i<xiaxianid.size();i++){
						try {
							try {
								vip=(double) (vip+prolocutorService.moneyvip(xiaxianid.get(i))*ps.getVip());
							} catch (Exception e) {
								// TODO: handle exception
							}
							notvip=(double) (notvip+prolocutorService.notmoneyvip(xiaxianid.get(i))*ps.getVip());
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
							alow=torder+vip-money;
							
							noo=nottorder+notvip;
							 
							alows=String.format("%.2f", alow).toString();
							noos=String.format("%.2f", noo).toString();
					
					//jiesu
					}	
				}
			}
							map.put("menupoint",3);
							map.put("prolocutor",prolocutor);
							//map.put("total", total);
							map.put("alow", alows);
							map.put("noo", noos);
							map.put("money", money);
							map.put("name", name);
							return "views/spokesman/wxspokesman.jsp";
			
		}
		
		
		
		//代言人下的学员订单详情
				@RequestMapping("proordercourse")
				public String proordercourse(Map<String, Object> map,HttpSession session){
				
					ArrayList<OrderandSeries>  course = new ArrayList<OrderandSeries>();
					List<Wxorder>  viptotal = new ArrayList<Wxorder>();
					
					//Users user = (Users) session.getAttribute("user");
					
					Users user =new Users();
					user.setID(21142);
					user.setProlocutor("4744d348-5809-4f2a-b787-4cdeabb883af");
					
					WxUser wxuser = (WxUser) session.getAttribute("wxuser");
					String prolocutor="a";
					try {
					  prolocutor=prolocutorService.selspro(user.getID());
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					
					if(user != null){
						if(prolocutor != null){
							//int id=user.getID();
								
				    
					List<Prolocutor> ls = null;
					Percentage ps=prolocutorService.selper();
					
					Integer xiaidzhu=0;
					Integer xiaid=0;
					ArrayList<Integer> xiaxianid=new ArrayList<Integer>();
					ArrayList<Integer> xiaxianidzhu=new ArrayList<Integer>();
					ArrayList<String> xiaxianopenid=new ArrayList<String>();
					
					if(prolocutor != null){	
						 ls= prolocutorService.selxiaxian(prolocutor);
					}
					 
					if(ls.size()>0){
						
						for(int i=0;i<ls.size();i++){
							xiaxianopenid.add(ls.get(i).getOpenid());
						}
					}
					if(xiaxianopenid.size()>0){
						
						for(int i=0;i<xiaxianopenid.size();i++){
							xiaidzhu=prolocutorService.openidzhu(xiaxianopenid.get(i));
							
							xiaxianidzhu.add(xiaidzhu);
							//xiaxianid.xiaxianopenid(xiaxianopenid.get(i).getOpenid());
						}
					}
					
					if(xiaxianidzhu.size()>0){
						for(int i=0;i<xiaxianidzhu.size();i++){
							xiaid=prolocutorService.openidsel(xiaxianidzhu.get(i));
							
							xiaxianid.add(xiaid);
							//xiaxianid.xiaxianopenid(xiaxianopenid.get(i).getOpenid());
						}
					}
					
					
						if(xiaxianid.size()>0){
							//kaishi
							for(int i=0;i<xiaxianid.size();i++){
								try {
									try {
									//now
										Wxorder viporder=vipService.getwxorder(xiaxianid.get(i));
										if(viporder !=null){
											viptotal.add(viporder);
										}
											
										
									} catch (Exception e) {
										// TODO: handle exception
									}
									
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							
							//jiesu
							}	
					
						if(xiaxianid.size()>0){
							//kaishi
							for(int i=0;i<xiaxianid.size();i++){
								try {
									try {
									//now
										List<OrderandSeries> oneorderbyone=prolocutorService.selorderandk(xiaxianid.get(i));
										course.addAll(oneorderbyone);	
										
										
									} catch (Exception e) {
										// TODO: handle exception
									}
									
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							
							//jiesu
							}	
						}
					}
				
						map.put("courseper", 0.2);
						map.put("vipper", 0.3);
						map.put("course", course);
						map.put("viptotal", viptotal);
						return "views/spokesman/wxtxorder.jsp";
				}
				
				
				//代言人下的学员订单详情test
				@RequestMapping("proordervip")
				@ResponseBody
				public List<Wxorder> proordervip(Map<String, Object> map,HttpSession session){
				
					ArrayList<Wxorder>  viptotal = new ArrayList<Wxorder>();
					
					//Users user = (Users) session.getAttribute("user");
					
					Users user =new Users();
					user.setID(21142);
					user.setProlocutor("4744d348-5809-4f2a-b787-4cdeabb883af");
					
					WxUser wxuser = (WxUser) session.getAttribute("wxuser");
					String prolocutor="a";
					try {
					  prolocutor=prolocutorService.selspro(user.getID());
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					
					if(user != null){
						if(prolocutor != null){
							//int id=user.getID();
								
				    
					List<Prolocutor> ls = null;
					Percentage ps=prolocutorService.selper();
					
					Integer xiaidzhu=0;
					Integer xiaid=0;
					ArrayList<Integer> xiaxianid=new ArrayList<Integer>();
					ArrayList<Integer> xiaxianidzhu=new ArrayList<Integer>();
					ArrayList<String> xiaxianopenid=new ArrayList<String>();
					
					if(prolocutor != null){	
						 ls= prolocutorService.selxiaxian(prolocutor);
					}
					 
					if(ls.size()>0){
						
						for(int i=0;i<ls.size();i++){
							xiaxianopenid.add(ls.get(i).getOpenid());
						}
					}
					if(xiaxianopenid.size()>0){
						
						for(int i=0;i<xiaxianopenid.size();i++){
							xiaidzhu=prolocutorService.openidzhu(xiaxianopenid.get(i));
							
							xiaxianidzhu.add(xiaidzhu);
							//xiaxianid.xiaxianopenid(xiaxianopenid.get(i).getOpenid());
						}
					}
					
					if(xiaxianidzhu.size()>0){
						for(int i=0;i<xiaxianidzhu.size();i++){
							xiaid=prolocutorService.openidsel(xiaxianidzhu.get(i));
							
							xiaxianid.add(xiaid);
							//xiaxianid.xiaxianopenid(xiaxianopenid.get(i).getOpenid());
						}
					}
					
						double torder=0;
						double vip=0;
						
					
						if(xiaxianid.size()>0){
							//kaishi
							for(int i=0;i<xiaxianid.size();i++){
								try {
									try {
									//now
										Wxorder viporder=vipService.getwxorder(xiaxianid.get(i));
										viptotal.add(viporder);	
									} catch (Exception e) {
										// TODO: handle exception
									}
									
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							
							//jiesu
							}	
						}
					}
									
									return viptotal;
				}
				
//				//代言人下的学员订单详情order
//				@RequestMapping("proorder")
//				@ResponseBody
//				public List<OrderandSeries> proorder(Map<String, Object> map,HttpSession session){
//				
//					List<OrderandSeries>  total=null;
//					Users user = (Users) session.getAttribute("user");
//					
//					if(user != null){
//						
//					ArrayList<Integer> idlist = GetproListId.getproListId(user);
//					
//					for(int i=0;i<idlist.size();i++){
//						List<OrderandSeries> oneorderbyone=prolocutorService.selorderandk(idlist.get(i));
//						total.addAll(oneorderbyone);
//						}		
//					}				
//						return total;
//					
//				}
}
