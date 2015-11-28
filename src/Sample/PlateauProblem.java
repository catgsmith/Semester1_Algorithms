package Sample;

public class PlateauProblem {
	public static void main(String[] args) {
		// TODO - Your solution
		int N = args.length;
		int[] array = new int[N];
		int new_length = 0;
		int location = 0;
		int max = 0;
		int current_length = 0;

		// assign digits into array
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(args[i]);
			array[i] = number;
		}

		int compare = array[0];
		for (int l = 0; l < N; l++) {

			if (array[l] < compare) {
				current_length = 0;
				compare = array[l];
			} else if (array[l] == compare) {
				current_length += 1;
				compare = array[l];
			}

			else if (array[l] > compare) {
				compare = array[l];
				l++;
			}

			compare = array[l];

			for (int b = 0; b < N; b++) {
				if (current_length > max) {
					max = current_length;
					location = array[l];
					new_length = max - 1;
				} else if (current_length == 1) {
					new_length = max;
				}
			}

		}
		System.out.println(location);
		System.out.println(new_length);
	}

}
