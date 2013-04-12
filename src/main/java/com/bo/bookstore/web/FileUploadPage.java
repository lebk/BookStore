package com.bo.bookstore.web;

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

public class FileUploadPage extends BookStoreBasePage
{

  private static final long serialVersionUID = -56016226340014634L;
  // private FileUploadField fileUpload;
//  private TextField doubanAddr;

  // private String UPLOAD_FOLDER = "C:\\";

  public FileUploadPage(final PageParameters parameters)
  {

    add(new FeedbackPanel("feedback"));

    final TextField<String> doubanAddr = new TextField<String>("doubanAddr",
        Model.of(""));
    doubanAddr.setRequired(true);

    Form<?> form = new Form<Void>("uploadForm")
      {

        @Override
        protected void onSubmit()
        {

          final String addrValue = doubanAddr.getModelObject();

          PageParameters pageParameters = new PageParameters();
          pageParameters.add("doubanAddr", addrValue);
          setResponsePage(SuccessPage.class, pageParameters);

        }

      };
    form.add(doubanAddr);
    add(form);
  }
}
