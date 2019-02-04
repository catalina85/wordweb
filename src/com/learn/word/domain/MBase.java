package com.learn.word.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MBase {
	private Map<Integer ,MBaseItem>  words = new HashMap<>();
	
	public void removeItem(Integer gId){
		words.remove(gId);
	}
	
	public void clear(){
		words.clear();
	}
	
	public boolean isEmpty(){
		return words.isEmpty();
	}
	
	public Collection<MBaseItem> getItems(){
		return words.values();
	}
	
	public int getWordNumber(){
		int total = 0;
		
		for(MBaseItem mbi : words.values()){
			total += mbi.getQuantity();
		}
		
		return total;
	}
	
	public Map<Integer ,MBaseItem>  getWords(){
		return words;
	}
	
	public boolean hasWord(Integer gId){
		return words.containsKey(gId);
	}
	
	public void addWord(Word word){
		MBaseItem mbi = words.get(word.getgId());
		
		if(mbi==null){
			mbi = new MBaseItem(word);
			words.put(word.getgId(), mbi);
		}else {
			return;
		}
		
	}
}

