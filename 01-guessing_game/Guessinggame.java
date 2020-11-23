import java.util.Scanner;
import java.lang.Math;

class Guessinggame {


  //Initial Number variables
   public static void main(String[] args) {
   String Name;
   String oddorEven;
   String decision;
   int range;
   int minimum;
   int sugoiAnswer;
   int attempts = 0;
   int numberWrong = 0;
   int maxnum;


   Scanner in = new Scanner(System.in);







 //Asking the player and the calculation
  boolean keepPlaying = true;

   System.out.print("What is your name? ");
   Name = in.nextLine();
   System.out.println("Hello, " + Name + " Let's play a guessing game!");

while (keepPlaying == true){
   System.out.println("Choose your range: ");
   maxnum = in.nextInt();
   System.out.println("Choose your minimum: ");
   minimum = in.nextInt();
   range = (maxnum - minimum + 1);
   System.out.println("Guess the number from " + minimum + " to " + maxnum);
   System.out.print("Guess the number: ");
   sugoiAnswer = in.nextInt();
   int rnm = (int)(Math.random()*range) + minimum;
   if (sugoiAnswer != rnm){
     attempts++;
   }






 //Number generation and loop



   while (sugoiAnswer != rnm){
     if (rnm % 2 == 0){
     oddorEven = ("even");
   }else{
     oddorEven = ("odd");
   }
     if (sugoiAnswer > rnm){

       System.out.println("The answer is smaller than " + sugoiAnswer + " and it's a " + oddorEven +" number, please try again:");
     }
     if (sugoiAnswer < rnm){

       System.out.println("The answer is bigger than " + sugoiAnswer + " and it's a " + oddorEven + " number, please try again:");
     }
        sugoiAnswer = in.nextInt();
        attempts++;

    }


      if (sugoiAnswer == rnm){
       System.out.println("Wow! You got it! it took you " + attempts + " retries to get it right, You're such a big brain!");
       keepPlaying = false;

      }

}

/*
I added the feature of hinting the player if the answer is a odd or a even number,
but I got stucked for hours into how to make the feature of restarting the game.
*/



  }





















}
