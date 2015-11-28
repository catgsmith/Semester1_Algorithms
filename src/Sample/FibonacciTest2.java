package Sample;

import javax.swing.JOptionPane;

public class FibonacciTest2 {
	static int pass = 0;
	static int[] fib = new int[10];

	public static void main(String args[]) {
		int number, fibonacciValue;

	String numberAsString;

	numberAsString = JOptionPane
		.showInputDialog("What Fib value do you want?");
	number = Integer.parseInt(numberAsString);

	printFibonacciSequence(number);
	fibonacciValue = fibonacci(number);
	System.out.printf("The %dth value of  Fib Sequence: Value = %d \n",
		number, fibonacciValue);
	System.exit(0);
	}

	// recursive declaration of method fibonacci
	public static int fibonacci(int n) {
		if (fib[n] != 0) 
			return fib[n];
		if (n == 0 || n == 1) {			
			return n;
		} else {
			fib[n] = (fibonacci(n - 1) + fibonacci(n - 2));
			return (fibonacci(n - 1) + fibonacci(n - 2));
		}

	} // end method fibonacci
	// Print Fib Sequence
	public static void printFibonacciSequence(int index){
		System.out.print("Fibonacci Series : ");
		
		fibonacci(index);
		for (int i = 0; i <= index; i++) {
			System.out.printf("%d, ", fib[i]);
		} // end for loop
	
		System.out.println("\n");
	} // end method fibonacci series
	

} // end class FibonacciTest