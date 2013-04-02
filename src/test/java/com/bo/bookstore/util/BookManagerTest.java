package com.bo.bookstore.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.bo.bookstore.demo.BookManager;

/**
 * Author: Terry_Lei Date: 2:17:16 PM
 */
public class BookManagerTest {
	BookManager bm;

	@Before
	public void setUp() throws Exception {
		String baseDir = "D:\\百度云\\书籍\\kindle 书籍";
		bm = new BookManager(baseDir);
	}

	@After
	public void tearDown() throws Exception {
		bm = null;
	}

	@Ignore
	@Test
	public void testShowAllBooksInfo() {
		// bm.showAllBooksInfo();
	}

}
