package com.bo.bookstore.douban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.dom4j.io.SAXReader;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:06:09
 */

public class DoubanClient {

	private static String urlHead = "http://api.douban.com/book/subjects?";
	private static Logger logger = Logger.getLogger(DoubanClient.class);

	public static void main(String[] args) {
		DoubanClient.queryBookbyNameOf("Just Spring");
	}

	private static String constructQueryURL(String bookName) {
		bookName = normalizeBookName(bookName);
		StringBuffer url = new StringBuffer();
		url.append(urlHead);
		url.append("start-index=1&max-results=20&");
		url.append("q=" + bookName);
		logger.info("Construct URL is:" + url);
		return url.toString();
	}

	private static String normalizeBookName(String bookName) {
		String newName = bookName;
		logger.info("The book name is:" + bookName);
		if (bookName.contains(" "))

		{

			logger.info("it contains space, replace with %20");
			newName = bookName.replace(" ", "%20");
		}
		return newName;
	}

	public static StringBuffer queryBookbyNameOf(String bookName) {
		StringBuffer responseContent = new StringBuffer();
		HttpClient client = new DefaultHttpClient();
		String url = constructQueryURL(bookName);

		HttpGet request = new HttpGet(url);
		HttpResponse response;
		try {
			response = client.execute(request);

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			// parseContext(response.getEntity().getContent());
			String line = "";

			while ((line = rd.readLine()) != null) {
				// logger.info(line);
				responseContent.append(line);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Document doc = getDomElement(responseContent.toString());
		doc.getFirstChild().
		logger.info(doc.toString());
		return responseContent;
	}

	private static void parseContext(InputStream it) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(it);

			logger.info(doc.toString());

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// private static void parseContext(String content) {
	// logger.info("context is:" + content);
	// SAXReader reader = new SAXReader();
	// try {
	// Document doc = reader.read(content);
	//
	// logger.info(doc.asXML());
	// } catch (DocumentException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	public static Document getDomElement(String xml) {
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder db = dbf.newDocumentBuilder();

			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			doc = db.parse(is);

		} catch (ParserConfigurationException e) {
			logger.info(e.getMessage());
			return null;
		} catch (SAXException e) {
			logger.info(e.getMessage());
			return null;
		} catch (IOException e) {
			logger.info(e.getMessage());
			return null;
		}
		// return DOM
		return doc;
	}
}
