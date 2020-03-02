import utils.Boissons;
import utils.Menu;
import utils.Pieces;

public class Lanceur {

	public static void main(String[] args) {
		
		Stockeur<Boisson> stockBoissons = new Stockeur();
		Monnayeur stockPieces = new Monnayeur();
		 
		// On ajoute les boissons dans le stock de boissons
		for (int i=0; i<Boissons.values().length; i++) {
			stockBoissons.addItem(new Boisson(i, Boissons.values()[i].getNom(), Boissons.values()[i].getPrix(), Boissons.values()[i].getQte()));
		}
		
		// On ajoute les pièces dans le stock de pièces
		for (int i=0; i<Pieces.values().length; i++) {
			stockPieces.addItem(new Piece(Pieces.values()[i].getId(), Pieces.values()[i].getNom(), Pieces.values()[i].getValeur(), Pieces.values()[i].getQuantite()));
		}
		
		String[] boissonsEnString = stockBoissons.stockEnString();
		String[] piecesEnString = stockPieces.stockEnString();
		
		boolean continuer = true;
		
		do {
		
			Menu menuBoisson = new Menu("Choix boisson", boissonsEnString);
			
			// tant que l'utilisateur ne saisit pas une boisson qui existe, on réaffiche le message :
			// Si il saisit 99, on annule
			menuBoisson.afficherMenu();
			int boissonChoisie = -1;
			do {
				boissonChoisie = menuBoisson.lireChoixMenu();
				if (boissonChoisie == 99) {
					break;
				}
				else if (boissonChoisie < 0 || boissonChoisie > boissonsEnString.length) {
					System.out.println("Saisissez un entier compris entre 0 et " + (boissonsEnString.length-1) + " ou 99");
				}
			}
			while (boissonChoisie < 0 || boissonChoisie > boissonsEnString.length);
			
			if (boissonChoisie == 99) {
				System.out.println("Au revoir !");
				continuer = false;
			}
			else {
				System.out.println("-------------------------");
				System.out.println("Vous avez choisi "+ boissonsEnString[boissonChoisie] + "\n");
				
				Menu menuPiece = new Menu("Insérez une pièce ", piecesEnString);
				
				// tant que l'utilisateur ne saisit pas assez d'argent pour acheter sa boisson, on réaffiche le message :
				// Si il saisit 99, on annule
				menuPiece.afficherMenu();
				
				int pieceChoisie;
				int sommePieces = 0;
				int prixBoissonChoisie = stockBoissons.getItem(boissonChoisie).getValeur();
				do {
					pieceChoisie = menuPiece.lireChoixMenu();
					if (pieceChoisie == 99) {
						break;
					}
					else if (pieceChoisie < 0 || pieceChoisie > piecesEnString.length) {
						System.out.println("Saisissez un entier compris entre 0 et " + (piecesEnString.length-1) + " ou 99");
					}
					else {
						sommePieces += stockPieces.getItem(pieceChoisie).getValeur();
						System.out.println("Vous avez inséré " + stockPieces.getItem(pieceChoisie).getValeur() / 100 + " euros et " + stockPieces.getItem(pieceChoisie).getValeur() % 100 + " centimes");
						
						// On ajoute 1 au stock de la pièce correspondante
						stockPieces.getItem(pieceChoisie).addQte();
					}
					//System.out.println(stockPieces.getItem(pieceChoisie).getQte());
				}
				while (sommePieces < prixBoissonChoisie);
				
				if (boissonChoisie == 99) {
					System.out.println("Au revoir !");
					continuer = false;
				}
				
				else {
					System.out.println("-------------------------");
					System.out.println("Au total, vous avez inséré " + sommePieces / 100 + " euros et " + sommePieces % 100 + " centimes");
					
					int monnaieDue = stockPieces.monnaieDue(sommePieces, prixBoissonChoisie);
					System.out.println("Je vous dois " + monnaieDue / 100 + " euros et " + monnaieDue % 100 + " centimes \n");
					
					int[] piecesRendues = stockPieces.rendreMonnaie(monnaieDue);
					
					System.out.println("Pièces à rendre :");
					for (int i=0; i<piecesRendues.length; i++) {
						System.out.println(i + " : " + piecesRendues[i]);
					}
					
					String[] acheterAutreBoisson = {"Oui"};
					Menu menuContinuer = new Menu("Voulez-vous acheter une autre boisson ?", acheterAutreBoisson);
					menuContinuer.afficherMenu();

					int choixContinuer;
					do {
						choixContinuer = menuContinuer.lireChoixMenu();
						if (choixContinuer == 99) {
							break;
						}
						else if (choixContinuer < 0 || choixContinuer > acheterAutreBoisson.length) {
							System.out.println("Saisissez un entier compris entre 0 et " + (acheterAutreBoisson.length-1) + " ou 99");
						}
						else {

						}
					}
					while (choixContinuer < 0 || choixContinuer > acheterAutreBoisson.length);
					
					if (choixContinuer == 99) {
						System.out.println("Au revoir !");
						continuer = false;
					}
				}
			}
			
			
			
			
		}
		while(continuer);
		// Cast :
		//System.out.println((int)('c'));
	}

}
