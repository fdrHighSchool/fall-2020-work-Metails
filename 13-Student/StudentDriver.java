import java.util.Arrays;
public class StudentDriver {
  public static void main(String[] args) {
    Student student1 = new Student("Hans", "123456789");
    System.out.println(student1);

    student1.setName("Jian");
    System.out.println(student1);
    student1.addGrade(52);
    student1.addGrade(59);
    student1.addGrade(46);
    student1.addGrade(40);
    student1.addGrade(90);
    student1.addGrade(96);
    student1.addGrade(72);
    student1.addGrade(89);
    student1.addGrade(80);
    student1.addGrade(79);
    student1.addGrade(105);
    student1.addGrade(91);
    student1.addGrade(102);

  }//end main method

}//end class
