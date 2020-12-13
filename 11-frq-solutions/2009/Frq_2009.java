import java.util.Arrays;
import java.util.Scanner;
public class Frq_2009{
  public static void main(String[] args){
  Scanner input = new Scanner(System.in);

  System.out.println("What's the highest number of the cubes: ");
  int limitCubes = input.nextInt();

  System.out.println("How many tosses: ");
  int tosses = input.nextInt();

  int answer[] = new int[tosses];

  answer = getCubeTosses(limitCubes,tosses);
  System.out.println("The array of number appeared are: " + Arrays.toString(answer));
  System.out.println("The longest sequence of numbers are: " + /*Arrays.toString(*/getLongestRun(answer))/*)*/;
  }//end main method

  //cube
  public static int[] getCubeTosses(int cubes, int tosses){
  int array[] = new int[tosses];

  for(int i = 0; i < tosses; i++){
  array[i] = (int)(Math.random() * (cubes - 1) + 1);
  }//end for loops

  return array;

  }//end getCubeTosses method

  public static int getLongestRun(int[] array){
  int greatestAmount = 0;
  int index = 0;
  int count = 0;

  for(int i = 0; i < array.length - 1; i++){
      if(array[i] == array[i + 1]){
      count++;
      //System.out.println("\nCount: " + count + "\n");
      if(count > greatestAmount){
        greatestAmount = count;
        index = i;
        //System.out.println("\nIndex right now:" + index + "\n");
      }else{
        count = 0;
      }//else statement
    }//end if statement
  }//end for loop

  if(greatestAmount == 0){
    return -1;
  }else{
  return array[index];
}

  }//end getLongestRun method
}//end main class
