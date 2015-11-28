package SortAlgorithms;

public class InsertionSort extends Sort {	

	/**
	 * Insertion sort algorithm
	 */
	public void sort(int[] sortMe) {

		int sortValue; // integer to be sorted 
		int insertIdx; // index of integer to be sorted
		
		// Select the next integer to be inserted 
		// relative the all items to the left of integer 
		for (int i = 1; i < sortMe.length; i++) {

			sortValue = sortMe[i];
			insertIdx = i;
			// find the correct insertion point
			for (int j = i; j > 0; j--) {
				if (sortMe[j - 1] > sortValue) {
					sortMe[j] = sortMe[j - 1];
				} else {
					break;
				}
				insertIdx--;
			}
			sortMe[insertIdx] = sortValue;
			// swap out
			// Print details of how insertion sort progresses
			if (trace) {
				System.out.printf("%14s  %s\n",	String.format("Insert %3d>",sortValue),
				arrayToString(sortMe));
			} //end if
		} // end for loop
	} // end sort method
} // end InsertionSort class
