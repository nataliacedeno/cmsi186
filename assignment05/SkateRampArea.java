import java.text.DecimalFormat;
public class SkateRampArea {
	
	//constants
	private static final int MINIMUM_POLY_ARG_COUNT = 5;
	private static final int MINIMUM_SIN_ARG_COUNT = 3;
	private static final double DEFAULT_PERCENT = 0.01;
	private static final boolean DEBUG_MODE = true;

	//private instance variables
	//you may need more than there
	private double [] coeffs = null;
	private int numCoeff = 0;
	private double [] midpoint = null;
	private String function = "";
	private double currentArea = 0.0;
	private double previousArea = 0.0;
	private double epsilon = DEFAULT_PERCENT; //epsilon is the % change we are looking for between the currentArea and previousArea
	private double lastArea = 0.0;
	private double prcntChange = 1.0;
	private int numRect = 1;
	private double lowerBound = 0.0;
	private double upperBound = 0.0;
	private DecimalFormat df = new DecimalFormat ("#00.0000");

	/**
	* Constructor method
	*/

	public SkateRampArea () {

	}

	/**
	* method to validate the arguments that are passed on the command line and set up all the values to calculate
	* @param args String array which contains command line arguments
	* @throws IllegalArgumentException when there is something; may be thrown manually or automatically
	*/

	public void validateArgsAndSetupIntegration(String [] args) {
		int i = 0;
		String[] functions = {"poly", "Poly", "POLY", "sin", "Sin", "SIN"};

		//check if there are enough arguments to meet the minimum, throw an exception if not
			//if 0 args, throw an error
		if (args.length < 3) {
			throw new IllegalArgumentException ("Cannot execute the program. Try running again with at least the function type, coefficients of x, and bounds.");
		}

		function = args[0];
			//if function is poly, there must be at least 5 args (func, at least 2 coeff or x, lb, ub)
			//if function is sin, there must be at least 3 args (func, lb, ub)
			//if function is not poly or sin (or capitalized versions), throw an error
		if (function.equals(functions[0]) || function.equals(functions[1]) || function.equals(functions[2])) {
			function = "poly";
			if (args.length < 5) {
				throw new IllegalArgumentException ("Not valid input. Try running again with 5 or more arguments for the polynomial function.");
			}

		} else if (function.equals(functions[3]) || function.equals(functions[4]) || function.equals(functions[5])) {
			function = "sin";
			if (args.length < 3) {
				throw new IllegalArgumentException ("Not valid input. Try running again with 3 or more arguments for the sine function.");
			}
		} else {
			throw new IllegalArgumentException ("Not valid input. Function must be either poly or sin.");
		}
			
		//converts the last arguments to their number
		if (args[args.length -1].contains("%")) {
			//now that we know there is a % in the last arg, make sure you have the correct num of args f
				//poly - need at least 6 args total
				//sin - need 4 args
			numCoeff = args.length - 4;
			if (function == "poly" && args.length < 6) {
				throw new IllegalArgumentException ("Not valid input. Try running again with 5 or more arguments before the percent for the polynomial function.");
			} else if (function == "sin" && args.length != 4) {
				throw new IllegalArgumentException ("Not valid input. Try running again with 3 or more arguments before the percent for the sine function.");
			}
			//check to see if there is a % in the last arg
			//if so
			try {
				epsilon = (Double.parseDouble( args[args.length - 1].substring( 0, args[args.length - 1].length() - 1))) / 100.0;
				if (Double.parseDouble(args[args.length - 2]) > Double.parseDouble(args[args.length - 3])) {
					upperBound = Double.parseDouble(args[args.length - 2]);
					lowerBound = Double.parseDouble(args[args.length - 3]);
				} else {
					upperBound = Double.parseDouble(args[args.length - 3]);
					lowerBound = Double.parseDouble(args[args.length - 2]);
				}
			} catch(NumberFormatException nfe) {
    			System.out.println("Not a valid input. Arguments must be doubles.");
			}
		} else {
			//last arg is ub
			//second to last arg is lb
			//ub and lb should be parsed to doubles in try/catch
			//make sure that ub and lb are in numerical order, or else flip them or throw an error
			numCoeff = args.length - 3;
			try {
				if (Double.parseDouble(args[args.length - 1]) > Double.parseDouble(args[args.length - 2])) {
					upperBound = Double.parseDouble(args[args.length - 1]);
					lowerBound = Double.parseDouble(args[args.length - 2]);
				} else {
					upperBound = Double.parseDouble(args[args.length - 2]);
					lowerBound = Double.parseDouble(args[args.length - 1]);
				}
			} catch(NumberFormatException nfe) {
    			System.out.println("Not a valid input. Arguments must be doubles.");
			}

		}

		//if function is poly and there is not a %, figure out how many coeff there are based on args.length as numCoeff
			//do some variation of the loop below to populate your coeff array with coefficients of x
			//make sure this is in a try/catch since you are using Double.parseDouble()
		coeffs = new double[numCoeff];
		try {
			for(i=0; i<numCoeff; i++) {
				coeffs[i] = Double.parseDouble(args[i+1]);
			}
		} catch (NumberFormatException nfe) {
    			System.out.println("Not a valid input. Arguments must be doubles.");
    	}
		//if function is poly and there is not a %, you will do some variation of the loop above with a different value for numCoeff
	}

	/**
	* Method to calculate the are under a poly curve given the lower bound, upper bound, coefficients and the number of rectangles
	* @param lb double the lower bound
	* @param ub double which contains command line arguments
	* @param coefficients double array which contains command line arguments
	* @param n int the number of rectangles to use in this estimation
	* @return IllegalArgumentException when there is something wrong; may be thrown manually or automatically
	*/


	public double calculateArea(double lb, double ub, double[] coefficients, int n) {
		//you likely need to initialize some variables here like midpoint, total area and yCoord
		midpoint = new double[n];
		double totalArea = 0.0;

		//find length of rectangles
		double rectLength = (ub-lb)/n;
		
		//for each rectangle
			//find the midpoint
			//for each coefficient
				//add the (coefficient * Math.pow(midpoint, index of coeff)) to the yCoord
			//add the (yCoord * length) to the total area
		//return the total area
		for (int j=0; j<n; j++) {
			double yCoord = 0.0;
			midpoint[j] = lb + ((rectLength/2)*(((j+1)*2)-1));
			if (function.equals("poly")) {
				for (int k=0; k<numCoeff; k++) {
					yCoord += (coeffs[k] * Math.pow(midpoint[j], k));
				}

			} else if (function.equals("sin")) {
				yCoord = Math.sin(midpoint[j]);
			}
			totalArea += (yCoord * rectLength);
		}
		return totalArea;
	}

	public static void runTests() {
		SkateRampArea sra = new SkateRampArea();
		System.out.println("Testing validateArgsAndSetupIntegration() for polynomial...");
		try{
			String[] array = {"poly", "1", "8", "-2", "1", "4"};
			sra.validateArgsAndSetupIntegration(array);
			System.out.println("Done.");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} 
		System.out.println();
		System.out.println();

		System.out.println("Testing validateArgsAndSetupIntegration() for polynomial with all uppercase...");
		try{
			String[] array = {"POLY", "13", "4", "5", "1", "6", "12"};
			sra.validateArgsAndSetupIntegration(array);
			System.out.println("Done.");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} 
		System.out.println();
		System.out.println();

		System.out.println("Testing validateArgsAndSetupIntegration() for polynomial with 3 arguments...");
		try{
			String[] array = {"poly", "3", "-4"};
			sra.validateArgsAndSetupIntegration(array);
			System.out.println("Done.");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} 
		System.out.println();
		System.out.println();

		System.out.println("Testing validateArgsAndSetupIntegration() for polynomial with flipped upper and lower bounds...");
		try{
			String[] array = {"poly", "5", "-12", "-1", "8", "3"};
			sra.validateArgsAndSetupIntegration(array);
			System.out.println("Done.");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} 
		System.out.println();
		System.out.println();

		System.out.println("Testing validateArgsAndSetupIntegration() for polynomial with percent...");
		try{
			String[] array = {"poly", "3", "1", "-7", "2", "-5", "1", "10%"};
			sra.validateArgsAndSetupIntegration(array);
			System.out.println("Done.");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} 
		System.out.println();
		System.out.println();

		System.out.println("Testing validateArgsAndSetupIntegration() for sine...");
		try{
			String[] array = {"sin", "1", "4"};
			sra.validateArgsAndSetupIntegration(array);
			System.out.println("Done.");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} 
		System.out.println();
		System.out.println();

		System.out.println("Testing validateArgsAndSetupIntegration() for sine with all uppercase...");
		try{
			String[] array = {"SIN", "3.14159", "10"};
			sra.validateArgsAndSetupIntegration(array);
			System.out.println("Done.");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} 
		System.out.println();
		System.out.println();

		System.out.println("Testing validateArgsAndSetupIntegration() for sine 2 arguments...");
		try{
			String[] array = {"sin", "-2"};
			sra.validateArgsAndSetupIntegration(array);
			System.out.println("Done.");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} 
		System.out.println();
		System.out.println();

		System.out.println("Testing validateArgsAndSetupIntegration() for sine with flipped upper and lower bounds...");
		try{
			String[] array = {"sin", "8", "3"};
			sra.validateArgsAndSetupIntegration(array);
			System.out.println("Done.");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} 
		System.out.println();
		System.out.println();

		System.out.println("Testing validateArgsAndSetupIntegration() for sine with percent...");
		try{
			String[] array = {"sin", "-1", "1", "5%"};
			sra.validateArgsAndSetupIntegration(array);
			System.out.println("Done.");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} 
		System.out.println();
		System.out.println();




		System.out.println("Testing calculateArea() for polynomial...");
		try{
			String[] array = {"poly", "2", "-5", "7", "3", "9"};
			sra.validateArgsAndSetupIntegration(array);
			sra.currentArea = sra.calculateArea(sra.lowerBound, sra.upperBound, sra.coeffs, sra.numRect);
				while (sra.prcntChange > sra.epsilon) {
				sra.previousArea = sra.currentArea;
				sra.numRect += 1;
				sra.currentArea = sra.calculateArea(sra.lowerBound, sra.upperBound, sra.coeffs, sra.numRect);
			
				sra.prcntChange = Math.abs((sra.currentArea - sra.previousArea)/sra.previousArea);
				}

				System.out.println();
				System.out.println("Number of iterations/rectangles: " + sra.numRect);
				System.out.println("Area: " + sra.currentArea);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		System.out.println();
		System.out.println();

		System.out.println("Testing calculateArea() for polynomial with percent...");
		try{
			String[] array = {"poly", "3", "-4", "9", "1", "6", "3%"};
			sra.validateArgsAndSetupIntegration(array);
			sra.currentArea = sra.calculateArea(sra.lowerBound, sra.upperBound, sra.coeffs, sra.numRect);
				while (sra.prcntChange > sra.epsilon) {
				sra.previousArea = sra.currentArea;
				sra.numRect += 1;
				sra.currentArea = sra.calculateArea(sra.lowerBound, sra.upperBound, sra.coeffs, sra.numRect);
			
				sra.prcntChange = Math.abs((sra.currentArea - sra.previousArea)/sra.previousArea);
				}

				System.out.println();
				System.out.println("Number of iterations/rectangles: " + sra.numRect);
				System.out.println("Area: " + sra.currentArea);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		System.out.println();
		System.out.println();

		System.out.println("Testing calculateArea() for sine...");
		try{
			String[] array = {"sin", "2", "7"};
			sra.validateArgsAndSetupIntegration(array);
			sra.currentArea = sra.calculateArea(sra.lowerBound, sra.upperBound, sra.coeffs, sra.numRect);
				while (sra.prcntChange > sra.epsilon) {
				sra.previousArea = sra.currentArea;
				sra.numRect += 1;
				sra.currentArea = sra.calculateArea(sra.lowerBound, sra.upperBound, sra.coeffs, sra.numRect);
			
				sra.prcntChange = Math.abs((sra.currentArea - sra.previousArea)/sra.previousArea);
				}

				System.out.println();
				System.out.println("Number of iterations/rectangles: " + sra.numRect);
				System.out.println("Area: " + sra.currentArea);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		System.out.println();
		System.out.println();

		System.out.println("Testing calculateArea() for sine with percent...");
		try{
			String[] array = {"sin", "5", "12", "12%"};
			sra.validateArgsAndSetupIntegration(array);
			sra.currentArea = sra.calculateArea(sra.lowerBound, sra.upperBound, sra.coeffs, sra.numRect);
				while (sra.prcntChange > sra.epsilon) {
				sra.previousArea = sra.currentArea;
				sra.numRect += 1;
				sra.currentArea = sra.calculateArea(sra.lowerBound, sra.upperBound, sra.coeffs, sra.numRect);
			
				sra.prcntChange = Math.abs((sra.currentArea - sra.previousArea)/sra.previousArea);
				}

				System.out.println();
				System.out.println("Number of iterations/rectangles: " + sra.numRect);
				System.out.println("Area: " + sra.currentArea);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		System.out.println();
		System.out.println();
	}

	/**
	* The main method that runs the program
	* @param args String array which contains command line arguments
	*/

	public static void main (String[] args) {
		if (args[0].equals("runtests")) {
			runTests();
		} else {
			SkateRampArea r = new SkateRampArea();

			try {
				r.validateArgsAndSetupIntegration(args);
				r.currentArea = r.calculateArea(r.lowerBound, r.upperBound, r.coeffs, r.numRect);
				while (r.prcntChange > r.epsilon) {
				r.previousArea = r.currentArea;
				r.numRect += 1;
				r.currentArea = r.calculateArea(r.lowerBound, r.upperBound, r.coeffs, r.numRect);
			
				r.prcntChange = Math.abs((r.currentArea - r.previousArea)/r.previousArea);
				}

				System.out.println();
				System.out.println("Number of iterations/rectangles: " + r.numRect);
				System.out.println("Area: " + r.currentArea);
				System.out.println();
				System.out.println();

			} catch(IllegalArgumentException iae) {
				System.out.println(iae.getMessage());
				System.exit(-1);
			}
		}
		
	}
}