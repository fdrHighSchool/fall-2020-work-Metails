import java.lang.*;
import java.util.*;

public class Distance{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Hello! You're using the caresidan distance method. Please enter the first x value: ");
    double xvalue1 = input.nextDouble();
    System.out.println("Please enter the first y value: ");
    double yvalue1 = input.nextDouble();
    System.out.println("Please enter the second x value: ");
    double xvalue2 = input.nextDouble();
    System.out.println("Please enter the second y value: ");
    double yvalue2 = input.nextDouble();
    System.out.println("The distance using the distance formula is: " + cartesianDistance(xvalue1,yvalue1,xvalue2,yvalue2));
    System.out.println("The distance using the taxi cab geometry is: " + taxicabDistance(xvalue1,yvalue1,xvalue2,xvalue1));

  }//end main method

  public static double cartesianDistance(double xvalue1,double yvalue1,double xvalue2,double yvalue2){
    double distance = Math.sqrt(Math.pow((xvalue2 - xvalue1), 2)+ Math.pow((yvalue2 - yvalue1), 2));
    return distance;
  }//end cartesian distance method

  public static double taxicabDistance(double xvalue1, double yvalue1, double xvalue2, double yvalue2){
    double distance = Math.abs(xvalue2 - xvalue1) + Math.abs(yvalue2 - yvalue1);
    return distance;
  }//end taxicab distance.

}//end class
