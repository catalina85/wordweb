package com.learn.word.domain;

import java.sql.Date;

public class Word {
	private Integer rowNum;
	private Integer gId;
	private Integer lId;
	private String name;
	private String pron;
	private String p;
	private String m;
	private Date mDate;
	private String lNa;
	private String meaning;
	private String bookName;
	private Integer mTime;
	
	public Word() {
		super();
	}

	public Word(Integer rowNum, Integer gId, Integer lId, String name, String pron, String p, String m, Date mDate,
			String lNa, String meaning, String bookName) {
		super();
		this.rowNum = rowNum;
		this.gId = gId;
		this.lId = lId;
		this.name = name;
		this.pron = pron;
		this.p = p;
		this.m = m;
		this.mDate = mDate;
		this.lNa = lNa;
		this.meaning = meaning;
		this.bookName = bookName;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

	public Integer getgId() {
		return gId;
	}

	public void setgId(Integer gId) {
		this.gId = gId;
	}

	public Integer getlId() {
		return lId;
	}

	public void setlId(Integer lId) {
		this.lId = lId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPron() {
		return pron;
	}

	public void setPron(String pron) {
		this.pron = pron;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public Date getmDate() {
		return mDate;
	}

	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}

	public String getlNa() {
		return lNa;
	}

	public void setlNa(String lNa) {
		this.lNa = lNa;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public Integer getmTime() {
		return mTime;
	}

	public void setmTime(Integer mTime) {
		this.mTime = mTime;
	}

	@Override
	public String toString() {
		return "Word [rowNum=" + rowNum + ", gId=" + gId + ", lId=" + lId + ", name=" + name + ", pron=" + pron + ", p="
				+ p + ", m=" + m + ", mDate=" + mDate + ", lNa=" + lNa + ", meaning=" + meaning + ", bookName="
				+ bookName + ", mTime=" + mTime + "]";
	}
	
	
	
	
}
