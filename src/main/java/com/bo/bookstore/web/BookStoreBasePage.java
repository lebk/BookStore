package com.bo.bookstore.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.Strings;

import com.bo.bookstore.web.footer.BookStoreFooterPanel;
import com.bo.bookstore.web.header.BookStoreHeaderPanel;

/**
 * Author: lebk.lei@gmail.com Date: 2013-3-22
 */
public class BookStoreBasePage extends WebPage
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor
   */
  public BookStoreBasePage()
  {
    this(new PageParameters());
  }

  /**
   * Constructor
   * 
   * @param pageParameters
   */
  public BookStoreBasePage(final PageParameters pageParameters)
  {
    super(pageParameters);

    final String packageName = getClass().getPackage().getName();
    add(new BookStoreHeaderPanel("headerPanel"));
    add(new BookStoreFooterPanel("footerPanel"));
    
    explain();
  }

  /**
   * Construct.
   * 
   * @param model
   */
  public BookStoreBasePage(IModel<?> model)
  {
    super(model);
  }

  /**
   * Override base method to provide an explanation
   */
  protected void explain()
  {
  }
}
