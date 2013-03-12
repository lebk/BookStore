package com.bo.bookstore.po;

// default package
// Generated Mar 12, 2013 1:51:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:06:09
 */
public class Book implements java.io.Serializable
{

  private int id;
  private BookInfo bookInfo;
  private String name;
  private Date addTime;
  private String location;

  public Book()
  {
  }

  public Book(int id)
  {
    this.id = id;
  }

  public Book(int id, BookInfo bookInfo, String name, Date addTime,
      String location)
  {
    this.id = id;
    this.bookInfo = bookInfo;
    this.name = name;
    this.addTime = addTime;
    this.location = location;
  }

  public int getId()
  {
    return this.id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public BookInfo getBookInfo()
  {
    return this.bookInfo;
  }

  public void setBookInfo(BookInfo bookInfo)
  {
    this.bookInfo = bookInfo;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Date getAddTime()
  {
    return this.addTime;
  }

  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }

  public String getLocation()
  {
    return this.location;
  }

  public void setLocation(String location)
  {
    this.location = location;
  }

}
