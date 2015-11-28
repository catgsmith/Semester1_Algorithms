package SortAlgorithms;

public abstract class Sort {

	protected static boolean trace = false; // option to print trace details
	protected int pass = 1; // count of array traversals
	
	/**
	 * abstract method sort
	 */
	public abstract void sort(int[] sortMe); 
	
	/**
	 * If you want to follow the sort progression with
	 * line by line output to the console - set trace to true
	 */ 
	public static void setTrace(boolean traceOn) {
		trace = traceOn;
	}	
	/**
	 * Print each element of the sequence
	 */ 
	public static String arrayToString(int[] mySortingArray) {
		StringBuilder sb = new StringBuilder("{");
		String comma = null;

		for (int element : mySortingArray) {
			sb.append((comma == null ? "" : comma) + element);
			comma = ",";
		}
		sb.append("}");
		return sb.toString();
	} // end method arrayToString
	
	/**
	 * Swap an element in an array
	 */ 
	protected void swap(int[] mySortingArray, int index1, int index2) {
		int temp = mySortingArray[index1];
		mySortingArray[index1] = mySortingArray[index2];
		mySortingArray[index2] = temp;
	} // end method swap
	
	/**
	 * Check that array elements are sorted
	 */ 
	public static boolean validate(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				return false;
			}
		}
		return true;
	} // end method validate
}
