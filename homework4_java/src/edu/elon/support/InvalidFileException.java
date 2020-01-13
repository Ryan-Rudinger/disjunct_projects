/**
 * InvalidFileException.java 1.0 Mar 30, 2017
 *
 * Copyright (c) 2017 Ryan J. Rudinger. All Rights Reserved
 * Campus Box 4452, Elon University, Elon, NC 27244
 */
package edu.elon.support;

import javax.swing.JOptionPane;

/**
 * An exception to inform the user of an invalid chosen file.
 *
 * @author ryanrudinger
 * @version 1.0
 *
 */
public class InvalidFileException extends Exception {

  /**
   * Creates a default InvalidFileException object with a default message.
   *
   */
  public InvalidFileException() {
    super("Invalid File");
  }

  /**
   * Creates an InvalidFileException object in which the programmer may decide upon the message.
   *
   * @param message - the string to be displayed within the JOptionPane
   */
  public InvalidFileException(String message) {
    String title = "Invalid File";
    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, null);
  }

}
