package com.bo.bookstore.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class BookStoreFooter extends Panel {

	/**
	   * 
	   */
	private static final long serialVersionUID = -1788642451893597367L;
	private static final String ContactInfo = "联系我";

	/**
	 * Construct.
	 * 
	 * @param id
	 *            id of the component
	 * @param exampleTitle
	 *            title of the example
	 * @param page
	 *            The example page
	 */
	public BookStoreFooter(String id, WebPage page) {
		super(id);

		add(new Label("Contact", ContactInfo));

	}
}
