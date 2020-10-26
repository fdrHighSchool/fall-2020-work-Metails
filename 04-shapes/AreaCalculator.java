import java.lang.*;

class AreaCalculator{
  public static void main(String[] args) {
      squareAreaCalculator(6);
      System.out.println();
      circleAreaCalculator(6);
      System.out.println();
      triangleAreaCalculator(16,15);
      System.out.println();
      System.out.println("The volume of this cube is: " + cubeVolCalculator(6));
      System.out.println("The volume of this rectangular prism is: " + rectangularPrismVolCal(5,9,6));
      System.out.println("The volume of this sphere is " + sphereVolumeCal(6));
      System.out.println("The volume of this triangular prism is " + triangularPrismVolCal(14,25,15,25));
      }//end main class

      public static void squareAreaCalculator(double length){
        double areaSquare = length * length;
        System.out.print("This is the area of a Square: " +areaSquare);
      }//end square area calculator method

      public static void circleAreaCalculator(double radius){
        double areaCircle = Math.PI * radius * radius;
        System.out.print("This is the area of a circle: " +areaCircle);
      }//end circle area calculator method

      public static void triangleAreaCalculator(double base,double height){
       double areaTriangle = base * height / 2;
       System.out.print("This is the area of a triangle: " + areaTriangle);
      }//end area triangle calculator method

      public static double cubeVolCalculator(double length){
        double volume = Math.pow(length,3);
        return volume;
      }//end cubeAreaCalculator method

      public static double rectangularPrismVolCal(double width, double height, double length){
        double volume = width * height * length;
        return volume;
      }//end triangularPrismAreaCal method

      public static double triangularPrismVolCal(double bside1, double bside2, double bside3, double height){
        double volume = ((1.0/4) * height) * Math.sqrt(-1 * Math.pow(bside1, 4) + 2 * (Math.pow(bside1 * bside2, 2)) + 2 * (Math.pow(bside1 * bside3, 2)) - Math.pow(bside2, 4) + 2 *
        (Math.pow(bside2 * bside3, 2)) - (Math.pow(bside3, 4)));
        return volume;
      }//end triangularPrismVolCal method

      public static double sphereVolumeCal(double radius){
        double volume = (4.0/3) * Math.PI * Math.pow(radius, 3);
        return volume;
      }//end sphereVolumeCal method



}//end class
