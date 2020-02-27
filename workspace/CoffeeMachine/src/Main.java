import java.util.Arrays;

//import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		boolean takeAnotherDrink = true;
		CoffeeMachine myCoffeeMachine = new CoffeeMachine();
		
		do {
			myCoffeeMachine.sayHello();
			
			myCoffeeMachine.displayDrinks();
			
			// On affiche les pièces que l'utilisateur peut rentrer
			myCoffeeMachine.displayInsertCoins();
			
			// On modifie le tableau des pièces entrées par l'utilisateur
			myCoffeeMachine.modifyCoinsEntered();
			
			//System.out.println(Arrays.toString(myCoffeeMachine.getCoinsEntered()));
			
			// On calcule et affiche la somme d'argent donnée par l'utilisateur
			int coinsEntered = myCoffeeMachine.calculateSumCoins(myCoffeeMachine.coinsEntered);
			myCoffeeMachine.displayCoinsEntered(coinsEntered);
			
			// On affiche les boissons que l'utilisateur peut choisir
			myCoffeeMachine.displayInsertDrink();

			// On récupère la boisson choisie par l'utilisateur ainsi que son prix
			int drinkChosen = myCoffeeMachine.getChosenDrink();
			
			// Si on a donné assez d'argent pour la boisson sélectionnée, on donne la boisson, on rend la monnaie et on met à jour le stock de pièces
			if (myCoffeeMachine.enoughMoneyGiven(drinkChosen, coinsEntered)) {
				myCoffeeMachine.modifyMachineCoins(coinsEntered, '+');
				
				int change;
				// Si on a assez de boissons dans la machine pour en donner une à l'utilisateur
				if (myCoffeeMachine.hasEnoughDrinks(drinkChosen)) {
					
					// On lui donne et on met à jour le stock de boissons de la machine
					myCoffeeMachine.giveDrink(drinkChosen);
					myCoffeeMachine.modifyMachineDrinks(drinkChosen);
					
					// On calcule la monnaie que l'on doit rendre à l'utilisateur et on la lui rend
					change = myCoffeeMachine.calculateChange(drinkChosen, coinsEntered);
					myCoffeeMachine.giveChange(change);
				}
				else {
					myCoffeeMachine.sayNotEnoughDrinks();
					change = coinsEntered;
					
					// Sinon on lui rend ses pièces
					myCoffeeMachine.giveChange(change);
				}
				
				// On modifie le stock de pièces de la machine
				myCoffeeMachine.modifyMachineCoins(change, '-');
				
				// Et on réinitialise le stock de pièces donné par l'utilisateur
				myCoffeeMachine.emptyArrayCoinsEntered();
			}
			
			// Sinon on rend l'argent donné et on prévient l'utilisateur
			else {
				myCoffeeMachine.notGiveDrink();
				myCoffeeMachine.giveChange(coinsEntered);
				coinsEntered = 0;
				myCoffeeMachine.emptyArrayCoinsEntered();
			}
			
			// On demande si l'utilisateur veut acheter une autre boisson
			myCoffeeMachine.displayGetAnotherDrink();
			takeAnotherDrink = myCoffeeMachine.buyAnotherDrink() == 0;
		}
		while(takeAnotherDrink);
		
		
		myCoffeeMachine.sayGoodbye();
		
	}

}
