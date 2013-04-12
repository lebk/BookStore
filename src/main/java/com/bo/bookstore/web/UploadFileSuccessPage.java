package com.bo.bookstore.web;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.bo.bookstore.services.BookService;
import com.bo.bookstore.services.impl.BookServiceImpl;
import com.bo.bookstore.util.DoubanUtil;

/**
 * Author: lebk.lei@gmail.com Date: 2013-4-12
 */
public class UploadFileSuccessPage extends BookStoreBasePage
{
  private static Logger logger = Logger.getLogger(UploadFileSuccessPage.class);

  public UploadFileSuccessPage(final PageParameters parameters)
  {

    String referUrl = "";

    if (parameters.get("doubanAddr") != null)
    {
      referUrl = parameters.get("doubanAddr").toString();
    }

    final Label result = new Label("result", "douban refer url is : "
        + referUrl);
    addBook(referUrl);
    add(result);

  }

  private void addBook(String referUrl)
  {
   
  BookService bs = new BookServiceImpl();
    String doubanBookId=referUrl.substring(referUrl.lastIndexOf("/")+1);
    logger.info("The url is:" + referUrl);
    logger.info("The douban book id is:" + doubanBookId);
    bs.addBook(doubanBookId);
  }
}
