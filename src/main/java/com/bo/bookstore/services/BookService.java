package com.bo.bookstore.services;

import com.bo.bookstore.po.Book;

/**
 * Author: lebk.lei@gmail.com Date: 2013-3-14
 */
public interface BookService
{

  public boolean addBook(String doubanBookId);

  public Book getBookByName(String bookName);
}
