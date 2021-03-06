package Test;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Personne francis = new Personne("Francis", 25, 65);
		
		// System.out.println(francis.nom + " " + francis.age); Inaccessible car private
		// francis.age = -6; On met en private pour �viter ceci
		
		francis.marcher();
		
		// System.out.println(francis.getNom() + " " + francis.getAge() + " cpt : " + francis.cpt);
		
		francis.setAge(-6);
		
		System.out.println(francis.getNom() + " " + francis.getAge());
		
		System.out.println(Personne.PI);
		
		// Personne.PI = 5.0f; On ne peut pas modifier une constante
		
		System.out.println(francis.getNom() + " " + francis.getAge() + " " + francis.AGERETRAITE);
		
		Personne autrePersonne = new Personne("Jacquie", 67, 67);
		
		// System.out.println("cpt Francis : " + francis.cpt + " cpt Jacquie : " + autrePersonne.cpt);
		// cpt attribut de classe donc appeler la classe et non l'instance
		
		System.out.println("cpt Francis : " + Personne.getCpt() + " cpt Jacquie : " + Personne.getCpt());
		
		System.out.println("cpt Francis : " + francis.getId() + " cpt Jacquie : " + autrePersonne.getId());
	}

}
