/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  A. Volosin
 * Date       :  2019-03-01
 * Description:  @see <a href='http://volosin.lmu.build/alissa-volosin/cmsi-186-programming-lab/cmsi-186-assignments/assignment-06/'>Assignment 06</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2019-03-01  A. Volosin    Initial writing and begin coding
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;
import java.io.IOException;

public class BrobInt {

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

  /// Some constants for other intrinsic data types
  ///  these can help speed up the math if they fit into the proper memory space
   public static final BrobInt MAX_INT  = new BrobInt( Integer.valueOf( Integer.MAX_VALUE ).toString() );
   public static final BrobInt MIN_INT  = new BrobInt( Integer.valueOf( Integer.MIN_VALUE ).toString() );
   public static final BrobInt MAX_LONG = new BrobInt( Long.valueOf( Long.MAX_VALUE ).toString() );
   public static final BrobInt MIN_LONG = new BrobInt( Long.valueOf( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   public  String internalValue = "";        // internal String representation of this BrobInt
   public  byte   sign          = 0;         // "0" is positive, "1" is negative
   private String reversed      = "";        // the backwards version of the internal String representation
   private byte[] byteVersion = null;
   private boolean sub = false;
   private boolean add = false;

   private static final boolean DEBUG_ON = false;
   private static final boolean INFO_ON  = false;

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt( String value ) {
    // Complete the code to accomplish what is in the javadoc text
   	// set an internal value equal to value to store it where other methods can access it
   	internalValue = value;
   	// store reversed string value
    reversed = new StringBuffer(value).reverse().toString();

   	// store the sign
   	if (internalValue.charAt(0) == '-') {
   		sign = 1;
   		reversed = reversed.substring(0, reversed.length() - 1);
   	} else if (internalValue.charAt(0) == '+') {
   		sign = 0;
   		reversed = reversed.substring(0, reversed.length() - 1);
   	} else {
   		sign = 0;
   	}
   	validateDigits();
    
    byteVersion = new byte[reversed.length()];
    // for each character in reversed, add that character to corresponding index in byteVersion as a byte
    for (int i=0; i<reversed.length(); i++) {
    	byteVersion[i] = (byte) Character.getNumericValue(reversed.charAt(i));
    }

   }

  
   /**  
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   */
   public boolean validateDigits() {
   	for (int i=0; i<reversed.length();i++) {
		if (Character.isDigit(reversed.charAt(i)) == false) {
    		throw new IllegalArgumentException( "Not a valid input. There is a character in the value that is not a digit." );
   		}
   	}
   	return true;
   }

  /**
   *  Method to add the value of a BrobInt passed as argument to this BrobInt
   *  @param  bint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   */
   public BrobInt add( BrobInt bint ) {
   	int i=0;
   	if (add) {
   		byte[] a = this.byteVersion;
   		byte[] b = bint.byteVersion;
   		byte[] c = new byte[Math.max(a.length,b.length) + 2]; //+2 to account for carrying
   		add = false;

   		byte carry = 0;
		if (a.length > b.length){
			for (i=0; i<b.length; i++) {
				c[i] =  (byte) (a[i] + b[i] + carry);
				if (c[0] > 9) {
					c[i] = (byte) (c[i] - 10);
					carry = 1;
				} else {
					carry = 0;
				}
			}
			for (i=b.length; i<a.length; i++) {
				c[i] = (byte) (a[i] + carry);
				if (c[0] > 9) {
					c[i] = (byte) (c[i] - 10);
					carry = 1;
				} else {
					carry = 0;
				}
			}
			if (carry == 1) {
				c[i+1] = carry;
			}
		} else if (a.length < b.length) {
			for (i=0; i<a.length; i++) {
				c[i] = (byte) (a[i] + b[i] + carry);
				if (c[0] > 9) {
					c[i] = (byte) (c[i] - 10);
					carry = 1;
				} else {
					carry = 0;
				}
			}
			for (i=a.length; i<b.length; i++) {
				c[i] = (byte) (b[i] + carry);
				if (c[0] > 9) {
					c[i] = (byte) (c[i] - 10);
					carry = 1;
				} else {
					carry = 0;
				}
			}
			if (carry == 1) {
				c[i+1] = carry;
			}
		} else {
			for (i=0; i<a.length; i++) {
				c[i] = (byte) (a[i] + b[i] + carry);
				if (c[0] > 9) {
					c[i] = (byte) (c[i] - 10);
					carry = 1;
				} else {
					carry = 0;
				}
			}
		}
		StringBuffer sbSum = new StringBuffer();
		for (i=0; i<c.length; i++) {
    		sbSum.append(c[i]);
		}
		if (this.sign == 1 && bint.sign == 0) {
			sbSum.append('-');
		}
		String stringSum = new StringBuilder(sbSum).reverse().toString();
		BrobInt sum = new BrobInt(stringSum);
		return removeLeadingZeros(sum);
		
   	} else {
	   	if (this.sign != bint.sign) {
	   		if (this.compareTo(bint) == 0) {
	   			return ZERO;
	   		} else if (this.compareTo(bint) == 1) {
	   			sub = true;
	   			return this.subtract(bint);
	   		} else {
	   			sub = true;
	   			return bint.subtract(this);
	   		}
	   	} else {
	   		byte[] a = this.byteVersion;
	   		byte[] b = bint.byteVersion;
	   		byte[] c = new byte[Math.max(a.length,b.length) + 2]; //+2 to account for carrying
	   		byte carry = 0;
			if (a.length > b.length){
				for (i=0; i<b.length; i++) {
					c[i] =  (byte) (a[i] + b[i] + carry);
					if (c[i] > 9) {
						c[i] = (byte) (c[i] - 10);
						carry = 1;
					} else {
						carry = 0;
					}
				}
				for (i=b.length; i<a.length; i++) {
					c[i] = (byte) (a[i] + carry);
					if (c[i] > 9) {
						c[i] = (byte) (c[i] - 10);
						carry = 1;
					} else {
						carry = 0;
					}
				}
				if (carry != 0) {
					c[i+1] = carry;
				}
			} else if (a.length < b.length) {
				for (i=0; i<a.length; i++) {
					c[i] = (byte) (a[i] + b[i] + carry);
					if (c[i] > 9) {
						c[i] = (byte) (c[i] - 10);
						carry = 1;
					} else {
						carry = 0;
					}
				}
				for (i=a.length; i<b.length; i++) {
					c[i] = (byte) (b[i] + carry);
					if (c[i] > 9) {
						c[i] = (byte) (c[i] - 10);
						carry = 1;
					} else {
						carry = 0;
					}
				}
				if (carry == 1) {
					c[i+1] = carry;
				}
			} else {
				for (i=0; i<a.length; i++) {
					c[i] = (byte) (a[i] + b[i] + carry);
					if (c[i] > 9) {
						c[i] = (byte) (c[i] - 10);
						carry = 1;
					} else {
						carry = 0;
					}
				}
				if (carry == 1) {
					c[i] = carry;
				}
			}
			StringBuffer sbSum = new StringBuffer();
			for (i=0; i<c.length; i++) {
	    		sbSum.append(c[i]);
			}
			if (this.sign == 1 && bint.sign == 1) {
				sbSum.append('-');
			}
			String stringSum = new StringBuilder(sbSum).reverse().toString();
			BrobInt sum = new BrobInt(stringSum);
			return removeLeadingZeros(sum);
	   	}
   	}
   }


  /** 
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   */
   public BrobInt subtract( BrobInt bint ) {
   	if (sub) {
   		byte[] a = this.byteVersion;
	   	byte[] b = bint.byteVersion;
	   	byte[] c = new byte[Math.max(a.length,b.length)];
	   	sub = false;

	   	boolean borrow = false;
   		if (a.length > b.length) {
	   		for (int i=0; i<b.length; i++) {
	   			if (borrow) {
	   				if (a[i+1] != 0) {
	   					a[i+1] -= 1;
	   					borrow = false;
	   				} else {
	   					a[i+1] = 9;
	   				}
	   			}
		        if (a[i] == b[i]) {         	// if digit in a and b are equal, c is 0
		           c[i] = 0;
		        } else if ( a[i] < b[i] ) {  	// if digit in a is less than b
		            c[i] = (byte) (a[i] + 10 - b[i]); 	// add 10 to a and substract b
		            if (a[i+1] != 0) {
		            	a[i+1] -= 1;     	 	// borrow from the next index in a
		            } else {
		            	a[i+1] = 9;
		            	borrow = true;
		            }
				       	 // NOTE that you need a loop here in the case that the next index is a 0
		                                     	// or if the next few digits are 0
		        } else {
		            c[i] = (byte) (a[i] - b[i]);
		        }
	    	}
	    	for (int i=b.length; i<a.length; i++){
	    		if (borrow) {
	   				if (a[i+1] != 0) {
	   					a[i+1] -= 1;
	   					borrow = false;
	   				} else {
	   					a[i+1] = 9;
	   				}
	   			}
	   			c[i] = (byte) a[i];
	    	}
	    	StringBuffer sbDif = new StringBuffer();
			for (int i=0; i<c.length; i++) {
				sbDif.append(c[i]);
			}
			if (this.sign == 1 && bint.sign == 0) {
				sbDif.append('-');
			}
			String stringDif = new StringBuilder(sbDif).reverse().toString();
			BrobInt dif = new BrobInt(stringDif);
			return removeLeadingZeros(dif);
    	} else {
    		for (int i=0; i<a.length; i++) {
	   			if (borrow) {
	   				if (b[i+1] != 0) {
	   					b[i+1] -= 1;
	   					borrow = false;
	   				} else {
	   					b[i+1] = 9;
	   				}
	   			}
		        if (a[i] == b[i]) {         	// if digit in a and b are equal, c is 0
		           c[i] = 0;
		        } else if ( b[i] < a[i] ) {  	// if digit in b is less than a
		            c[i] = (byte) (b[i] + 10 - a[i]); 	// add 10 to b and substract a
		            if (b[i+1] != 0) {
		            	b[i+1] -= 1;     	 	// borrow from the next index in b
		            } else {
		            	b[i+1] = 9;
		            	borrow = true;
		            }
				       	 // NOTE that you need a loop here in the case that the next index is a 0
		                                     	// or if the next few digits are 0
		        } else {
		            c[i] = (byte) (b[i] - a[i]);
		        }
	    	}
	    	for (int i=a.length; i<b.length; i++){
	    		if (borrow) {
	   				if (b[i+1] != 0) {
	   					b[i+1] -= 1;
	   					borrow = false;
	   				} else {
	   					b[i+1] = 9;
	   				}
	   			}
	   			c[i] = (byte) b[i];
	    	}
	    	StringBuffer sbDif = new StringBuffer();
			for (int i=0; i<c.length; i++) {
				sbDif.append(c[i]);
			}
			if (this.sign == 0 && bint.sign == 1) {
				sbDif.append('-');
			}
			String stringDif = new StringBuilder(sbDif).reverse().toString();
			BrobInt dif = new BrobInt(stringDif);
			return removeLeadingZeros(dif);

    	}
   	} else {
   		if (this.equals(bint)) {
	   			return ZERO;
	   		}
   		if (this.sign != bint.sign) {
   			add = true;
   			return this.add(bint);
	   	} else {
	   		byte[] a = this.byteVersion;
		   	byte[] b = bint.byteVersion;
		   	byte[] c = new byte[Math.max(a.length,b.length)];

		   	boolean borrow = false;
	   		if (this.compareTo(bint)==1) {
		   		for (int i=0; i<b.length; i++) {
		   			if (borrow) {
		   				if (a[i+1] != 0) {
		   					a[i+1] -= 1;
		   					borrow = false;
		   				} else {
		   					a[i+1] = 9;
		   				}
		   			}
			        if (a[i] == b[i]) {         	// if digit in a and b are equal, c is 0
			           c[i] = 0;
			        } else if ( a[i] < b[i] ) {  	// if digit in a is less than b
			            c[i] = (byte) (a[i] + 10 - b[i]); 	// add 10 to a and substract b
			            if (a[i+1] != 0) {
			            	a[i+1] -= 1;     	 	// borrow from the next index in a
			            } else {
			            	a[i+1] = 9;
			            	borrow = true;
			            }
					       	 // NOTE that you need a loop here in the case that the next index is a 0
			                                     	// or if the next few digits are 0
			        } else {
			            c[i] = (byte) (a[i] - b[i]);
			        }
		    	}
		    	for (int i=b.length; i<a.length; i++){
		    		if (borrow) {
		   				if (a[i+1] != 0) {
		   					a[i+1] -= 1;
		   					borrow = false;
		   				} else {
		   					a[i+1] = 9;
		   				}
		   			}
		   			c[i] = (byte) a[i];
		    	}
		    	StringBuffer sbDif = new StringBuffer();
				for (int i=0; i<c.length; i++) {
    				sbDif.append(c[i]);
				}
				if (this.sign == 1 && bint.sign == 1) {
					sbDif.append('-');
				}
				String stringDif = new StringBuilder(sbDif).reverse().toString();
				BrobInt dif = new BrobInt(stringDif);
				return removeLeadingZeros(dif);
	    	} else {
	    		for (int i=0; i<a.length; i++) {
		   			if (borrow) {
		   				if (b[i+1] != 0) {
		   					b[i+1] -= 1;
		   					borrow = false;
		   				} else {
		   					b[i+1] = 9;
		   				}
		   			}
			        if (a[i] == b[i]) {         	// if digit in a and b are equal, c is 0
			           c[i] = 0;
			        } else if ( b[i] < a[i] ) {  	// if digit in b is less than a
			            c[i] = (byte) (b[i] + 10 - a[i]); 	// add 10 to b and substract a
			            if (b[i+1] != 0) {
			            	b[i+1] -= 1;     	 	// borrow from the next index in b
			            } else {
			            	b[i+1] = 9;
			            	borrow = true;
			            }
					       	 // NOTE that you need a loop here in the case that the next index is a 0
			                                     	// or if the next few digits are 0
			        } else {
			            c[i] = (byte) (b[i] - a[i]);
			        }
		    	}
		    	for (int i=a.length; i<b.length; i++){
		    		if (borrow) {
		   				if (b[i+1] != 0) {
		   					b[i+1] -= 1;
		   					borrow = false;
		   				} else {
		   					b[i+1] = 9;
		   				}
		   			}
		   			c[i] = (byte) b[i];
		    	}
		    	StringBuffer sbDif = new StringBuffer();
				for (int i=0; i<c.length; i++) {
    				sbDif.append(c[i]);
				}
				if (this.sign == 0 && bint.sign == 0) {
					sbDif.append('-');
				}
				String stringDif = new StringBuilder(sbDif).reverse().toString();
				BrobInt dif = new BrobInt(stringDif);
				return removeLeadingZeros(dif);
	    	}
		}
   	}
   }

  /** 
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to multiply this by
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   */
   public BrobInt multiply( BrobInt bint ) {
   	if (this == ZERO || bint == ZERO) {
   		return ZERO;
   	} else{
   		String absA = new StringBuffer(this.reversed).reverse().toString();
   		String absB = new StringBuffer(bint.reversed).reverse().toString();
   		BrobInt a = new BrobInt(absA);
   		BrobInt b = new BrobInt(absB);
   		if (a.compareTo(b) == -1) {
   			absA = new StringBuffer(bint.reversed).reverse().toString();
   			absB = new StringBuffer(this.reversed).reverse().toString();
   			a = new BrobInt(absA);
   			b = new BrobInt(absB);
   		}   		
   		int count = 0;
   		String countS = "";
   		BrobInt countB = ZERO;

   		BrobInt aSum = ZERO;
		while (countB.compareTo(b)==-1) {
			aSum = aSum.add(a);
			count += 1;
			countS = Integer.toString(count);
			countB = new BrobInt(countS);
		}
		if (this.sign != bint.sign) {
			StringBuilder aReverse = new StringBuilder(aSum.reversed).append('-');
			String stringProd = new StringBuilder(aReverse).reverse().toString();
			BrobInt prod = new BrobInt(stringProd);
			return removeLeadingZeros(prod);
		} else {
			return removeLeadingZeros(aSum);
		}	
   	}
   }

  /** 
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  bint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   */
   public BrobInt divide( BrobInt bint ) {
   	if (bint == ZERO) {
   		throw new Error ("Cannot divide by zero!");
   	}
   	String absA = new StringBuffer(this.reversed).reverse().toString();
   	String absB = new StringBuffer(bint.reversed).reverse().toString();
   	BrobInt a = new BrobInt(absA);
   	BrobInt b = new BrobInt(absB);
   	if (a.compareTo(b) == -1) {
   		return ZERO;
   	} else if (this.equals(bint)) {
   		return ONE;
   	} else {
   		int difInt = 0;
   		while ((a.compareTo(b)==1)) {
   			difInt++;
   			a = a.subtract(b);

   		}
   		if (a.compareTo(b) == 0) {
   			difInt++;
   		}
   		if (this.sign != bint.sign) {
   			difInt *= -1;
   		}
   		String difString = Integer.toString(difInt);
   		BrobInt quotient = new BrobInt(difString);
   		return removeLeadingZeros(quotient);
   	}
   }

  /** 
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  bint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   */
   public BrobInt remainder( BrobInt bint ) {
   	if (this.compareTo(bint) == -1) {
		return removeLeadingZeros(this);
   	} else {
   		String absA = new StringBuffer(this.reversed).reverse().toString();
   		String absB = new StringBuffer(bint.reversed).reverse().toString();
   		BrobInt a = new BrobInt(absA);
   		BrobInt b = new BrobInt(absB);
   		BrobInt mod = a.subtract(b.multiply(a.divide(b)));
   		if (this.sign != bint.sign) {
			StringBuilder modReverse = new StringBuilder(mod.reversed).append('-');
			String stringMod = new StringBuilder(modReverse).reverse().toString();
			BrobInt remainder = new BrobInt(stringMod);
	   		return removeLeadingZeros(remainder);
   		} else {
   			return removeLeadingZeros(mod);
   		}
   	}
   }

  /** 
   *  Method to compare a BrobInt passed as argument to this BrobInt
   *  @param  bint  BrobInt to compare to this
   *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
   *  NOTE: this method does not do a lexicographical comparison using the java String "compareTo()" method
   *        It takes into account the length of the two numbers, and if that isn't enough it does a
   *        character by character comparison to determine
   */
   public int compareTo( BrobInt bint ) {

     // remove any leading zeros because we will compare lengths
      String me  = removeLeadingZeros( this ).toString();
      String arg = removeLeadingZeros( bint ).toString();

     // handle the signs here
      if( 1 == sign && 0 == bint.sign ) {
         return -1;
      } else if( 0 == sign && 1 == bint.sign ) {
         return 1;
      } else if( 0 == sign && 0 == bint.sign ) {
        // the signs are the same at this point ~ both positive
        // check the length and return the appropriate value
        //   1 means this is longer than bint, hence larger positive
        //  -1 means bint is longer than this, hence larger positive
         if( me.length() != arg.length() ) {
            return (me.length() > arg.length()) ? 1 : -1;
         }
      } else {
        // the signs are the same at this point ~ both negative
         if( me.length() != arg.length() ) {
            return (me.length() > arg.length()) ? -1 : 1;
         }
      }

     // otherwise, they are the same length, so compare absolute values
      for( int i = 0; i < me.length(); i++ ) {
         Character a = Character.valueOf( me.charAt(i) );
         Character b = Character.valueOf( arg.charAt(i) );
         if( Character.valueOf(a).compareTo( Character.valueOf(b) ) > 0 ) {
            return 1;
         } else if( Character.valueOf(a).compareTo( Character.valueOf(b) ) < 0 ) {
            return (-1);
         }
      }
      return 0;

      // if a (this) > b (bint), returns 1
      // if a (this) < b (bint), returns -1
      // if a (this) == b (bint), returns 0
   }

  /**
   *  Method to check if a BrobInt passed as argument is equal to this BrobInt
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   */
   public boolean equals( BrobInt bint ) {
      return ( (this.sign == bint.sign) && (this.toString().equals( bint.toString() )) );
   }

  /**
   *  Method to return a BrobInt given a long value passed as argument
   *  @param  value    long type number to make into a BrobInt
   *  @return BrobInt  which is the BrobInt representation of the long
   */
   public static BrobInt valueOf( long value ) throws NumberFormatException {
      BrobInt bi = null;
      try { bi = new BrobInt( Long.valueOf( value ).toString() ); }
      catch( NumberFormatException nfe ) { throw new NumberFormatException( "\n  Sorry, the value must be numeric of type long." ); }
      return bi;
   }

  /**
   *  Method to return a String representation of this BrobInt
   *  @return String  which is the String representation of this BrobInt
   */
   public String toString() {
      return internalValue;
   }

  /**
   *  Method to remove leading zeros from a BrobInt passed as argument
   *  @param  bint     BrobInt to remove zeros from
   *  @return BrobInt that is the argument BrobInt with leading zeros removed
   *  Note that the sign is preserved if it exists
   */
   public BrobInt removeLeadingZeros( BrobInt bint ) {
      Character sign = null;
      String returnString = bint.toString();
      int index = 0;

      if( allZeroDetect( bint ) ) {
         return bint;
      }
      if( ('-' == returnString.charAt( index )) || ('+' == returnString.charAt( index )) ) {
         sign = returnString.charAt( index );
         index++;
      }
      if( returnString.charAt( index ) != '0' ) {
         return bint;
      }

      while( returnString.charAt( index ) == '0' ) {
         index++;
      }
      returnString = bint.toString().substring( index, bint.toString().length() );
      if( sign != null ) {
         returnString = sign.toString() + returnString;
      }
      return new BrobInt( returnString );

   }

  /**
   *  Method to return a boolean if a BrobInt is all zeros
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if the BrobInt passed is all zeros, false otherwise
   */
   public boolean allZeroDetect( BrobInt bint ) {
      for( int i = 0; i < bint.toString().length(); i++ ) {
         if( bint.toString().charAt(i) != '0' ) {
            return false;
         }
      }
      return true;
   }

  /**
   *  Method to display an Array representation of this BrobInt as its bytes
   *  @param   d  byte array from which to display the contents
   *  NOTE: may be changed to int[] or some other type based on requirements in code above
   */
   public void toArray( byte[] d ) {
      System.out.println( "Array contents: " + Arrays.toString( d ) );
   }


  /**
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  NOTE:  we don't really care about these, since we test the BrobInt class with the BrobIntTester
   */
   public static void main( String[] args ) {
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );

      BrobInt b1 = null;;
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "147258369789456123" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.getMessage()); }
      try { System.out.println( "   expecting: 147258369789456123\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      System.out.println( "\n    Multiplying 3 by 12: " );
      try { System.out.println( "      expecting: 36\n        and got: " + new BrobInt("3").multiply( new BrobInt("12") ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

	  System.out.println( "\n    Remainder of 5 by 2: " );
      try { System.out.println( "      expecting: 1\n        and got: " + new BrobInt("5").remainder( new BrobInt("2") ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      System.out.println( "\n    Multiplying 3 by 82832833 and adding 1: " );
      try { System.out.println( "      expecting: 248498500\n        and got: " + BrobInt.THREE.multiply( new BrobInt( "82832833" ) ).add( BrobInt.ONE ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      System.exit( 0 );

   }
}
