package com.bo.bookstore.dao;

// default package
// Generated Mar 12, 2013 1:51:58 PM by Hibernate Tools 3.4.0.CR1

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
public class DoubanHeaderDao
{

  private Logger logger = Logger.getLogger(DoubanHeaderDao.class);

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

  public void persist(DoubanHeader transientInstance)
  {
    logger.debug("persisting DoubanHeader instance");
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

  public void attachDirty(DoubanHeader instance)
  {
    logger.debug("attaching dirty DoubanHeader instance");
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

  public void attachClean(DoubanHeader instance)
  {
    logger.debug("attaching clean DoubanHeader instance");
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

  public void delete(DoubanHeader persistentInstance)
  {
    logger.debug("deleting DoubanHeader instance");
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

  public DoubanHeader merge(DoubanHeader detachedInstance)
  {
    logger.debug("merging DoubanHeader instance");
    try
    {
      DoubanHeader result = (DoubanHeader) sessionFactory.getCurrentSession()
          .merge(detachedInstance);
      logger.debug("merge successful");
      return result;
    } catch (RuntimeException re)
    {
      logger.error("merge failed", re);
      throw re;
    }
  }

  public DoubanHeader findById(int id)
  {
    logger.debug("getting DoubanHeader instance with id: " + id);
    try
    {
      DoubanHeader instance = (DoubanHeader) sessionFactory.getCurrentSession()
          .get("DoubanHeader", id);
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

  public List<DoubanHeader> findByExample(DoubanHeader instance)
  {
    logger.debug("finding DoubanHeader instance by example");
    try
    {
      List<DoubanHeader> results = (List<DoubanHeader>) sessionFactory
          .getCurrentSession().createCriteria("DoubanHeader")
          .add(create(instance)).list();
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
