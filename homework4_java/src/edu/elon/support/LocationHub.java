/**
 * LocationHub.java 1.0 Mar 28, 2017
 *
 * Copyright (c) 2017 Ryan J. Rudinger. All Rights Reserved
 * Campus Box 4452, Elon University, Elon, NC 27244
 */
package edu.elon.support;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * The network for CityLocation where CityLocation objects are defined and stored.
 *
 * @author ryanrudinger
 * @version 1.0
 *
 */
public class LocationHub {
  private int count;
  private File file;
  private CityLocation[] locs;

  /**
   * Creates an object of LocationHub that stores an array of CityLocation objects, initialized at
   * 10000 locations.
   *
   */
  public LocationHub() {
    locs = new CityLocation[10000];

  }

  /**
   * Gets list of numPlaces closest locations to user-defined location.
   *
   * @param numPlaces - int value of the number of places to store
   * @return list of closest locations to user-defined location
   */
  public CityLocation[] getList(int numPlaces) {
    CityLocation[] resultList = new CityLocation[numPlaces];
    for (int i = 0; i < numPlaces; i++) {
      resultList[i] = locs[i];
    }
    return resultList;
  }

  /**
   * Reads the file passed in, skips the first two lines, pulls key information in the file, and
   * stores it in CityLocation objects. Once the file is read, the array is trimmed down to remove
   * empty locations in memory.
   *
   * @param aFile - file to be read
   * @throws FileNotFoundException
   */
  public void readFile(File aFile) throws FileNotFoundException {
    file = aFile;
    String[] lineArray = null;
    Scanner in = new Scanner(file, "UTF-8");

    in.nextLine();
    in.nextLine();
    count = 0;
    while (in.hasNextLine()) {
      String line = in.nextLine();
      lineArray = line.split(",");

      if (count >= locs.length) {
        locs = Arrays.copyOf(locs, 2 * locs.length);
      }

      locs[count] = new CityLocation(lineArray[3], Double.parseDouble(lineArray[5].trim()),
        Double.parseDouble(lineArray[6].trim()), 0);
      System.out.println("Iterating: " + (count + 1)); // Just to see the processing
      count++;
    }
    locs = Arrays.copyOf(locs, count);

    in.close();

  }

  /**
   * Sets the distance of each CityLocation object from the user.
   *
   * @param userLat - user-defined fixed latitude
   * @param userLong - user-defined fixed longitude
   */
  public void setDistance(double userLat, double userLong) {
    DistanceMeasurer measurer = new DistanceMeasurer();
    for (int i = 0; i < count; i++) {
      double distance = measurer.computeDistanceFromUser(userLat, userLong, locs[i]);
      locs[i].setDistance(distance);
    }
  }

  /**
   * Sets file of user's choice.
   * 
   * @return - a comma separated file to be read
   * 
   * @throws InvalidFileException
   *
   */
  public File setFile() throws InvalidFileException {
    JFileChooser fileChooser = new JFileChooser();

    fileChooser.setDialogTitle("Choose a file");
    fileChooser.setApproveButtonText("Try to open me");
    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      file = fileChooser.getSelectedFile();
    } else if (file == null) {
      System.exit(0);
    }
    return file;
  }

  /**
   * Sorts a list of CityLocation objects by ascending distance from user. Utilizes the fact that
   * CityLocation implements the Comparable interface and compareTo method, where the compareTo
   * method compares CityLocation objects by distance from user-defined location.
   *
   */
  public void sortList() {
    Arrays.sort(locs);
  }

}
