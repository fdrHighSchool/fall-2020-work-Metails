import java.util.Scanner;
public class Averge{
  public static void main(String[] args) {
      int numberGrades = 0;
      double total = 0;
      Scanner answer = new Scanner(System.in);
      System.out.println("How many grades do you have? ");
      numberGrades = answer.nextInt();
      for(int i = 0; i < numberGrades; i++){
      System.out.println("What was your grade? ");
      double firstGrade = answer.nextDouble();
      total = (total + firstGrade);

    }
    double averge = (total / numberGrades);
    System.out.println("Your averge is " + averge + "%");

  }
}
