import java.util.Arrays;

public class Student {
  // instance variables
  private String name;
  private String osis;
  private double average;
  private int[] grades;

  //------------------------------------------------//

  // constructor
  public Student(String n, String o) {
    this.name = n;
    this.osis = o;
    grades = new int[10];
  }//end constructor method

  //------------------------------------------------//

  // other methods
  public String getName() {

    return "";
  }//end getName method


  public String getOSIS() {

    return "";
  }//end getOSIS method


  public void setName(String name) {
    this.name = name;

  }//end setName method

  public void fillArray(){
    for(int arrayCount = 0; arrayCount < this.grades.length; arrayCount++){
      this.grades[arrayCount] = (int)(Math.random() * 46 + 55);
    }//end for loop
  }//end fillArray method

  /*
   * N: addGrade
   * P: take-in a single grade and add it to the student's gradebook.
        should find the first non-zero index in the array and insert the grade
        there. if there is no room for that value, replace the lowest grade in
        array with it.
   * I: grade (int)
   * R: n/a
   */
  public void addGrade(int grade) {
    int spaceIndex = 0;
    int lowestNumber = this.grades[0];
    boolean space = false;
    int lowestIndex = 0;

    for(int count = 1; count <= this.grades.length; count++){
      if(this.grades[(this.grades.length - count)] == 0){
        space = true;
        spaceIndex = this.grades.length - count;
      }//end if statement
    }//end for loop of count

      if(space == true){
        this.grades[spaceIndex] = grade;
      }else{
        for(int countLowest = 0; countLowest < this.grades.length; countLowest++){
          //System.out.println(this.grades[countLowest] + " < " + lowestNumber);
          if(this.grades[countLowest] < lowestNumber){
            lowestNumber = this.grades[countLowest];
            lowestIndex = countLowest;
          }//end if statement
        }//end countLowest for loop

        this.grades[lowestIndex] = grade;
      }//end else statement

      System.out.println(Arrays.toString(this.grades));

  }//end addGrade method


  public double calculateAverage() {
  double total = 0;
  int totalAdded = 0;
  int[] arrays = new int[10];
 for(int i = 0; i < arrays.length; i++){
   if(arrays[i] != 0){
     total += arrays[i];
     totalAdded++;
   }//end if statement
 }
 if(totalAdded == 0){
System.out.println("There's no grade in here");
 }else{
  this.average = total/totalAdded;
 }//end else statement

    return this.average;
  }//end calculateAverage() method

  /*
   * Returns the String representation of a Student.
   * Right now, we are choosing to display the student's name and OSIS.
   * NOTE: This method overrides the default toString method that
   *       displays the memory address.
   */

   public void displayGrades(){
     System.out.println(Arrays.toString(grades));
   }//end displayGrades


  public String toString() {
    return "Student: " + this.name + " OSIS: " + this.osis;

  }//end toString method


}//end class
