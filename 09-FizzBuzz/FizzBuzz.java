public class FizzBuzz{
  public static void main(String[] args) {
    int upperBound = 100;

    for(int i = 1; i <= upperBound; i++){
      //insert logic here to execute FizzBuzz and generate output
      if(isFizz(i)){//when i can be divide by 3 with no remiander
        System.out.println(i + ":" + "Fizz!");
      }else if(isBuzz(i)){//when i can be divide by 5 with no remainder
        System.out.println(i + ":" + "Buzz!");
      }else if (isFizz(i) && isBuzz(i)){ //when i is able to be divide by 3 and 5 with no remainder
        System.out.println(i + ":" + "FizzBuzz!!!!");
      }else //when none of them can divide
        System.out.println(i + ":" + i);
    }//end for loop

  }//end main method

  //***********************************************************//

  /*
   * N: isFizz
   * P: determine if the number is to be classified as "fizz"
        a number is classified as "fizz" if it's divisible by 3
   * I: an integer
   * R: true/false value
   */
  public static boolean isFizz(int num){
    return (num % 3 == 0);
  }//end isFizz method

  //***********************************************************//

  /*
   * N: isBuzz
   * P: determine if the number is to be classified as "buzz"
        a number is classified as "buzz" if it's divisible by 5
   * I: an integer
   * R: true/false value
   */
  public static boolean isBuzz(int num){
    return (num % 5 == 0);
  }//end isBuzz method

}//end class
