package com.bo.bookstore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.bo.bookstore.gui.BookUIManager;

/**
 * @author: Terry_Lei
 * @date 2013-3-12 下午2:06:09
 */
public class BookStoreStartGUI extends JFrame
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    SwingUtilities.invokeLater(new Runnable()
      {

        public void run()
        {
          BookUIManager.createAndShowGUI(new File("D:\\百度云\\书籍\\kindle 书籍\\"));

        }
      });
  }

}
