package com.bo.bookstore.web;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Author: lebk.lei@gmail.com Date: 2013-3-22
 */
public class BookStoreHeader extends Panel
{
  /**
   * 
   */
  private static final long serialVersionUID = -1788642451893597367L;
  private static final String storeTitle = "我的书屋";

  /**
   * Construct.
   * 
   * @param id
   *          id of the component
   * @param exampleTitle
   *          title of the example
   */
  public BookStoreHeader(String id)
  {
    super(id);

    add(new Label("title", storeTitle));

  }
}
