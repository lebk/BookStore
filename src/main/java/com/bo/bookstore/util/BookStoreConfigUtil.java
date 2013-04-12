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
    
     String baseDir = System.getProperty("user.dir");
     String propertiesName = "BookStoreConfig.properties";
     logger.info("basedir: " + baseDir);
     // Temp fix about,Deploy the product env
     
     if (baseDir.equalsIgnoreCase("/"))
     {
       return "/opt/vmfactory/webapps/VMFactory/WEB-INF/classes/" + propertiesName;
     }
     
     String bookstoreConfig = (baseDir + "/src/main/resources/" + propertiesName).replaceAll("%20", " ");


     if (bookstoreConfig.contains("tomcat"))

     {
       logger.info("deploy to tomcat, redrirect to the property file's location");
       if (bookstoreConfig.contains("bin"))
       {
         // If deploy to Tomcat server (the tomcat starts from %TOMCAT_HOME%,
         // use following file path.

         bookstoreConfig = (baseDir + "\\..\\webapps\\bookstore-0.1\\WEB-INF\\classes\\" + propertiesName).replaceAll("%20", " ");
       } else
       {
         // The tomcat is started by Eclipse Tomcat plugin,%TOMCAT_HOME%
         bookstoreConfig = (baseDir + "\\webapps\\bookstore-0.1\\WEB-INF\\classes\\" + propertiesName).replaceAll("%20", " ");

       }
     }
       

    return bookstoreConfig;

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
