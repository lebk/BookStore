package com.bo.bookstore.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.bo.bookstore.dao.BookDao;
import com.bo.bookstore.po.Book;
import com.bo.bookstore.po.BookInfo;
import com.bo.bookstore.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:47:03
 */
public class BookDaoImpl implements BookDao, java.io.Serializable
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
      bk.setId(12);
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

  @Override
  public boolean addBook(String bookName, Integer book_info_id)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();

    Transaction transaction = null;

    try
    {

      transaction = session.beginTransaction();
      Book bk = new Book();
      bk.setId(12);

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

  @Override
  public boolean addBook(String bookName, BookInfo bookInfo)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();

    Transaction transaction = null;

    try
    {

      transaction = session.beginTransaction();
      Book bk = new Book();
      bk.setId(12);
      bk.setBookInfo(bookInfo);
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

  @Override
  public Book getBookByName(String bookName)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();

    Transaction transaction = null;

    try
    {
      transaction = session.beginTransaction();
      List ol = session.createQuery(
          "from " + Book.class.getName() + " where name='" + bookName + "'")
          .list();
      if (ol.size() == 0)
      {
        logger.error("No " + Book.class.getName() + " found by the name: "
            + bookName);
        return null;
      }

      for (Iterator it = ol.iterator(); it.hasNext();)
      {
        Book o = (Book) it.next();
        // calling the book size method in order to the BookInfo object is
        // loaded.
        logger.info("the book size is:" + o.getBookInfo().getBooks().size());
        return o;
      }
      transaction.commit();
    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return null;
  }

  @Override
  public List<Book> getAllBooks()
  {
    List<Book> lb = new ArrayList<Book>();
    Session session = HibernateUtil.getSessionFactory().openSession();

    Transaction transaction = null;

    try
    {
      transaction = session.beginTransaction();
      List ol = session.createQuery("from " + Book.class.getName()).list();
      if (ol.size() == 0)
      {
        logger.error("No Book found in the db");
        return lb;
      }

      for (Iterator it = ol.iterator(); it.hasNext();)
      {
        Book o = (Book) it.next();
        // calling the book size method in order to the BookInfo object is
        // loaded.
        // logger.info("the book size is:" + o.getBookInfo().getBooks().size());
        lb.add(o);
      }
      transaction.commit();
    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return lb;
  }
}
