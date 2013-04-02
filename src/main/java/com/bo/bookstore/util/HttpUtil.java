package com.bo.bookstore.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

/**
 * Author: lebk.lei@gmail.com Date: 2013-4-2
 */
public class HttpUtil
{
  private static Logger logger = Logger.getLogger(HttpUtil.class);

  public static void main(String[] args)
  {
    String url = "http://img3.douban.com/spic/s4133396.jpg";
    downloadFileFrom(url);
  }

  public static boolean downloadFileFrom(String url)
  {
    try
    {
      long startTime = System.currentTimeMillis();
      logger.info("Connecting to the site...\n");
      URL _url = new URL(url);
      _url.openConnection();
      InputStream reader = _url.openStream();
      FileOutputStream writer = new FileOutputStream("C:/MyBooks/s4133396.jpg");
      byte[] buffer = new byte[153600];
      int totalBytesRead = 0;
      int bytesRead = 0;
      while ((bytesRead = reader.read(buffer)) > 0)
      {
        writer.write(buffer, 0, bytesRead);
        buffer = new byte[10000];
        totalBytesRead += bytesRead;
      }

      long endTime = System.currentTimeMillis();

      logger.info("Done. " + (new Integer(totalBytesRead).toString())
          + " bytes read (" + (new Long(endTime - startTime).toString())
          + " millseconds).\n");
      writer.close();
      reader.close();
    } catch (IOException e)

    {
      logger.error("Fail to download the file:" + e.getMessage());
      return false;
    }
    return true;
  }
}
