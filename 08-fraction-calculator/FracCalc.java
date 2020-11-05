import java.util.Scanner;
public class FracCalc {

    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
    public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      boolean start = true;
      String stop = "quit";

      while(start == true){
      System.out.println("What is the fraction equation you want to calculate: ");
      String equation = input.nextLine();
      int yesorno = stop.compareToIgnoreCase(equation);
      if(yesorno == 0){
        start = false;

      }else{
        if(start = true){
        System.out.println("The second operand(fraction) is: " + produceAnswer(equation));
      }//end statment for indicating if it will print this above statement.
    }



    }//end while statement
      //if statement to stop the the loop.

        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        // Checkpoint 2: Accept user input multiple times.
    }//end main method

    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
    public static String produceAnswer(String input){
      int lastIndex = input.length();
      int space1 = input.indexOf(" ");
      String firstFrac = input.substring(0, space1);
      String operator = input.substring(space1 + 1, space1 + 2);
      String secondFrac = input.substring(space1 + 3, lastIndex);


      String wholeNum = wholeNumberIndicator(secondFrac);
      String secondNumerator = numeratorIndicator(secondFrac);
      String secondDenominator = denominatorIndicator(secondFrac);

      String answer = ("Whole: " + wholeNum + " Numerator: " + secondNumerator + " Denominator: " + secondDenominator);



      return answer;
        // TODO: Implement this function to produce the solution to the input
        // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
        // Checkpoint 2: Return the second operand as a string representing each part.
        //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".
        //               Note: Answer does not need to be reduced, but it must be correct.
        // Final project: All answers must be reduced.
        //               Example "4/5 * 1_2/4" returns "1_1/5".
        //Integer.parseInt(secondFrac);
    }//end produceAnswer method


    //Creates method to get whole number, numerator, denominator.
    public static String wholeNumberIndicator(String input){
      boolean uslash = input.contains("_");
      if(uslash == true){
      int indexUnderSlash = input.indexOf("_");
      String whole = input.substring(0,indexUnderSlash);
      return whole;
    }else{
      return "0";
    }
}//end wholeNumberIndicator method

    public static String numeratorIndicator(String input){
      boolean slash = input.contains("/");
      boolean underslash = input.contains("_");
      if(underslash == true){
        int uslash1 = input.indexOf("_");
        int indexSlash = input.indexOf("/");
        String secondNumerator = input.substring(uslash1 + 1, indexSlash);
        return secondNumerator;
      }else{
      if(slash == true){
        int indexSlash = input.indexOf("/");
        String secNumerator = input.substring(0, indexSlash);
        return secNumerator;
        }else{
          return "0";
        }
    }//last bracket of the whole if statement

    }//end numeratorIndicator method

    public static String denominatorIndicator(String input){
      boolean slash = input.contains("/");
      if(slash == true){
        int indexSlash2 = input.indexOf("/");
        int fullIndex = input.length();
        String secDenominator = input.substring(indexSlash2 + 1, fullIndex);
        return secDenominator;
    }else{
      return "1";
    }
  }//end denominatorIndicator method


    // TODO: Fill in the space below with helper methods

    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int greatestCommonDivisor(int a, int b){

    //}end greatestCommonDivisor method

    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */
     return 0;
   }
    public static int leastCommonMultiple(int a, int b){
      return 0;
    }//end leastCommonMultiple



}//end class
