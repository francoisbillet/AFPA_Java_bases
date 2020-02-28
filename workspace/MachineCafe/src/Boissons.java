
public enum Boissons {
	
	CAFE ("café", 40),
	THÉ ("thé", 20),
	CHOCOLAT ("chocolat", 60);
	
	private String nom;
	private int prix;
	private int qte;
	
	Boissons(String nom, int prix) {
		this.nom = nom;
		this.prix = prix;
		this.qte = 2;
	}

	public String getNom() {
		return nom;
	}

	public int getPrix() {
		return prix;
	}
	
	public int getQte() {
		return qte;
	}
}
