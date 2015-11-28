package Sample;

import javax.swing.JOptionPane;

public class FibonacciTest {
	static int pass = 0;


	public static void main(String args[]) {
		long number, fibonacciValue;

	String numberAsString;

	numberAsString = JOptionPane
		.showInputDialog("What Fib value do you want?");
	number = Long.parseLong(numberAsString);


	printFibonacciSequence(number);
	
	fibonacciValue = fibonacci(number-1); // nth value with zero index
	
	System.out.printf("The %dth value of  Fib Sequence: Value = %d \n",
		number, fibonacciValue);
	System.exit(0);
	}

	// recursive declaration of method fibonacci
	public static long fibonacci(long n) {
		
		if (n == 0 || n == 1) {			
			return n;
		} else {			
			return fibonacci(n - 1) + fibonacci(n - 2);
		}

	} // end method fibonacci
	
	
	// Print Fib Sequence
	public static void printFibonacciSequence(long index){
		System.out.print("Fibonacci Series : ");
		
		for (int i=0; i< index; i++) {
			System.out.printf("%d, ", fibonacci(i));
		} // end for loop
		
		System.out.println("\n");
	} // end method fibonacci series
	
} // end class FibonacciTest

