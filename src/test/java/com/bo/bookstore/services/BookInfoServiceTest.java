package com.bo.bookstore.services;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bo.bookstore.po.BookInfo;
import com.bo.bookstore.services.impl.BookInfoServiceImpl;

/**
 * Author: lebk.lei@gmail.com Date: 2013-3-21
 */
public class BookInfoServiceTest
{
  BookInfoService bis;
  static Logger logger = Logger.getLogger(BookInfoServiceTest.class);

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
    bis = new BookInfoServiceImpl();
  }

  @After
  public void tearDown() throws Exception
  {
    bis = null;
  }

  @Test
  public void testGetBookInfobyId()
  {
    BookInfo bi = bis.getBookInfobyId(5);
    Assert.assertTrue("Get the Information successfully", bi != null);
    logger.info("The Author: " + bi.getAuthor());
    logger.info("The rate_average: " + bi.getRateAverage());
    logger.info("The description: " + bi.getDescription());
    logger.info("The douban_refer_id: " + bi.getDoubanReferId());
  }

}
