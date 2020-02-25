package Test;

public class Personne {

	// ATTRIBUTS DE CLASSE
	public static final float PI = 3.14f;
	private static int cpt = 0;
	
	// ATTRIBUTS D'INSTANCES
	private String nom;
	private int age;
	private int id;
	
	

	public final int AGERETRAITE;
	
	// CONSTRUCTEUR
	public Personne(String nom, int age, int ageRetraite) {
		// super();
		this.id = cpt++;
		this.nom = nom;
		this.age = age;
		this.AGERETRAITE = ageRetraite;
		
		// cpt++;
	}

	// METHODES
	public void marcher() {
		System.out.println("Je marche");
	}
	
	public int getId() {
		return id;
	}
	
	
	public static int getCpt() {
		return cpt;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		}
		else {
			System.out.println("Je n'ai pas modifié l'âge car il était négatif");
		}
	}

}
