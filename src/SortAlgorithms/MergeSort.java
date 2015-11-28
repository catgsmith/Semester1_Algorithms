package SortAlgorithms;

public class MergeSort extends Sort{
	
	/**
	 * Merge sort algorithm
	 */
	public void sort(int[] sortMe) {

		// copy values into sortMe from new sorted array
		// so that changes propagate back to calling method
		int[] sorted = merge(sortMe);
		for (int i = 0; i < sortMe.length; i++) {
			sortMe[i] = sorted[i]; // affect change to original array
		}

	} // end MergeSort method

	// Mergesort Merge Method : Recursive
	private int[] merge(int[] mergeArray) {
		// if length of array is 1 then considered sorted
		if (mergeArray.length <= 1)
			return mergeArray;

		// split into smaller arrays on each recursive call
		int[][] parts = splitArray(mergeArray);

		// when all parts return length 1 then recombine with
		// process mergeArrays
		return mergeArrays(merge(parts[0]), merge(parts[1]));
	}

	// Mergesort Split Array in half to get two arrays
	private int[][] splitArray(int[] splitMe) {
		int[][] splitter = new int[2][];
		int splitHalf = (int) splitMe.length / 2;

		splitter[0] = new int[splitHalf];
		splitter[1] = new int[splitHalf + splitMe.length % 2];

		// split arrays
		for (int i = 0; i < splitHalf; i++) {
			splitter[0][i] = splitMe[i];
			splitter[1][i] = splitMe[i + splitHalf];
		}
		if (splitMe.length % 2 > 0)
			splitter[1][splitHalf] = splitMe[splitHalf * 2];

		return splitter;
	}

	// Merge two sorted arrays into one sorted array
	private int[] mergeArrays(int[] arryA, int[] arryB) {

		int[] combiner = new int[arryA.length + arryB.length];

		int j = 0;
		int k = 0;
		for (int i = 0; i < combiner.length; i++) {
			if (!(k < arryB.length)
					|| (j < arryA.length && arryA[j] <= arryB[k]))
				combiner[i] = arryA[j++];

			else if (!(j < arryA.length)
					|| (k < arryB.length && arryB[k] < arryA[j]))
				combiner[i] = arryB[k++];
		}
		// Print trace details of how merge sort progresses
		if (trace) {
			System.out.printf("%2d> Merge: %s and %s resulting in: %s\n",
					pass++, arrayToString(arryA), arrayToString(arryB),
					arrayToString(combiner));
		}

		return combiner;
	} // end method mergeArrays
}
