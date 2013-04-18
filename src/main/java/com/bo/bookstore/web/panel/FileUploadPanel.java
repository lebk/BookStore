package com.bo.bookstore.web.panel;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.bo.bookstore.web.UploadFileSuccessPage;

public class FileUploadPanel extends Panel {
	private static final long serialVersionUID = -1400249289085555438L;

	public FileUploadPanel(String id) {
		super(id);
		add(new FeedbackPanel("feedback"));

		final TextField<String> doubanAddr = new TextField<String>(
				"doubanAddr", Model.of(""));
		doubanAddr.setRequired(true);

		Form<?> form = new Form<Void>("uploadForm") {

			@Override
			protected void onSubmit() {

				final String addrValue = doubanAddr.getModelObject();

				PageParameters pageParameters = new PageParameters();
				pageParameters.add("doubanAddr", addrValue);
				setResponsePage(UploadFileSuccessPage.class, pageParameters);

			}

		};
		form.add(doubanAddr);
		add(form);
	}
}
