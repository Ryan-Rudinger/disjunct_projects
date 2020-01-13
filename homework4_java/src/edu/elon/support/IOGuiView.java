/**
 * IOGuiView.java 1.0 Mar 13, 2017
 *
 * Copyright (c) 2017 Jack Redpath & Ryan Rudinger. All Rights Reserved
 * Campus Box 8499, Elon University, Elon, NC 27244
 */
package edu.elon.support;

import java.awt.Font;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * The heart of all user interaction for the application.
 *
 * @author jredpath
 * @author rrudinger
 * @version 1.0
 *
 */
public class IOGuiView {

  /**
   * Displays a table locations and their latitudes, longitudes and distance from a user-defined
   * location.
   * 
   * @param numPlaces - int value of the number of places to display
   * @param userName - String literal of name of user
   * @param locations - array of CityLocation objects closest to user-defined location
   */
  public void finalDisplay(int numPlaces, String userName, CityLocation[] locations) {
    UIManager.put("OptionPane.messageFont",
                  new FontUIResource(new Font("Monospaced", Font.PLAIN, 12)));
    String title = "Closest Cities";
    String message = "Closest " + numPlaces + " to " + userName + " are:\n";
    message = message + String.format("%-30s %-15s %-15s %15s %n", "Location", "Latitude",
                                      "Longitude", "Mileage");

    for (int i = 0; i < numPlaces; i++) {
      message = message + String.format("%-30s %-15.4f %-15.4f %15.2f %n", locations[i].getName(),
                                        locations[i].getLatitude(), locations[i].getLongitude(),
                                        locations[i].getDistance());
    }

    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, null);
  }

  /**
   * Sets user-defined latitude of user's location.
   *
   * @return latitude double value of latitude of user's location
   */
  public double setLatitude() {
    String title = "Latitude Entry";
    String message = "Enter your latitude:";
    double latitude = 0.0;
    boolean valid = false;
    while (!valid) {
      try {
        latitude = Double.parseDouble(JOptionPane.showInputDialog(null, message, title,
                                                                  JOptionPane.QUESTION_MESSAGE));
        valid = true;
      } catch (NumberFormatException e) {
        title = "Error";
        message = "Numbers only. Try again:";

      }
    }
    return latitude;
  }

  /**
   * Sets user-defined longitude of user's location.
   *
   * @return longitude double value of longitude of user's location
   */
  public double setLongitude() {
    String title = "Longitude Entry";
    String message = "Enter your longitude:";
    double longitude = 0.0;
    boolean valid = false;
    while (!valid) {
      try {
        longitude = Double.parseDouble(JOptionPane.showInputDialog(null, message, title,
                                                                   JOptionPane.QUESTION_MESSAGE));
        valid = true;
      } catch (NumberFormatException e) {
        title = "Error";
        message = "Numbers only. Try again:";

      }
    }
    return longitude;
  }

  /**
   * Sets user-defined name of person interacting with application.
   *
   * @return name String literal of user's name
   */
  public String setName() {
    String title = "Username Entry";
    String message = "Enter your name: ";
    String name = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    if (name == null) {
      System.exit(0);
    }
    return name;

  }

  /**
   * Sets the number of cities to display from the user's location.
   *
   * @return numCities number of cities to display from user location
   */
  public int setNumCities() {
    String title = "Number of Closest Cities";
    String message = "Enter desired number of closest cities to your location:";
    int numCities = 0;
    boolean valid = false;
    while (!valid) {
      try {
        numCities = Integer.parseInt(JOptionPane.showInputDialog(null, message, title,
                                                                 JOptionPane.QUESTION_MESSAGE));
        valid = true;
      } catch (NumberFormatException e) {
        title = "Error";
        message = "Numbers only. Try again:";
      }
    }
    return numCities;

  }

  /**
   * Displays a message in a JOptionPane informing the user that the file chosen is not in proper
   * format
   * 
   * @param file - the file the user chooses
   *
   */
  public void showInvalidFileException(File file) {
    String message = "The file " + file.getName() + " is not in proper format.";
    String title = "Invalid File";
    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, null);

  }

}
