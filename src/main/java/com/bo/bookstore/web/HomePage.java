package com.bo.bookstore.web;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.WebPage;

import com.bo.bookstore.services.BookService;
import com.bo.bookstore.services.impl.BookServiceImpl;

public class HomePage extends WebPage
{
  private static final long serialVersionUID = 1L;
  private BookService bs = new BookServiceImpl();

  public HomePage(final PageParameters parameters)
  {
    super(parameters);
    String bookName = "浮士德";
    add(new Label("title", bookName));
    add(new Label("summary", getSummary(bookName)));
    // TODO Add your page's components here
    add(new BookmarkablePageLink<Void>("fileUploadLink", FileUploadPage.class));
  }

  private String getSummary(String bookName)
  {
    return bs.getBookByName(bookName).getBookInfo().getDescription();
  }
}
