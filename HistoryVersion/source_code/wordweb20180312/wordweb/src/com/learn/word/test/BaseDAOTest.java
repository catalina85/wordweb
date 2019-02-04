package com.learn.word.test;

import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import com.learn.word.dao.impl.WordDAOImpl;
import com.learn.word.domain.Word;

public class BaseDAOTest {

	private WordDAOImpl wordDAOImpl = new WordDAOImpl();

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {

		String sql = "select  G_ID \"gId\",l_id \"lId\",NAME \"name\",PRON \"pron\",P \"p\",M \"m\",MDATE \"mDate\",L_NA \"lNa\",MEANING \"meaning\",BOOK_NAME \"bookName\"  from testword2 where g_id = ? ";
		System.out.println(sql);
		Word word = wordDAOImpl.query(sql, 11224);
		System.out.println(word);

	}

	@Test
	public void testQueryForList() {

		try {
			String sql = "select  G_ID \"gId\",L_ID \"lId\",NAME \"name\",PRON \"pron\",P \"p\",M \"m\",fir_date \"mDate\",L_NA \"lNa\",MEANING \"meaning\",BOOK_NAME \"bookName\"  from newrm where meaning like ?";
			System.out.println(sql);
			List<Word> words = wordDAOImpl.queryForList(sql, "%自满%");
			// System.out.println(words);
			for (Word word : words) {
				System.out.println(word);
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testGetSingelValue() {

		String sql = "select  count(name)  from testword2 ";
		System.out.println(sql);
		Object pron = wordDAOImpl.getSingelValue(sql);
		int i = Integer.parseInt(pron.toString());
		System.out.println(i);
		System.out.println("wan");
	}

	@Test
	public void testBatch() throws Exception {
		String sql = "UPDATE testword2 SET mDate =?, p =?, m =? WHERE g_id = ?";
		String sql1 = "UPDATE testword2 SET g_id = ? WHERE g_id = ?";
		Object[][] ob = new Object[17749][4];
		String  p = "*";
		String  m = "n";
		
		for (int i = 0; i < 17749; i++) {
			ob[i][0] = new Date(new java.util.Date().getTime());
			ob[i][1] = "n";
			ob[i][2] = "n";
			ob[i][3] = (int)(1+i);
			
		}
		wordDAOImpl.batch(sql, ob);

		System.out.println("finish");
	}
}
