package com.learn.word.domain;

public class MBaseItem {
	
	private Word word;
	private int quantity;



	public MBaseItem(Word word) {
		this.word = word;
		this.quantity = 1;
	}

	public Word getWord() {
		return word;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
	
}
