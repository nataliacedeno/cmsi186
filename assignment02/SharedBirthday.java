/**
 * By Ray Toal
 */



public class SharedBirthday {

    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                throw new IllegalArgumentException("Exactly three arguments required");
            }
            int people = Integer.parseInt(args[0]);
            int days = Integer.parseInt(args[1]);
            int trials = Integer.parseInt(args[2]);
            System.out.println(probabilityEstimate(people, days, trials));
        } catch (NumberFormatException e) {
            System.err.println("Arguments must all be integers");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static double probabilityEstimate(int people, int days, int trials) {
        //
        // TODO: Do the main work here. I've just returned 0.0 as a place holder
        // so the code compiles. It isn't right though. Remove the return here and
        // implement the whole method on your own.
        //
        int[] dayArray = new int[days];
        int max = days - 1;
        int min = 0;
        int successfulTrials = 0;

        for (int t=0; t<trials; t++) {
            int sharedBdayCount = 0;
            for (int d=0; d<days; d++) {
                dayArray[d] = 0;
        }
            for (int p=0; p<people; p++) {
                int bday = (int) Math.floor(Math.random() * (max - min + 1)) + min;
                dayArray[bday]++;
            }
            for (int a=0; a<dayArray.length; a++) {
                if (dayArray[a] > 1) {
                    sharedBdayCount++;
                }
            }
            if (sharedBdayCount >= 1) {
                successfulTrials++;
            }
        }
        
        return (double) successfulTrials/trials;
    }

    //
    // TODO: Don't be afraid to write private helper methods to keep your code modular.
    //
}
