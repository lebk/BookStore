package com.bo.bookstore.dao;


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;
import com.bo.bookstore.po.*;
import com.bo.bookstore.util.BookManager;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:06:09
 */
public class BookDao
{

  private Logger logger = Logger.getLogger(BookDao.class);

  private final SessionFactory sessionFactory = getSessionFactory();

  protected SessionFactory getSessionFactory()
  {
    try
    {
      return (SessionFactory) new InitialContext().lookup("SessionFactory");
    } catch (Exception e)
    {
      logger.error("Could not locate SessionFactory in JNDI", e);
      throw new IllegalStateException("Could not locate SessionFactory in JNDI");
    }
  }

  public void persist(Book transientInstance)
  {
    logger.debug("persisting Book instance");
    try
    {
      sessionFactory.getCurrentSession().persist(transientInstance);
      logger.debug("persist successful");
    } catch (RuntimeException re)
    {
      logger.error("persist failed", re);
      throw re;
    }
  }

  public void attachDirty(Book instance)
  {
    logger.debug("attaching dirty Book instance");
    try
    {
      sessionFactory.getCurrentSession().saveOrUpdate(instance);
      logger.debug("attach successful");
    } catch (RuntimeException re)
    {
      logger.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(Book instance)
  {
    logger.debug("attaching clean Book instance");
    try
    {
      sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
      logger.debug("attach successful");
    } catch (RuntimeException re)
    {
      logger.error("attach failed", re);
      throw re;
    }
  }

  public void delete(Book persistentInstance)
  {
    logger.debug("deleting Book instance");
    try
    {
      sessionFactory.getCurrentSession().delete(persistentInstance);
      logger.debug("delete successful");
    } catch (RuntimeException re)
    {
      logger.error("delete failed", re);
      throw re;
    }
  }

  public Book merge(Book detachedInstance)
  {
    logger.debug("merging Book instance");
    try
    {
      Book result = (Book) sessionFactory.getCurrentSession().merge(
          detachedInstance);
      logger.debug("merge successful");
      return result;
    } catch (RuntimeException re)
    {
      logger.error("merge failed", re);
      throw re;
    }
  }

  public Book findById(int id)
  {
    logger.debug("getting Book instance with id: " + id);
    try
    {
      Book instance = (Book) sessionFactory.getCurrentSession().get("Book", id);
      if (instance == null)
      {
        logger.debug("get successful, no instance found");
      } else
      {
        logger.debug("get successful, instance found");
      }
      return instance;
    } catch (RuntimeException re)
    {
      logger.error("get failed", re);
      throw re;
    }
  }

  public List<Book> findByExample(Book instance)
  {
    logger.debug("finding Book instance by example");
    try
    {
      List<Book> results = (List<Book>) sessionFactory.getCurrentSession()
          .createCriteria("Book").add(create(instance)).list();
      logger
          .debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re)
    {
      logger.error("find by example failed", re);
      throw re;
    }
  }
}
