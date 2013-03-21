package com.bo.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import com.bo.bookstore.po.Book;
import com.bo.bookstore.services.BookService;
import com.bo.bookstore.services.impl.BookServiceImpl;

/**
 * Author: lebk.lei@gmail.com Date: 2013-3-20
 */
public class BookSummaryPage extends WebPage implements java.io.Serializable
{

  private static final long serialVersionUID = 7179769981914513602L;
  BookService bs = new BookServiceImpl();

  public BookSummaryPage()
  {

    List<Book> list = new ArrayList<Book>();

    list = bs.getAllBooks();

    final DataView dataView = new DataView("simple", new ListDataProvider(list))
      {
        @Override
        public void populateItem(final Item item)
        {
          final Book b = (Book) item.getModelObject();
          item.add(new Label("id", b.getId()));
          item.add(new Label("name", b.getName()));
        }
      };

    dataView.setItemsPerPage(10);

    add(dataView);

    add(new PagingNavigator("navigator", dataView));
    add(new BookmarkablePageLink<Void>("fileUploadLink", FileUploadPage.class));
  }

}
