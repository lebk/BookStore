package com.bo.bookstore.services.impl;

import org.apache.log4j.Logger;

import com.bo.bookstore.dao.BookDao;
import com.bo.bookstore.dao.impl.BookDaoImpl;
import com.bo.bookstore.douban.DoubanClient;
import com.bo.bookstore.services.BookService;
import com.google.gdata.data.douban.SubjectEntry;

/**
 * Author: lebk.lei@gmail.com Date: 2013-3-14
 */
public class BookServiceImpl implements BookService {
	private static Logger logger = Logger.getLogger(BookServiceImpl.class);
	BookDao bd = new BookDaoImpl();

	@Override
	public boolean addBook(String doubanBookId) {

		SubjectEntry se = DoubanClient.getSubjectEntry(doubanBookId);
		if (se.getSummary() != null) {
			logger.info("summary is " + se.getSummary().getPlainText());
		}
		logger.info("author is " + se.getAuthors().get(0).getName());
		String bookName = se.getTitle().getPlainText();
		logger.info("title is " + bookName);

		bd.addBook(bookName);
		return true;

	}
}
