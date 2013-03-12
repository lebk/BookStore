package com.bo.bookstore.po;

// default package
// Generated Mar 12, 2013 1:51:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:06:09
 */
public class BookInfo implements java.io.Serializable
{

  private int id;
  private DoubanHeader doubanHeader;
  private Integer doubanReferId;
  private String author;
  private String description;
  private String comments;
  private Set<Book> books = new HashSet<Book>(0);

  public BookInfo()
  {
  }

  public BookInfo(int id)
  {
    this.id = id;
  }

  public BookInfo(int id, DoubanHeader doubanHeader, Integer doubanReferId,
      String author, String description, String comments, Set<Book> books)
  {
    this.id = id;
    this.doubanHeader = doubanHeader;
    this.doubanReferId = doubanReferId;
    this.author = author;
    this.description = description;
    this.comments = comments;
    this.books = books;
  }

  public int getId()
  {
    return this.id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public DoubanHeader getDoubanHeader()
  {
    return this.doubanHeader;
  }

  public void setDoubanHeader(DoubanHeader doubanHeader)
  {
    this.doubanHeader = doubanHeader;
  }

  public Integer getDoubanReferId()
  {
    return this.doubanReferId;
  }

  public void setDoubanReferId(Integer doubanReferId)
  {
    this.doubanReferId = doubanReferId;
  }

  public String getAuthor()
  {
    return this.author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public String getDescription()
  {
    return this.description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getComments()
  {
    return this.comments;
  }

  public void setComments(String comments)
  {
    this.comments = comments;
  }

  public Set<Book> getBooks()
  {
    return this.books;
  }

  public void setBooks(Set<Book> books)
  {
    this.books = books;
  }

}
