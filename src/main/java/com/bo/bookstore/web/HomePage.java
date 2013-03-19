package com.bo.bookstore.web;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage
{
  private static final long serialVersionUID = 1L;

  public HomePage(final PageParameters parameters)
  {
    super(parameters);
    String bookName = "资治通鉴";
    add(new Label("title", bookName));
    add(new Label("summary", getSummary(bookName)));
    // TODO Add your page's components here

  }

  private String getSummary(String bookName)
  {
    return "Helle World Boy";
  }
}
