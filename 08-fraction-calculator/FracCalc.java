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

      //Determine the operator and change the method to excute based upon different operators.
      if(operator.contains("*")){
        System.out.println("The answer is " + multiply(wholeNum1, firstNumerator1, firstDenominator1, wholeNum2, secondNumerator2, secondDenominator2,improperNumerator(wholeNum1, firstNumerator1, firstDenominator1),improperNumerator(wholeNum2, secondNumerator2, secondDenominator2)));
      }else
      if(operator.contains("/")){
        System.out.println("The answer is " + division(wholeNum1, firstNumerator1, firstDenominator1, wholeNum2, secondNumerator2, secondDenominator2,improperNumerator(wholeNum1, firstNumerator1, firstDenominator1),improperNumerator(wholeNum2, secondNumerator2, secondDenominator2)));
      }else
      if(operator.contains("+") && firstDenominator1 != secondDenominator2){
        System.out.println("The answer is " + addDifferentDenominator(wholeNum1, firstNumerator1, firstDenominator1, wholeNum2, secondNumerator2, secondDenominator2,improperNumerator(wholeNum1, firstNumerator1, firstDenominator1),improperNumerator(wholeNum2, secondNumerator2, secondDenominator2)));
      }else
      if(operator.contains("+") && firstDenominator1 == secondDenominator2){
        System.out.println("The answer is " + addSameDenominator(wholeNum1, firstNumerator1, firstDenominator1, wholeNum2, secondNumerator2, secondDenominator2,improperNumerator(wholeNum1, firstNumerator1, firstDenominator1),improperNumerator(wholeNum2, secondNumerator2, secondDenominator2)));
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
      //if there is slash that means it is a fraction and the index before the slash will be the numerator
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



  //method that will turn fractions that has a whole number into improper fraction
  public static int improperNumerator(int wholenumber, int numerator, int denominator){
    int improperNumerator = denominator * wholenumber + numerator;
    return improperNumerator;
  }//end whole method


    /*
    These will be easy to check if I want to indicate which of the if statment is the code using:

    using 1 means: if statement of 1 in the method is used
    using 2 means: if statment of 2 in the method is used
    using 3 means if statment of 3 in the method is used
    using 4 means if statment of 4 in the method is used
    */

    //method to excute multiplication.
    public static String multiply(int wholeNum1, int firstNumerator1, int firstDenominator1, int wholeNum2, int secondNumerator2, int secondDenominator2, int improperFrac1, int improperFrac2){

      //Create if statements to react to different situations in multiplying fractions.
      if(wholeNum1 != 0 && wholeNum2 != 0){
        //multiply it after turning whole number into fraction
        int answerNumerator = improperFrac1 * improperFrac2;
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

            //multiply them using the improper fraction that was done using the improper fraction method.
            int answerNumerator = improperFrac1 * secondNumerator2;
            int answerDenominator = firstDenominator1 * secondDenominator2;
            String answer = (answerNumerator + "/" + answerDenominator);
            return answer + " using 3";

        }else
          //this case would only happend if frac 2 has a whole number, thus it will getting rid of it.
            if(wholeNum2 > 0 && wholeNum1 == 0){


              //multiply them after getting rid of the whole number
              int answerNumerator = improperFrac2 * firstNumerator1;
              int answerDenominator = firstDenominator1 * secondDenominator2;
              String answer = (answerNumerator + "/" + answerDenominator);
              return answer + " using 4";
            }else{
              return "0";
            }//last closing bracket for the whole if statement

          }//end multiply method




          //Created method to execute division
          public static String division(int wholeNum1, int firstNumerator1, int firstDenominator1, int wholeNum2, int secondNumerator2, int secondDenominator2, int improperFrac1, int improperFrac2){
            //Creating if statement to handle different situations.
            if(wholeNum1 > 0 && wholeNum2 > 0){
              //divide them using the improper fraction because in this case, both of the fractions has a whole number
              int answerNumerator = improperFrac1 * secondDenominator2;
              int answerDenominator = firstDenominator1 * improperFrac2;
              String answer = (answerNumerator + "/" + answerDenominator);
              return answer + " using 1";
            }else
              if(wholeNum1 == 0 && wholeNum2 == 0){
                //simply divide the fraction because there is no whole number in this case.
                int answerNumerator = firstNumerator1 * secondDenominator2;
                int answerDenominator = firstDenominator1 * secondNumerator2;
                String answer = (answerNumerator + "/" + answerDenominator);
                return answer + " using 2";
              //end second if statement
            }else // this is a if statement when only fraction 1 has a whole number
              if(wholeNum1 > 0 && wholeNum2 == 0){

                  //divide them using the improperfraction from fraction 1
                  int answerNumerator = improperFrac1 * secondDenominator2;
                  int answerDenominator = firstDenominator1 * secondNumerator2;
                  String answer = (answerNumerator + "/" + answerDenominator);
                  return answer + " using 3";

              }else
                //this case would only happend if frac 2 has a whole number, thus it will get rid of the whole number and turn it into fraction.
                  if(wholeNum2 > 0 && wholeNum1 == 0){

                    //divide them after turning the whole number into fraction
                    int answerNumerator = secondDenominator2 * firstNumerator1;
                    int answerDenominator = firstDenominator1 * improperFrac2;
                    String answer = (answerNumerator + "/" + answerDenominator);
                    return answer + " using 4";
                  }else{
                    return "0";
                  }//last closing bracket for the whole if statement
          }//end division method



          // Creating method to add fraction in the situation where denominator is different
          public static String addDifferentDenominator(int wholeNum1, int firstNumerator1, int firstDenominator1, int wholeNum2, int secondNumerator2, int secondDenominator2, int improperFrac1, int improperFrac2){
            //Creating if statement to handle different situations.
            if(wholeNum1 > 0 && wholeNum2 > 0){
              //add it after getting rid of the whole number in the fraction
              int answerNumerator = (improperFrac1 * secondDenominator2) + (improperFrac2 * firstDenominator1);
              int answerDenominator = (firstDenominator1 * secondDenominator2);
              String answer = (answerNumerator + "/" + answerDenominator);
              return answer + " using 1";
            }else
              if(wholeNum1 == 0 && wholeNum2 == 0){
                //add the fraction because there is no whole number in this case.
                int answerNumerator = (firstNumerator1 * secondDenominator2) + (secondNumerator2 * firstDenominator1);
                int answerDenominator = (firstDenominator1 * secondDenominator2);
                String answer = (answerNumerator + "/" + answerDenominator);
                return answer + " using 2";
              //end second if statement
            }else
              if(wholeNum1 > 0 && wholeNum2 == 0){

                  //divide them after simplifying the fraction
                  int answerNumerator = (improperFrac1 * secondDenominator2) + (firstDenominator1 * secondNumerator2);
                  int answerDenominator = firstDenominator1 * secondDenominator2;
                  String answer = (answerNumerator + "/" + answerDenominator);
                  return answer + " using 3";

              }else
                //this case would only happend if frac 2 has a whole number, thus it will get rid of the whole number and turn it into fraction.
                  if(wholeNum2 > 0 && wholeNum1 == 0){
                    //simplify it
                    int simplifiedNum2 = secondDenominator2 * wholeNum2 + secondNumerator2;

                    //add them after turning the whole number into fraction
                    int answerNumerator = (firstNumerator1 * secondDenominator2) + (improperFrac2 * firstDenominator1);
                    int answerDenominator = firstDenominator1 * secondDenominator2;
                    String answer = (answerNumerator + "/" + answerDenominator);
                    return answer + " using 4";
                  }else{
                    return "0";
                  }//last closing bracket for the whole if statement
          }//end of the whole adding method


          //Created a method to calculate addition when it has the same denominator.
          public static String addSameDenominator(int wholeNum1, int firstNumerator1, int firstDenominator1, int wholeNum2, int secondNumerator2, int secondDenominator2, int improperFrac1, int improperFrac2){
            //Creating if statement to handle different situations.
            if(wholeNum1 > 0 && wholeNum2 > 0){
              //add it after getting rid of the whole number in the fraction
              int answerNumerator = improperFrac1 + improperFrac2;
              int answerDenominator = firstDenominator1;
              String answer = (answerNumerator + "/" + answerDenominator);
              return answer + " using 1";
            }else
              if(wholeNum1 == 0 && wholeNum2 == 0){
                //simply add the fraction because there is no whole number in this case.
                int answerNumerator = firstNumerator1 + secondNumerator2;
                int answerDenominator = firstDenominator1;
                String answer = (answerNumerator + "/" + answerDenominator);
                return answer + " using 2";
              //end second if statement
            }else
              if(wholeNum1 > 0 && wholeNum2 == 0){
                  //add the fraction with improper form
                  int answerNumerator = improperFrac1 + secondNumerator2;
                  int answerDenominator = firstDenominator1;
                  String answer = (answerNumerator + "/" + answerDenominator);
                  return answer + " using 3";

              }else
                //this case would only happend if frac 2 has a whole number, thus it will get rid of the whole number and turn it into fraction.
                  if(wholeNum2 > 0 && wholeNum1 == 0){

                    //add them after turning the whole number into fraction
                    int answerNumerator = firstNumerator1 + improperFrac2;
                    int answerDenominator = firstDenominator1 * secondDenominator2;
                    String answer = (answerNumerator + "/" + answerDenominator);
                    return answer + " using 4";
                  }else{
                    return "0";
                  }//last closing bracket for the whole statement.
          }//end the whole method



    // TODO: Fill in the space below with helper methods

    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int greatestCommonDivisor(int denominator1, int denominator2){


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
    public static int leastCommonMultiple(int denominator1, int denominator2){
      //if()

      return 0;
    }//end leastCommonMultiple



}//end class
