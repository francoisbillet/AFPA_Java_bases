
public class MoneyManager {
	
	public int[][] machineCoins;
	public int[] coinsEntered;

	public MoneyManager() {
		this.machineCoins = new int[][] {{10,5},{20,5},{50,5},{100,5},{200,5}};
		this.coinsEntered = new int[] {0,0,0,0,0};
	}

	public int[][] getMachineCoins() {
		return machineCoins;
	}

	/*public int[] getCoinsEntered() {
		return coinsEntered;
	}*/
	
}
