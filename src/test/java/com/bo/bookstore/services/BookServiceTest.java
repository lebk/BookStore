package com.bo.bookstore.services;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bo.bookstore.po.Book;
import com.bo.bookstore.services.impl.BookServiceImpl;

/**
 * Author: lebk.lei@gmail.com Date: 2013-3-14
 */
public class BookServiceTest
{
  BookService bs;
  static Logger logger = Logger.getLogger(BookServiceTest.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {
  }

  @Before
  public void setUp() throws Exception
  {
    bs = new BookServiceImpl();
  }

  @After
  public void tearDown() throws Exception
  {
    bs = null;
  }

  @Test
  public void testAddBook()
  {
    String bookId = "2029680";
    boolean ret = bs.addBook(bookId);
    Assert.assertTrue("should return true when add a book", ret);
  }

  @Test
  public void testGetBookByName()
  {
    String bookName = "资治通鉴";
    Book b = bs.getBookByName(bookName);
    logger.info(b.getId());
    logger.info(b.getAddTime());
    logger.info(b.getName());

    logger.info(b.getBookInfo().getDescription());
  }
}
