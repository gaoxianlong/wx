package com.jcxa.safe.entity;

import java.util.Date;

public class Users {
	private Integer ID;
	private String NickName;
	private String RealName;
	private String Telephone;
	private String Password;
	private String HeadUrl;
	private String Sex;
	private String Birthday;
	private String City1;
	private String City2;
	private String City3;
	private String Sign;
	private Date Registertime;
	private Date Lasttime;
	private String Salt;
	private String School;
	private String Grade;
	private String Education;
	private String Teacher;
	private String HelpCode;
	private Integer Prestudent;
	private String Qqid;
	private Integer WXopendID;
	private String Unionid;
	private String demo1;
	private String wxclass;
	private String prolocutor;
	private Date nowdaiyatime;

	public Date getNowdaiyatime() {
		return nowdaiyatime;
	}

	public void setNowdaiyatime(Date nowdaiyatime) {
		this.nowdaiyatime = nowdaiyatime;
	}

	public String getProlocutor() {
		return prolocutor;
	}

	public void setProlocutor(String prolocutor) {
		this.prolocutor = prolocutor;
	}

	public String getDemo1() {
		return this.demo1;
	}

	public void setDemo1(String demo1) {
		this.demo1 = demo1;
	}

	public String getWxclass() {
		return this.wxclass;
	}

	public void setWxclass(String wxclass) {
		this.wxclass = wxclass;
	}

	

	public Integer getWXopendID() {
		return WXopendID;
	}

	public void setWXopendID(Integer wXopendID) {
		WXopendID = wXopendID;
	}

	public String getUnionid() {
		return this.Unionid;
	}

	public void setUnionid(String unionid) {
		this.Unionid = unionid;
	}

	public String getSalt() {
		return this.Salt;
	}

	public void setSalt(String salt) {
		this.Salt = salt;
	}

	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer iD) {
		this.ID = iD;
	}

	public String getNickName() {
		return this.NickName;
	}

	public void setNickName(String nickName) {
		this.NickName = nickName;
	}

	public String getRealName() {
		return this.RealName;
	}

	public void setRealName(String realName) {
		this.RealName = realName;
	}

	public String getTelephone() {
		return this.Telephone;
	}

	public void setTelephone(String telephone) {
		this.Telephone = telephone;
	}

	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getHeadUrl() {
		return this.HeadUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.HeadUrl = headUrl;
	}

	public String getSex() {
		return this.Sex;
	}

	public void setSex(String sex) {
		this.Sex = sex;
	}

	public String getBirthday() {
		return this.Birthday;
	}

	public void setBirthday(String birthday) {
		this.Birthday = birthday;
	}

	public String getCity1() {
		return this.City1;
	}

	public void setCity1(String city1) {
		this.City1 = city1;
	}

	public String getCity2() {
		return this.City2;
	}

	public void setCity2(String city2) {
		this.City2 = city2;
	}

	public String getCity3() {
		return this.City3;
	}

	public void setCity3(String city3) {
		this.City3 = city3;
	}

	public String getSchool() {
		return this.School;
	}

	public void setSchool(String school) {
		this.School = school;
	}

	public String getGrade() {
		return this.Grade;
	}

	public void setGrade(String grade) {
		this.Grade = grade;
	}

	public String getEducation() {
		return this.Education;
	}

	public void setEducation(String education) {
		this.Education = education;
	}

	public String getTeacher() {
		return this.Teacher;
	}

	public void setTeacher(String teacher) {
		this.Teacher = teacher;
	}

	public String getHelpCode() {
		return this.HelpCode;
	}

	public void setHelpCode(String helpCode) {
		this.HelpCode = helpCode;
	}

	public Date getRegistertime() {
		return this.Registertime;
	}

	public void setRegistertime(Date registertime) {
		this.Registertime = registertime;
	}

	public Date getLasttime() {
		return this.Lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.Lasttime = lasttime;
	}

	public Integer getPrestudent() {
		return this.Prestudent;
	}

	public void setPrestudent(Integer prestudent) {
		this.Prestudent = prestudent;
	}

	public String getSign() {
		return this.Sign;
	}

	public void setSign(String sign) {
		this.Sign = sign;
	}

	public String getQqid() {
		return this.Qqid;
	}

	public void setQqid(String qqid) {
		this.Qqid = qqid;
	}

	@Override
	public String toString() {
		return "Users [ID=" + ID + ", NickName=" + NickName + ", RealName="
				+ RealName + ", Telephone=" + Telephone + ", Password="
				+ Password + ", HeadUrl=" + HeadUrl + ", Sex=" + Sex
				+ ", Birthday=" + Birthday + ", City1=" + City1 + ", City2="
				+ City2 + ", City3=" + City3 + ", Sign=" + Sign
				+ ", Registertime=" + Registertime + ", Lasttime=" + Lasttime
				+ ", Salt=" + Salt + ", School=" + School + ", Grade=" + Grade
				+ ", Education=" + Education + ", Teacher=" + Teacher
				+ ", HelpCode=" + HelpCode + ", Prestudent=" + Prestudent
				+ ", Qqid=" + Qqid + ", WXopendID=" + WXopendID + ", Unionid="
				+ Unionid + ", demo1=" + demo1 + ", wxclass=" + wxclass
				+ ", prolocutor=" + prolocutor + ", nowdaiyatime="
				+ nowdaiyatime + "]";
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = 31 * result
				+ (this.Birthday == null ? 0 : this.Birthday.hashCode());
		result = 31 * result + (this.City1 == null ? 0 : this.City1.hashCode());
		result = 31 * result + (this.City2 == null ? 0 : this.City2.hashCode());
		result = 31 * result + (this.City3 == null ? 0 : this.City3.hashCode());
		result = 31 * result
				+ (this.Education == null ? 0 : this.Education.hashCode());
		result = 31 * result + (this.Grade == null ? 0 : this.Grade.hashCode());
		result = 31 * result
				+ (this.HeadUrl == null ? 0 : this.HeadUrl.hashCode());
		result = 31 * result
				+ (this.HelpCode == null ? 0 : this.HelpCode.hashCode());
		result = 31 * result + (this.ID == null ? 0 : this.ID.hashCode());
		result = 31 * result
				+ (this.Lasttime == null ? 0 : this.Lasttime.hashCode());
		result = 31 * result
				+ (this.NickName == null ? 0 : this.NickName.hashCode());
		result = 31 * result
				+ (this.Password == null ? 0 : this.Password.hashCode());
		result = 31 * result
				+ (this.Prestudent == null ? 0 : this.Prestudent.hashCode());
		result = 31 * result + (this.Qqid == null ? 0 : this.Qqid.hashCode());
		result = 31 * result
				+ (this.RealName == null ? 0 : this.RealName.hashCode());
		result = 31
				* result
				+ (this.Registertime == null ? 0 : this.Registertime.hashCode());
		result = 31 * result + (this.Salt == null ? 0 : this.Salt.hashCode());
		result = 31 * result
				+ (this.School == null ? 0 : this.School.hashCode());
		result = 31 * result + (this.Sex == null ? 0 : this.Sex.hashCode());
		result = 31 * result + (this.Sign == null ? 0 : this.Sign.hashCode());
		result = 31 * result
				+ (this.Teacher == null ? 0 : this.Teacher.hashCode());
		result = 31 * result
				+ (this.Telephone == null ? 0 : this.Telephone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Users other = (Users) obj;
		if (this.Birthday == null) {
			if (other.Birthday != null) {
				return false;
			}
		} else if (!this.Birthday.equals(other.Birthday)) {
			return false;
		}
		if (this.City1 == null) {
			if (other.City1 != null) {
				return false;
			}
		} else if (!this.City1.equals(other.City1)) {
			return false;
		}
		if (this.City2 == null) {
			if (other.City2 != null) {
				return false;
			}
		} else if (!this.City2.equals(other.City2)) {
			return false;
		}
		if (this.City3 == null) {
			if (other.City3 != null) {
				return false;
			}
		} else if (!this.City3.equals(other.City3)) {
			return false;
		}
		if (this.Education == null) {
			if (other.Education != null) {
				return false;
			}
		} else if (!this.Education.equals(other.Education)) {
			return false;
		}
		if (this.Grade == null) {
			if (other.Grade != null) {
				return false;
			}
		} else if (!this.Grade.equals(other.Grade)) {
			return false;
		}
		if (this.HeadUrl == null) {
			if (other.HeadUrl != null) {
				return false;
			}
		} else if (!this.HeadUrl.equals(other.HeadUrl)) {
			return false;
		}
		if (this.HelpCode == null) {
			if (other.HelpCode != null) {
				return false;
			}
		} else if (!this.HelpCode.equals(other.HelpCode)) {
			return false;
		}
		if (this.ID == null) {
			if (other.ID != null) {
				return false;
			}
		} else if (!this.ID.equals(other.ID)) {
			return false;
		}
		if (this.Lasttime == null) {
			if (other.Lasttime != null) {
				return false;
			}
		} else if (!this.Lasttime.equals(other.Lasttime)) {
			return false;
		}
		if (this.NickName == null) {
			if (other.NickName != null) {
				return false;
			}
		} else if (!this.NickName.equals(other.NickName)) {
			return false;
		}
		if (this.Password == null) {
			if (other.Password != null) {
				return false;
			}
		} else if (!this.Password.equals(other.Password)) {
			return false;
		}
		if (this.Prestudent == null) {
			if (other.Prestudent != null) {
				return false;
			}
		} else if (!this.Prestudent.equals(other.Prestudent)) {
			return false;
		}
		if (this.Qqid == null) {
			if (other.Qqid != null) {
				return false;
			}
		} else if (!this.Qqid.equals(other.Qqid)) {
			return false;
		}
		if (this.RealName == null) {
			if (other.RealName != null) {
				return false;
			}
		} else if (!this.RealName.equals(other.RealName)) {
			return false;
		}
		if (this.Registertime == null) {
			if (other.Registertime != null) {
				return false;
			}
		} else if (!this.Registertime.equals(other.Registertime)) {
			return false;
		}
		if (this.Salt == null) {
			if (other.Salt != null) {
				return false;
			}
		} else if (!this.Salt.equals(other.Salt)) {
			return false;
		}
		if (this.School == null) {
			if (other.School != null) {
				return false;
			}
		} else if (!this.School.equals(other.School)) {
			return false;
		}
		if (this.Sex == null) {
			if (other.Sex != null) {
				return false;
			}
		} else if (!this.Sex.equals(other.Sex)) {
			return false;
		}
		if (this.Sign == null) {
			if (other.Sign != null) {
				return false;
			}
		} else if (!this.Sign.equals(other.Sign)) {
			return false;
		}
		if (this.Teacher == null) {
			if (other.Teacher != null) {
				return false;
			}
		} else if (!this.Teacher.equals(other.Teacher)) {
			return false;
		}
		if (this.Telephone == null) {
			if (other.Telephone != null) {
				return false;
			}
		} else if (!this.Telephone.equals(other.Telephone)) {
			return false;
		}
		return true;
	}
}
