package utils;

public class Menu {
	
	//ATTRIBUTS
	private String 		titre;
	private String[] 	choix;
	
	//CONSTRUCTEUR
	public Menu(String titre, String[] choix) {
		super();
		this.titre = titre;
		this.choix = choix;
	}

	public String[] getChoix() {
		return choix;
	}

	
	// G & S
	public void setChoix(String[] choix) {
		this.choix = choix;
	}
	
	
	// AUTRES METHODES
	public void afficherMenu() {
		System.out.println(this.titre);
		//System.out.println(this.getChoix().length);
		for (int indice = 0 ; indice < this.choix.length ; indice++) {
			System.out.println(indice +" - "+ this.choix[indice]);
		}
		System.out.println("99 -  Quitter");
	}
	
	public int lireChoixMenu() {
		//afficherMenu();
		System.out.println("");
		return SaisieClavier.lireEntier("Veuillez taper votre choix :");
		
	}
	

}
