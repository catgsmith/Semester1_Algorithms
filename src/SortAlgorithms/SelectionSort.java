package SortAlgorithms;

public class SelectionSort extends Sort{
	

	/**
	 * Selection sort algorithm
	 */	 
	public void sort(int[] sortMe) {

		int nextSmallest;
		boolean isSwap;

		// each loop advance the start position by 1
		for (int sortIdx = 0; sortIdx < sortMe.length - 1; sortIdx++) {
			isSwap = false; // initialize swap required flag
			nextSmallest = sortIdx; // initialize index of smallest value

			// find the index of the next smallest value in the list
			for (int i = sortIdx + 1; i < sortMe.length; i++) {

				if (sortMe[i] < sortMe[nextSmallest]) {
					nextSmallest = i;
					isSwap = true;
				} // end if
			}// end for

			if (isSwap) { // only swap if smaller value found
				swap(sortMe, sortIdx, nextSmallest);
			} // swap smallest found with element in position sortIdx.

			// Print details of how selection sort progresses
			if (trace) {
				System.out.printf("%14s  %s\n",	String.format("Select %2d>",sortMe[sortIdx]),
				arrayToString(sortMe));
			}
		} // end for loop
	} // end method sort
} // end class SelectionSort
