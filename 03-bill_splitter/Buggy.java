import java.util.Scanner;

 class Buggy{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Bill-Splitter");
		System.out.print("Enter the total, pre-tax: ");

		double total = input.nextDouble();
		System.out.print("How many people? ");

		int numPeople = input.nextInt();
		double perPerson = total / numPeople;
    double tipsPerPerson = total * .08/ numPeople;

		System.out.println("Each person must pay $" + perPerson + " plus 8% of tips equally distributed to each person which would be " + tipsPerPerson + " dollars");


	}//end main method
}//end class
