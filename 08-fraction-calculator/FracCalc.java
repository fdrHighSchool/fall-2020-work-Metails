import java.util.Scanner;
public class FracCalc {

    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */

     //The to do list:

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

     //1:
     //if statement to stop the the loop.

       // TODO: Read the input from the user and call produceAnswer with an equation
       // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
       // Checkpoint 2: Accept user input multiple times.


       //2:
       /**
        * produceAnswer - This function takes a String 'input' and produces the result.
        * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
        *      Example: input ==> "1/2 + 3/4"
        * @return the result of the fraction after it has been calculated.
        *      Example: return ==> "1_1/4"
        */


    public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      boolean start = true;
      String stop = "quit";
      //This will loop the whole thing until player typed "quit"
      while(start == true){
      System.out.println("What is the fraction equation you want to calculate: ");
      System.out.println("Or just simply type \"quit\" to exit the calculator :D");
      String equation = input.nextLine();
      int yesorno = stop.compareToIgnoreCase(equation);
      if(yesorno == 0){
        start = false;

      }else{
        if(start = true){
        System.out.println("The answer is: " + produceAnswer(equation) + "\n");
      }//end statment for indicating if it will print this above statement.

    }//last closing brackets for the whole if statement

  }//end the whole while statement

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

      //Turn them into actual whole number, numerator, and denominator for the first fraction as int
      int wholeNum1 = wholeNumberIndicator(firstFrac);
      int firstNumerator1 = numeratorIndicator(firstFrac);
      int firstDenominator1 = denominatorIndicator(firstFrac);

      //Turn them into actual whole number, numerator, and denominator for the second fraction as int
      int wholeNum2 = wholeNumberIndicator(secondFrac);
      int secondNumerator2 = numeratorIndicator(secondFrac);
      int secondDenominator2 = denominatorIndicator(secondFrac);

      //This is print out to accomplish checkpoint 2(Don't know if I should delete this yet)
      System.out.println("\nWhole: " + wholeNum1 + " Numerator: " + firstNumerator1 + " Denominator: " + firstDenominator1 + "\n");
      System.out.println("Whole: " + wholeNum2 + " Numerator: " + secondNumerator2 + " Denominator: " + secondDenominator2 + "\n");
      //System.out.println("\nGCF: " + greatestCommonDivisor(3,24));

      //Determine which operator it is, then change the method to excute based upon different operators and requirements.
      //this will happen will one of the denominator is equal to 0
      if(firstDenominator1 == 0 || secondDenominator2 == 0){
        String answer = ("ERROR: Cannot divide by zero.");
        return answer;
      }else
      //if operator is * then proceeds to multiply method
      if(operator.contains("*")){
        String answerMixed = multiply(wholeNum1, firstNumerator1, firstDenominator1, wholeNum2, secondNumerator2, secondDenominator2,improperNumerator(wholeNum1, firstNumerator1, firstDenominator1),improperNumerator(wholeNum2, secondNumerator2, secondDenominator2));
        String answer = reducing(answerMixed);
        return answer;
      }else
      //if operator is / then proceeds to division method
      if(operator.contains("/")){
        String answerMixed = division(wholeNum1, firstNumerator1, firstDenominator1, wholeNum2, secondNumerator2, secondDenominator2,improperNumerator(wholeNum1, firstNumerator1, firstDenominator1),improperNumerator(wholeNum2, secondNumerator2, secondDenominator2));
        String answer = reducing(answerMixed);
        return answer;
      }else
      //if operator = + and both fraction's denominator are not the same, it will excute the statments below, which is method for solving fractions that has different denominator.
      if(operator.contains("+") && firstDenominator1 != secondDenominator2){
        String answerMixed = addDifferentDenominator(wholeNum1, firstNumerator1, firstDenominator1, wholeNum2, secondNumerator2, secondDenominator2,improperNumerator(wholeNum1, firstNumerator1, firstDenominator1),improperNumerator(wholeNum2, secondNumerator2, secondDenominator2));
        String answer = reducing(answerMixed);
        return answer;
      }else
      //if operator = + and both fraction's denominator are the same, it will excute the statments below, it's method to add fractions when both denominators are the same.
      if(operator.contains("+") && firstDenominator1 == secondDenominator2){
        String answerMixed = addSameDenominator(wholeNum1, firstNumerator1, firstDenominator1, wholeNum2, secondNumerator2, secondDenominator2,improperNumerator(wholeNum1, firstNumerator1, firstDenominator1),improperNumerator(wholeNum2, secondNumerator2, secondDenominator2));
        String answer = reducing(answerMixed);
        return answer;
      }else
        //if statment when indicate operator with "-" and have different denominator
        if(operator.contains("-") && firstDenominator1 != secondDenominator2){
          String answerMixed = subtractDifferentDenominator(wholeNum1, firstNumerator1, firstDenominator1, wholeNum2, secondNumerator2, secondDenominator2,improperNumerator(wholeNum1, firstNumerator1, firstDenominator1),improperNumerator(wholeNum2, secondNumerator2, secondDenominator2));
          String answer = reducing(answerMixed);
          return answer;
        }else
        //if statement when operator is "-" and both denominator are the same, then proceeds to execute subtraction when both denomiantor are the same
        if(operator.contains("-") && firstDenominator1 == secondDenominator2){
          String answerMixed = subtractSameDenominator(wholeNum1, firstNumerator1, firstDenominator1, wholeNum2, secondNumerator2, secondDenominator2,improperNumerator(wholeNum1, firstNumerator1, firstDenominator1),improperNumerator(wholeNum2, secondNumerator2, secondDenominator2));
          String answer = reducing(answerMixed);
          return answer;
        }else {
          return ":(";
        }//end the if statement for the changing method upon different operator.



    }//end produceAnswer method

    //creating method to reduce the answer by using method created
    public static String reducing(String answerMixed){
      //Reduce them and create variable needed to do so as well.
      int answerNum = numeratorIndicator(answerMixed)/greatestCommonDivisor(numeratorIndicator(answerMixed),denominatorIndicator(answerMixed));
      int answerDen = denominatorIndicator(answerMixed)/greatestCommonDivisor(numeratorIndicator(answerMixed),denominatorIndicator(answerMixed));
      int remainder = 0;
      int newWhole = answerNum;

      //Getting to know what the GCF is, easier to fix bugs
      System.out.println("GCF is: " + greatestCommonDivisor(numeratorIndicator(answerMixed),denominatorIndicator(answerMixed)));

      //Going to Use absolute value below so that system can still know which one is bigger even when numbers are negative
      if(Integer.toString(answerNum).contains("-") && Integer.toString(answerDen).contains("-")){
      answerNum = Math.abs(answerNum);
      answerDen = Math.abs(answerDen);
      System.out.println("\nTurning into positive because there is 2 negative\n");
    }//the end of the if statment within if statement 1 to turn negative fraction into positive.
      while(Math.abs(answerNum) > Math.abs(answerDen)){
        remainder = answerNum % answerDen;
        newWhole = answerNum / answerDen;
        //excute code below when numerator is bigger than denominator, meaning it can be reduced
        if(remainder != 0){
          //if both numerator and the new whole number contains "-" it's going to remove "-" sign in numerator
          if(Integer.toString(remainder).contains("-") && Integer.toString(newWhole).contains("-")){
            String stringRemainder = Integer.toString(remainder).replace("-", "");
            remainder = Integer.parseInt(stringRemainder);
          }//end if statment for checking if remainder and the whole contains negative

          //this will remove denominator's "-" sign and make wholenumber the only one who has "-" sign
          if(Integer.toString(newWhole).contains("-") && Integer.toString(answerDen).contains("-")){
            String stringDenominator = Integer.toString(answerDen).replace("-","");
            answerDen = Integer.parseInt(stringDenominator);
          }//end if statement when whole number and denominator both contains 0

        String answer = (newWhole + "_" + remainder + "/" + answerDen);
        return answer;
        }//end the if statement within answerNum > answerDen

        //Get rid of 1 when denominator is 1
        if(answerDen == 1){
          return Integer.toString(newWhole);
        }//end if for answerDen == 1


      }//end of answerNum > answerDen while statement
      //This will work when the numerator is zero thus returning 0 without a denominator
      if(answerNum == 0){
        String answer = "0";
        return answer;
      }//end if for Numerator = 0

      if(Math.abs(answerNum) == Math.abs(answerDen)){
        int answer = (answerNum / answerDen);
        return Integer.toString(answer);
      }//end if for same numerator and same denominator

      //circumstances where denominator has to - sign but not the numerator
      if(Integer.toString(answerDen).contains("-")){
        String stringDenominator = Integer.toString(answerDen).replace("-","");
        answerDen = Integer.parseInt(stringDenominator);
        answerNum *= -1;
        String answer = (answerNum + "/" + answerDen);
        return answer;
      }//end if statement

      String answer = (answerNum + "/" + answerDen);
      return answer;
    }//end reducing method



    //Creating method to get the whole number, numerator, denominator.
    //This method will find whole number in the fraction
    public static int wholeNumberIndicator(String input){
      //Whole number only exists if there is a "_" in front of that number
      boolean uslash = input.contains("_");
      //when there is "_" get the number from index of 0 to index of "_"
      if(input.contains("_")){
      int indexUnderSlash = input.indexOf("_");
      String whole = input.substring(0,indexUnderSlash);
      return Integer.parseInt(whole);
    }else{
      //return 0 because the input doesn't have a whole number
      return 0;
    }
}//end wholeNumberIndicator method



    //This will execute method to indicates the numerator in the fraction
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
        //this will excute when the input is not a fraction because there is no "/" or "_"
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
      //There is no "/", meaning it's a number and not fraction, only return 1 back as denominator.
      return 1;
    }
  }//end denominatorIndicator method





  //method that will turn fractions that has a whole number into improper fraction
  public static int improperNumerator(int wholenumber, int numerator, int denominator){
    //Only when whole number is a negative, because negative + positive numerator is basicallly subtracting, and I don't mean to subtract
    if(Integer.toString(wholenumber).contains("-") == true){
    int improperNumerator = denominator * wholenumber + (-1 * numerator);
    return improperNumerator;
    }else
    //No negative for whole number, simply add them.
    if(Integer.toString(wholenumber).contains("-") == false){
    int improperNumerator = denominator * wholenumber + numerator;
    return improperNumerator;
    }else{
    //Never want to return pure numerator, this is more of a placeholder than anything
    return numerator;
    }//last bracket of the whole if statement
  }//end whole method


    /*
    These will be easy to check if I want to indicate which of the if statment is the code using:

    using 1 means: if statement of 1 in the method is used
    using 2 means: if statment of 2 in the method is used
    using 3 means if statment of 3 in the method is used
    using 4 means if statment of 4 in the method is used
    using 5 means if statment of 5 in the method is used(Don't want this to ever be used, but it's easy to know if something went wrong)
    */

    /*
    Creating numerous method for multiply,divide,subtract,and addition
    Easier to track down bug and stuff.
    */


    //method to excute multiplication.
    public static String multiply(int wholeNum1, int firstNumerator1, int firstDenominator1, int wholeNum2, int secondNumerator2, int secondDenominator2, int improperFrac1, int improperFrac2){

      //Create if statements to react to different situations in multiplying fractions.
      if(wholeNum1 > 0 || wholeNum1 < 0 && wholeNum2 > 0 || wholeNum2 < 0){

        int answerNumerator = improperFrac1 * improperFrac2;
        int answerDenominator = firstDenominator1 * secondDenominator2;
        String answer = (answerNumerator + "/" + answerDenominator);
        System.out.println("using 1 in multiplying method");
        return answer;
      }else
        //simply multiply fraction because there is no whole number in this case.
        if(wholeNum1 == 0 && wholeNum2 == 0){

          int answerNumerator = firstNumerator1 * secondNumerator2;
          int answerDenominator = firstDenominator1 * secondDenominator2;
          String answer = (answerNumerator + "/" + answerDenominator);
          System.out.println("using 2 in multiplying method");
          return answer;
        //end second if statement
      }else
        //This case would only happen when fraction 2 has no whole number, but fraction 1 does.
        if(wholeNum1 > 0 || wholeNum1 < 0 && wholeNum2 == 0){

            int answerNumerator = improperFrac1 * secondNumerator2;
            int answerDenominator = firstDenominator1 * secondDenominator2;
            String answer = (answerNumerator + "/" + answerDenominator);
            System.out.println("using 3 in multiplying method");
            return answer;

        }else
          //this case would only happend if frac 2 has a whole number but fraction 1 does not
            if(wholeNum2 > 0 || wholeNum2 < 0 && wholeNum1 == 0){

              int answerNumerator = improperFrac2 * firstNumerator1;
              int answerDenominator = firstDenominator1 * secondDenominator2;
              String answer = (answerNumerator + "/" + answerDenominator);
              System.out.println("using 4 in multiplying method");
              return answer;
            }else{
              System.out.println("Using 5 in multiplying method");
              System.out.println("\nSomething is wrong here");
              return "0";
            }//last closing bracket for the whole if statement

          }//end multiply method




          //Created method to execute division
          public static String division(int wholeNum1, int firstNumerator1, int firstDenominator1, int wholeNum2, int secondNumerator2, int secondDenominator2, int improperFrac1, int improperFrac2){
            //Creating if statement to handle different situations.
            //divide them using the improper fraction because in this case, both of the fractions has a whole number
            if(wholeNum1 > 0 || wholeNum1 < 0 && wholeNum2 > 0 || wholeNum2 < 0){

            int answerNumerator = improperFrac1 * secondDenominator2;
            int answerDenominator = firstDenominator1 * improperFrac2;

            String answer = (answerNumerator + "/" + answerDenominator);
            System.out.println("using 1 in division method");
            return answer;
            }else
              //since both fraction has no whole number, just simply divide it
              if(wholeNum1 == 0 && wholeNum2 == 0){
                //simply divide the fraction because there is no whole number in this case.
                int answerNumerator = firstNumerator1 * secondDenominator2;
                int answerDenominator = firstDenominator1 * secondNumerator2;

                String answer = (answerNumerator + "/" + answerDenominator);
                System.out.println("using 2 in division method");
                return answer;
              //end second if statement
            }else // this is a if statement when only fraction 1 has a whole number
              if(wholeNum1 > 0 || wholeNum1 < 0 && wholeNum2 == 0){

                  //divide them using the improperfraction from fraction 1
                  int answerNumerator = improperFrac1 * secondDenominator2;
                  int answerDenominator = firstDenominator1 * secondNumerator2;

                  String answer = (answerNumerator + "/" + answerDenominator);
                  System.out.println("using 3 in division method");
                  return answer;

              }else
                //no wholenumber for fraction 1, then this will execute
                  if(wholeNum2 > 0 || wholeNum2 < 0 && wholeNum1 == 0){

                    //divide them after turning the whole number into fraction
                    int answerNumerator = secondDenominator2 * firstNumerator1;
                    int answerDenominator = firstDenominator1 * improperFrac2;

                    String answer = (answerNumerator + "/" + answerDenominator);
                    System.out.println("using 4 in division method");
                    return answer;

                  }else{
                    System.out.println("Using 5 in division method");
                    System.out.println("\nSomething is wrong here");
                    return "0";
                  }//last closing bracket for the whole if statement
          }//end division method





          // Creating method to add fraction in the situation where denominator is different, and it will use the formula for adding fraction with different denominator
          public static String addDifferentDenominator(int wholeNum1, int firstNumerator1, int firstDenominator1, int wholeNum2, int secondNumerator2, int secondDenominator2, int improperFrac1, int improperFrac2){
            //Creating if statement to handle different situations.
            if(wholeNum1 > 0 || wholeNum1 < 0 && wholeNum2 > 0 || wholeNum2 < 0){
              //add it after getting rid of the whole number in the fraction
              int answerNumerator = (improperFrac1 * secondDenominator2) + (improperFrac2 * firstDenominator1);
              int answerDenominator = (firstDenominator1 * secondDenominator2);
              String answer = (answerNumerator + "/" + answerDenominator);
              System.out.println("using 1 in adding different denominator method");
              return answer;
            }else
              //No fraction has whole number
              if(wholeNum1 == 0 && wholeNum2 == 0){
                //add the fraction because there is no whole number in this case.
                int answerNumerator = (firstNumerator1 * secondDenominator2) + (secondNumerator2 * firstDenominator1);
                int answerDenominator = (firstDenominator1 * secondDenominator2);
                String answer = (answerNumerator + "/" + answerDenominator);
                System.out.println("using 2 in adding different denominator method");
                return answer;
              //end second if statement
            }else
              //when only fraction 1 has whole number
              if(wholeNum1 > 0 || wholeNum1 < 0 && wholeNum2 == 0){

                  //add the fraction with fraction 1's improper form using formula of adding with different denominator
                  int answerNumerator = (improperFrac1 * secondDenominator2) + (firstDenominator1 * secondNumerator2);
                  int answerDenominator = firstDenominator1 * secondDenominator2;
                  String answer = (answerNumerator + "/" + answerDenominator);
                  System.out.println("using 3 in adding different denominator method");
                  return answer;

              }else
                  //when only fraction 2 has whole number
                  if(wholeNum2 > 0 || wholeNum2 < 0 && wholeNum1 == 0){

                    //add them after turning the whole number into fraction
                    int answerNumerator = (firstNumerator1 * secondDenominator2) + (improperFrac2 * firstDenominator1);
                    int answerDenominator = firstDenominator1 * secondDenominator2;
                    String answer = (answerNumerator + "/" + answerDenominator);
                    System.out.println("using 4 in adding different denominator method");
                    return answer;

                  }else{
                    System.out.println("Using 5 in adding different denominator method");
                    System.out.println("\nSomething is wrong here");
                    return "0";
                  }//last closing bracket for the whole if statement
          }//end of the whole addDifferentDenominator method




          //Created a method to calculate addition when it has the same denominator.
          public static String addSameDenominator(int wholeNum1, int firstNumerator1, int firstDenominator1, int wholeNum2, int secondNumerator2, int secondDenominator2, int improperFrac1, int improperFrac2){
            //Creating if statement to handle different situations.
            //When both fraction has a whole number
            if(wholeNum1 > 0 || wholeNum1 < 0 && wholeNum2 > 0 || wholeNum2 < 0){
              //add it after getting rid of the whole number in the fraction
              int answerNumerator = improperFrac1 + improperFrac2;
              int answerDenominator = firstDenominator1;
              String answer = (answerNumerator + "/" + answerDenominator);
              System.out.println("using 1 in adding same denominator method");
              return answer;
            }else
              //when both fraction doesn't have a whole number
              if(wholeNum1 == 0 && wholeNum2 == 0){
                //simply add the fraction because there is no whole number in this case.
                int answerNumerator = firstNumerator1 + secondNumerator2;
                int answerDenominator = firstDenominator1;
                String answer = (answerNumerator + "/" + answerDenominator);
                System.out.println("using 2 in adding same denominator method");
                return answer;
              //end second if statement
            }else
              //when only fraction 1 has a whole number
              if(wholeNum1 > 0 || wholeNum1 < 0 && wholeNum2 == 0){
                  //add the fraction with improper form
                  int answerNumerator = improperFrac1 + secondNumerator2;
                  int answerDenominator = firstDenominator1;
                  String answer = (answerNumerator + "/" + answerDenominator);
                  System.out.println("using 3 in adding same denominator method");
                  return answer;

              }else
                //this case would only happend if frac 2 has a whole number
                  if(wholeNum2 > 0 || wholeNum2 < 0 && wholeNum1 == 0){

                    //add them after turning the whole number into fraction
                    int answerNumerator = firstNumerator1 + improperFrac2;
                    int answerDenominator = firstDenominator1 * secondDenominator2;
                    String answer = (answerNumerator + "/" + answerDenominator);
                    System.out.println("using 4 in adding same denominator method");
                    return answer;

                  }else{
                    System.out.println("Using 5 in adding same denominator method");
                    System.out.println("\nSomething is wrong here");
                    return "0";
                  }//last closing bracket for the whole statement.
          }//end the addSameDenominator method


          // Creating method to subtract fraction with different denominator.
          public static String subtractDifferentDenominator(int wholeNum1, int firstNumerator1, int firstDenominator1, int wholeNum2, int secondNumerator2, int secondDenominator2, int improperFrac1, int improperFrac2){
            //Creating if statement to handle different situations.
            //when both fraction have whole number
            if(wholeNum1 > 0 || wholeNum1 < 0 && wholeNum2 > 0 || wholeNum2 < 0){
              //subtract it after getting rid of the whole number in the fraction
              int answerNumerator = (improperFrac1 * secondDenominator2) - (improperFrac2 * firstDenominator1);
              int answerDenominator = (firstDenominator1 * secondDenominator2);
              String answer = (answerNumerator + "/" + answerDenominator);
              System.out.println("using 1 in subtracting different denominator method");
              return answer;
            }else
              //When both fraction doesn't have a whole number
              if(wholeNum1 == 0 && wholeNum2 == 0){
                //subtract the fraction because there is no whole number in this case.
                int answerNumerator = (firstNumerator1 * secondDenominator2) - (secondNumerator2 * firstDenominator1);
                int answerDenominator = (firstDenominator1 * secondDenominator2);
                String answer = (answerNumerator + "/" + answerDenominator);
                System.out.println("using 2 in subtracting different denominator method");
                return answer;
              //end second if statement
            }else
              //when only fraction 1 has a whole number
              if(wholeNum1 > 0 || wholeNum1 < 0 && wholeNum2 == 0){

                  //subtract them after simplifying the fraction
                  int answerNumerator = (improperFrac1 * secondDenominator2) - (firstDenominator1 * secondNumerator2);
                  int answerDenominator = firstDenominator1 * secondDenominator2;
                  String answer = (answerNumerator + "/" + answerDenominator);
                  System.out.println("using 3 in subtracting different denominator method");
                  return answer;

              }else
                //Only happen if frac 2 has a whole number
                  if(wholeNum2 > 0 || wholeNum2 < 0 && wholeNum1 == 0){

                    //subtract them after turning the whole number into fraction
                    int answerNumerator = (firstNumerator1 * secondDenominator2) - (improperFrac2 * firstDenominator1);
                    int answerDenominator = firstDenominator1 * secondDenominator2;
                    String answer = (answerNumerator + "/" + answerDenominator);
                    System.out.println("using 4 in subtracting different denominator method");
                    return answer;

                  }else{
                    System.out.println("Using 5 in subtracting different denominator method");
                    System.out.println("\nSomething is wrong here");
                    return "0";
                  }//last closing bracket for the whole if statement
          }//end of the subtractDifferentDenominator method


          //Created a method to calculate addition when it has the same denominator.
          public static String subtractSameDenominator(int wholeNum1, int firstNumerator1, int firstDenominator1, int wholeNum2, int secondNumerator2, int secondDenominator2, int improperFrac1, int improperFrac2){
            //Creating if statement to handle different situations.
            //Both frac has whole number
            if(wholeNum1 > 0 || wholeNum1 < 0 && wholeNum2 > 0 || wholeNum2 < 0){
              //subtract it with fraction 1 and 2's imporperform with it's numerator
              int answerNumerator = improperFrac1 - improperFrac2;
              int answerDenominator = firstDenominator1;
              String answer = (answerNumerator + "/" + answerDenominator);
              System.out.println("using 1 in subtracting same denominator method");
              return answer;
            }else
              //Both doesn't have whole number
              if(wholeNum1 == 0 && wholeNum2 == 0){
                //simply add the fraction because there is no whole number in this case.
                int answerNumerator = firstNumerator1 - secondNumerator2;
                int answerDenominator = firstDenominator1;
                String answer = (answerNumerator + "/" + answerDenominator);
                System.out.println("using 2 in subtracting same denominator method");
                return answer;
              //end second if statement
            }else
              //Only fraction 1 has whole number
              if(wholeNum1 > 0 || wholeNum1 < 0 && wholeNum2 == 0){
                  //add the fraction with improper form
                  int answerNumerator = improperFrac1 - secondNumerator2;
                  int answerDenominator = firstDenominator1;
                  String answer = (answerNumerator + "/" + answerDenominator);
                  System.out.println("using 3 in subtracting same denominator method");
                  return answer;

              }else
                //this case would only happend if frac 2 has a whole number
                  if(wholeNum2 > 0 || wholeNum2 < 0 && wholeNum1 == 0){

                    //add them after turning the whole number into fraction
                    int answerNumerator = firstNumerator1 - improperFrac2;
                    int answerDenominator = firstDenominator1 * secondDenominator2;
                    String answer = (answerNumerator + "/" + answerDenominator);
                    System.out.println("using 4 in subtracting same denominator method");
                    return answer;

                  }else{
                    System.out.println("Using 5 in subtracting same denominator method");
                    System.out.println("\nSomething is wrong here");
                    return "0";
                  }//last closing bracket for the entire if statement.
          }//end the subtractDenominator method


// TODO: Fill in the space below with helper methods

    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */


    public static int greatestCommonDivisor(int numerator, int denominator){
      //compare numerator and denominator to see which one is bigger
      //Since GCF can't be greater than the least Numerator or denominator
      //Thus, the minimum will be amount of loops it will run, which will be the maxium amount of time that the while loop would run
      //gcf must at least be 1
      int gcf = 1;

      //Get the minimum of the both
      int min = Math.min(numerator, denominator);

      for(int t = min; t != 0; t--){
        //when numerator module the number of t = 0, that means it will be a potential GCF
        if(numerator % t == 0 && denominator % t == 0){//when numerator module the number of t = 0, that means it will be a potential GCF
          gcf = t;
          return gcf;
        }//end last bracket for if statement

      }//end for loops
      return 1;
    }//end greatestCommonDivisor method

    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */

   //}//Honestly I don't think I need to create a least common multiple method, all I need is a GCF
    public static int leastCommonMultiple(int denominator1, int denominator2){
      //if()

      return 0;
    }//end leastCommonMultiple



}//end class
