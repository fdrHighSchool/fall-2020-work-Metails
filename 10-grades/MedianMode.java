import java.util.Scanner;
import java.util.*;

public class MedianMode{
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int numbers;
    System.out.println("Enter amount of numbers QwQ");
    numbers = input.nextInt();
    int count[] = new int[numbers];
    int n = count.length;

    //for loop printing out the user's input
    for(int i = 0; i < numbers; i++){
      System.out.println("Number " + (i + 1) + " is");
      count[i] = input.nextInt();
    }
      System.out.println("The median is: " + median(numbers,n, count));
      System.out.println("The mean is: " + getAverage(count));
      System.out.println("The mode is: " + mode(count, count.length));
  }//end main

  public static int median(int numbers, int n, int count[]){

    for(int i = 0; i < numbers; i++){
      for(int k = i + 1; k < numbers; k++){

//Before Swap [1,20,10]
//After Swap [1,10,20]

//See if which number is bigger than switch them
        if(count[i] > count[k]){
          int swapNumbers = count[i]; //SwapNumber Becomes 20
          count[i] = count[k]; //20 = 10
          count[k] = swapNumbers; //10 = 20
        }
      }
    }
//Arrays.sort(count);
    if(n % 2 != 0)
       return count[n / 2];

       return (count[(n - 1) / 2] + count[n / 2]) / 2;


  }//end median method
  public static double getAverage(int [] count){
    double sum = 0;
    //for each loop
    for(int grade : count){
      sum += grade;
    }
    return sum / count.length;
  }//end getAverage method

//Methods to find mode
public static String mode(int[] array, int times){
    int appearCounts[] = new int[times];
    int indexRecorder[] = new int[times];
    boolean yesMode = false; //if it do have a mode
    int zero = 0;
    int position = 0;

    //Loops to get which index in the original array appeared the most by creating another array
    for(int i = 0;i < array.length; i++){
      for(int a = 0; a < array.length;a++){
        if(array[i] == array[a]){
          appearCounts[i]++;
        }//end if statment
      }//end the second for loop
    }//end the the first for loop

    //boolean array will be used to check if there is a mode or not
     boolean checkTrue[] = new boolean[appearCounts.length];
    for(int check = 0; check < checkTrue.length; check++){
      if(appearCounts[check] == 1){
        checkTrue[check] = false;
      }else if(appearCounts[check] > 1){
       checkTrue[check] = true;
      }//end else if statements
    }//end for loops

    for(boolean trueOrFalse : checkTrue){
      if(trueOrFalse == true){
        yesMode = true;
      }//end if statement
    }//end for loops

    if(yesMode == true){
    for(int q = 0; q < array.length; q++){
      if(appearCounts[q] >= appearCounts[position]){
      position = q;
      }//end if statement
    }//end for loop

    return Integer.toString(array[position]);

  }else{
  return "\nThere's no mode with given number buddy :< \n*cries in the bathroom ;-;";
  }//end else statement
  }//end method
}//end class
