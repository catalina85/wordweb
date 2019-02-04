package com.learn.word.web;

public class CriteriaWord {

	private String nameFeatureOne;
	private String nameFeatureTwo;
	private String nameFeatureThree;
	private String meaningFeatureOne;
	private String meaningFeatureTwo;
	private String meaningFeatureThree;

	private int pageNo;

	public String getNameFeatureOne() {
		return nameFeatureOne;
	}

	public void setNameFeatureOne(String nameFeatureOne) {
		this.nameFeatureOne = nameFeatureOne;
	}

	public String getNameFeatureTwo() {
		return nameFeatureTwo;
	}

	public void setNameFeatureTwo(String nameFeatureTwo) {
		this.nameFeatureTwo = nameFeatureTwo;
	}

	public String getNameFeatureThree() {
		return nameFeatureThree;
	}

	public void setNameFeatureThree(String nameFeatureThree) {
		this.nameFeatureThree = nameFeatureThree;
	}

	public String getMeaningFeatureOne() {
		return meaningFeatureOne;
	}

	public void setMeaningFeatureOne(String meaningFeatureOne) {
		this.meaningFeatureOne = meaningFeatureOne;
	}

	public String getMeaningFeatureTwo() {
		return meaningFeatureTwo;
	}

	public void setMeaningFeatureTwo(String meaningFeatureTwo) {
		this.meaningFeatureTwo = meaningFeatureTwo;
	}

	public String getMeaningFeatureThree() {
		return meaningFeatureThree;
	}

	public void setMeaningFeatureThree(String meaningFeatureThree) {
		this.meaningFeatureThree = meaningFeatureThree;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public CriteriaWord() {
		super();
	}

	public CriteriaWord(String nameFeatureOne, String nameFeatureTwo, String nameFeatureThree, String meaningFeatureOne,
			String meaningFeatureTwo, String meaningFeatureThree, int pageNo) {
		super();
		this.nameFeatureOne = nameFeatureOne;
		this.nameFeatureTwo = nameFeatureTwo;
		this.nameFeatureThree = nameFeatureThree;
		this.meaningFeatureOne = meaningFeatureOne;
		this.meaningFeatureTwo = meaningFeatureTwo;
		this.meaningFeatureThree = meaningFeatureThree;
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "CriteriaWord [nameFeatureOne=" + nameFeatureOne + ", nameFeatureTwo=" + nameFeatureTwo
				+ ", nameFeatureThree=" + nameFeatureThree + ", meaningFeatureOne=" + meaningFeatureOne
				+ ", meaningFeatureTwo=" + meaningFeatureTwo + ", meaningFeatureThree=" + meaningFeatureThree
				+ ", pageNo=" + pageNo + "]";
	}

	
}
