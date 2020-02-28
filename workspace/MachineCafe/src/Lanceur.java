import utils.Menu;

public class Lanceur {

	public static void main(String[] args) {
		
		Stockeur<Boisson> stockBoissons = new Stockeur();
		Stockeur<Piece> stockPieces = new Stockeur<Piece>();
		 
		// On ajoute les boissons dans le stock de boissons
		for (int i=0; i<Boissons.values().length; i++) {
			stockBoissons.addItem(new Boisson(i, Boissons.values()[i].getNom(), Boissons.values()[i].getPrix(), Boissons.values()[i].getQte()));
		}
		
		// On ajoute les pièces dans le stock de pièces
		for (int i=0; i<Boissons.values().length; i++) {
			stockPieces.addItem(new Piece(i, Pieces.values()[i].getNom(), Pieces.values()[i].getValeur(), Pieces.values()[i].getQuantite()));
		}
		
		String[] boissonsEnString = stockBoissons.stockEnString();
		String[] piecesEnString = stockPieces.stockEnString();
		
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
		}
		else {
			System.out.println("-------------------------");
			System.out.println("Vous avez choisi "+ boissonsEnString[boissonChoisie]);
			
			Menu menuPiece = new Menu("Insérez une pièce ", piecesEnString);
			
			// tant que l'utilisateur ne saisit pas assez d'argent pour acheter sa boisson, on réaffiche le message :
			// Si il saisit 99, on annule
			menuPiece.afficherMenu();
			
			// TODO à modifier !
			int pieceChoisie;
			do {
				pieceChoisie = menuPiece.lireChoixMenu();
				System.out.println(pieceChoisie);
				if (pieceChoisie == 99) {
					break;
				}
				else if (pieceChoisie < 0 || pieceChoisie > piecesEnString.length) {
					System.out.println("Saisissez un entier compris entre 0 et " + (piecesEnString.length-1) + " ou 99");
				}
			}
			while (true);
		}
		
		
		/*System.out.println("-------------------------");
		
		
		stockBoissons.addItem(new Boisson(0, "café", 60, 10));
		stockBoissons.getItem(0).addQte();
		System.out.println(stockBoissons.getItem(0).getQte());
		stockBoissons.getItem(0).setMarque("Coca-Cola");
		System.out.println(stockBoissons.getItem(0).getMarque());
		
		stockPieces.addItem(new Piece(0, "10cts", 10, 5));*/
		
		// Cast :
		//System.out.println((int)('c'));
	}

}
