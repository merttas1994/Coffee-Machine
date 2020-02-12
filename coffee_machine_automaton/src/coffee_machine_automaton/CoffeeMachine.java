/**
 * 
 */
package coffee_machine_automaton;

/**
 * @author merttas
 *
 */

import java.util.Scanner;

public class CoffeeMachine {

	static Scanner input=new Scanner(System.in);

	private double coffee_powder, milk, water, prc_milk_coffee, prc_filter_coffee, prc_filter_milk_coffee, prc_total=0.0;
	private int count_coffee = 0;

	public CoffeeMachine(){ // Initialization values to zero
		this.coffee_powder=0;
		this.milk=0;
		this.water=0;
	}

	private void setIngredient(){   // Filling Ingredient to the Machine
		System.out.println("\nIt is filling to the machine now...");
		this.coffee_powder = 1000.0;
		this.milk = 10;
		this.water= 10;
		System.out.println("Filling Completed.");
	} 

	private void getIngredient(){   // Getting the Current Status
		System.out.println("Available Coffee Powder(Gr) "+String.format("%.1f",this.coffee_powder));
		System.out.println("Available Milk(Lt) "+String.format("%.1f", this.milk));
		System.out.println("Available Water(Lt) "+String.format("%.1f", this.water));
	}

	private void cleanMachine(){ // Setting the values to zero for cleaning the Machine
		System.out.println("\nCleaning Machine...");
		this.coffee_powder = 0;
		this.milk = 0;
		this.water= 0;
		System.out.println("Cleaning Completed.");
	}

	private void makeCoffee(){  // Coffee Selection Menu to make coffee
		System.out.println("\n ------------------------- ");
		System.out.println("|      Select Type:          |"
				+          "\n ------------------------- "
				+        "\n| 1: Filter Coffee           |"
				+        "\n| 2: Coffee with Milk        |"
				+        "\n| 3: Filter Coffee with Milk |" 
				+      "\n\n| 0: Discard                 |");
		System.out.println(" --------------------------- \n");
		System.out.print("Please select your coffee: ");

		char t = input.next().charAt(0);
		switch(t){
		case '1':
			this.filterCoffee();     //Call to filterCoffee Method
			this.calculatePrices();
			System.out.println("\nYour price is "+this.prc_filter_coffee+"₺");
			prc_total=prc_total+this.prc_filter_coffee;
			break;
		case '2':
			this.milkCoffee();      //Call to milkCoffee Method
			this.calculatePrices();
			System.out.println("\nYour price is "+this.prc_milk_coffee+"₺");
			prc_total=prc_total+this.prc_milk_coffee;
			break;
		case '3':
			this.milkCoffee();      //Call to milkCoffee Method
			this.calculatePrices();
			System.out.println("\nYour price is "+this.prc_filter_milk_coffee+"₺");
			prc_total=prc_total+this.prc_filter_milk_coffee;
			break;	
		case '0':
			break;
		}
	}

	private void filterCoffee(){
		if(this.coffee_powder >= 10 && this.water >= 0.2){
			System.out.println("\nMaking Black Coffee...");
			System.out.println("\nTaking 10gm of Coffee Powder.");
			this.coffee_powder = this.coffee_powder - 10;
			System.out.println("Taking 0.2 liter of Water.");
			this.water = this.water - 0.2;
			System.out.println("\nYour Filter Coffee is Ready.");
			this.count_coffee++;

		}
		else{
			System.out.println("\nAvailable Coffee Power(Gr) "+String.format("%.1f",this.coffee_powder));
			System.out.println("Available Water(Lt) "+String.format("%.1f", this.water));
			System.out.println("\nSome Iteams Are Not Available, Please Fill before Making Coffee.");
		}
	}

	private void milkCoffee(){
		if(this.coffee_powder >= 10 && this.milk >= 0.4 && this.water >= 0.2){
			System.out.println("\nMaking Milk Coffee...");
			System.out.println("\nTaking 10gm of Coffee Powder.");
			this.coffee_powder = this.coffee_powder - 10;
			System.out.println("Taking 0.4 Liter of Milk.");
			this.milk = this.milk - 0.4;
			System.out.println("Taking 0.2 liter of Water.");
			this.water = this.water - 0.2;
			System.out.println("\nYour Milk Coffee is Ready.");
			this.count_coffee++;


		}
		else{
			System.out.println("\nAvailable Coffee Power(Gr) "+String.format("%.1f",this.coffee_powder));
			System.out.println("Available Milk(Lt) "+String.format("%.1f", this.milk));
			System.out.println("Available Water(Lt) "+String.format("%.1f", this.water));
			System.out.println("\nSome Iteams Are Not Available, Please Fill before Making Coffee.");
		}
	}

	private void coffeePrices(){
		System.out.println("------------- Prices ----------");
		System.out.println("1.Coffee with milk        : 10₺");
		System.out.println("2.Filter Coffee           : 15₺");
		System.out.println("3.Filter Coffee with milk : 20₺");
	}

	private void calculatePrices(){
		this.prc_milk_coffee=10;
		this.prc_filter_coffee=15;
		this.prc_filter_milk_coffee=20;
	}

	public void startMachine(){    // public start to access all private method of this class
		System.out.println(" ----------------------------------------------------------------");
		System.out.println("|                   Coffee Machine By Mert                       |");
		System.out.println(" ----------------------------------------------------------------");
		System.out.println("\nCurrent Status: ");
		this.getIngredient();

		boolean t = true;
		while(t){ // Infinity loop to see always the menu
			System.out.println("\n -------------------------------- ");
			System.out.println("|1:     Status of Ingredient     |\n -------------------------------- \n|2:"
					+ "      Fill Ingredient         |\n -------------------------------- \n|3:       Clean Machine          |"
					+ "\n -------------------------------- \n|4:        Make Coffee           |"
					+ "\n -------------------------------- \n|5: How Many Coffee We Have Made?|"
					+ "\n -------------------------------- \n|6:        Price List            |"
					+ "\n -------------------------------- \n|7:        Exit                  |");
			System.out.println(" -------------------------------- \n\n");
			System.out.print("Please make your choice: ");
			char c = CoffeeMachine.input.next().charAt(0);
			switch(c){
			case '1': 
				System.out.println("------------- Status ------------");
				this.getIngredient();
				System.out.println("---------------------------------");
				break;
			case '2':
				this.setIngredient();
				System.out.println("\nCurrent Status: ");
				this.getIngredient();
				break;
			case '3':
				this.cleanMachine();
				break;
			case '4':
				this.makeCoffee();
				this.calculatePrices();
				this.coffeePrices();
				break;
			case '5':
				System.out.println("\nWe Have Made "+this.count_coffee+" Coffee(s).");
				System.out.println("Your total price is "+prc_total);
				break;
			case '6':
				this.coffeePrices();
				break;
			case '7':
				System.out.println("\nExiting...\n");
				t = false;
				break;
			}   
		} 

	}

	public static class MakeCoffee{
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			Scanner scan = new Scanner(System.in);
			System.out.println("\nDo you want to run the Machine Y or N ?");

			char d;
			d = scan.next().charAt(0);

			if(d == 'Y' || d == 'y'){
				CoffeeMachine cm = new CoffeeMachine();     
				cm.startMachine();     
				System.out.println("Shutting Down...\n");
			}else
				System.out.println("Shutting Down...\n");

		}
	}
}