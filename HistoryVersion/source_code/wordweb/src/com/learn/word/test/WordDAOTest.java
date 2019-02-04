package com.learn.word.test;

import java.util.List;

import org.junit.Test;

import com.learn.word.dao.WordDAO;
import com.learn.word.dao.impl.WordDAOImpl;
import com.learn.word.domain.Word;
import com.learn.word.web.CriteriaWord;
import com.learn.word.web.Page;

public class WordDAOTest {
	
	private WordDAO wordDAO = new WordDAOImpl();

	@Test
	public void testGetWord() {
		
		Word word = wordDAO.getWord(11224);
		System.out.println(word);
	}

	@Test
	public void testGetPage() {
		CriteriaWord cw = new CriteriaWord();
		System.out.println(cw.getPageNo() + "cw.pageno");
		Page<Word> page = wordDAO.getPage(cw);
		
		System.out.println();
		System.out.println("pageNo: " + page.getPageNo());
		System.out.println("totalPageNumber: " + page.getTotalPageNumber());
		System.out.println("list: " + page.getList());
		System.out.println("prevPage: " + page.getPrevPage());
		System.out.println("nextPage: " + page.getNextPage()); 
	}

	@Test
	public void testGetTotalWordNumber() {
		try {
			CriteriaWord cw = new CriteriaWord();
			int count = wordDAO.getTotalWordNumber(cw);
			System.out.println(count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}

	@Test
	public void testGetPageList() {
		try {
			CriteriaWord cw = new CriteriaWord();
			
			List<Word> words = wordDAO.getPageList(cw, 9);
			
			//System.out.println(words);
			
			for(Word word:words){
				System.out.println(word);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
