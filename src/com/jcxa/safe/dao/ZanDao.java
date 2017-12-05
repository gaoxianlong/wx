package com.jcxa.safe.dao;

import com.jcxa.safe.entity.Zan;

public abstract interface ZanDao
{
  public abstract void addzan(Zan paramZan);
  
  public abstract void deleteZanvo(Integer paramInteger1, Integer paramInteger2);
  
  public abstract void addvideo(Integer paramInteger1, Integer paramInteger2);
  
  public abstract Integer selectZanV(Integer paramInteger);
  
  public abstract Integer selectVideo(Integer paramInteger1, Integer paramInteger2);
}
