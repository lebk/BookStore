package com.bo.bookstore.po;


import java.util.HashSet;
import java.util.Set;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:06:09
 */
public class DoubanHeader implements java.io.Serializable
{

  private int id;
  private String url;
  private Set<BookInfo> bookInfos = new HashSet<BookInfo>(0);

  public DoubanHeader()
  {
  }

  public DoubanHeader(int id)
  {
    this.id = id;
  }

  public DoubanHeader(int id, String url, Set<BookInfo> bookInfos)
  {
    this.id = id;
    this.url = url;
    this.bookInfos = bookInfos;
  }

  public int getId()
  {
    return this.id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getUrl()
  {
    return this.url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  public Set<BookInfo> getBookInfos()
  {
    return this.bookInfos;
  }

  public void setBookInfos(Set<BookInfo> bookInfos)
  {
    this.bookInfos = bookInfos;
  }

}
