package com.bo.bookstore.web.footer;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class BookStoreFooterPanel extends Panel {

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
	 */
	public BookStoreFooterPanel(String id) {
		super(id);

		add(new Label("Contact", ContactInfo));

	}
}
