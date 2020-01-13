import java.util.HashMap;
import java.util.Scanner;

/**
 * StringToByteParser.java 1.0 Dec 11, 2019
 */

/**
 * This class supports a function for parsing human readable file sizes. The function receives
 * strings in the format: "<number> <unit>" and shall return the number of bytes as a long data
 * type.
 *
 * @author ryanrudinger
 * @version 1.0
 *
 */
public class StringToByteParser {

  private final int BIT_MULTIPLIER = 8;
  private long bytes;
  private HashMap<String, Long> map;
  private double num;
  private String parsedUnitType;
  private String strToParse;

  /**
   * Constructs the default StringToByteParser object which instantiates the map of unit types to
   * their respective bases and exponents (<String, Long>), as well as other instance variables.
   *
   */
  public StringToByteParser() {
    map = new HashMap<String, Long>();

    map.put("B", (long) Math.pow(10, 0));
    map.put("KB", (long) Math.pow(10, 3));
    map.put("MB", (long) Math.pow(10, 6));
    map.put("GB", (long) Math.pow(10, 9));
    map.put("TB", (long) Math.pow(10, 12));
    map.put("PB", (long) Math.pow(10, 15));

    map.put("KiB", (long) Math.pow(2, 10));
    map.put("MiB", (long) Math.pow(2, 20));
    map.put("GiB", (long) Math.pow(2, 30));
    map.put("TiB", (long) Math.pow(2, 40));
    map.put("PiB", (long) Math.pow(2, 50));

    parsedUnitType = "";
    strToParse = "";
    num = 0.0;
    bytes = 0;
  }

  /**
   * Runs the program utilizing other methods within the class. Decision was to go for an "as secure
   * as possible" approach rather than giving access of data and methods to other classes. Runs the
   * program until user input says otherwise.
   *
   */
  public void go() {

    Scanner scnr = new Scanner(System.in);
    boolean didContinue = true;
    String userIn = "";

    while (didContinue) {

      do {
        try {

          System.out.print("Enter a file size in the format <number> <unit> (Ex: 3.75 GiB): ");
          strToParse = scnr.nextLine();

          parseStringForNumberAndUnit(strToParse);

        } catch (UnitTypeNotFoundException e) {

          e.printError();
        }
      } while (!containsUnitType(parsedUnitType) && !Double.isNaN(num));

      applyAssociatedPower();

      printBytes();

      System.out.print("\nEnter Y/y for another file to convert. Other keys will exit: ");
      userIn = scnr.nextLine();
      System.out.println();

      didContinue = (userIn.equals("Y") || userIn.equals("y")) ? true : false;
    }
    scnr.close();
  }

  /**
   * Applies the associated power of the unit type (<unit>) to the entered number (<number>),
   * referred to by the HashMap. The value is rounded up and converted to a long data type.
   * 
   */
  private void applyAssociatedPower() {
    long val = (long) (num * map.get(parsedUnitType));
    bytes = (long) Math.ceil(val);
  }

  /**
   * Checks to see if the parsed unit type is within the keys of the map.
   * 
   * @return boolean value to check if the parsed unit type is found within the map containing all
   *         possible unit types
   */
  private boolean containsUnitType(String unitType) {

    return map.containsKey(unitType);
  }

  /**
   * 
   * Separates the <number> <unit> into two variables in order to properly find number of bytes. If
   * a character is not found, the unit type will be set to "B" and the number value will be the
   * entered user input.
   *
   *
   * @param s String object to parse
   * @throws UnitTypeNotFoundException
   */
  private void parseStringForNumberAndUnit(String s) throws UnitTypeNotFoundException {

    boolean charFound = false;
    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetter(s.charAt(i))) {

        charFound = true;

        String strNum = s.substring(0, i).trim();
        setNumberValue(strNum);

        setUnitType(s.substring(i, s.length()).trim());

        break;
      }
    }
    if (!charFound) {
      setNumberValue(s);
      setUnitType("B");
    }

    if (!containsUnitType(parsedUnitType)) {
      throw new UnitTypeNotFoundException();
    }

  }

  /**
   * Prints the results in number of bytes (and bits for fun!).
   */
  private void printBytes() {
    System.out.println(strToParse + " is " + bytes + " bytes, or " + bytes * BIT_MULTIPLIER
                       + " bits :-)");
  }

  /**
   * 
   * Sets the number value from the parsed String object, and catches for invalid number entries.
   *
   * @param s parsed String object to be converted to a double
   */
  private void setNumberValue(String s) {
    try {
      num = Double.parseDouble(s);
    } catch (Exception e) {
      System.out.println("Invalid number. Valid numbers do not contain letters/characters.");
    }

  }

  /**
   * 
   * Sets the unit type from the parsed String object to check against the map of valid unit types.
   *
   * @param s parsed String object to represent the unit type
   */
  private void setUnitType(String s) {
    parsedUnitType = s;
  }

}
