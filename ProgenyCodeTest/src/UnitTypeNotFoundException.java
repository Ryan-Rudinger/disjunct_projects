/**
 * UnitTypeNotFoundException.java 1.0 Dec 13, 2019
 */

/**
 * An Exception subclass that is thrown if the user-entered unit type does not match the available
 * unit types.
 *
 * @author ryanrudinger
 * @version 1.0
 *
 */
public class UnitTypeNotFoundException extends Exception {

  private String[] unitTypes;

  /**
   * Assigns possible unit types to a String array for display.
   *
   */
  public UnitTypeNotFoundException() {
    unitTypes =
      new String[] { "B", "KB", "MB", "GB", "TB", "PB", "KiB", "MiB", "GiB", "TiB", "PiB" };
  }

  /**
   * Prints the error informing the user an invalid unit type was entered, and gives the user the
   * valid unit types.
   */
  public void printError() {

    System.out.println("The unit type submitted did not match a known unit type. Those available are: ");
    for (int i = 0; i < unitTypes.length; i++) {
      if (i == unitTypes.length - 1) {
        System.out.println(unitTypes[i] + ".");
      } else {
        System.out.print(unitTypes[i] + ",  ");
      }
    }
    System.out.println();
  }
}
