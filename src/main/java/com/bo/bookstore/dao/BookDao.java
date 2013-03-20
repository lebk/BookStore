package com.bo.bookstore.dao;

import java.util.List;

import com.bo.bookstore.po.Book;
import com.bo.bookstore.po.BookInfo;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:06:09
 */
public interface BookDao
{

  public boolean addBook(String bookName);

  public boolean addBook(String bookName, Integer book_info_id);

  public boolean addBook(String bookName, BookInfo bookInfo);

  public Book getBookByName(String bookName);

  public List<Book> getAllBooks();
}
