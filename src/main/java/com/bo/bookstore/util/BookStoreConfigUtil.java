package com.bo.bookstore.util;

/**
 * Author: lebk.lei@gmail.com
 * Date: 2013-4-2
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

public class BookStoreConfigUtil
{
  private static Properties properties = new Properties();
  static Logger logger = Logger.getLogger(BookStoreConfigUtil.class);

  static
  {
    logger
        .info("-------- Begin to init the bookstore config from BookStoreConfig.peroperites --------");
    init();
    logger
        .info("-------- End to init the bookstore config from BookStoreConfig.peroperites --------");
  }

  private static String getBookStoreConfigDir()
  {
    // String baseDir = System.getProperty("user.dir");
    //
    // logger.info("basedir: " + baseDir);
    // String bookstoreConfig = (baseDir +
    // "/src/main/resources/BookStoreConfig.properties")
    // .replaceAll("%20", " ");

    String path = BookStoreConfigUtil.class.getClass().getClassLoader()
        .getResource("").getPath();
    logger.info("The path is:" + path);
    return path;

  }

  public static void init()
  {
    String bookstoreconfig = null;
    FileInputStream is = null;

    try
    {

      bookstoreconfig = getBookStoreConfigDir();

      logger.info("bookstpre path: " + bookstoreconfig);

      is = new FileInputStream(bookstoreconfig);
      properties.load(is);
    } catch (IOException e)
    {
      logger.error(e.getMessage());
      e.printStackTrace();
    } catch (Exception e)
    {
      logger.error("Read bookstore file: " + bookstoreconfig + " error!");

      logger.error(e.getMessage());

    } finally
    {
      try
      {
        if (is != null)
        {
          is.close();
        }
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }

  public static String getBookBasePath()
  {
    return properties.getProperty("BookBasePath").trim();
  }

  public static void main(String[] args)
  {
    logger.info(getBookBasePath());

  }
}
