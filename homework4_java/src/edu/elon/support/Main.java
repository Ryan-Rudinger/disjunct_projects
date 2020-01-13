/**
 * Main.java 1.0 Mar 13, 2017
 *
 * Copyright (c) 2017 Jack Redpath & Ryan Rudinger. All Rights Reserved
 * Campus Box 8499, Elon University, Elon, NC 27244
 */
package edu.elon.support;

import java.io.FileNotFoundException;

import javax.swing.SwingUtilities;

/**
 * Distance calculator application that determines the distance between a user-defined location and
 * a list of locations within a file, and then sorts a user-defined number of locations and their
 * distances in ascending order from the set location.
 *
 * @author jredpath
 * @author rrudinger
 * @version 1.0
 *
 */
public class Main {

  /**
   * Starts application.
   *
   * @param args
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException {
    SwingUtilities.invokeLater(new Runnable() {

      @Override

      public void run() {
        SupportController c = new SupportController();
        try {
          c.go();
        } catch (InvalidFileException e) {

          e.printStackTrace();
        }
      }
    });
  }

}
