
public class Triangle extends Shape {

	private int side1;
	private int side2;
	private int side3;
	
	public Triangle(int side1, int side2, int side3) {
		//super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	@Override
	public float getPerimeter() {
		return this.side1 + this.side2 + this.side3;
	}

	@Override
	public float getArea() {
		// TODO à faire
		return 0;
	}
	
	public void draw() {
		System.out.println("I am a triangle with sides of " + this.side1 + ", " + this.side2 + " and " + this.side3);
	}

}
