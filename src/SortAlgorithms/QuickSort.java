package SortAlgorithms;

public class QuickSort extends Sort {

	
	/**
	 * Quick sort algorithm
	 */
	public void sort(int[] sortMe) {

		int select1 = 0;
		int select2 = sortMe.length - 1;
		partition(sortMe, select1, select2);

		if (trace) {
			System.out.println();
		}

	} // end sort method

	// Quicksort Partition Method : Recursive 
	private void partition(int[] splitArray, int low, int high) {
		int pivot = splitArray[(int) (Math.floor(Math.random()
				* (high - low + 1)) + low)];

		int i = low;
		int j = high;
		
		if (trace) { // Print trace details following each partition
			System.out.printf("\nBetween(%2d,%2d) pivot %4d> %s", low, high,
					pivot, arrayToString(splitArray));
		}

		while (i <= j) {
			while (splitArray[i] < pivot) i++; //from left stop  at >= pivot 
			while (splitArray[j] > pivot) j--; //from right stop at <= pivot

			// Swap two elements
			if (i < j) {
				swap(splitArray, i, j);

				// Print trace details of how quick sort progresses
				if (trace) {
					System.out.printf(", swap %d and %d", splitArray[i],
							splitArray[j]);
				} // end trace
			} // end swap condition
			
			if (i <= j) {
				i++;
				j--;
			} // iterate converging indexes
		}

		if ((high - low) <= 1) return; // arrays of 2 elements are sorted		 
		
		if (low < j) 	partition(splitArray, low, j);
		if (i < high)	partition(splitArray, i, high);
		
	} // end partition method
}
