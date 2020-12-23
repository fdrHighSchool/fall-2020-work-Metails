import java.util.Arrays;

//import sun.print.SunMinMaxPage;

//import sun.print.SunMinMaxPage;

class Grades2D {
  public static void main(String[] args) {
    int [][] grades = new int[30][10];
    grades = randomGrades(grades);

    double highestGrades = highestAverage(grades)[0];
    int highestStudent = (int)highestAverage(grades)[1];
    double secondHighestGrades = salutatorian(highestGrades, grades)[0];
    int salutatorianStudent = (int)salutatorian(highestGrades, grades)[1];

    System.out.println("The 2DArray withhelding grades is:\n" + Arrays.deepToString(randomGrades(grades)));
    System.out.println("\nStudent with the highest grade is: Student # " + highestStudent + " With the average grades of " + highestGrades);

    System.out.println("\nStudent with the second highest grade is: Student # " + salutatorianStudent + " With the average grades of " + secondHighestGrades);

  }//end main method
  public static int[][] randomGrades(int[][] grades) {
    for(int i = 0;i < grades.length;i++){
      for(int a = 0;a < grades[i].length; a++){
      grades[i][a] = (int)(Math.random() * (100 - 55)) + 55;
      }//end for loops of a
    }//end for loops of i
    return grades;
  }//end randomGrades

  public static double[] highestAverage(int [][] grades) {
    double average = 0;
    double greatestAverage = 0;
    int greatestStudent = 0;
    for(int i = 0;i < grades.length;i++){
      for(int a = 0;a < grades[i].length; a++){
        average += grades[i][a];
      }//end for loops of a
      average /= 10;
      if(average > greatestAverage){
        greatestAverage = average;
        greatestStudent = i;
      }//end if statement
      average = 0;
    }//end for loops of i

    //greatestStudent + 1 because array start counting by 0 instead of 1
    double[] highestGradesStudent = new double[]{greatestAverage, greatestStudent + 1};
    return highestGradesStudent;
  }//end highestAverage

  /*
  public static int[][] valedictorian(int [][] grades) {

    double average = 0.0;
    double beyondAverage = 0.0;
    int THEstudent = 0;
    for(int i = 0; i < grades.length; i++) {
      for(int x = 0; x > 15; x++) {
        average += grades[i][x];
      }///End the for loop
      average /= 15;
      if (average)
    }
  }
*/
  public static double[] salutatorian(double maxGrades, int [][] grades) {
    double average = 0;
    double greatestAverage = 0;
    int greatestStudent = 0;
    for(int i = 0;i < grades.length;i++){
      for(int a = 0;a < grades[i].length; a++){
        average += grades[i][a];
      }//end for loops of a
      average /= 10;
      if(average > greatestAverage && average < maxGrades){
        greatestAverage = average;
        greatestStudent = i;
      }//end if statement
      average = 0;
    }//end for loops of i
    //greatestStudent + 1 because array start counting by 0 instead of 1

    double[] highestGradesStudent = new double[]{greatestAverage, greatestStudent + 1};
    return highestGradesStudent;
  }//end salutorian

  /*
  }//end salutatorian
   public static double getAverage(int[] arr){
    double sum = 0;
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];
    }
    return sum / arr.length;
  }
  */
}//end class
