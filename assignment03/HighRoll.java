import java.io.Console;

public class HighRoll {
	public static void main (String[] args) {
		int count = 0;
		int sides = 0;
		int highScore = 0;

		if (args.length < 2 || args.length > 2) {
			System.out.print("Not valid input!\n");
            System.out.print("Next time, try entering exactly 2 integers for the number of dice in the set and the number of sides.");
            System.out.println();
			System.exit(-1);
		}

		try {
			count = Integer.parseInt(args[0]);
			sides = Integer.parseInt(args[1]);
		} catch (NumberFormatException nfe) {
			System.out.println("Not a valid input, please try entering integers.");
		}
		DiceSet ds = new DiceSet(count, sides);
		Console console = System.console();

		System.out.println("\n     Welcome to the HighRoll! The goal of this game is to get the highest score.\n");

		while(true) {
			//message to the user, explaining the program
			// print the menu
			// wait for input
			// execute based on user input
			try {
				System.out.println("     Press the 'M' key to display the main menu.");
				System.out.println("     Press the 'H' key for the help menu.");
				System.out.println();
				String command = console.readLine("Choose an option from above or from the main menu. ").trim();
				System.out.println();
	            switch (command) {
	            	case "M":
					 System.out.println("     Press the 'R' key to roll all of the dice in the dice set.");
					 System.out.println("     Press the 'D' key to roll an individual die.");
					 System.out.println("     Press the 'C' key to calculate the current score.");
					 System.out.println("     Press the 'S' key to save the current score as the high score.");
					 System.out.println("     Press the 'Y' key to display the current high score.");
					 System.out.println("     Press the 'N' key to create a new DiceSet.");
      				 System.out.println("     Press the 'Q' key to quit the program.");
      				 System.out.println();
      				 System.out.println();
      				 break;

      				case "H":
      				 System.out.println("  Welcome to HighRoll! \n\n  HighRoll is a game of chance where you create a set of dice and try \n  to get the highest score by selecting options from the main menu.");
      				 System.out.println("\n  How to play: ");
      				 System.out.println("	1. Run HighRoll.java with two inputs. \n 	   The first input being the number of dice in your dice set.\n 	   The second input being the number of sides each die will have.");
      				 System.out.println(" 	2. By choosing options from the main menu, roll your dice and \n 	   attempt to get a high score.");
      				 System.out.println("	3. Once you are happy with your current score(*), set it as \n 	   your high score. \n\n 	   (*) Check your current score using the option from the menu.");
      				 System.out.println();
      				 System.out.println();
      				 break;

      				case "R": 
	               	 System.out.println("  Rolling DiceSet...");
	               	 ds.roll();
	               	 System.out.println("  DiceSet: " + ds.toString());
	               	 System.out.println();
	               	 System.out.println();
	               	 break;

	            	case "D": 
	               	 String d = console.readLine("  Which die would you like to roll? ").trim();
	               	 int die = Integer.parseInt(d);
	               	 System.out.println("  Rolling die number " + die + "...");
	               	 ds.rollIndividual(die);
	               	 System.out.println("  DiceSet: " + ds.toString());
	               	 System.out.println();
	               	 System.out.println();
	               	 break;

	               	case "C": 
	               	 System.out.println("  Calculating current score...");
	               	 System.out.println("  Current score: " + ds.sum()); 
	               	 System.out.println();
	               	 System.out.println();
	              	 break;

	               	case "S":
	               	 System.out.println("  Saving current score as high score..."); 
	               	 highScore = ds.sum();
	               	 System.out.println("  High score: " + highScore);
	               	 System.out.println();
	               	 System.out.println();
	               	 break;

	               	case "Y": 
	               	 System.out.println("  High score: " + highScore);
	               	 System.out.println();
	               	 System.out.println(); 
	               	 break;

	               	case "N":
	               	 String c = console.readLine("  How many dice would you like in your new DiceSet? ").trim();
	               	 count = Integer.parseInt(c);
	               	 String s = console.readLine("  How many sides would you like for your new dice to have? ").trim();
	               	 sides = Integer.parseInt(s);
	               	 ds = new DiceSet(count, sides);
	               	 System.out.println();
	               	 System.out.println();
	               	 break;

	               	case "Q": 
	               	 System.out.println("  Thanks for playing!");
	               	 System.out.println();
	               	 System.exit(0);

	               	default: System.out.println("  Invalid input. Try again.\n\n");
	            }
         	} catch (Exception e) {
            	System.err.println(e.getMessage());
         	}
		}
	}
}