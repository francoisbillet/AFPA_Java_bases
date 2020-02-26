import java.util.Arrays;

//import java.util.Arrays;
//import java.util.ArrayList;

public class CoffeeMachine extends MoneyManager {
	
	private myScanner mySc;
	
	public CoffeeMachine() {
		super();
		this.mySc = new myScanner();
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
		boolean end = false;
		do {
			System.out.println("Votre choix : ");
			int choice = this.mySc.getInput();
			//int choice = Integer.parseInt(input);
			if (choice < -1 || choice > this.coinsEntered.length - 1) {
				System.out.println("Veuillez rentrer un nombre compris entre -1 et " + (this.coinsEntered.length-1));
			}
			else {
				if (choice == -1) {
					end = true;
				}
				else {
					this.coinsEntered[choice] += 1;
				}
			}
			
		}
		while (!end);
		System.out.println("");
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
		return this.mySc.getInput();
	}
	
	public boolean enoughMoneyGiven(int drink_index, int coinsEntered) {
		return coinsEntered >= (Drink.values()[drink_index].getPrice());
	}
	
	public void giveDrink(int drink_index) {
		System.out.println("");
		System.out.println("Voilà votre " + (Drink.values()[drink_index].getName()) + " !");
		// On enlève une boisson correspondante du stock
	}
	
	public int calculateChange(int drink_index, int coinsEntered) {
		int change = coinsEntered - (Drink.values()[drink_index].getPrice());
		return change;
	}
	
	public void giveChange(int change) {
		System.out.println("Je vous rends " + change/100 + " € et " + change%100 + " centimes" + "\n");
	}
 
	public void modifyMachineCoins(int change, char op) {
		for (int i=this.machineCoins.length - 1; i>=0; i--) {
			if (change/this.machineCoins[i][0] > 0) {
				if (op == '+') {
					this.machineCoins[i][1] += change/this.machineCoins[i][0];
				}
				else if (op == '-') {
					this.machineCoins[i][1] -= change/this.machineCoins[i][0];
				}
				change = change%this.machineCoins[i][0];
			}
			//System.out.println(change);
		}

		for (int j=0; j<this.machineCoins.length; j++) {
				System.out.println(this.machineCoins[j][0] + " " + this.machineCoins[j][1]);
		}
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
		return this.mySc.getInput();
	}
	
	public void sayGoodbye() {
		System.out.println("Au revoir et à bientôt !");
	}
	
}
