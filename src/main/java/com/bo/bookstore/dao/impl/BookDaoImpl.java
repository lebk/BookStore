package com.bo.bookstore.dao.impl;

import java.util.Date;

import org.apache.log4j.Logger;

import com.bo.bookstore.dao.BookDao;
import com.bo.bookstore.po.Book;
import com.bo.bookstore.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:47:03
 */
public class BookDaoImpl implements BookDao
{
  static Logger logger = Logger.getLogger(BookDaoImpl.class);

  public boolean addBook(String bookName)
  {

    Session session = HibernateUtil.getSessionFactory().openSession();

    Transaction transaction = null;

    try
    {

      transaction = session.beginTransaction();
      Book bk = new Book();
      bk.setName(bookName);
      bk.setAddTime(new Date());
      session.save(bk);
      transaction.commit();
      return true;

    } catch (HibernateException e)
    {

      transaction.rollback();
      logger.error(e.toString());
      e.printStackTrace();

    } finally
    {

      session.close();

    }
    logger.error("Add book failed");
    return false;
  }

}
