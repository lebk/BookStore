package com.bo.bookstore.services.impl;

import org.apache.log4j.Logger;

import com.bo.bookstore.dao.BookDao;
import com.bo.bookstore.dao.BookInfoDao;
import com.bo.bookstore.dao.impl.BookDaoImpl;
import com.bo.bookstore.dao.impl.BookInfoDaoImpl;
import com.bo.bookstore.po.BookInfo;
import com.bo.bookstore.services.BookInfoService;

/**
 * Author: lebk.lei@gmail.com Date: 2013-3-21
 */
public class BookInfoServiceImpl implements BookInfoService
{
  private static Logger logger = Logger.getLogger(BookInfoServiceImpl.class);
  BookInfoDao bid = new BookInfoDaoImpl();

  @Override
  public BookInfo getBookInfobyId(Integer id)
  {
    return bid.getBookInfoById(id);
  }

}
