import java.util.Scanner;
import java.util.Arrays;
public class FRQ_Questions{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("What's your number: ");
    int number = input.nextInt();

    System.out.println("How many times: ");
    int times = input.nextInt();

    System.out.println("\nFalse means that it's not self divisable,and true means that it is self divisable \nSelfDivisor of this number: " + selfDivisor(number));
    System.out.println("Array of firstNumSelfDivisors: " + Arrays.toString(firstNumSelfDivisors(number, times)));
  }//end main method

  public static boolean selfDivisor(int number){
    String inputNumber = Integer.toString(number);
    boolean trueOrFalse = true;
    for(int i = 0; i < inputNumber.length(); i++){
      if(number % Integer.parseInt(inputNumber.substring(i, i+1)) != 0){
        trueOrFalse = false;
      }//end if statement
    }//end for loops
    return trueOrFalse;
  }//end partA method

  public static int[] firstNumSelfDivisors(int numValue, int arraySize){
    numValue++;
    int array[] = new int[arraySize];
    String inputNumber = Integer.toString(numValue);
    boolean torF = true;
    int i = 0;

    while(i < arraySize){
      inputNumber = Integer.toString(numValue);
      torF = true;
      for(int a = 0; a < inputNumber.length(); a++){

        //if digit of a number is divide by zero, it's not self disiaable
        try{
        if(numValue % Integer.parseInt(inputNumber.substring(a, a + 1)) != 0)
          torF = false;
        }catch (ArithmeticException e){
          torF = false;
        }//end catch statement

      }//end for loops statement

      if(torF == true){
        array[i] = numValue;
        numValue++;
        i++;
      }else{
        numValue++;
      }//end else statement
    }//end for while loops


    return array;

  }//end firstNumSelfDivisors method

}//end class
