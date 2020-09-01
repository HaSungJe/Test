package com.myweb.domain;

import java.sql.Timestamp;

public class BoardListVo {
	/*
	 * tbl_boardlist
	 * seq         : 게시판 생성번호
	 * name        : 게시판 이름
	 * creater_id  : 게시판 생성자 ID(관리자) 
	 * creater_seq : 게시판 생성자 번호(관리자)
	 * viewgrade   : 게시판 접근권한 제한
	 * rdate	   : 게시판 생성일
	 * udate       : 게시판 수정일
	 * use         : 게시판 사용여부
	 * code        : 게시판 코드(게시판 접근시 필요)
	 * lv          : 정렬순서
	 */
	int seq;
	String name;
	String creater_id;
	int creater_seq;
	String viewgrade;
	Timestamp rdate;
	Timestamp udate;
	String use;
	String code;
	int lv;
	
	public BoardListVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreater_id() {
		return creater_id;
	}

	public void setCreater_id(String creater_id) {
		this.creater_id = creater_id;
	}

	public int getCreater_seq() {
		return creater_seq;
	}

	public void setCreater_seq(int creater_seq) {
		this.creater_seq = creater_seq;
	}

	public String getViewgrade() {
		return viewgrade;
	}

	public void setViewgrade(String viewgrade) {
		this.viewgrade = viewgrade;
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

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public BoardListVo(int seq, String name, String creater_id, int creater_seq, String viewgrade, Timestamp rdate,
			Timestamp udate, String use, String code, int lv) {
		super();
		this.seq = seq;
		this.name = name;
		this.creater_id = creater_id;
		this.creater_seq = creater_seq;
		this.viewgrade = viewgrade;
		this.rdate = rdate;
		this.udate = udate;
		this.use = use;
		this.code = code;
		this.lv = lv;
	}

	@Override
	public String toString() {
		return "Boardlist [seq=" + seq + ", name=" + name + ", creater_id=" + creater_id + ", creater_seq="
				+ creater_seq + ", viewgrade=" + viewgrade + ", rdate=" + rdate + ", udate=" + udate + ", use=" + use
				+ ", code=" + code + ", lv=" + lv + "]";
	}

	
}
