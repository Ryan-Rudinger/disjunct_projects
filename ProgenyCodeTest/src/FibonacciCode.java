import java.util.ArrayList;

/**
 * FibonacciCode.java 1.0 Dec 10, 2019
**/

/**
 * Automates the Fibonacci Code while less than the sum of 4,000,000 from the previous two values.
 *
 * @author Paul Brown Bear
 * @version 1.0
 *
 */
public class FibonacciCode {

  private final int END_VALUE = 4000000;
  private ArrayList<Integer> fibList;
  private final int FIRST_START_VALUE = 1;
  private final int SECOND_START_VALUE = 2;
  private long sumOfEvenNums;

  /**
   * Creates default FibonacciCode object with empty ArrayList and instantiates private variables.
   *
   */
  public FibonacciCode() {

    fibList = new ArrayList<Integer>();
    sumOfEvenNums = 0;
  }

  /**
   * Tries to find the sum of the even values of the Fibonacci Code less than END_VALUE.
   *
   * @return long value to represent the sum of the even numbers of the Fibonacci Code less than
   *         END_VALUE
   * 
   */
  public long getSumOfEvenVals() {

    try {

      doFibCode();
      for (int i = 0; i < fibList.size(); i++) {
        int val = fibList.get(i);
        boolean isEven = val % 2 == 0;

        if (isEven) {
          sumOfEvenNums += val;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sumOfEvenNums;
  }

  /**
   * 
   * Retrieves the sum of the even values of the Fibonacci Code less than END_VALUE
   *
   * @return long data type representing sum of even values less than END_VALUE
   */
  public long getSumOfEvenValues() {
    return sumOfEvenNums;
  }

  /**
   * Creates the Fibonacci Code in fibList less than END_VALUE.
   * 
   */
  private void doFibCode() {

    fibList.add(FIRST_START_VALUE);
    fibList.add(SECOND_START_VALUE);
    int sumOfLastTwo = sumLastTwoValues();

    while (sumOfLastTwo < END_VALUE) {
      fibList.add(sumOfLastTwo);
      sumOfLastTwo = sumLastTwoValues();
    }
  }

  /**
   * 
   * Finds sum of last two values within the current Fibonacci Code stored in fibList.
   *
   * @return int value representing sum of last two values of current Fibonacci Code
   */
  private int sumLastTwoValues() {

    int lastVal = fibList.get(fibList.size() - 1);
    int prevLastVal = fibList.get(fibList.size() - 2);
    int sum = lastVal + prevLastVal;
    return sum;
  }
}
