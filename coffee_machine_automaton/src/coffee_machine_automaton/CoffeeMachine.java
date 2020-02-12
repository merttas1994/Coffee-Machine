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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
