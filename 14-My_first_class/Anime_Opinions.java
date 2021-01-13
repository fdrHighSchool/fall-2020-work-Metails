import java.util.*;
public class Anime_Opinions{
  private String animeChoice1;
  private String animeChoice2;
  private String animeChoice3;
  private String favorite;

//constructor method
public Anime_Opinions(String anime1, String anime2, String anime3){
  this.animeChoice1 = anime1;
  this.animeChoice2 = anime2;
  this.animeChoice3 = anime3;
}//end Anime_Weebs constructor method

public void displayAnimeChoices(){
  System.out.println("1." + this.animeChoice1);
  System.out.println("2." + this.animeChoice2);
  System.out.println("3." + this.animeChoice3);
}//end displayFinalAnime method

public void personsChoice(){
  Scanner prefered = new Scanner(System.in);
  System.out.println("Which one do you prefered? Chooses starting from your favorite then to your least favorite by picking 1, 2 or 3: ");
  String playerChoice = prefered.nextLine();

  if(playerChoice.equals("1")){
  this.favorite = this.animeChoice1;
  }
  if(playerChoice.equals("2")){
  this.favorite = this.animeChoice2;
  }
  if(playerChoice.equals("3")){
  this.favorite = this.animeChoice3;
  }//last bracket of above if statement

}//end personsChoice method

public String toString(){
  return "His favorite Anime is: " + favorite;
}//end weebsChoice


}//end class
