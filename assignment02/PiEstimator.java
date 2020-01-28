/**
 * By Ray Toal
 */

public class PiEstimator {

    public static void main(String[] args) {
        int totalDartThrows = 10000;    // 10000 darts thrown for default
        if (args.length != 1) {
            System.out.print("No arguments supplied: Defaulting to 10000 total darts.\n");
            System.out.print("Next time, try entering an integer for the total number of darts thrown.");
            System.out.println();
        }
        else {
            try {
                totalDartThrows = Integer.parseInt(args[0]);
            } 
            catch (NumberFormatException nfe) {
                System.out.print("Sorry, bad input: Must be an integer number! Please try again.");
                System.exit(-1);
            }
        }
        estimate(totalDartThrows)
    }

    public static double estimate(double darts) {
        double x = Math.random()*2;
        double y = Math.random()*2;
        long numDartsInCircle = 0;
        for (int i=0; i<darts; i++) {
            if (Math.sqrt(Math.pow((x-1),2) + Math.pow((y-1),2)) <= 1){
                numDartsInCircle++;
            }
            x = Math.random()*2;
            y = Math.random()*2;
        }
        return (4 * numDartsInCircle/darts);
    }
}
