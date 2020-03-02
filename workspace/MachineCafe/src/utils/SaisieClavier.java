package utils;
import java.util.Scanner;

public class SaisieClavier {
	
	public static int lireEntier(String inviteSaisie) {
		Scanner scan = new Scanner(System.in);
		
		int saisie; // saisie réalisée par l'utilisateur
		
		System.out.println(inviteSaisie);
		while (!scan.hasNextInt()) { // tant que la future saisie n'est pas un int
			System.out.println("un entier on t'a dit ! "); // message d'erreur
			System.out.println(inviteSaisie);
			scan.next(); // evecue la saisie invalide
		}
		
		saisie = scan.nextInt(); // à ce niveau je prend la saisie valide
		
		return saisie;
	}

}
