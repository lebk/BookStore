package com.bo.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.request.resource.PackageResourceReference;

import com.bo.bookstore.po.Book;
import com.bo.bookstore.services.BookInfoService;
import com.bo.bookstore.services.BookService;
import com.bo.bookstore.services.impl.BookInfoServiceImpl;
import com.bo.bookstore.services.impl.BookServiceImpl;

/**
 * Author: lebk.lei@gmail.com Date: 2013-3-20
 */
public class BookSummaryPage extends BookStoreBasePage implements
    java.io.Serializable
{

  private static final long serialVersionUID = 7179769981914513602L;
  BookService bs = new BookServiceImpl();
  BookInfoService bis = new BookInfoServiceImpl();
  private static Logger logger = Logger.getLogger(BookSummaryPage.class);

  public BookSummaryPage()
  {

    List<Book> list = new ArrayList<Book>();

    list = bs.getAllBooks();
    logger.info("begin to show the book information!");
    final DataView dataView = new DataView("book", new ListDataProvider(list))
      {
        @Override
        public void populateItem(final Item item)
        {
          final Book b = (Book) item.getModelObject();
          item.add(new Image("image1", new PackageResourceReference(
              BookSummaryPage.class, "s4133396.jpg")));
          item.add(new Image("image2", new PackageResourceReference(
              BookSummaryPage.class, "s4133396.jpg")));
          item.add(new Image("image3", new PackageResourceReference(
              BookSummaryPage.class, "s4133396.jpg")));
          item.add(new Image("image4", new PackageResourceReference(
              BookSummaryPage.class, "s4133396.jpg")));
          item.add(new Image("image5", new PackageResourceReference(
              BookSummaryPage.class, "s4133396.jpg")));
        
        }
      };

    dataView.setItemsPerPage(10);

    add(dataView);
    add(new PagingNavigator("navigator", dataView));
    add(new BookmarkablePageLink<Void>("fileUploadLink", FileUploadPage.class));
  }

}
