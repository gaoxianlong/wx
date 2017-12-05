package com.jcxa.safe.controller;

import com.jcxa.safe.entity.Zan;
import com.jcxa.safe.service.ZanService;
import com.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ZanController{
  @Autowired
  private ZanService zanService;
  
  
  
  @RequestMapping("/addzan")
  @ResponseBody
  public String addzan(Integer uid, Integer vid){
    Zan zan = new Zan();
    zan.setUid(uid);
    zan.setVid(vid);
    zan.setAddtimes(DateUtils.getFormatDateYMDHMS());
    zanService.addzanService(zan);
    System.out.println(zan.toString());
    if (vid != null)
    {
      Integer num = zanService.selectZanVService(vid);
      num = Integer.valueOf(num.intValue() + 1);
      System.out.println("数量点赞" + num);
      zanService.addvideoService(num, vid);
    }
    return "ok";
  }
  
  @RequestMapping("/deleteZanvo")
  @ResponseBody
  public String deleteZanvo(Integer uid, Integer vid){
    zanService.deleteZanvo(uid, vid);
    Integer num = zanService.selectZanVService(vid);
    num = Integer.valueOf(num.intValue() - 1);
    if (num.intValue() < 1) {
      num = Integer.valueOf(0);
    }
    System.out.println("删除点赞+++" + num);
    zanService.addvideoService(num, vid);
    return "ok";
  }
}
