package com.bo.bookstore.dao;

import com.bo.bookstore.po.BookInfo;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:06:09
 */
public interface BookInfoDao
{
  public BookInfo addBookInfo(String doubanReferId, String author,
      Float rateAverage, String description, String comments);

  public boolean deleteBookInfo(String doubanReferId);

  public BookInfo getBookInfoById(Integer id);

}
