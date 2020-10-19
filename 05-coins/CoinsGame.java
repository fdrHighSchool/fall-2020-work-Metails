/*
Names:
Thomas Huang
Jian Hua Deng
Jing Lun Ma
*/

import java.util.*;

class CoinsGame {

  public static void main(String[] args) {//main method
    System.out.println("You have a starting coins with 100.");
    int coins = 100; // starting money
    int fcoins = 0; // gain of money(added to the total money)
    while (true) { //a while loop could go forever
      // greet the user of your with a certain
      // amount of base coins to their bank (can be random or fixed)
      Scanner input = new Scanner(System.in);
      System.out.println("What will you do next?\n1.Play\n2.Shop\n3.Quit");
      // aske the user for what to do next
      int chose = input.nextInt();

      //Allowing player to select options.
      if (chose == 1) { //Play
        int reward = play(fcoins); //use of return statement in play()
        System.out.println("You've got a reward of coins: " + reward);
        fcoins = coins + reward; // calculate final coins after rewarded
        System.out.println("Now you have coins: " + fcoins);
        coins = fcoins; // store the coins as the final coins
      } //end chose 1
      if (chose == 2){ //Shop
        coins = (shop(coins));
        //use of return statement to store the remaining coins
      } //end chose 2

      if (chose == 3) { //Quit
        System.out.println("Bye");
        break; //end the code
      } //end chose 3
    }


    // create a looping structure that allows the user to play
    // A) a fixed number of rounds
    // OR
    // B) until they choose to quit
    // (this is prefereable, but we didn't review this type of loop yet)


    // in the loop, present the user with a menu of options that asks the      user what they want to do:
    // 1. play
    // 2. shop
    // 3. quit
    // (feel free to add more options to this if you're inspired)

    // based on their entry, call the method to perform that behavior
    // at all times, keep updating the user's bank balance
  }//end main method


  /*
   * Name: play
   * Purpose: simulate a round of the game, award the user a random
              amount of coins for playing
   * Input: ???
   * Return: a random number of coins the user won that round
   */
  public static int play(int coins) {//Play method(creates random gold for reward and then return the value back.)
    Random rand = new Random();
    int min = 50;
    int max = 70;
    //generate random number from selected range as reward.
    int reward = (int)(Math.random() * (max - min + 1) + min);
    return reward;
  }//end play method


  /*
   * Name: shop
   * Purpose: allow the player to spend coins
   * Input: amount of coins user currently has
   * Return: how many coins spent/updated balance
   */
  public static int shop(int coins) { //Shop method
    Scanner input = new Scanner(System.in);
    int item1 = 240;
    int item2 = 150;
    // set items' values
    System.out.println("You have coins $" + coins + "\nWhat items do you want to buy?\n1)item1 = $240\n2)item2 = $150\n3)quit shop");
    // ask for options
    int item = input.nextInt();
    int remain = 0; // set a main "remain" coins for all items
    if(item == 1) { // when user chose is item1
      if (coins < item1){ //not enough coins for item1
        System.out.println("Not enough coin\nYou still have coins: " + coins);
      } //end not enough coin for item 1 <

      if (coins >= item1){ //purchasing the item1
        remain = coins - item1; //calculate remain by minus item's value
        System.out.println("You now have remain coins: " + remain);
        coins = remain; //store the final coins equals to the remain
      } //end >=
    }//end item 1 if statement

    if (item == 2){ // when user chose is item2
      if (coins < item2){ //not enough coins for item2
        System.out.println("Not enough coin\nYou still have coins: " + coins);
      } //end item 2 if statement<

      if (coins >= item2){ //purchasing the item2
        remain = coins - item2; //calculate remain by minus item's value
        System.out.println("You now have remain coins: " + remain);
        coins = remain; //store the final coins equals to the remain
      } //end >=
    } //end item 2 if statement
    return coins; // return for the coins value for shop()

  }//end shop method

}//end class
