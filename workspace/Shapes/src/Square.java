
public class Square extends Rectangle {

	public Square(int side) {
		super(side, side);
	}
	
	public Square() {
		//super();
	}
	
	public void setSide(int side) {
		this.setLength(side);
		this.setWidth(side);
	}
	
	// Surcharge = polymorphisme d'h�ritage
	public void draw() {
		System.out.println("I am a square with sides of " + this.getLength());
	}
	
	public void drawMother() {
		super.draw(); // appel � une m�thode de la classe m�re surcharg�e chez moi
	}

}
