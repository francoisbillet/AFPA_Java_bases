
public enum Pieces {

	DIX ("10cts", 10),
	VINGT ("20cts", 20),
	CINQUANTE ("50cts", 50),
	UN ("1€", 100),
	DEUX ("2€", 200);
	
	private String nom;
	private int valeur;
	private int qte;
	
	Pieces(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;
		this.qte = 5;
	}

	public String getNom() {
		return nom;
	}
	
	public int getValeur() {
		return valeur;
	}
	
	public int getQuantite() {
		return qte;
	}
}
