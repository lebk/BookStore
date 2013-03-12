package com.bo.bookstore.util;


import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Copyright: Copyright (c) 2012 Company: Symantec Inc.
 * 
 * @author Terry Lei(Terry_Lei@symantec.com)
 * @date Apr 11, 2012
 */

public class HibernateUtil
{

  private static final SessionFactory sessionFactory;
  private static Logger logger = Logger.getLogger(HibernateUtil.class);

  static
  {

    try
    {

      sessionFactory = new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex)
    {

      logger.error("Initial SessionFactory creation failed." + ex);

      throw new ExceptionInInitializerError(ex);

    }

  }

  public static SessionFactory getSessionFactory()
  {

    return sessionFactory;

  }

}