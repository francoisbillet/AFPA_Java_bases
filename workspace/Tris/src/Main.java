import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {

		int[] array = {1,3,5,7,4,-2,9};
		Array myArray = new Array(array);
		//System.out.println(myArray);
		System.out.println("Array de base : " + myArray.displayArray());
		Array bubbleSortedArray = myArray.bubbleSort();
		System.out.println("Bubble sort : " + bubbleSortedArray.displayArray() + "\n");
		
		Array myArray2 = new Array(array);
		System.out.println("Array de base : " + myArray2.displayArray());
		Array selectionSortedArray = myArray2.selectionSort();
		System.out.println("Selection sort : " + selectionSortedArray.displayArray() + "\n");
		
		int a = 0;
		int b = a++;
		//System.out.println(b + " " + a);
		
		int c = --b;
		//System.out.println(c + " " + b);
	}

}
