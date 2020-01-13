/**
 * CityLocation.java 1.0 Mar 28, 2017
 *
 * Copyright (c) 2017 Ryan J. Rudinger. All Rights Reserved
 * Campus Box 4452, Elon University, Elon, NC 27244
 */
package edu.elon.support;

/**
 * Provides location information.
 *
 * @author ryanrudinger
 * @version 1.0
 *
 */
public class CityLocation implements LocationInterface, Comparable {
  private double distance;
  private double latitude;
  private double longitude;
  private String name;

  /**
   * Creates a CityLocation with a name, location and a distance set to user.
   *
   * @param aName - name of location
   * @param aLat - latitude of location
   * @param aLong - longitude of location
   * @param aDist - distance from user-defined location
   */
  public CityLocation(String aName, double aLat, double aLong, double aDist) {
    name = aName;
    latitude = aLat;
    longitude = aLong;
    distance = aDist;
  }

  /*
   * Compares a CityLocation object to another CityLocation object and determines the assortment by
   * measuring distance from the user.
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(Object obj) {
    CityLocation otherLoc = (CityLocation) obj;

    if (distance - otherLoc.getDistance() > 0) {
      return 1;
    } else if (distance - otherLoc.getDistance() < 0) {
      return -1;
    } else {
      return 0;
    }
  }

  /**
   * Gets distance from user-defined location.
   * 
   * @return a double value representing distance from the user-defined location
   */
  public double getDistance() {
    return distance;
  }

  /*
   * Gets the latitude of a specific location.
   * 
   * @see edu.elon.support.LocationInterface#getLatitude()
   */
  @Override
  public double getLatitude() {
    return latitude;
  }

  /*
   * Gets the longitude of a specific location.
   * 
   * @see edu.elon.support.LocationInterface#getLongitude()
   */
  @Override
  public double getLongitude() {
    return longitude;
  }

  /*
   * Gets the name of a specific location.
   * 
   * @see edu.elon.support.LocationInterface#getName()
   */
  @Override
  public String getName() {

    return name.substring(1, name.length() - 1);
  }

  /**
   * Sets distance from user-defined location.
   * 
   * @param aDistance the distance to set
   */
  public void setDistance(double aDistance) {
    distance = aDistance;
  }

  /**
   * Sets latitude of a location.
   * 
   * @param aLatitude the latitude to set
   */
  public void setLatitude(double aLatitude) {
    latitude = aLatitude;
  }

  /**
   * Sets longitude of a location.
   * 
   * @param aLongitude the longitude to set
   */
  public void setLongitude(double aLongitude) {
    longitude = aLongitude;
  }

  /**
   * Sets name of location.
   * 
   * @param aName the name to set
   */
  public void setName(String aName) {
    name = aName;
  }
}
