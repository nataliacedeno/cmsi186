/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobIntTester.java
 * Purpose    :  Test Harness for the BrobInt java class
 * @author    :  A.Volosin
 * Date       :  2019-03-01
 * Description:  
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2019-03-01  A.Volosin     Initial writing and release
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class BrobIntTester {

   private static String g01String = "144127909719710664015092431502440849849506284148982076191826176553";
   private static String g02String = "144127909719710664015092431502440849849506284148982076191826176553";
   private static String g03String = "144127909719710664015092431502440849849506284108982076191826176553";
   private static String g04String = "14412790971971066401509243150244084984950628410898207";
   private static String g05String = "0";
   private static String g06String = "1";
   private static String g07String = "10";
   private static String g08String = "000000008";
   private static String g09String = "8";
   private static String g10String = "-10981834098109834901283409810834098102938409182034891823048019920";
   private static String g11String = "10";
   private static String g12String = "20";
   private static String g13String = "234567";
   private static String g14String = "-234567";
   private static String g15String = "-10";
   private static String g16String = "-999999";
   private static String g17String = "765";
   private static String g18String = "23";
   private static String g19String = "56789";
   private static String g20String = "37";
   private static String g21String = "34958092!38192";
   private static String g22String = "-1983!0980237";
   private static String g23String = "193284108-9788719";
   private static String g24String = "000000&&000001";
   private static String g25String = "-0000001";
   private static String g26String = "12903";
   private static String g27String = "928";
   private static String g28String = "-9283";
   private static String g29String = "189";
   private static String g30String = "00005";
   private static String g31String = "525";


   private static BrobInt g1 = null;
   private static BrobInt g2 = null;
   private static BrobInt g3 = null;
   private static BrobInt g4 = null;
   private static BrobInt g5 = null;
   private static BrobInt g6 = null;
   private static BrobInt g7 = null;
   private static BrobInt g8 = null;
   private static BrobInt g9 = null;
   private static BrobInt g10 = null;
   private static BrobInt g11 = null;
   private static BrobInt g12 = null;
   private static BrobInt g13 = null;
   private static BrobInt g14 = null;
   private static BrobInt g15 = null;
   private static BrobInt g16 = null;
   private static BrobInt g17 = null;
   private static BrobInt g18 = null;
   private static BrobInt g19 = null;
   private static BrobInt g20 = null;
   private static BrobInt g21 = null;
   private static BrobInt g22 = null;
   private static BrobInt g23 = null;
   private static BrobInt g24 = null;
   private static BrobInt g25 = null;
   private static BrobInt g26 = null;
   private static BrobInt g27 = null;
   private static BrobInt g28 = null;
   private static BrobInt g29 = null;
   private static BrobInt g30 = null;
   private static BrobInt g31 = null;
   private static BrobInt g32 = null;
   private static BrobInt g33 = null;
   private static BrobInt g34 = null;
   private static BrobInt g35 = null;
   private static BrobInt g36 = null;
   private static BrobInt g37 = null;
   private static BrobInt g38 = null;
   private static BrobInt g39 = null;
   private static BrobInt g40 = null;


   public BrobIntTester() {
      
   }

   public static void main( String[] args ) {
      BrobIntTester git = new BrobIntTester();

      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );

      System.out.println( "    TESTING CONSTRUCTOR AND CONSTANTS:\n" +
                          "    ==================================" );
      try {
         System.out.println( "    Test 001: Making a new BrobInt: " );
         g1 = new BrobInt( g01String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + g01String + "\n" +
                             "        and got: " + g1.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 002: Making a second new BrobInt [same as first]: " );
      try {
         g2 = new BrobInt( g02String );
         System.out.println( "      expecting: " + g02String + "\n" +
                             "        and got: " + g2.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 003: Comparing equality of g1 and g2 with 'equals()': " );
         System.out.println( "      expecting: true\n" + "        and got: " + g1.equals( g2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 004: Making a third new BrobInt [differs at position 47    |]: " +
                             "\n           [position indicated by down arrow]                  v   " );
         g3 = new BrobInt( g03String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + g03String + "\n" +
                             "        and got: " + g3.toString() );
         System.out.println( "          g1 is: " + g1.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 005: Comparing equality of g1 and g3 [detect different digit]: " );
         System.out.println( "      expecting: false\n" + "        and got: " + g1.equals( g3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 006: Making a fourth new BrobInt [same as g3 but truncated]: "  );
         g4 = new BrobInt( g04String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + g04String + "\n" +
                             "        and got: " + g4.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 007: Comparing equality of g3 and g4 [detect different length prior to detecting different digit]: " );
         System.out.println( "      expecting: false\n" + "        and got: " + g3.equals( g4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 008: Making a fifth new BrobInt, checking BrobInt.ZERO: "  );
         g5 = new BrobInt( "0" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + BrobInt.ZERO + "\n" +
                             "        and got: " + g5.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 009: Making a sixth new BrobInt, checking BrobInt.ONE: "  );
         g6 = new BrobInt( "1" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + BrobInt.ONE + "\n" +
                             "        and got: " + g6.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 010: Making a seventh new BrobInt, checking BrobInt.TEN: "  );
         g7 = new BrobInt( g07String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + BrobInt.TEN + "\n" +
                             "        and got: " + g7.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING VALUEOF( LONG ) METHOD:\n" +
                          "    ===============================" );
      System.out.println( "\n    Test 011: Creating several long type values to check the 'valueOf()' method: " );
      long long01 = Long.MAX_VALUE;
      long long02 = Long.MIN_VALUE;
      long long03 = 1234567890;
      try {
         System.out.println( "      expecting: " + Long.MAX_VALUE + "\n" +
                             "        and got: " + long01 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + Long.MIN_VALUE + "\n" +
                             "        and got: " + long02 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 1234567890\n" +
                             "        and got: " + long03 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 012: Now testing 'valueOf()' method: " );
         g8  = BrobInt.valueOf( long01 );
         g9  = BrobInt.valueOf( long02 );
         g10 = BrobInt.valueOf( long03 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + Long.MAX_VALUE + "\n" +
                             "        and got: " + g8.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + Long.MIN_VALUE + "\n" +
                             "        and got: " + g9.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 1234567890\n" +
                             "        and got: " + g10.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING ADD() METHODS:\n" +
                          "    ==========================" );
      try {
         System.out.println( "\n    Test 013: Making an eleventh and twelfth new BrobInt, calling add method: "  );
         g11 = new BrobInt( g11String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 10\n" +
                             "        and got: " + g11.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         g12 = new BrobInt( g12String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 20\n" +
                             "        and got: " + g12.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014: Adding g11 and g12: " );
         System.out.println( "      expecting: 30 and got " + g11.add( g12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 015: Making a thirteenth new BrobInt, calling add methods: "  );
      try {
         g13 = new BrobInt( g13String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 234567\n" +
                             "        and got: " + g13.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016: Adding g11 and g13 [10 + 234567] using bytes: " );
         System.out.println( "      expecting: 234577 and got " + g11.add( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 017: Adding g13 and g11 [234567 + 10] using bytes: " );
         System.out.println( "      expecting: 234577 and got " + g13.add( g11 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 018: Making a fourteenth new BrobInt, calling add methods: "  );
      try {
         g14 = new BrobInt( g14String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: -234567\n" +
                             "        and got: " + g14.toString() );
         System.out.println( "\n    Test 019: Making a fifteenth new BrobInt, calling add methods: "  );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         g15 = new BrobInt( g15String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: -10\n" +
                             "        and got: " + g15.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 020: Adding g14 and g15 [-234567 + -10] using bytes: " );
         System.out.println( "      expecting: -234577 and got " + g14.add( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 021: Adding g15 and g14 [-10 + -234567] using bytes: " );
         System.out.println( "      expecting: -234577 and got " + g15.add( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 022: Making a sixteenth new BrobInt, calling add methods: "  );
      try {
         g16 = new BrobInt( g16String );
         System.out.println( "      expecting: -999999\n" +
                             "        and got: " + g16.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 023: Adding g14 and g16 [-234567 + -999999] using bytes: " );
         System.out.println( "      expecting: -1234566 and got " + g14.add( g16 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 024: Adding g16 and g14 [-999999 + -234567] using bytes: " );
         System.out.println( "      expecting: -1234566 and got " + g16.add( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n      Test 025: Adding g1 and g4 using bytes: " );
         System.out.println( "      expecting: 144127909719725076806064402568842359092656528233967026820237074760\n" +
                             "        and got: " + g1.add( g4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING COMPARETO() METHOD:\n" +
                          "    ===========================\n" +
                          "    NOTE: this.compareTo(that) returns: -1 if this < that\n" +
                          "                               returns: +1 if this > that\n" +
                          "                               returns:  0 if this = that" );
      try {
         System.out.println( "\n    Test 026: Checking compareTo() method on g1.compareTo g2: "  );
         System.out.println( "      expecting: 0 and got: " + g1.compareTo( g2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 027: Checking compareTo() method on g2.compareTo g1: "  );
         System.out.println( "      expecting: 0 and got: " + g2.compareTo( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 028: Checking compareTo() method on g1.compareTo g3: "  );
         System.out.println( "      expecting: positive value and got: " + g1.compareTo( g3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 029: Checking compareTo() method on g3.compareTo g1: "  );
         System.out.println( "      expecting: negative value and got: " + g3.compareTo( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030: Checking compareTo() method on g3.compareTo g4: "  );
         System.out.println( "      expecting: positive value and got: " + g3.compareTo( g4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030a: Checking compareTo() method on 123456789.compareTo 234: "  );
         System.out.println( "      expecting: positive value and got: " + (new BrobInt("123456789").compareTo( new BrobInt("234"))) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030b: Checking compareTo() method on 123.compareTo 123456789: "  );
         System.out.println( "      expecting: ngative value and got: " + (new BrobInt("123").compareTo( new BrobInt("123456789"))) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030c: Checking compareTo() method on g3.compareTo 999: "  );
         System.out.println( "      expecting: positive value and got: " + g3.compareTo( new BrobInt( "999" ) ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030d: Checking compareTo() method on 1234.compareTo -999: "  );
         System.out.println( "      expecting: positive value and got: " + (new BrobInt("1234").compareTo( new BrobInt( "-999" ) ) ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030e: Checking compareTo() method on -999.compareTo G3: "  );
         System.out.println( "      expecting: negative value and got: " + new BrobInt( "-999" ).compareTo( g3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING SUBTRACT() METHOD:\n" +
                          "    ==============================" );
      System.out.println( "\n      Test 031: Subtracting g13 take away g11 [234567 - 10] using bytes: " );
      try {
         System.out.println( "      expecting: 234557\n" +
                             "        and got: " + g13.subtract( g11 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 032: Subtracting g11 take away g13 [10 - 234567] using bytes: " );
      try {
         System.out.println( "      expecting: -234557\n" +
                             "        and got: " + g11.subtract( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 033: Subtracting g13 take away g15 [234567 - (-10)] using bytes: " );
      try {
         System.out.println( "      expecting: 234577\n" +
                             "        and got: " + g13.subtract( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 034: Subtracting g15 take away g13 [(-10) - 234567] using bytes: " );
      try {
         System.out.println( "      expecting: -234577\n" +
                             "        and got: " + g15.subtract( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 035: Subtracting g14 take away g16 [(-234567) - (-999999)] using bytes: " );
      try {
         System.out.println( "      expecting: 765432\n" +
                             "        and got: " + g14.subtract( g16 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 036: Subtracting g16 take away g14 [(-999999) - (-234567)] using bytes: " );
      try {
         System.out.println( "      expecting: -765432\n" +
                             "        and got: " + g16.subtract( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037: Subtracting g1 take away g1 [too long to list] using bytes: " );
      try {
         System.out.println( "      expecting: 000000000000000000000000000000000000000000000000000000000000000000\n" +
                             "        and got: " + g1.subtract( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING MULTIPLY() METHOD:\n" +
                          "    ==========================" );
      System.out.println( "\n      Test 038: Multiplying g7 by g12 [10 * 20]: " );
      try {
         System.out.println( "      expecting: 200\n" +
                             "        and got: " + g7.multiply( g12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n    Test 039: Making a seventeenth new BrobInt: "  );
      try {
         g17 = new BrobInt( g17String );
         System.out.println( "      expecting: 765\n" +
                             "        and got: " + g17.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 040: Making a eightteenth new BrobInt: "  );
      try {
         g18 = new BrobInt( g18String );
         System.out.println( "      expecting: 23\n" +
                             "        and got: " + g18.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 041: Making a nineteenth new BrobInt: "  );
      try {
         g19 = new BrobInt( g19String );
         System.out.println( "      expecting: 56789\n" +
                             "        and got: " + g19.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 042: Making a twentieth new BrobInt: "  );
      try {
         g20 = new BrobInt( g20String );
         System.out.println( "      expecting: 37\n" +
                             "        and got: " + g20.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 043: Multiplying g17 by g18 [765 * 23]: " );
      try {
         System.out.println( "      expecting: 17595\n" +
                             "        and got: " + g17.multiply( g18 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 044: Multiplying g18 by g20 [23 * 37]: " );
      try {
         System.out.println( "      expecting: 851\n" +
                             "        and got: " + g18.multiply( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 045: Multiplying g19 by g20 [56789 * 37]: " );
      try {
         System.out.println( "      expecting: 2101193\n" +
                             "        and got: " + g19.multiply( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 046: Multiplying g18 by g17 [23 * 765]: " );
      try {
         System.out.println( "      expecting: 17595\n" +
                             "        and got: " + g18.multiply( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 047: Multiplying g17 by g19 [765 * 56789]: " );
      try {
         System.out.println( "      expecting: 43443585\n" +
                             "        and got: " + g17.multiply( g19 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048: Multiplying g20 by g19 [37 * 56789]: " );
      try {
         System.out.println( "      expecting: 2101193\n" +
                             "        and got: " + g20.multiply( g19 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n\n    TESTING DIVIDE() METHOD:\n" +
                          "    ========================" );
      System.out.println( "\n      Test 049: Dividing g19 by g20 [56789 / 37]: " );
      try {
         System.out.println( "      expecting: 1534\n" +
                             "        and got: " + g19.divide( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050: Dividing g17 by g20 [765 / 37]: " );
      try {
         System.out.println( "      expecting: 20\n" +
                             "        and got: " + g17.divide( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n\n    TESTING REMAINDER() METHOD:\n" +
                          "    ===========================" );
      System.out.println( "\n      Test 051: Modding g17 by g18 [765 % 23]: " );
      try {
         System.out.println( "      expecting: 6\n" +
                             "        and got: " + g17.remainder( g18 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052: Modding g19 by g20 [56789 % 37]: " );
      try {
         System.out.println( "      expecting: 31\n" +
                             "        and got: " + g19.remainder( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "    TESTING CONSTRUCTOR AND CONSTANTS:\n" +
                          "    ==================================" );
      try {
         System.out.println( "    Test 053: Making a new BrobInt with zeros before it: " );
         g21 = new BrobInt( g08String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }
      try {
         System.out.println( "      expecting: " + g09String + "\n" +
                             "        and got: " + g21.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "\n    Test 054: Making a new BrobInt [same as first but without zeros before it]: " );
         g22 = new BrobInt( g09String );
         System.out.println( "      expecting: " + g09String + "\n" +
                             "        and got: " + g22.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 055: Comparing equality of g21 with g22 with 'equals()': " );
         System.out.println( "      expecting: true\n" + "        and got: " + g21.equals( g22 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 056: Comparing equality of g22 with g21 with 'equals()': " );
         System.out.println( "      expecting: true\n" + "        and got: " + g22.equals( g21 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "\n    Test 057: Making a new BrobInt [negative number]: " );
         g23 = new BrobInt( g10String );
         System.out.println( "      expecting: " + g10String + "\n" +
                             "        and got: " + g23.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "\n    Test 058: Making a new BrobInt with characters inside: " );
         g24 = new BrobInt( g21String );
         System.out.println( "      expecting: " + g21String + "\n" +
                             "        and got: " + g24.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "\n    Test 059: Making a new BrobInt with characters inside: " );
         g25 = new BrobInt( g22String );
         System.out.println( "      expecting: " + g22String + "\n" +
                             "        and got: " + g25.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "\n    Test 060: Making a new BrobInt with characters inside: " );
         g26 = new BrobInt( g23String );
         System.out.println( "      expecting: " + g23String + "\n" +
                             "        and got: " + g26.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 061: Making a new BrobInt with characters inside: " );
         g27 = new BrobInt( g24String );
         System.out.println( "      expecting: " + g24String + "\n" +
                             "        and got: " + g27.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "\n    Test 062: Making a new BrobInt : " );
         g28 = new BrobInt( g25String );
         System.out.println( "      expecting: " + g25String + "\n" +
                             "        and got: " + g28.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 063: Making a new BrobInt: " );
         g29 = new BrobInt( g26String );
         System.out.println( "      expecting: " + g26String + "\n" +
                             "        and got: " + g29.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 064: Making a new BrobInt: " );
         g30 = new BrobInt( g27String );
         System.out.println( "      expecting: " + g27String + "\n" +
                             "        and got: " + g30.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 065: Making a new BrobInt: " );
         g31 = new BrobInt( g28String );
         System.out.println( "      expecting: " + g28String + "\n" +
                             "        and got: " + g31.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 066: Making a new BrobInt: " );
         g32 = new BrobInt( g29String );
         System.out.println( "      expecting: " + g29String + "\n" +
                             "        and got: " + g32.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 067: Making a new BrobInt: " );
         g33 = new BrobInt( g30String );
         System.out.println( "      expecting: " + g30String + "\n" +
                             "        and got: " + g33.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n\n    TESTING ADD() METHODS:\n" +
                          "    ==========================" );

      try {
         System.out.println( "    Test 068: Adding g29 and g30 [12903 + 928]: " );
         System.out.println( "      expecting: 13831 and got " + g29.add( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 069: Adding g30 and g29 [928+ 12903]: " );
         System.out.println( "      expecting: 13831 and got " + g29.add( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 070: Adding g29 and g31 [12903 + -9283]: " );
         System.out.println( "      expecting: 3620 and got " + g29.add( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 071: Adding g31 and g29 [-9283 + 12903]: " );
         System.out.println( "      expecting: 3620 and got " + g31.add( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 072: Adding g33 and g32 [00005 + 189]: " );
         System.out.println( "      expecting: 194 and got " + g32.add( g33 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 073: Adding g32 and g33 [189 + 00005]: " );
         System.out.println( "      expecting: 194 and got " + g32.add( g33 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 074: Adding g32 and g34 [189 + 525]: " );
         System.out.println( "      expecting: 714 and got " + g32.add( g34 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 075: Adding g34 and g32 [525 + 189]: " );
         System.out.println( "      expecting: 714 and got " + g34.add( g32 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 076: Adding g31 and g15 [(-9283) + (-10)]: " );
         System.out.println( "      expecting: -9293 and got " + g31.add( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 077: Adding g15 and g31 [(-10) + (-9283)]: " );
         System.out.println( "      expecting: -9293 and got " + g15.add( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 078: Adding g31 to itself [(-9283) + (-9283)]: " );
         System.out.println( "      expecting: -18566 and got " + g31.add( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 079: Adding g31 to g32 to g33 [(-9283) + 189 + 00005]: " );
         System.out.println( "      expecting: -9089 and got " + g31.add( g32 ).add( g33 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      try {
         System.out.println( "    Test 080: Adding g32 to g33 to g31 [189 + 00005 + (-9283)]: " );
         System.out.println( "      expecting: -9089 and got " + g32.add( g33 ).add( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n\n    TESTING SUBTRACT() METHODS:\n" +
                          "    ==========================" );
      System.out.println( "\n      Test 081: Subtracting g29 take away g31 [12903 - (-9283)]: " );
      try {
         System.out.println( "      expecting: 22186\n" +
                             "        and got: " + g29.subtract( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 082: Subtracting g31 take away g29 [(-9283) - 12903]: " );
      try {
         System.out.println( "      expecting: -22186\n" +
                             "        and got: " + g31.subtract( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }
      
      System.out.println( "\n      Test 083: Subtracting g29 take away g30 [12903 - 928]: " );
      try {
         System.out.println( "      expecting: 11975\n" +
                             "        and got: " + g29.subtract( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 084: Subtracting g30 take away g29 [928 - 12903]: " );
      try {
         System.out.println( "      expecting: -11975\n" +
                             "        and got: " + g30.subtract( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 085: Subtracting g30 take away g31 [928 - (-9283)]: " );
      try {
         System.out.println( "      expecting: 10211\n" +
                             "        and got: " + g30.subtract( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 086: Subtracting g31 take away g30 [(-9283) - 928]: " );
      try {
         System.out.println( "      expecting: -10211\n" +
                             "        and got: " + g31.subtract( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 087: Subtracting g32 take away g33 [189 - 00005]: " );
      try {
         System.out.println( "      expecting: 184\n" +
                             "        and got: " + g32.subtract( g33 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 088: Subtracting g33 take away g32 [00005 - 189]: " );
      try {
         System.out.println( "      expecting: -184\n" +
                             "        and got: " + g33.subtract( g32 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 089: Subtracting g32 take away g34 [189 - 525]: " );
      try {
         System.out.println( "      expecting: -336\n" +
                             "        and got: " + g32.subtract( g34 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 090: Subtracting g34 take away g32 [525 - 189]: " );
      try {
         System.out.println( "      expecting: 336\n" +
                             "        and got: " + g34.subtract( g32 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 091: Subtracting g33 take away g34 [00005 - 525]: " );
      try {
         System.out.println( "      expecting: -520\n" +
                             "        and got: " + g33.subtract( g34 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 092: Subtracting g34 take away g33 [525 - 00005]: " );
      try {
         System.out.println( "      expecting: 520\n" +
                             "        and got: " + g34.subtract( g33 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 093: Subtracting g31 take away g15 [(-9283) - (-10)]: " );
      try {
         System.out.println( "      expecting: -9273\n" +
                             "        and got: " + g31.subtract( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 094: Subtracting g15 take away g31 [(-10) - (-9283)]: " );
      try {
         System.out.println( "      expecting: 9273\n" +
                             "        and got: " + g15.subtract( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 095: Subtracting g34 take away g32 take away g15 [525 - 189 - (-10)]: " );
      try {
         System.out.println( "      expecting: 346\n" +
                             "        and got: " + g15.subtract( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 096: Subtracting g32 take away g15 take away g34 [189 - (-10) - 525]: " );
      try {
         System.out.println( "      expecting: -326\n" +
                             "        and got: " + g15.subtract( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 097: Subtracting g15 take away g34 take away g32 [(-10) - 525 - 189]: " );
      try {
         System.out.println( "      expecting: -724\n" +
                             "        and got: " + g15.subtract( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 098: Subtracting g30 take away itself [928 - 928]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g30.subtract( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n\n    TESTING MULTIPLY() METHOD:\n" +
                          "    ==========================" );

      System.out.println( "\n      Test 099: Multiplying g15 and g31 [(-10) * (-9283)]: " );
      try {
         System.out.println( "      expecting: 92830\n" +
                             "        and got: " + g15.multiply( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 100: Multiplying g31 and g15 [(-9283) * (-10)]: " );
      try {
         System.out.println( "      expecting: 92830\n" +
                             "        and got: " + g31.multiply( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 101: Multiplying g29 and g30 [12903 * 928]: " );
      try {
         System.out.println( "      expecting: 11973984\n" +
                             "        and got: " + g29.multiply( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 102: Multiplying g30 and g29 [928 * 12903]: " );
      try {
         System.out.println( "      expecting: 11973984\n" +
                             "        and got: " + g30.multiply( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 103: Multiplying g30 and g31 [928 * (-9283)]: " );
      try {
         System.out.println( "      expecting: -8614624\n" +
                             "        and got: " + g30.multiply( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 104: Multiplying g31 and g30 [(-9283) * 928]: " );
      try {
         System.out.println( "      expecting: -8614624\n" +
                             "        and got: " + g31.multiply( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 105: Multiplying g5and g31 [0 * (-9283)]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g5.multiply( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 106: Multiplying g31 and g5[(-9283) * 0]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g31.multiply( g5) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 107: Multiplying g31, g3, g30, and g5[(-9283) * 00005 * 928 * 0]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g31.multiply( g5) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 108: Multiplying g31, g3, and g30[(-9283) * 00005 * 928]: " );
      try {
         System.out.println( "      expecting: -43073120\n" +
                             "        and got: " + g31.multiply( g5) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 109: Multiplying g32 and g33 [189 * 00005]: " );
      try {
         System.out.println( "      expecting: 945\n" +
                             "        and got: " + g32.multiply( g33 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 110: Multiplying g33 and g32 [00005 * 189]: " );
      try {
         System.out.println( "      expecting: 945\n" +
                             "        and got: " + g33.multiply( g32 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 111: Multiplying g32 and g34 [189 * 525]: " );
      try {
         System.out.println( "      expecting: 99225\n" +
                             "        and got: " + g32.multiply( g34 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 112: Multiplying g34 and g32 [525 * 189]: " );
      try {
         System.out.println( "      expecting: 99225\n" +
                             "        and got: " + g34.multiply( g32 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 113: Multiplying g33 and g34 [00005 * 525]: " );
      try {
         System.out.println( "      expecting: 2625\n" +
                             "        and got: " + g33.multiply( g34 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 114: Multiplying g34 and g33 [525 * 00005]: " );
      try {
         System.out.println( "      expecting: 2625\n" +
                             "        and got: " + g34.multiply( g33 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n\n    TESTING DIVIDE() METHOD:\n" +
                          "    ========================" );
      System.out.println( "\n      Test 115: Dividing g5by g29 [0 / 12903]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g5.divide( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 116: Dividing g29 by g5[12903 / 0]: " );
      try {
         System.out.println( "      expecting: ERROR\n" +
                             "        and got: " + g29.divide( g5) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 117: Dividing g15 by g31 [(-10) / (-9283)]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g15.divide( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 118: Dividing g31 by g15 [(-9283) / (-10)]: " );
      try {
         System.out.println( "      expecting: 928\n" +
                             "        and got: " + g31.divide( g15) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 119: Dividing g30 by g29 [928 / 12903]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g30.divide( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 120: Dividing g29 by g30 [12903 / 928]: " );
      try {
         System.out.println( "      expecting: 13\n" +
                             "        and got: " + g29.divide( g30) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 121: Dividing g30 by g31 [928 / (-9283)]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g30.divide( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 122: Dividing g31 by g30 [(-9283) / 928]: " );
      try {
         System.out.println( "      expecting: -10\n" +
                             "        and got: " + g31.divide( g30) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 123: Dividing g31 by g29 [(-9283) / 12903]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g31.divide( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 124: Dividing g29 by g31 [12903 / (-9283)]: " );
      try {
         System.out.println( "      expecting: -1\n" +
                             "        and got: " + g29.divide( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 125: Dividing g32 by g33 [189 / 00005]: " );
      try {
         System.out.println( "      expecting: 37\n" +
                             "        and got: " + g32.divide( g33 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 126: Dividing g33 by g32 [00005 / 189]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g33.divide( g32 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 127: Dividing g32 by g34 [189 / 525]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g32.divide( g34 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 128: Dividing g34 by g32 [525 / 189]: " );
      try {
         System.out.println( "      expecting: 2\n" +
                             "        and got: " + g34.divide( g32 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 129: Dividing g33 by g34 [00005 / 525]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g33.divide( g34 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 130: Dividing g34 by g33 [525 / 00005]: " );
      try {
         System.out.println( "      expecting: 105\n" +
                             "        and got: " + g34.divide( g33 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }
      System.exit( 0 );

      System.out.println( "\n\n    TESTING REMAINDER() METHOD:\n" +
                          "    ===========================" );
      System.out.println( "\n      Test 131: Modding g29 by g31 [12903 % (-9283)]: " );
      try {
         System.out.println( "      expecting: -5663\n" +
                             "        and got: " + g29.subtract( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 132: Modding g31 by g29 [(-9283) % 12903]: " );
      try {
         System.out.println( "      expecting: 3620\n" +
                             "        and got: " + g31.subtract( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }
      
      System.out.println( "\n      Test 133: Modding g29 by g30 [12903 % 928]: " );
      try {
         System.out.println( "      expecting: 839\n" +
                             "        and got: " + g29.subtract( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 134: Modding g30 by g29 [928 % 12903]: " );
      try {
         System.out.println( "      expecting: 928\n" +
                             "        and got: " + g30.subtract( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 135: Modding g30 by g31 [928 % (-9283)]: " );
      try {
         System.out.println( "      expecting: -8355\n" +
                             "        and got: " + g30.subtract( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 136: Modding g31 by g30 [(-9283) % 928]: " );
      try {
         System.out.println( "      expecting: 925\n" +
                             "        and got: " + g31.subtract( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 137: Modding g32 by g33 [189 % 00005]: " );
      try {
         System.out.println( "      expecting: 5\n" +
                             "        and got: " + g32.subtract( g33 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 138: Modding g33 by g32 [00005 % 189]: " );
      try {
         System.out.println( "      expecting: 5\n" +
                             "        and got: " + g33.subtract( g32 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 139: Modding g32 by g34 [189 % 525]: " );
      try {
         System.out.println( "      expecting: 189\n" +
                             "        and got: " + g32.subtract( g34 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 140: Modding g34 by g32 [525 % 189]: " );
      try {
         System.out.println( "      expecting: 147\n" +
                             "        and got: " + g34.subtract( g32 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 141: Modding g33 by g34 [00005 % 525]: " );
      try {
         System.out.println( "      expecting: 5\n" +
                             "        and got: " + g33.subtract( g34 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 142: Modding g34 by g33 [525 % 00005]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g34.subtract( g33 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 143: Modding g31 by g15 [(-9283) % (-10)]: " );
      try {
         System.out.println( "      expecting: -3\n" +
                             "        and got: " + g31.subtract( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

      System.out.println( "\n      Test 144: Modding g15 by g31 [(-10) % (-9283)]: " );
      try {
         System.out.println( "      expecting: -10\n" +
                             "        and got: " + g15.subtract( g31 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }

   }
}
