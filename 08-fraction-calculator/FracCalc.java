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
      //This will loop the whole thing until player typed "quit"
      while(start == true){
      System.out.println("What is the fraction equation you want to calculate: ");
      System.out.println("Or just simply type \"quit\" to exit the game");
      String equation = input.nextLine();
      int yesorno = stop.compareToIgnoreCase(equation);
      if(yesorno == 0){
        start = false;

      }else{
        if(start = true){
        System.out.println("The second operand(fraction) is: " + produceAnswer(equation) + "\n");
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
      //Get all the fraction and operator needed
      int lastIndex = input.length();
      int space1 = input.indexOf(" ");
      String firstFrac = input.substring(0, space1);
      String operator = input.substring(space1 + 1, space1 + 2);
      String secondFrac = input.substring(space1 + 3, lastIndex);

      //Turn them into actual whole number, numerator, and denominator for the first fraction
      int wholeNum1 = wholeNumberIndicator(firstFrac);
      int firstNumerator1 = numeratorIndicator(firstFrac);
      int firstDenominator1 = denominatorIndicator(firstFrac);

      //Turn them into actual whole number, numerator, and denominator for the second fraction

      int wholeNum2 = wholeNumberIndicator(secondFrac);
      int secondNumerator2 = numeratorIndicator(secondFrac);
      int secondDenominator2 = denominatorIndicator(secondFrac);
      //This is print out to accomplish checkpoint 2(Don't know if I should delete this yet)
      String answer = ("Whole: " + wholeNum2 + " Numerator: " + secondNumerator2 + " Denominator: " + secondDenominator2);

      //Determine the operator and change the method to excute upon different operators.
      if(operator.contains("*")){
        System.out.println("The answer is " + multiply(wholeNum1, firstNumerator1, firstDenominator1, wholeNum2, secondNumerator2, secondDenominator2));
      }else
      if(operator.contains("/")){
        System.out.println("The answer is " + division(wholeNum1, firstNumerator1, firstDenominator1, wholeNum2, secondNumerator2, secondDenominator2));
      }

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


    //Creating method to get whole number, numerator, denominator.
    //This method will find whole number in the fraction
    public static int wholeNumberIndicator(String input){
      //Whole number only exists if there is a _in front of that number
      boolean uslash = input.contains("_");
      if(uslash == true){
      int indexUnderSlash = input.indexOf("_");
      String whole = input.substring(0,indexUnderSlash);
      return Integer.parseInt(whole);
    }else{
      return 0;
    }
}//end wholeNumberIndicator method

    //This will execute method to calcaulte numerator in the fraction
    public static int numeratorIndicator(String input){
      //indicates if there is / and _, these will be useful to find the numerator
      boolean slash = input.contains("/");
      boolean underslash = input.contains("_");
      //these if statements will indicates if there is actually a whole number in front of it
      if(underslash == true){
        int uslash1 = input.indexOf("_");
        int indexSlash = input.indexOf("/");
        String secondNumerator = input.substring(uslash1 + 1, indexSlash);
        return Integer.parseInt(secondNumerator);
      }else{
      //if there is slash that means it's a fraction and the index before the slash is the numerator
      if(slash == true){
        int indexSlash = input.indexOf("/");
        String secNumerator = input.substring(0, indexSlash);
        return Integer.parseInt(secNumerator);
        }else{
          int fullInd = input.length();
          String secNumerator = input.substring(0,fullInd);
          return Integer.parseInt(secNumerator);
        }
    }//last bracket of the whole if statement

    }//end numeratorIndicator method

    //This will excute method to indicate the denominator in the fraction
    public static int denominatorIndicator(String input){
      boolean slash = input.contains("/");
      //If there is a slash, the index after the slash must be the denominator
      if(slash == true){
        int indexSlash2 = input.indexOf("/");
        int fullIndex = input.length();
        String secDenominator = input.substring(indexSlash2 + 1, fullIndex);
        return Integer.parseInt(secDenominator);
    }else{
      return 1;
    }
  }//end denominatorIndicator method


    //method to excute multiplication.
    public static String multiply(int wholeNum1, int firstNumerator1, int firstDenominator1, int wholeNum2, int secondNumerator2, int secondDenominator2){

      //Create if statements to react to different situations in multiplying fractions.
      if(wholeNum1 != 0 && wholeNum2 != 0){
        //get rid of the whole number by simplifying the fraction.
        int simplifiedNum1 = (firstDenominator1 * wholeNum1) + firstNumerator1;
        int simplifiedNum2 = (secondDenominator2 * wholeNum2) + secondNumerator2;
        //multiply it after simplifying the fraction
        int answerNumerator = simplifiedNum1 * simplifiedNum2;
        int answerDenominator = firstDenominator1 * secondDenominator2;
        String answer = (answerNumerator + "/" + answerDenominator);
        return answer + " using 1";
      }else
        if(wholeNum1 == 0 && wholeNum2 == 0){
          //simply multiply fraction because there is no whole number in this case.
          int answerNumerator = firstNumerator1 * secondNumerator2;
          int answerDenominator = firstDenominator1 * secondDenominator2;
          String answer = (answerNumerator + "/" + answerDenominator);
          return answer + " using 2";
        //end second if statement
      }else
        if(wholeNum1 > 0 && wholeNum2 == 0){
            //this case only occur when frac1 has whole number that is more than 1, if that happens, it will simplify frac 1
            int simplifiedNum1 = firstDenominator1 * wholeNum1 + firstNumerator1;

            //multiply them after simplifying the fraction
            int answerNumerator = simplifiedNum1 * secondNumerator2;
            int answerDenominator = firstDenominator1 * secondDenominator2;
            String answer = (answerNumerator + "/" + answerDenominator);
            return answer + " using 3";

        }else
          //this case would only happend if frac 2 has a whole number, thus it will simplify it.
            if(wholeNum2 > 0 && wholeNum1 == 0){
              //simplify it
              int simplifiedNum2 = secondDenominator2 * wholeNum2 + secondNumerator2;

              //multiply them after simplifying the fraction
              int answerNumerator = simplifiedNum2 * firstNumerator1;
              int answerDenominator = firstDenominator1 * secondDenominator2;
              String answer = (answerNumerator + "/" + answerDenominator);
              return answer + " using 4";
            }else{
              return "0";
            }//last closing bracket for the whole if statement

          }//end multiply method

          //Created method to execute division
          public static String division(int wholeNum1, int firstNumerator1, int firstDenominator1, int wholeNum2, int secondNumerator2, int secondDenominator2){

            if(wholeNum1 > 0 && wholeNum2 > 0){
              //get rid of the whole number by simplifying the fraction.
              int simplifiedNum1 = (firstDenominator1 * wholeNum1) + firstNumerator1;
              int simplifiedNum2 = (secondDenominator2 * wholeNum2) + secondNumerator2;
              //multiply it after simplifying the fraction
              int answerNumerator = simplifiedNum1 * secondDenominator2;
              int answerDenominator = firstDenominator1 * simplifiedNum2;
              String answer = (answerNumerator + "/" + answerDenominator);
              return answer + " using 1";
            }else
              if(wholeNum1 == 0 && wholeNum2 == 0){
                //simply multiply fraction because there is no whole number in this case.
                int answerNumerator = firstNumerator1 * secondDenominator2;
                int answerDenominator = firstDenominator1 * secondNumerator2;
                String answer = (answerNumerator + "/" + answerDenominator);
                return answer + " using 2";
              //end second if statement
            }else
              if(wholeNum1 > 0 && wholeNum2 == 0){
                  //this case only occur when frac1 has whole number that is more than 1, if that happens, it will simplify frac 1
                  int simplifiedNum1 = firstDenominator1 * wholeNum1 + firstNumerator1;

                  //multiply them after simplifying the fraction
                  int answerNumerator = simplifiedNum1 * secondDenominator2;
                  int answerDenominator = firstDenominator1 * secondNumerator2;
                  String answer = (answerNumerator + "/" + answerDenominator);
                  return answer + " using 3";

              }else
                //this case would only happend if frac 2 has a whole number, thus it will simplify it.
                  if(wholeNum2 > 0 && wholeNum1 == 0){
                    //simplify it
                    int simplifiedNum2 = secondDenominator2 * wholeNum2 + secondNumerator2;

                    //multiply them after simplifying the fraction
                    int answerNumerator = secondDenominator2 * firstNumerator1;
                    int answerDenominator = firstDenominator1 * simplifiedNum2;
                    String answer = (answerNumerator + "/" + answerDenominator);
                    return answer + " using 4";
                  }else{
                    return "0";
                  }//last closing bracket for the whole if statement
          }//end division method

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
