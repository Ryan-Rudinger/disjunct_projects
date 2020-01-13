/**
 * LocationInterface.java 1.0 Mar 15, 2017
 *
 * Copyright (c) 2017 Ryan J. Rudinger. All Rights Reserved
 * Campus Box 4452, Elon University, Elon, NC 27244
 */
package edu.elon.support;

/**
 * Start each class or interface with summary description line
 * 
 * @author jackredpath
 * @author ryanrudinger
 * @version 1.0
 *
 */
public interface LocationInterface {
  /**
   * Gets the latitude of a specific location.
   *
   * @return double value of latitude coordinate
   */
  double getLatitude();

  /**
   * Gets the longitude of a specific location.
   *
   * @return double value of longitude coordinate
   */
  double getLongitude();

  /**
   * Gets the name of a specific location.
   *
   * @return String literal of name
   */
  String getName();

}
