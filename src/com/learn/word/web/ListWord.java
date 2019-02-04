package com.learn.word.web;

public class ListWord {
	
	private String listName;
	private String listNameEnd;
	private int pageNo;
	
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public String getListNameEnd() {
		return listNameEnd;
	}
	public void setListNameEnd(String listNameEnd) {
		this.listNameEnd = listNameEnd;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public ListWord() {
		super();
	}
	public ListWord(String listName, String listNameEnd, int pageNo) {
		super();
		this.listName = listName;
		this.listNameEnd = listNameEnd;
		this.pageNo = pageNo;
	}
	

}
