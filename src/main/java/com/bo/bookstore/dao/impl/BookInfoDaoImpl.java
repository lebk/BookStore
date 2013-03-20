package com.bo.bookstore.dao.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bo.bookstore.dao.BookInfoDao;
import com.bo.bookstore.po.Book;
import com.bo.bookstore.po.BookInfo;
import com.bo.bookstore.util.HibernateUtil;

public class BookInfoDaoImpl implements BookInfoDao, java.io.Serializable
{
  static Logger logger = Logger.getLogger(BookDaoImpl.class);

  public boolean addBookInfo()
  {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public BookInfo addBookInfo(String doubanReferId, String author,
      Float rateAverage, String description, String comments)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();

    Transaction transaction = null;

    try
    {

      transaction = session.beginTransaction();
      BookInfo bki = new BookInfo();
      bki.setAuthor(author);
      bki.setDoubanReferId(doubanReferId);
      bki.setRateAverage(rateAverage);
      bki.setDescription(description);

      session.save(bki);
      transaction.commit();
      return bki;

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
    return null;
  }

  @Override
  public boolean deleteBookInfo(String doubanReferId)
  {
    // TODO Auto-generated method stub
    return true;
  }

}
