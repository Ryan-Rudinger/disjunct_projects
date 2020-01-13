/**
 * Model.java 1.0 Mar 13, 2017
 *
 * Copyright (c) 2017 Jack Redpath & Ryan Rudinger. All Rights Reserved
 * Campus Box 8499, Elon University, Elon, NC 27244
 */
package edu.elon.support;

/**
 * The DistanceMeasurer class holds the method to calculate the distance between a fixed point and
 * another location.
 * 
 * @author jredpath
 * @author rrudinger
 * @version 1.0
 *
 */
public class DistanceMeasurer {

  /**
   * Creates a DistanceMeasurer object.
   *
   */
  public DistanceMeasurer() {
    // intentionally left empty.
  }

  /**
   * 
   * Utilizes Haversine Formula to calculate the distance (in miles) between two points.
   * 
   * (c) Haversine Distance Algorithm by ananth
   * https://bigdatanerd.wordpress.com/2011/11/03/java-implementation-of-haversine-formula-for-distance-calculation-between-two-points/
   * 
   * @param userLat - latitude of user-defined location
   * @param userLong - longitude of user-defined location
   * @param otherLoc - CityLocation object to compute the distance to from the user-defined location
   * 
   * @return double value of calculated distance of a Location object to user location
   * 
   */
  public double computeDistanceFromUser(double userLat, double userLong, CityLocation otherLoc) {
    double distance = 0.0;
    final double R = 3958.756; // Earth's radius in miles (6371 km)
    double locLat = otherLoc.getLatitude();
    double locLong = otherLoc.getLongitude();
    double latDistance = Math.toRadians(locLat - userLat);
    double longDistance = Math.toRadians(locLong - userLong);

    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
               + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(locLat))
                 * Math.sin(longDistance / 2) * Math.sin(longDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    distance = R * c;
    return distance;
  }

}
