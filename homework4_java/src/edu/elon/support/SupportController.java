/**
 * Controller.java 1.0 Mar 13, 2017
 *
 * Copyright (c) 2017 Jack Redpath & Ryan Rudinger. All Rights Reserved
 * Campus Box 8499, Elon University, Elon, NC 27244
 */
package edu.elon.support;

import java.io.File;

/**
 * Manages application by creating objects of multiple classes within the package for user
 * interaction and distance calculations from user location.
 *
 * @author jredpath
 * @author rrudinger
 * @version 1.0
 *
 */
public class SupportController {
  private File file;
  private IOGuiView gui;
  private LocationHub hub;
  private CityLocation[] locations;

  /**
   * Creates controller that initializes objects of LocationHub, IOGuiView and File.
   *
   */
  public SupportController() {
    hub = new LocationHub();
    gui = new IOGuiView();
    file = null;
  }

  /**
   * Drives creation of setting the file, user interaction through IOGuiView object, and calculating
   * distances between the user and the user-defined amount of locations.
   * 
   * @throws InvalidFileException
   *
   */

  public void go() throws InvalidFileException {
    boolean valid = false;
    while (!valid) {
      file = null;
      file = hub.setFile();
      try {
        hub.readFile(file);
        valid = true;
      } catch (Exception e) {
        gui.showInvalidFileException(file);
      }
    }
    while (gui != null) { // While gui is not null (cancel selection), run!

      String username = gui.setName();
      double userLat = gui.setLatitude();
      double userLong = gui.setLongitude();
      int numCities = gui.setNumCities();
      hub.setDistance(userLat, userLong);
      hub.sortList();
      locations = hub.getList(numCities);
      gui.finalDisplay(numCities, username, locations);
    }
  }

}
