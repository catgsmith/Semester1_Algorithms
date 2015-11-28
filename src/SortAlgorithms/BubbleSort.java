package SortAlgorithms;

public class BubbleSort extends Sort {

	/**
	 * Bubble sort algorithm
	 */	
	@Override
	public void sort(int[] sortMe) {

		int endSeq = sortMe.length;

		while (endSeq > 1) {
			// after each pass the highest value of the pass relocated  
			// to the end of the pass, and the pass is decreased by 1
			for (int idx = 0; idx < endSeq - 1; idx++) {
				// compare each integer with it's neighbour and swap as needed
				// to put the higher value to the right of the pair
				if (sortMe[idx] > sortMe[idx + 1]) {
					swap(sortMe, idx, idx + 1);
				}
			}
			// If trace on: Print details of sort as progresses thru each pass
			if (trace) {
				System.out.printf("      Pass %2d>  %s\n", pass++,
						arrayToString(sortMe));
			}
			endSeq--; // decrease the pass
		}
	}	
}
