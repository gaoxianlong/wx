package com.jcxa.safe.entity;

public class OrderSms
{
  private String PhoneNumbers;
  private String SignName;
  private String TemplateCode;
  private String Code;
  private String RequestId;
  private boolean Message;
  private String BizId;
  
  public String getPhoneNumbers()
  {
    return this.PhoneNumbers;
  }
  
  public void setPhoneNumbers(String phoneNumbers)
  {
    this.PhoneNumbers = phoneNumbers;
  }
  
  public String getSignName()
  {
    return this.SignName;
  }
  
  public void setSignName(String signName)
  {
    this.SignName = signName;
  }
  
  public String getTemplateCode()
  {
    return this.TemplateCode;
  }
  
  public void setTemplateCode(String templateCode)
  {
    this.TemplateCode = templateCode;
  }
  
  public String getCode()
  {
    return this.Code;
  }
  
  public void setCode(String code)
  {
    this.Code = code;
  }
  
  public String getRequestId()
  {
    return this.RequestId;
  }
  
  public void setRequestId(String requestId)
  {
    this.RequestId = requestId;
  }
  
  public boolean isMessage()
  {
    return this.Message;
  }
  
  public void setMessage(boolean message)
  {
    this.Message = message;
  }
  
  public String getBizId()
  {
    return this.BizId;
  }
  
  public void setBizId(String bizId)
  {
    this.BizId = bizId;
  }
  
  @Override
public String toString()
  {
    return 
    
      "OrderSms [PhoneNumbers=" + this.PhoneNumbers + ", SignName=" + this.SignName + ", TemplateCode=" + this.TemplateCode + ", Code=" + this.Code + ", RequestId=" + this.RequestId + ", Message=" + this.Message + ", BizId=" + this.BizId + "]";
  }
}
