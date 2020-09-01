package com.myweb.domain;

import java.sql.Timestamp;

public class UserVo {
	int seq;
	String id;
	String pw;
	String name;
	String birth;
	String gender;
	String phone;
	String use;
	String grade;
	Timestamp rdate;
	Timestamp udate;
	Timestamp lstlogintime;
	String lstloginip;
	String autologin;
	String rip;
	String subname;
	
	public UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserVo(int seq, String id, String pw, String name, String birth, String gender, String phone, String use,
			String grade, Timestamp rdate, Timestamp udate, Timestamp lstlogintime, String lstloginip, String autologin,
			String rip, String subname) {
		super();
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.use = use;
		this.grade = grade;
		this.rdate = rdate;
		this.udate = udate;
		this.lstlogintime = lstlogintime;
		this.lstloginip = lstloginip;
		this.autologin = autologin;
		this.rip = rip;
		this.subname = subname;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Timestamp getRdate() {
		return rdate;
	}

	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}

	public Timestamp getUdate() {
		return udate;
	}

	public void setUdate(Timestamp udate) {
		this.udate = udate;
	}

	public Timestamp getLstlogintime() {
		return lstlogintime;
	}

	public void setLstlogintime(Timestamp lstlogintime) {
		this.lstlogintime = lstlogintime;
	}

	public String getLstloginip() {
		return lstloginip;
	}

	public void setLstloginip(String lstloginip) {
		this.lstloginip = lstloginip;
	}

	public String getAutologin() {
		return autologin;
	}

	public void setAutologin(String autologin) {
		this.autologin = autologin;
	}

	public String getRip() {
		return rip;
	}

	public void setRip(String rip) {
		this.rip = rip;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	@Override
	public String toString() {
		return "UserVo [seq=" + seq + ", id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth + ", gender="
				+ gender + ", phone=" + phone + ", use=" + use + ", grade=" + grade + ", rdate=" + rdate + ", udate="
				+ udate + ", lstlogintime=" + lstlogintime + ", lstloginip=" + lstloginip + ", autologin=" + autologin
				+ ", rip=" + rip + ", subname=" + subname + "]";
	}
	
	
	
	
}
