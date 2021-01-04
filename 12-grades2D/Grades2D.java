import java.util.Arrays;


class Grades2D {
  public static void main(String[] args) {
    int [][] grades = new int[30][10];
    grades = randomGrades(grades);

    double highestGrades = highestAverage(grades)[0];
    int highestStudent = (int)highestAverage(grades)[1];
    double secondHighestGrades = salutatorian(highestGrades, grades)[0];
    int salutatorianStudent = (int)salutatorian(highestGrades, grades)[1];

    displayStudents(grades);
    System.out.println("\nStudent with the highest grade is: Student # " + highestStudent + " With the average grades of " + highestGrades);
    System.out.println("\nStudent with the second highest grade is: Student # " + salutatorianStudent + " With the average grades of " + secondHighestGrades);

  }//end main method
  public static int[][] randomGrades(int[][] grades) {
    for(int i = 0;i < grades.length;i++){
      for(int a = 0;a < grades[i].length; a++){
      grades[i][a] = (int)(Math.random() * (100 - 55 + 1)) + 55;
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

  public static void displayStudents(int [][] grades){
    double average = 0;
    for(int j = 0; j < grades.length; j++){
      for(int k = 0; k < grades[j].length;k++){
        average += grades[j][k];
      }//end second for loops
      average /= 10;
      System.out.println("Student #" + (j+1) + ": " + average + "%");
      average = 0;
    }//end for loops
  }//end displayStudents method


}//end class
