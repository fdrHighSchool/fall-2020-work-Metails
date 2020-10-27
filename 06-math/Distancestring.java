import java.lang.*;
import java.util.*;

public class Distancestring{
  public static void main(String[] args) {
    //get two points from the user (x, y)
    Scanner input = new Scanner(System.in);

    System.out.println("What is your first x and y value?");
    String firstValue = input.nextLine();
    System.out.println("What is your second x and y value?");
    String secondValue = input.nextLine();
    int x1 = getx(firstValue);
    int x2 = getx(secondValue);
    int y1 = getY(firstValue);
    int y2 = getY(secondValue);
    System.out.println("The distance using the cartesian formula is: " + cartesianDistance(x1,y1,x2,y2));
    System.out.println("The distance using the taxicab formula is: " + taxicabDistance(x1, y1, x2, y2));


  }//end main method
  public static int getx(String points){
    int comma = points.indexOf(",");
    String x = points.substring(1,comma);
    return Integer.parseInt(x);

  }//end getx method

  public static int getY(String points){
    int closingBra = points.indexOf(")");
    int comma = points.indexOf(",");
    String y = points.substring((comma + 2), closingBra);
    return Integer.parseInt(y);
  }//end gety method

  public static double cartesianDistance(double x1,double y1,double x2,double y2){
    double distance = Math.sqrt(Math.pow((x2 - x1), 2)+ Math.pow((y2 - y1), 2));
    return distance;
  }//end cartesian distance method

  //The formula that I got for calculating the taxicab distance is |x2 - x1| + |y2 - y1|
  public static double taxicabDistance(double x1, double y1, double x2, double y2){
    double distance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
    return distance;
  }//end taxicabDistance method

}//end class
