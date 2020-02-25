import java.util.Arrays;

public class Array {

	private int[] array;
	
	public Array(int[] array) {
		this.array = array;
	}
	
	public Array bubbleSort() {
		int[] sortedArray = this.array.clone();
		boolean isSortedTab = false;
		do {
			isSortedTab = true;
			for (int i=0; i<sortedArray.length - 1; i++) {
				if (sortedArray[i] > sortedArray[i+1]) {
					permuterValeurs(sortedArray, i, i+1);
					isSortedTab = false;
				}
			}
		} while (!isSortedTab);
		return new Array(sortedArray);
	}

	public Array selectionSort() {
		int max;
		int i_max;
		boolean sortedTab = false;
		int cpt = -1;
		do {
			cpt++;
			sortedTab = true;
			max = this.array[0];
			i_max = 0;
			for (int i=0; i<this.array.length - cpt; i++) {
				if (this.array[i] > max) {
					max = this.array[i];
					i_max = i;
					sortedTab = false;
				}
			}
			permuterValeurs(this.array, i_max, this.array.length-cpt-1);
		} while (!sortedTab);
		
		return this;
	}
	
	private void permuterValeurs(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public String displayArray() {
		return Arrays.toString(this.array);
	}

}
