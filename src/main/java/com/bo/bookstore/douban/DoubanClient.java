package com.bo.bookstore.douban;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.bo.bookstore.util.DoubanUtil;
import com.google.gdata.client.douban.DoubanService;
import com.google.gdata.data.douban.Attribute;
import com.google.gdata.data.douban.SubjectEntry;
import com.google.gdata.data.extensions.Rating;
import com.google.gdata.util.ServiceException;


/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:06:09
 */

public class DoubanClient {
	private static Logger logger = Logger.getLogger(DoubanClient.class);

	public static SubjectEntry getSubjectEntry(String bookId) {
		DoubanService ds = DoubanUtil.getDoubanService();
		SubjectEntry subjectEntry = null;
		try {
			subjectEntry = ds.getBook(bookId);
			logger.info(subjectEntry.getXmlBlob().toString());
			printSubjectEntry(subjectEntry);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjectEntry;
	}

	private static void printSubjectEntry(SubjectEntry subjectEntry) {

		if (subjectEntry.getSummary() != null)
			System.out.println("summary is "
					+ subjectEntry.getSummary().getPlainText());
		logger.info("author is " + subjectEntry.getAuthors().get(0).getName());
		logger.info("title is " + subjectEntry.getTitle().getPlainText());

		for (Attribute attr : subjectEntry.getAttributes()) {
			logger.info(attr.getName() + " : " + attr.getContent());
		}
		logger.info("id is " + subjectEntry.getId());
		// for (Tag tag : subjectEntry.getTags()) {
		// logger.info(tag.getName() + " : " + tag.getCount());
		// }

		Rating rating = subjectEntry.getRating();
		if (rating != null)
			logger.info("max is " + rating.getMax() + " min is "
					+ rating.getMin() + " numRaters is "
					+ rating.getNumRaters() + " average is "
					+ rating.getAverage());

		logger.info("-------------------");

	}

}
