package com.bo.bookstore.douban;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.bo.bookstore.util.DoubanUtil;
import com.google.gdata.client.douban.DoubanService;
import com.google.gdata.data.Link;
import com.google.gdata.data.douban.Attribute;
import com.google.gdata.data.douban.SubjectEntry;
import com.google.gdata.data.extensions.Rating;
import com.google.gdata.util.ServiceException;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:06:09
 */

public class DoubanClient
{
  private static Logger logger = Logger.getLogger(DoubanClient.class);

  public static SubjectEntry getSubjectEntry(String bookId)
  {
    DoubanService ds = DoubanUtil.getDoubanService();
    SubjectEntry subjectEntry = null;
    try
    {
      subjectEntry = ds.getBook(bookId);
      logger.info(subjectEntry.getXmlBlob().toString());
      printSubjectEntry(subjectEntry);

    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ServiceException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return subjectEntry;
  }

  private static void printSubjectEntry(SubjectEntry se)
  {

    if (se.getSummary() != null)
      System.out.println("summary is " + se.getSummary().getPlainText());
    logger.info("author is " + se.getAuthors().get(0).getName());
    logger.info("title is " + se.getTitle().getPlainText());

    for (Attribute attr : se.getAttributes())
    {
      logger.info(attr.getName() + " : " + attr.getContent());
    }
    logger.info("id is " + se.getId());
    // for (Tag tag : subjectEntry.getTags()) {
    // logger.info(tag.getName() + " : " + tag.getCount());
    // }
    Rating rating = se.getRating();
    if (rating != null)
      logger.info("max is " + rating.getMax() + " min is " + rating.getMin()
          + " numRaters is " + rating.getNumRaters() + " average is "
          + rating.getAverage());
    for (Link link : se.getLinks())
    {
      logger.info("  " + link.getRel() + " is " + link.getHref());
    }
    logger.info("-------------------");

  }

}
