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

      // amount of base coins to their bank (can be random or fixed)
      Scanner input = new Scanner(System.in);
      System.out.println("What will you do next?\n1.Play\n2.Shop\n3.Quit");

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



  }//end main method


  //Play method(creates random gold for reward and then return the value back.)
  public static int play(int coins) {
    Random rand = new Random();
    int min = 50;
    int max = 70;
    //generate random number from selected range as reward.
    int reward = (int)(Math.random() * (max - min + 1) + min);
    return reward;
  }//end play method



  public static int shop(int coins) { //Shop method
    Scanner input = new Scanner(System.in);
    int item1 = 240;
    int item2 = 150;

    System.out.println("You have coins $" + coins + "\nWhat items do you want to buy?\n1)item1 = $240\n2)item2 = $150\n3)quit shop");
    // ask for options
    int item = input.nextInt();
    int remain = 0; // set a main "remain" coins for all items

    //if statement when player don't have enough to purchase item
    if(item == 1) {
      if (coins < item1){ //not enough coins for item1
        System.out.println("Not enough coin\nYou still have coins: " + coins);
      } //end not enough coin for item 1 <

      //if statement for returning value after purchases.
      if (coins >= item1){
        remain = coins - item1;
        System.out.println("You now have remain coins: " + remain);
        coins = remain;
      } //end >=
    }//end item 1 if statement

    //if statement when player don't have enough coins to purchase this item.
    if (item == 2){
      if (coins < item2){ //not enough coins for item2
        System.out.println("Not enough coin\nYou still have coins: " + coins);
      } //end item 2 if statement<

      //if statement to return value when player selected this option.
      if (coins >= item2){
        remain = coins - item2; //calculate remain by minus item's value
        System.out.println("You now have remain coins: " + remain);
        coins = remain; //store the final coins equals to the remain
      } //end >=
    } //end item 2 if statement
    return coins; 

  }//end shop method

}//end class
