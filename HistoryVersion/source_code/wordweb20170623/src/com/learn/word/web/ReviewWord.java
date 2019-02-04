package com.learn.word.web;

import java.sql.Date;
import java.sql.Timestamp;


public class ReviewWord {
	
	private Timestamp mDate;
	private Timestamp mDateEnd;
	private int pageNo;
	
	public Timestamp getmDate() {
		return mDate;
	}
	public void setmDate(Timestamp mDate) {
		this.mDate = mDate;
	}
	public Timestamp getmDateEnd() {
		return mDateEnd;
	}
	public void setmDateEnd(Timestamp mDateEnd) {
		this.mDateEnd = mDateEnd;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public ReviewWord() {
		super();
	}
	public ReviewWord(Timestamp mDate, Timestamp mDateEnd, int pageNo) {
		super();
		this.mDate = mDate;
		this.mDateEnd = mDateEnd;
		this.pageNo = pageNo;
	}
	
}
