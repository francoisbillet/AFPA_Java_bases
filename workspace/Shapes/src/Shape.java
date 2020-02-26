
public abstract class Shape implements Drawable {

	// Attributes
	private static int count = 1;
	private int id;
	
	// Constructor
	public Shape() {
		//super();
		this.id = count++;
	}

	// Getter

	public int getId() {
		return id;
	}

	// Other methods
	
	public abstract float getPerimeter();
	public abstract float getArea();
	
	@Override
	public void draw() {
		//System.out.println("I'm a geometrical shape");
	}

}
