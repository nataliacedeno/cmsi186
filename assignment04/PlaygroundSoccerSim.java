/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  PlaygroundSoccerSim.java
 *  Purpose       :  A class for kicking an arbitrary number of balls on a playground and detecting a 
 *                   collision or a goal
 *  @author       :  Alissa Volosin
 *  Date          :  2019-08-06
 *  Description   :  Coming soon...
 *  Notes         :  Coming soon...
 *  Warnings      :  None
 *  Exceptions    :  Coming soon...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.3.0  2019-01-05  A. Volosin    Update method code
 *  @version 2.1.0  2020-02-2   A. Volosin    Convert to Playground problem
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.text.DecimalFormat;
import java.util.Arrays;
import java.io.Console;


public class PlaygroundSoccerSim {

  // private data for 
  //    - default playground height and width
	private static double DEFAULT_PLAYGROUND_HEIGHT = 1000;
  private static double DEFAULT_PLAYGROUND_WIDTH = 1000;
  //    - default time slice
	private static double DEFAULT_TIME_SLICE = 1.0;


  // private instance data for
  //    - are any balls still moving (still a chance of a collision)
  private int ballsMoving = 0;
  private int ballsOutOfBounds = 0;
  private int ballsAtRest = 0;
  //    - time slice
	private double timeSlice = DEFAULT_TIME_SLICE;
  //    - playground size
	private double playgroundHeight = DEFAULT_PLAYGROUND_HEIGHT;
  private double playgroundWidth = DEFAULT_PLAYGROUND_WIDTH;
  //    - number of balls
	private int ballCount = 0;
  //    - array of soccer balls
	private Ball[] soccerBalls = null;
  //    - clock
	private Clock c = new Clock();
  private int[] ballsCollided = new int[2];
  private boolean collision = false;
  private int count = 0;

  // You can put a private static final String here that includes the intro message
  //  or how to use the program



   public PlaygroundSoccerSim() {
  
   }

  /**
   *  Method to validate the input arguments
   *  @param arguments String array of the arguments supplied to the program
   */
   public void validateArgsAndSetupSim( String arguments[] ) {

    // if no arguments specified OR if number of arguments is NOT a factor of 4 
    // OR if number of arguments is NOT a factor of 4 plus 1
    // then dispay message about how to run this program, how it works
    if (arguments.length == 0 || arguments.length % 4 == 2 || arguments.length % 4 == 3 || arguments.length == 1) {
    	throw new IllegalArgumentException ("Cannot execute the program. Try running the program with a multiple of 4 arguments.");
    } else if (arguments.length % 4 == 1) {
    	try {
    		timeSlice = c.validateTimeSliceArg(arguments[arguments.length-1]);
    	} catch (NumberFormatException nfe) {
    		System.out.println("Not valid input. Try running the program with a multiple of 4 doubles.");
    	} catch (IllegalArgumentException iae) {
    		System.out.println("Not valid input. Try running the program with a multiple of 4 doubles within reasonable range.");
    	}
    } else if (arguments.length %4 == 0){
    	timeSlice = DEFAULT_TIME_SLICE;
    }
     

    // else if argument count % 4 is 1, assume last is timeslice in seconds
    // try to call validateTimeSliceArg from Clock class
    
    // else if argument count % 4 is 0, there is no optional time slice, use the defualt
                            

    // now handle and validate the ball arguments
    //    - ballCount
    ballCount = (int) Math.floor(arguments.length / 4);
    // populate soccerBall array, similar to DiceSet
    soccerBalls = new Ball[ballCount];

    for (int i=0; i<soccerBalls.length; i++) {
    	try{
    		soccerBalls[i] = new Ball(Double.parseDouble(arguments[i*4]), Double.parseDouble(arguments[i*4+1]), Double.parseDouble(arguments[i*4+2]), Double.parseDouble(arguments[i*4+3]) );
    	} catch (NumberFormatException nfe) {
    		System.out.println("Not a valid input. Arguments must be doubles.");
    	}
    }

    Console console = System.console();

    try {
      String pgSize = console.readLine("Would you like to change the playground size from the default 1000 ft x 1000 ft? (Y/N)  ").trim();
      switch (pgSize) {
        case "Y":
          String pgw = console.readLine("Playground Height: ").trim();
          playgroundWidth = Double.parseDouble(pgw);
          String pgh = console.readLine("Playground Height: ").trim();
          playgroundHeight = Double.parseDouble(pgh);
        case "N":
          break;
        default: 
          System.out.println("Invalid input. Playground is set to default size. \n\n");
          break;
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    // converting args to doubles should be in a try / catch
   }
  /**
   *  method to report the status of the simulation for every clock tick
   *  @param  c  Clock object which keeps track of time
   *  NOTE: this method calls the clock.tick() method to get one second to elapse
   *

  /**
   *  method to move the balls in the soccerBall array
   *
   */
   public void simUpdate() {
    // for each ball
    //  - if the ball is not out of bounds and not at rest, move the ball
    //  - if the ball is out of bounds after the move or at rest, set the ball out of bounds or at rest
    ballsMoving = 0;
    ballsOutOfBounds = 0;
    for (int i=0; i<ballCount; i++) {
      if (soccerBalls[i].isBallOutOfBounds(playgroundWidth,playgroundHeight)){
        ballsOutOfBounds += 1;
      } else if(!soccerBalls[i].isNotStillMoving()) {
        ballsMoving += 1;
        soccerBalls[i].updateSpeedsForOneTick(timeSlice);
        soccerBalls[i].move(timeSlice);
      }
    }
    ballsAtRest = ballCount - (ballsMoving + ballsOutOfBounds);

      
    System.out.println();
    c.tick(timeSlice);
    System.out.println("----------" + c.toString() + "----------");
    System.out.println("Iteration #" + count);
    count += 1;
    System.out.println();
    System.out.println("Number of balls in motion: " + ballsMoving);
    System.out.println("Number of balls at rest in bounds: " + ballsAtRest);
    System.out.println("Number of balls out of bounds: " + ballsOutOfBounds);
    System.out.println();
    for (int i=0; i<ballCount; i++){
      System.out.println("Ball #" + i + " Report...");
      System.out.println(soccerBalls[i].toString());
      System.out.println();
    }
    collisionCheck();
    
   }

  /**
   *  method to check for a collision soccerBall array
   *
   */
   public int[] collisionCheck() {
    // Compare location of each ball, to every other ball in the array (unless the ball is out of bounds)
    // Use the distance formula (from our dart assignment) to determind if the balls have collided
    // balls have colided if their distance is <= the radius of ball 1 plus the radius of ball 2
    
    // you can decide what you want this method to return
    // if it returns an array of integers, perhaps the array should contain the indexes
    // of the two balls that collided
    outer: for ( int i = 0; i < soccerBalls.length - 1; i++ ) {
      for ( int j = i + 1; j < soccerBalls.length; j++) {
        double distance = Math.sqrt(Math.pow((soccerBalls[i].getPosition()[0] - soccerBalls[j].getPosition()[0]),2) + Math.pow((soccerBalls[i].getPosition()[1] - soccerBalls[j].getPosition()[1]),2));
        if ((distance*12)<=(4.45*2)) {
          ballsCollided[0]=i;
          ballsCollided[1]=j;
          collision = true;
          break outer;
        }
      }
    }
      return ballsCollided;
   }


  /**
   *  method to see if the sim should continue
   *  we need at least one ball moving (in bounds) for the sim to continue
   *
   */


   public boolean atLeastOneBallInBoundsAndMoving() {
    if (ballsOutOfBounds<ballCount && ballsMoving>=1) {
      return true;
    } else {
      return false;
    }
   }

  /**
   *  main method of the simulation
   *  @param  args  String array of the command line arguments
   */
   public static void main( String args[] ) {
      //message to user balls created, etc..
      PlaygroundSoccerSim pss = new PlaygroundSoccerSim();
      System.out.println();
      System.out.println();

      System.out.println("   Welcome to PlaygroundSoccerSim.java! \n\n   The objective of this program is to input different balls on a \n   playground and see if any of them collide. To input balls type \n   a multiple of 4 doubles, the first two being the x and y position \n   of the ball and the second two being the x and y velocity of the ball. \n   You can also enter a time slice after all of the balls.");
      System.out.println();
      System.out.println();

      pss.validateArgsAndSetupSim(args);
      
      System.out.println("Playground size: " + pss.playgroundWidth + "ft x " + pss.playgroundHeight + "ft");
      System.out.println("Radius of all balls: 4.45in");
      System.out.println("Time slice: " + pss.timeSlice);
      System.out.println();
      System.out.println("----------" + pss.c.toString() + "----------");
      System.out.println("Iteration #" + pss.count);
      pss.count += 1;
      System.out.println();
      for (int i=0; i<pss.ballCount; i++) {
        if (pss.soccerBalls[i].isBallOutOfBounds(pss.playgroundWidth,pss.playgroundHeight)) {
          pss.ballsOutOfBounds += 1;
        } else if(!pss.soccerBalls[i].isNotStillMoving()) {
          pss.ballsMoving += 1;
          pss.soccerBalls[i].updateSpeedsForOneTick(pss.timeSlice);
          pss.soccerBalls[i].move(pss.timeSlice);
        }
      }
      pss.ballsAtRest = pss.ballCount - (pss.ballsMoving + pss.ballsOutOfBounds);

      System.out.println("Number of balls in motion: " + pss.ballsMoving);
      System.out.println("Number of balls at rest: " + pss.ballsAtRest);
      System.out.println("Number of balls out of bounds: " + pss.ballsOutOfBounds);
      System.out.println();
      pss.collisionCheck();
      while (!pss.collision && pss.atLeastOneBallInBoundsAndMoving()) {
        pss.simUpdate();
      }
      if (pss.collision) {
        System.out.println();
        System.out.println();
        System.out.println("COLLISION BETWEEN BALL #" + pss.collisionCheck()[0] + " AND BALL #" + pss.collisionCheck()[1] + "!!");
        System.out.println();
        System.out.println("Ball #" + pss.collisionCheck()[0] + " Report...");
        System.out.println(pss.soccerBalls[pss.collisionCheck()[0]].toString());
        System.out.println("Ball #" + pss.collisionCheck()[1] + " Report...");
        System.out.println(pss.soccerBalls[pss.collisionCheck()[1]].toString());
        System.out.println();
        System.out.println();
        System.out.println("GAME OVER");
      }
      if (!pss.collision && !pss.atLeastOneBallInBoundsAndMoving()) {
        System.out.println();
        System.out.println();
        System.out.println("NO COLLISION POSSIBLE! \nAll balls are at rest or out of bounds.");
        System.out.println();
        System.out.println();
        System.out.println("GAME OVER");
      }
  }
}

