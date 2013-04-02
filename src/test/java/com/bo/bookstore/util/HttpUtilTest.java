package com.bo.bookstore.util;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bo.bookstore.services.BookServiceTest;

/**
 * Author: lebk.lei@gmail.com Date: 2013-4-2
 */
public class HttpUtilTest
{
  static Logger logger = Logger.getLogger(BookServiceTest.class);

  String url = "http://img3.douban.com/spic/s4133396.jpg";

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
  }

  @After
  public void tearDown() throws Exception
  {
  }

  @Test
  public void testDownloadFileFrom()
  {
    String localPath = HttpUtil.downloadFileFrom(url);
    Assert.assertTrue("Should download the cover pic successfully", !localPath.equals(""));

  }

}
