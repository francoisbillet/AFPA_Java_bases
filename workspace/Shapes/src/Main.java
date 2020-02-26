
public class Main {

	public static void main(String[] args) {

		/*Circle circle1 = new Circle(2);
		System.out.println(circle1.getArea());
		
		//System.out.println(Circle.PI);
		
		Circle circle2 = new Circle();
		circle2.setRadius(9);
		System.out.println(circle2.getPerimeter());
		
		Rectangle rectangle1 = new Rectangle(6, 8);
		System.out.println(rectangle1.getPerimeter());
		
		Square square1 = new Square(4);
		square1.draw();
		square1.drawMother();
		
		Square square2 = new Square();
		square2.setSide(5);
		System.out.println(square2.getArea());
		System.out.println(square2.getPerimeter());
		
		Rectangle test = new Square(3);
		test.draw();
		
		// Square test2 = new Rectangle(2); PAS POSSIBLE !
		
		Dora d = new Dora();
		d.draw();
		
		Triangle t1 = new Triangle(4, 5, 6);
		t1.draw();
		System.out.println(t1.getPerimeter());
		System.out.println(t1.getId());
		
		//Triangle t2 = new Triangle();
		//System.out.println(t2.getId());
		 
		 */
		
		// Shape myShape = new Shape(); IMPOSSIBLE, on ne peut pas instancier une classe abstraite
		
		Shape[] myShapes = new Shape[5];
		myShapes[0] = new Rectangle(5, 9);
		myShapes[1] = new Square(12);
		myShapes[2] = new Triangle(2, 3, 6);
		myShapes[3] = new Circle(55);
		myShapes[4] = new Circle(2);
		
		for (Shape s : myShapes) {
			s.draw();
			System.out.println(s.getPerimeter());
		}
		
		Drawable[] toDraw = new Drawable[2];
		toDraw[0] = new Dora();
		toDraw[1] = new Circle(17);
		
		for (Drawable dd : toDraw) {
			dd.draw();
		}
	}

}
