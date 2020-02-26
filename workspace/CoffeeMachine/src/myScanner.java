import java.util.Scanner;

public class myScanner {

	private Scanner sc;

	public myScanner() {
		this.sc = new Scanner(System.in);
	}
	
	public int getInput() {
		return this.sc.nextInt();
	}
	
}
