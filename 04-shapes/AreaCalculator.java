import java.lang.*;

class AreaCalculator{
  public static void main(String[] args) {
      System.out.println("This is the area of a Square: " + squareAreaCalculator(6));
      System.out.println("The area of this square is: " + rectangleAreaCalculator(7, 8));
      System.out.println("This is the area of a circle: " + circleAreaCalculator(6));
    System.out.println("This is the area of this right triangle: " + rightTriangleAreaCalculator(25,15));
      System.out.println();
      System.out.println("The volume of this cube is: " + cubeVolCalculator(6));
      System.out.println("The volume of this rectangular prism is: " + rectangularPrismVolCal(rectangleAreaCalculator(7, 8), 6));
      System.out.println("The volume of this sphere is " + sphereVolumeCal(6));
      System.out.println("The volume of this right triangular prism is " + rightTriangularPrismVolCal(rightTriangleAreaCalculator(25, 15) , 18));
      }//end main class

      public static double squareAreaCalculator(double length){
        double areaSquare = Math.pow(length, 2);
        return areaSquare;
      }//end square area calculator method

      public static double rectangleAreaCalculator(double length, double width){
        double area = length * width;
        return area;
      }
      public static double circleAreaCalculator(double radius){
        double areaCircle = Math.PI * radius * radius;
        return areaCircle;
      }//end circle area calculator method

      public static double rightTriangleAreaCalculator(double base,double height){
       double areaTriangle = base * height / 2;
       return areaTriangle;
      }//end area triangle calculator method

      //a^3
      public static double cubeVolCalculator(double length){
        double volume = Math.pow(length,3);
        return volume;
      }//end cubeAreaCalculator method

      // L*W*H or area * height
      public static double rectangularPrismVolCal(double area, double height){
        double volume = area * height;
        return volume;
      }//end triangularPrismAreaCal method

      // V = 0.5 * base * altitude * height
      public static double rightTriangularPrismVolCal(double area, double height){
        double volume = (area * height) / 2;
        return volume;
      }//end triangularPrismVolCal method

      // 4/3*pi*r^3
      public static double sphereVolumeCal(double radius){
        double volume = (4.0/3) * Math.PI * Math.pow(radius, 3);
        return volume;
      }//end sphereVolumeCal method



}//end class
