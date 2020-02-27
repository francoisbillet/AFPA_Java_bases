import java.util.Arrays;

//import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		boolean takeAnotherDrink = true;
		CoffeeMachine myCoffeeMachine = new CoffeeMachine();
		
		do {
			myCoffeeMachine.sayHello();
			
			myCoffeeMachine.displayDrinks();
			
			// On affiche les pi�ces que l'utilisateur peut rentrer
			myCoffeeMachine.displayInsertCoins();
			
			// On modifie le tableau des pi�ces entr�es par l'utilisateur
			myCoffeeMachine.modifyCoinsEntered();
			
			//System.out.println(Arrays.toString(myCoffeeMachine.getCoinsEntered()));
			
			// On calcule et affiche la somme d'argent donn�e par l'utilisateur
			int coinsEntered = myCoffeeMachine.calculateSumCoins(myCoffeeMachine.coinsEntered);
			myCoffeeMachine.displayCoinsEntered(coinsEntered);
			
			// On affiche les boissons que l'utilisateur peut choisir
			myCoffeeMachine.displayInsertDrink();

			// On r�cup�re la boisson choisie par l'utilisateur ainsi que son prix
			int drinkChosen = myCoffeeMachine.getChosenDrink();
			
			// Si on a donn� assez d'argent pour la boisson s�lectionn�e, on donne la boisson, on rend la monnaie et on met � jour le stock de pi�ces
			if (myCoffeeMachine.enoughMoneyGiven(drinkChosen, coinsEntered)) {
				myCoffeeMachine.modifyMachineCoins(coinsEntered, '+');
				
				int change;
				// Si on a assez de boissons dans la machine pour en donner une � l'utilisateur
				if (myCoffeeMachine.hasEnoughDrinks(drinkChosen)) {
					
					// On lui donne et on met � jour le stock de boissons de la machine
					myCoffeeMachine.giveDrink(drinkChosen);
					myCoffeeMachine.modifyMachineDrinks(drinkChosen);
					
					// On calcule la monnaie que l'on doit rendre � l'utilisateur et on la lui rend
					change = myCoffeeMachine.calculateChange(drinkChosen, coinsEntered);
					myCoffeeMachine.giveChange(change);
				}
				else {
					myCoffeeMachine.sayNotEnoughDrinks();
					change = coinsEntered;
					
					// Sinon on lui rend ses pi�ces
					myCoffeeMachine.giveChange(change);
				}
				
				// On modifie le stock de pi�ces de la machine
				myCoffeeMachine.modifyMachineCoins(change, '-');
				
				// Et on r�initialise le stock de pi�ces donn� par l'utilisateur
				myCoffeeMachine.emptyArrayCoinsEntered();
			}
			
			// Sinon on rend l'argent donn� et on pr�vient l'utilisateur
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
