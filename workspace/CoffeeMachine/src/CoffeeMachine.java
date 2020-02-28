import java.util.Arrays;

//import java.util.Arrays;
//import java.util.ArrayList;

public class CoffeeMachine extends MoneyManager {
	
	private myScanner mySc;
	protected int[][] machineCoins;
	protected int[] coinsEntered;
	protected int[][] machineDrinks;
	
	public CoffeeMachine() {
		super();
		this.mySc = new myScanner();
		this.machineCoins = new int[][] {{10,0},{20,5},{50,5},{100,5},{200,5}};
		this.coinsEntered = new int[] {0,0,0,0,0};
		this.machineDrinks = new int[][] {{0,2},{1,2}};
	}
	
	public void sayHello() {
		System.out.println("Bienvenue à la machine à café !" + "\n");
	}
	
	public void displayDrinks() {
		System.out.println("Boissons disponibles :");
		for (Drink d : Drink.values()) {
			System.out.println(d.getName() + ": " + d.getPrice() + " cts");
		}
		System.out.println("");
	}
	
	public void displayInsertCoins() {
		System.out.println("Insérez une pièce : ");
		System.out.println("0. 10 cts");
		System.out.println("1. 20 cts");
		System.out.println("2. 50 cts");
		System.out.println("3. 1 €");
		System.out.println("4. 2 €");
		System.out.println("-1. Fin" + "\n");
	}
	
	// Cette méthode modifie le tableau coinsEntered
	public void modifyCoinsEntered() {
		this.coinsEntered = mySc.getCoinsEntered();
	}
	
	public int calculateSumCoins(int[] coins) {
		return coins[0]*10 + coins[1]*20 + coins[2]*50 + coins[3]*100 + coins[4]*200;
	}
	
	public void displayCoinsEntered(int sumCoins) {
		System.out.println("Vous avez donné " + sumCoins/100 + " € et " + sumCoins%100 + " centimes" + "\n");
	}
	
	public void displayInsertDrink() {
		int cpt = 0;
		System.out.println("Choisissez votre boisson :");
		for (Drink d : Drink.values()) {
			System.out.println(cpt + ". " + d.getName() + ": " + d.getPrice() + " cts");
			cpt ++;
		}
		System.out.println("");
	}
	
	public int getChosenDrink() {
		return mySc.getChosenDrink();
	}
	
	public boolean enoughMoneyGiven(int drink_index, int coinsEntered) {
		return coinsEntered >= (Drink.values()[drink_index].getPrice());
	}
	
	// TODO problème monnaie
	public void modifyMachineCoins(int change, char op) {
		for (int i=this.machineCoins.length - 1; i>=0; i--) {
			if (change/this.machineCoins[i][0] > 0) {
				if (op == '+') {
					this.machineCoins[i][1] += change/this.machineCoins[i][0];
				}
				else if (op == '-') {
					// Si il n'y a pas assez de pièces dans la machine
					if (this.machineCoins[i][1] - change/this.machineCoins[i][0] < 0) {
						System.out.println("Je suis désolé mais je n'ai pas assez de monnaie pour vous...");
					}
					else {
						this.machineCoins[i][1] -= change/this.machineCoins[i][0];
					}
				}
				change = change%this.machineCoins[i][0];
			}
			//System.out.println(change);
		}

		for (int j=0; j<this.machineCoins.length; j++) {
				//System.out.println(this.machineCoins[j][0] + " " + this.machineCoins[j][1]);
		}
	}
	
	public boolean hasEnoughDrinks(int drinkChosen) {
		return this.machineDrinks[drinkChosen][1] > 0;
	}
	
	public void modifyMachineDrinks(int drinkChosen) {
		this.machineDrinks[drinkChosen][1] -= 1;
		System.out.println(this.machineDrinks[drinkChosen][1]);
	}
	
	public void giveDrink(int drink_index) {
		System.out.println("");
		System.out.println("Voilà votre " + (Drink.values()[drink_index].getName()) + " !");
		// On enlève une boisson correspondante du stock
	}
	
	public void sayNotEnoughDrinks() {
		System.out.println("Je suis désolé mais je n'ai plus assez de cette boisson..." + "\n");
	}
	
	public int calculateChange(int drink_index, int coinsEntered) {
		int change = coinsEntered - (Drink.values()[drink_index].getPrice());
		return change;
	}
	
	public void giveChange(int change) {
		System.out.println("Je vous rends " + change/100 + " € et " + change%100 + " centimes" + "\n");
	}
	
	public void emptyArrayCoinsEntered() {
		this.coinsEntered = new int[] {0,0,0,0,0};
	}
	
	public void notGiveDrink() {
		System.out.println("Vous n'avez pas donné assez d'argent pour acheter cette boisson..");
	}
	
	public void displayGetAnotherDrink() {
		System.out.println("Voulez-vous acheter une autre boisson ?");
		System.out.println("0. Oui");
		System.out.println("1. Non" + "\n");
	}
	
	public int buyAnotherDrink() {
		return mySc.getChosenDrink();
	}
	
	public void sayGoodbye() {
		System.out.println("Au revoir et à bientôt !");
	}
	
}
