import java.util.Scanner;

public class myScanner {

	private Scanner sc;

	public myScanner() {
		this.sc = new Scanner(System.in);
	}
	
	public int getInput() {
		String input;
		input = this.sc.nextLine();
		//System.out.println(input);
		try {
			return Integer.parseInt(input);
		}
		catch(Exception e) {
			//System.out.println("error");
			return 99;
		}
		
	}
	
	public int[] getCoinsEntered() {
		boolean end = false;
		int[] coinsEntered = {0,0,0,0,0};
		do {
			System.out.println("Votre choix : (-1 pour sortir) ");
			int choice = 0;
			choice = getInput();
			
			if (choice < -1 || choice > coinsEntered.length - 1) {
				if (choice == 99) {
					System.out.println("Veuillez rentrer un entier" + "\n");
				}
				else {
					System.out.println("Veuillez rentrer un nombre compris entre -1 et " + (coinsEntered.length-1) + "\n");
				}
			}
			else {
				if (choice == -1) {
					end = true;
				}
				else {
					coinsEntered[choice] += 1;
				}
			}
			
		}
		while (!end);
		System.out.println("");
		
		return coinsEntered;
	}
	
	public int getChosenDrink() {
		boolean end = false;
		int choice = 0;
		do {
			System.out.println("Votre choix : (-1 pour sortir) ");
			choice = getInput();
			
			if (choice < -1 || choice > 1) {
				if (choice == 99) {
					System.out.println("Veuillez rentrer un entier" + "\n");
				}
				else {
					System.out.println("Veuillez rentrer un nombre compris entre -1 et 1" + "\n");
				}
			}
			else {
				end = true;
			}
				
		}
		while (!end);
		
		return choice;
	}
	
}
