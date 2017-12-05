package com.jcxa.safe.service;

import com.jcxa.safe.dao.ZanDao;
import com.jcxa.safe.entity.Zan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZanService
{
  @Autowired
  private ZanDao dao;
  
  public void addzanService(Zan zan)
  {
    dao.addzan(zan);
  }
  
  public void deleteZanvo(Integer uid, Integer vid)
  {
    dao.deleteZanvo(uid, vid);
  }
  
  public void addvideoService(Integer zanNum, Integer id)
  {
    dao.addvideo(zanNum, id);
  }
  
  public Integer selectZanVService(Integer id)
  {
    Integer num = dao.selectZanV(id);
    return num;
  }
  
  public boolean selectVideoService(Integer uid, Integer vid)
  {
    Integer count = dao.selectVideo(uid, vid);
    boolean flag;
    if (count.intValue() != 0) {
      flag = true;
    } else {
      flag = false;
    }
    return flag;
  }
}
