import java.util.Arrays;

public class Student {
  // instance variables
  private String name;
  private String osis;
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

    for(int count = 0; count < this.grades.length; count++){
      if(this.grades[count] == 0){
        space = true;
        spaceIndex = count;
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

    return 0.0;
  }//end calculateAverage() method

  /*
   * Returns the String representation of a Student.
   * Right now, we are choosing to display the student's name and OSIS.
   * NOTE: This method overrides the default toString method that
   *       displays the memory address.
   */
  public String toString() {
    return "Student: " + this.name + " OSIS: " + this.osis;

  }//end toString method


}//end class
