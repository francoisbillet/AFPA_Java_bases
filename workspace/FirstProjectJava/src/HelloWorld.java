
public class HelloWorld {

	public static int un = 1; //attribut de classe (pas de l'instance) car static
	private static int deux = 2;
	protected static int trois = 3;
	static int quatre = 4; //package-friendly
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		int monEntier = 2;
		//System.out.println(monEntier);
		
		short monShort = 3;
		//System.out.println(monShort);
		
		System.out.println(min(2,3));
		System.out.println(min(un,deux));
		System.out.println(min(deux,trois));
	}
	
	static int min(int a, int b) {
		return Math.min(a,b);
	}

}
