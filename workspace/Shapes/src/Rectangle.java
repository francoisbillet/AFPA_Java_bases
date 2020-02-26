
public class Rectangle extends Shape {

	private int length;
	private int width;
	
	public Rectangle() {
	}
	
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public float getPerimeter() {
		return (this.length + this.width) * 2;
	}
	
	public float getArea() {
		return this.length * this.width;
	}
	
	public void draw() {
		System.out.println("I am a rectangle with a length of " + this.length + " and a width of " + this.width);
	}
}
