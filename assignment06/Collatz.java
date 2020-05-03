public class Collatz {
   public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
   public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
   public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
   public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
   public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
   public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
   public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
   public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
   public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
   public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
   public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"

   private static int count = 0;

   public static void main(String[] args) {
   	System.out.println( "\n  Welcome to Collatz.java!\n" );
    System.out.println( "\n  The goal of the Collatz sequence is to arrive at 1 given a BrobInt.\n  When the BrobInt is even it is divided by 2. When it is odd\n  it is multiplied by 3 then added with 1.\n\n" );
   	try{
   		if (args.length != 1) {
   			throw new IllegalArgumentException ("Wrong number of arguements! Try again with only one BrobInt.");
   		} else {
   			BrobInt b1 = null;
	    	try { 
	    		System.out.println("  Making a new BrobInt from input: "); 
	    		b1 = new BrobInt( args[0] ); 
	    		System.out.println("  expecting:" + args[0] + "\n  and got: " + b1.toString());
	    		System.out.println();
	    	}
	    	catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }
	    	try {
	    		if (b1.compareTo(ZERO) == 1) {
	    			while (!b1.equals(ONE)) {
			    		if ((b1.remainder(TWO)).equals(ZERO)) { 
			    			b1 = b1.divide(TWO);
			    		} 
			    		else{ 
			    			b1 = ONE.add(THREE.multiply(b1)); 
			    		}
			    		System.out.println(  b1.toString());
			    		count += 1;
			    	}
			    	System.out.println("It takes steps " + count + " to get from " + args[0] + " to 1!!");
	    		} else {
	    			throw new IllegalArgumentException ("Bad input! Try again with a positive BrobInt.");
	    		}
	    	} catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }
   		}
   	} catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }
   			
   }
}