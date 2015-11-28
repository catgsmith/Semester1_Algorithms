package SortAlgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SortUtility {
	// declare class variables
	private static final String OUTPUT_FILE = "Output.txt";
	private static boolean isSorted = false;

	private static Scanner input = new Scanner(System.in);

	/**
	 * Main Routine
	 */
	public static void main(String[] args) {
		
		/* 
		 * Set TRACE option to print sort progression in detail
		 */		
		Sort.setTrace(true); 

		System.out.println("This program sorts a list of integers\n"
				+ "with an algorithm entered by the user.\n"
				+ "Enter name of text file containing integers: ");

		String filename = input.next(); // prompt user for filename

		int option = getSortOption();   // prompt user for option 

		if (option != -1) { // when option to terminate not taken
			
			int[] sortArray;
			try {
				sortArray = readFromFile(filename);

				doSort(sortArray, option); // sort integers with chosen algorithm

				writeToFile(OUTPUT_FILE, sortArray); // write integers to output file
				
			} catch (SortException e) {
				System.err.println("Error: " + e.getMessage());
			} // read integers from file

		} // end if

	}// end main method
	
	/**
	 * getSortOption : Prompt user for choice of sort algorithm
	 * Return : option for chosen algorithm
	 */
	private static int getSortOption() {
		int selectSort = 0; // initialize option
		
		//  prompt user to choose algorithm
		System.out.println("Enter 1  for BubbleSort\n"
					+ "Enter 2  for Selection Sort\n"
					+ "Enter 3  for Insertion Sort\n"
					+ "Enter 4  for Quick Sort\n" + "Enter 5  for Merge Sort\n"
					+ "\nEnter -1 to exit");
		
		do { // Prompt for valid option

			if (selectSort == -1) {
				System.out.println("Program Terminated ...");
				break;
			} else if (selectSort == 0 || selectSort > 5) {				
				System.out.print("\nEnter number: ");
				selectSort = input.nextInt();
			} // test if exit condition chosen
		} while (selectSort < 1 || selectSort > 5);

		return selectSort;
	} // end method getSortOption

	/**
	 * readFromFile : Load random numbers from file
	 * Return : array of integers in no particular order
	 */	
	private static int[] readFromFile(String filename) throws SortException{

		File inFile = new File(filename);

		List<Integer> inputArray = new ArrayList<Integer>();
		// use Scanner to read from a file
		Scanner input = null;

		try {
			// read data into an array using Scanner
			input = new Scanner(inFile);

			while (input.hasNextInt()) {
				inputArray.add(input.nextInt());
			}

		} catch (FileNotFoundException e) {			
			throw new SortException("Sorry File Not Found");
			
		} catch (Exception e)  {
			throw new SortException(e.getMessage());
		} finally {
			// close input stream
			if (input != null) input.close();
		}

		// Create array of integers
		int[] result = new int[inputArray.size()];
		Iterator<Integer> iterator = inputArray.iterator();
		for (int i = 0; i < result.length; i++) {
			result[i] = iterator.next().intValue();
		}

		return result;
	} // end readFromFile method

	/**
	 * writeToFile : Write sorted numbers to output file
	 */	
	private static void writeToFile(String filename, int[] sorted) throws SortException{

		File outFile = new File(filename);

		boolean written = false;

		try {
			if (!outFile.exists()) {
				outFile.createNewFile(); // create file if doesn't exist
			}
			// create stream object and PrintWriter object
			FileOutputStream outFileStream = new FileOutputStream(outFile);
			PrintWriter outStream = new PrintWriter(outFileStream);

			// Write contents of array to a text file
			for (Integer num : sorted) {
				outStream.println(num);
			}

			outStream.close(); // close output stream

			written = true; // file written
		} catch (IOException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			throw new SortException(sw.toString());
		} finally {
			if (written) {
				System.out.printf("Sorted data written to %s", filename);
			} else
				System.out.println("Sorry data not written");
		}
	} // end method writeToFile
	
	/**
	 * doSort : Launch the selected Sort Process
	 */	
	private static void doSort(int[] sortMe, int choice) {
		Sort sorter = null;
		
		System.out.println("Unsorted array: " + Sort.arrayToString(sortMe));
		
		switch (choice) {
		case 1:
			sorter = new BubbleSort();
			break;
		case 2:
			sorter = new SelectionSort();
			break;
		case 3:
			sorter = new InsertionSort();
			break;
		case 4:
			sorter = new QuickSort();
			break;
		case 5:
			sorter = new MergeSort();
			break;			
		}
		// Call sort method
		sorter.sort(sortMe);
		
		// Double check the results
		
		isSorted = Sort.validate(sortMe);
		System.out.printf("%14s: %s\n", (isSorted) ? "Sorted!" : "Sort Failed", 
				Sort.arrayToString(sortMe));

	} // end doSort method

} // end class SortUtility

@SuppressWarnings("serial")
class SortException extends Exception {
	 
    private String message = null;
 
    public SortException() {
        super();
    }
 
    public SortException(String message) {
        super(message);
        this.message = message;
    }
 
    public SortException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
}
