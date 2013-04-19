package com.bo.bookstore.web.pages;

import com.bo.bookstore.web.BookStoreBasePage;
import com.bo.bookstore.web.panel.BookDetailPanel;

/**
 * Author: lebk.lei@gmail.com Date: 2013-4-12
 */
public class BookDetailPage extends BookStoreBasePage
{

  /**
   * 
   */
  private static final long serialVersionUID = 7026166363455720745L;

  public BookDetailPage()
  {
    super();
    this.add(new BookDetailPanel("contentPanel"));
  }
}
