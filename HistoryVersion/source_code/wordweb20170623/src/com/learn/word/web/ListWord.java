package com.learn.word.web;

public class ListWord {
	
	private String listName;
	private int pageNo;
	
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
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
	public ListWord(String listName, int pageNo) {
		super();
		this.listName = listName;
		this.pageNo = pageNo;
	}
	
}
