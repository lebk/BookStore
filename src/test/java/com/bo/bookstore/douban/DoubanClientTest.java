package com.bo.bookstore.douban;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Author: lebk.lei@gmail.com Date: 2013-3-14
 */
public class DoubanClientTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSubjectEntry() {
		String bookId = "2029680";
		DoubanClient.getSubjectEntry(bookId);
	}

}
