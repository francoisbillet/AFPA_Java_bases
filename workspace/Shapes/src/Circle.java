
public class Circle extends Shape {

	// Class Attribute
	public final static float PI = 3.14f;
	
	// Instance Attribute
	private int radius;

	public Circle() {
	}
	
	public Circle(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public float getPerimeter() {
		return 2 * PI * this.radius;
	}
	
	public float getArea() {
		return PI * this.radius * this.radius;
	}
	
	public void draw() {
		System.out.println("I am a circle with a radius of " + this.radius);
	}
	
}
