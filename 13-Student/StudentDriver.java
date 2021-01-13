import java.util.Arrays;
public class StudentDriver {
  public static void main(String[] args) {
    Student student1 = new Student("Hans", "123456789");
    System.out.println(student1);

    student1.setName("Jian");
    System.out.println(student1);
    student1.fillArray();
    student1.addGrade(100);

  }//end main method

}//end class
