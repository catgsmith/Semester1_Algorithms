package Sample;

import javax.swing.JOptionPane;

public class Factorial {

	public static void main(String[] args) {
		String numberAsString = JOptionPane
				.showInputDialog("What Factorial value do you want?");
		int	n = Integer.parseInt(numberAsString);
		
		int result = factorial(n);
		System.out.printf("The factorial of %d is %d" , n, result);
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
}
