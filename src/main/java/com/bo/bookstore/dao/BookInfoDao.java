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

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:06:09
 */
public class BookInfoDao
{

  private Logger logger = Logger.getLogger(BookInfoDao.class);

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

  public void persist(BookInfo transientInstance)
  {
    logger.debug("persisting BookInfo instance");
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

  public void attachDirty(BookInfo instance)
  {
    logger.debug("attaching dirty BookInfo instance");
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

  public void attachClean(BookInfo instance)
  {
    logger.debug("attaching clean BookInfo instance");
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

  public void delete(BookInfo persistentInstance)
  {
    logger.debug("deleting BookInfo instance");
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

  public BookInfo merge(BookInfo detachedInstance)
  {
    logger.debug("merging BookInfo instance");
    try
    {
      BookInfo result = (BookInfo) sessionFactory.getCurrentSession().merge(
          detachedInstance);
      logger.debug("merge successful");
      return result;
    } catch (RuntimeException re)
    {
      logger.error("merge failed", re);
      throw re;
    }
  }

  public BookInfo findById(int id)
  {
    logger.debug("getting BookInfo instance with id: " + id);
    try
    {
      BookInfo instance = (BookInfo) sessionFactory.getCurrentSession().get(
          "BookInfo", id);
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

  public List<BookInfo> findByExample(BookInfo instance)
  {
    logger.debug("finding BookInfo instance by example");
    try
    {
      List<BookInfo> results = (List<BookInfo>) sessionFactory
          .getCurrentSession().createCriteria("BookInfo").add(create(instance))
          .list();
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
