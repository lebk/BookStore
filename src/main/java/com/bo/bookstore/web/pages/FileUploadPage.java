package com.bo.bookstore.web.pages;

import java.io.File;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.UrlTextField;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.lang.Bytes;

import com.bo.bookstore.web.BookStoreBasePage;
import com.bo.bookstore.web.UploadFileSuccessPage;
import com.bo.bookstore.web.panel.BookSummaryPanel;
import com.bo.bookstore.web.panel.FileUploadPanel;

public class FileUploadPage extends BookStoreBasePage
{

  private static final long serialVersionUID = -56016226340014634L;

  public FileUploadPage()
  {
	    super();
	    add(new FileUploadPanel("contentPanel"));
  }
}
