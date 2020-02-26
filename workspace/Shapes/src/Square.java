
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
	
	// Surcharge = polymorphisme d'héritage
	public void draw() {
		System.out.println("I am a square with sides of " + this.getLength());
	}
	
	public void drawMother() {
		super.draw(); // appel à une méthode de la classe mère surchargée chez moi
	}

}
