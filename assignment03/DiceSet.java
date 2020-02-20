/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  A. Volosin
 *  Date          :  2020-02.03
 *  Description   :  This helper class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then stolen from B.J. Johnson, then modified to show some 
 *                   interesting things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 *  @version 2.0.0  2019-02-03  A. Volosin    Update naming conventions and comments
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * This constructor is a method you will run to CREATE a DiceSet
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet(int count, int sides) {
      if (count<=0) {
        throw new IllegalArgumentException("Need a positive number of die to make a DiceSet.");
      }
      this.count = count;
      this.sides = sides;
      this.ds = new Die[count];
      for(int i=0; i< this.ds.length; i++) {
        this.ds[i] = new Die(sides);
        this.ds[i].roll();
        // System.out.println(ds[i]);
      }

   }

  /**
   * Sums up all dice in the DiceSet
   * @return the sum of all the dice values in the set
   */

   public int sum() {
    int sum = 0;
    for (int i = 0; i < this.ds.length; i++) {
      sum +=  this.ds[i].getValue();
    }
    return sum;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  This method does not return anything, it just rolls new values for all die
   *  in the DiceSet.
   *  You will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
    for(int i=0;i<this.ds.length; i++) {
      this.ds[i].roll();
    }
   }

  /**
   * Rolls a single die of the dice in this set indexed by 'dieIndex' to a random value
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @throws IllegalArgumentException if the index is out of range
   */
   public int rollIndividual(int dieIndex) {
    if (dieIndex>(this.ds.length) || dieIndex<1) {
      throw new IllegalArgumentException("Index is out of range.");
    }
    this.ds[dieIndex-1].roll();
    return this.ds[dieIndex-1].getValue();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @throws IllegalArgumentException if the index is out of range
   */
   public int getIndividual(int dieIndex) {
    if (dieIndex>(this.ds.length) || dieIndex<1) {
      throw new IllegalArgumentException("Index is out of range.");
    }
    return this.ds[dieIndex-1].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
    String result = "";
    for (int i=0; i<this.ds.length; i++){
      result += (" [" + this.ds[i].getValue() + "] ");
    }
    return "{" + result.trim() + "}";
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
    public static String toString(DiceSet ds) {
      String result = "";
      for (int i=1;i<=ds.count;i++){
        result += (" [" + ds.getIndividual(i)+ "] ");
      }
      return "{" + result.trim() + "}";
    }

  /**
   * A little test main to check things out
   * Write tests that out put results of each method at least twice
   * This main method only serves as a tester.
   */
   public static void main(String[] args) {
      // You do this part!
    System.out.println("Constructing a DiceSet of length 0 and 6 sides...");
    try {
      DiceSet ds1 = new DiceSet(0, 6);
    } catch (IllegalArgumentException iae) {
      System.out.println("Cannot construct a DiceSet with 0 die.");
    }

    System.out.println();
    System.out.println();
    System.out.println("Constructing a DiceSet of length 4 and 6 sides...");
    DiceSet ds1 = new DiceSet(4, 6);
    System.out.println("Non-static toString");
    System.out.println(ds1.toString());
    System.out.println("Static toString");
    System.out.println(DiceSet.toString(ds1));

    System.out.println();
    System.out.println();
    System.out.println("Rolling DiceSet...");
    ds1.roll();
    System.out.println("Non-static toString");
    System.out.println(ds1.toString());
    System.out.println("Static toString");
    System.out.println(DiceSet.toString(ds1));

    System.out.println();
    System.out.println();
    System.out.println("Rolling third die...");
    System.out.println("New value: " + ds1.rollIndividual(3));
    System.out.println("DiceSet after roll: " + ds1.toString());

    System.out.println();
    System.out.println();
    System.out.println("Sum of DiceSet: " + ds1.sum());

    System.out.println();
    System.out.println();
    System.out.println("Getting value of second die...");
    System.out.println("Die 2 value: " + ds1.getIndividual(2));

    System.out.println();
    System.out.println();
    System.out.println("Constructing a DiceSet of length 7 and 12 sides...");
    DiceSet ds2 = new DiceSet(7, 12);
    System.out.println("Non-static toString");
    System.out.println(ds2.toString());
    System.out.println("Static toString");
    System.out.println(DiceSet.toString(ds2));

    System.out.println();
    System.out.println();
    System.out.println("Rolling DiceSet...");
    ds2.roll();
    System.out.println("Non-static toString");
    System.out.println(ds2.toString());
    System.out.println("Static toString");
    System.out.println(DiceSet.toString(ds2));

    System.out.println();
    System.out.println();
    System.out.println("Rolling third die...");
    System.out.println("New value: " + ds2.rollIndividual(4));
    System.out.println("DiceSet after roll: " + ds2.toString());

    System.out.println();
    System.out.println();
    System.out.println("Sum of DiceSet: " + ds2.sum());

    System.out.println();
    System.out.println();
    System.out.println("Getting value of second die...");
    System.out.println("Die 6 value: " + ds2.getIndividual(6));
   }
}