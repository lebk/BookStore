package com.bo.bookstore.web.pages;

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
import com.bo.bookstore.web.BookStoreBasePage;
import com.bo.bookstore.web.FileUploadPage;
import com.bo.bookstore.web.panel.BookSummaryPanel;

/**
 * Author: lebk.lei@gmail.com Date: 2013-3-20
 */
public class HomePage extends BookStoreBasePage {

	private static final long serialVersionUID = 7179769981914513602L;
	BookService bs = new BookServiceImpl();
	BookInfoService bis = new BookInfoServiceImpl();
	private static Logger logger = Logger.getLogger(BookSummaryPanel.class);

	public HomePage() {

		super();
		this.add(new BookSummaryPanel("contentPanel"));
	}
}
