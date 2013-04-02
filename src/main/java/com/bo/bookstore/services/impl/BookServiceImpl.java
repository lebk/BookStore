package com.bo.bookstore.services.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.bo.bookstore.dao.BookDao;
import com.bo.bookstore.dao.BookInfoDao;
import com.bo.bookstore.dao.impl.BookDaoImpl;
import com.bo.bookstore.dao.impl.BookInfoDaoImpl;
import com.bo.bookstore.douban.DoubanClient;
import com.bo.bookstore.po.Book;
import com.bo.bookstore.po.BookInfo;
import com.bo.bookstore.services.BookService;
import com.bo.bookstore.util.HttpUtil;
import com.google.gdata.data.Link;
import com.google.gdata.data.douban.SubjectEntry;

/**
 * Author: lebk.lei@gmail.com Date: 2013-3-14
 */
public class BookServiceImpl implements BookService, java.io.Serializable
{
  private static Logger logger = Logger.getLogger(BookServiceImpl.class);
  BookDao bd = new BookDaoImpl();
  BookInfoDao bid = new BookInfoDaoImpl();

  public boolean addBook(String doubanReferId)
  {

    SubjectEntry se = DoubanClient.getSubjectEntry(doubanReferId);

    String author = se.getAuthors().get(0).getName();
    Float rateAverage = Float.valueOf(se.getRating().getAverage());
    String description = se.getSummary().getPlainText();
    String comment = "";

    if (se.getSummary() != null)
    {
      logger.info("summary is: " + description);
    }
    logger.info("author is: " + author);
    String bookName = se.getTitle().getPlainText();
    logger.info("title is " + bookName);
    logger.info("douban id is " + se.getId());
    logger.info("averge rating is:" + rateAverage);
    String coverPicUrl = "";
    for (Link link : se.getLinks())
    {
      logger.info("  " + link.getRel() + " is " + link.getHref());
      if (link.getRel().equals("image"))
      {
        coverPicUrl = link.getHref();
      }
    }
    String localPicUrl = "";
    if (!coverPicUrl.equals(""))
    {
      localPicUrl = HttpUtil.downloadFileFrom(coverPicUrl);
    }
    BookInfo bi = bid.addBookInfo(doubanReferId, author, rateAverage,
        description, comment, coverPicUrl, localPicUrl);

    if (bi == null)
    {
      logger.error("fail to add the book info:" + BookInfo.class.getName());
      return false;
    }

    BookInfo bki = new BookInfo();
    bki.setAuthor(author);
    bki.setDescription(description);
    bki.setRateAverage(rateAverage);
    bki.setDoubanReferId(doubanReferId);
    boolean ret = bd.addBook(bookName, bi);
    if (ret == false)
    {
      logger.error("fail to add the book into:" + Book.class.getName()
          + ",remove the item in:" + BookInfo.class.getName());
      bid.deleteBookInfo(doubanReferId);
      return false;
    }
    return true;

  }

  @Override
  public Book getBookByName(String bookName)
  {
    return bd.getBookByName(bookName);
  }

  @Override
  public List<Book> getAllBooks()
  {
    // TODO Auto-generated method stub
    return bd.getAllBooks();
  }
}
