import java.util.Scanner;
class Temperature{
  public static void main(String[] args){
    double todayTemperature;
    double Ftemperature;
    Scanner answer = new Scanner(System.in);

    System.out.println("Hello! To covert current temperature into Fahrenheit, do you mind tell me today's temperature in Celsius?");
    todayTemperature = answer.nextDouble();
    Ftemperature = (todayTemperature * 1.8) + 32;
    System.out.println("Today's temperature in fahrenheit is: " + Ftemperature + " F");
  }//end method
}//end class
