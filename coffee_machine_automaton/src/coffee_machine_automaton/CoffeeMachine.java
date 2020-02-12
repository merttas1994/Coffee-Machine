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
	
	private double coffee_powder, milk, water;
    private int count_coffee = 0;
    
    public CoffeeMachine(){ // Initial values to zero...
        this.coffee_powder=0;
        this.milk=0;
        this.water=0;
    }
    
    private void setIngredient(){   // Fill Ingredient to Machine
        System.out.println("\nIt is filling to machine now...");
        this.coffee_powder = 1000.0;
        this.milk = 10;
        this.water= 10;
        System.out.println("Filling Completed.");
    } 
    
    private void getIngredient(){   // To Get Status
        System.out.println("Available Coffee Powder(Gr) "+String.format("%.1f",this.coffee_powder));
        System.out.println("Available Milk(Lt) "+String.format("%.1f", this.milk));
        System.out.println("Available Water(Lt) "+String.format("%.1f", this.water));
}
    
    private void cleanMachine(){ // To set the values to zero
        System.out.println("\nCleaning Machine...");
        this.coffee_powder = 0;
        this.milk = 0;
        this.water= 0;
        System.out.println("Cleaning Completed.");
    }
    
    private void makeCoffee(){  //Coffee Selection Menu
        System.out.println("\n ------------------------- ");
        System.out.println("|      Select Type:          |"
        		+          "\n ------------------------- "
        		+        "\n| 1: Filter Coffee           |"
        		+        "\n| 2: Coffee with Milk        |"
        		+        "\n| 3: Filter Coffee with Milk |" 
        		+      "\n\n| 0: Discard                 |");
        System.out.println(" --------------------------- \n");
        char t = input.next().charAt(0);
        switch(t){
            case '1':
                this.filterCoffee();     //Call to BlackCoffee Method
                break;
            case '2':
                this.milkCoffee();      //Call to MilkCoffee Method
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
            System.out.println("\nAvailable Coffee Power(Gram) "+String.format("%.1f",this.coffee_powder));
            System.out.println("Available Water(Liter) "+String.format("%.1f", this.water));
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
            System.out.println("\nAvailable Coffee Power(Gram) "+String.format("%.1f",this.coffee_powder));
            System.out.println("Available Milk(Liter) "+String.format("%.1f", this.milk));
            System.out.println("Available Water(Liter) "+String.format("%.1f", this.water));
            System.out.println("\nSome Iteams Are Not Available, Please Fill before Making Coffee.");
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
