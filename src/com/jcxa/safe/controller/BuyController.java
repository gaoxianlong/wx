package com.jcxa.safe.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcxa.safe.entity.Series;
import com.jcxa.safe.service.PlayService;


@Controller
public class BuyController {
	@Autowired
	private PlayService playService;
	
	@RequestMapping("buy")
	public String hello(@RequestParam(value = "serid") Integer serid,Map<String, Object> map){
		System.out.println("hello");
		//查询课程封面的信息
		Series sers=playService.getplaySeries(serid);
		map.put("ser", sers);
		return "views/wxorder.jsp";
		
	}
}
