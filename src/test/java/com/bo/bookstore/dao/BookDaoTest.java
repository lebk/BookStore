package com.bo.bookstore.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.bo.bookstore.dao.*;
import com.bo.bookstore.dao.impl.BookDaoImpl;
import com.bo.bookstore.po.Book;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:40:35
 */
public class BookDaoTest
{

  BookDao bd;

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
    bd = new BookDaoImpl();

  }

  @After
  public void tearDown() throws Exception
  {
    bd = null;
  }

  @Test
  public void testAddBook()
  {

    bd.addBook("testBook");
  }

}
