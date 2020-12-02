import java.util.*;
import java.io.*;

public class ThePowerOfSpaceShip{
  public static void main(String[] args) {
    int totalFuel = 0;
    try{
      Scanner s = new Scanner(new File("Triggered.txt"));

      while(s.hasNext()){
        int a = Integer.parseInt(s.next());
        int fuel = (a/3)-2;
        totalFuel += fuel;
      }//end while loop

      System.out.println("Total fuel is: " + totalFuel);

      s.close();
    }//end try

    catch(Exception e){
      System.out.println("file not found");
    }//end catch
  }//end main method


}//end class
