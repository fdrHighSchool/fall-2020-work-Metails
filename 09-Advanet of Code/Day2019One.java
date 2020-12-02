import java.util.Scanner
public class Day2019One{
  public static void main(String[] args){
    Scanner sugoi = new Scanner(System.in)

    System.out.print("Please enter the mass: ");
    int a = sugoi.nextInt();
    System.out.println("Total fuel requirements: " + fuelNeeded(a));
  }//end main method

  public static int fuelNeeded(int a){
    int answer = (a / 3) - 2;
    return answer;
  }//end fuelNeeded method
}//end class
