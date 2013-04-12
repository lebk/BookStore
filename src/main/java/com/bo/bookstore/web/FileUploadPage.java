package com.bo.bookstore.web;

import java.io.File;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.UrlTextField;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.lang.Bytes;

public class FileUploadPage extends BookStoreBasePage
{

  private static final long serialVersionUID = -56016226340014634L;
  private FileUploadField fileUpload;
  private TextField address;
  private String UPLOAD_FOLDER = "C:\\";

  public FileUploadPage(final PageParameters parameters)
  {

    Form<?> addrForm = new Form<Void>("addrForm")
      {
        @Override
        protected void onSubmit()
        {
          // get the entered password and pass to next page
          PageParameters pageParameters = new PageParameters();
          pageParameters.add("address", address.getModelObject());

        }
      };

    Form<?> uploadForm = new Form<Void>("uploadForm")
      {
        @Override
        protected void onSubmit()
        {

          final FileUpload uploadedFile = fileUpload.getFileUpload();
          if (uploadedFile != null)
          {

            // write to a new file
            File newFile = new File(UPLOAD_FOLDER
                + uploadedFile.getClientFileName());

            if (newFile.exists())
            {
              newFile.delete();
            }

            try
            {
              newFile.createNewFile();
              uploadedFile.writeTo(newFile);

              info("saved file: " + uploadedFile.getClientFileName());
            } catch (Exception e)
            {
              throw new IllegalStateException("Error");
            }
          }
        }

      };

    // Enable multipart mode (need for uploads file)
    uploadForm.setMultiPart(true);

    // max upload size, 10k
    uploadForm.setMaxSize(Bytes.megabytes(30));

    uploadForm.add(fileUpload = new FileUploadField("fileUpload"));
    addrForm.add(address = new TextField("address"));
    add(addrForm);
    add(uploadForm);

  }
}
