package quickThoughts;

import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Random;

public class ColorTheory {

	public static void main(String[] args) {
//		Random rand = new Random();

//		ArrayList<Object> big = new ArrayList<>(); // Can't handle 5^5
//		long startTime = System.nanoTime();
//		while (big.size() != 27) {
//			ArrayList<Object> small = new ArrayList<>();
//			for (int i = 0; i < 3; i++) { // This for loop fills the array with random numbers ranging from 1 to 3
//			small.add(rand.nextInt((3 - 1) + 1) + 1);
//			}
//			if (big.contains(small)==false) {
//			big.add(small);}
//	}
//		long endTime   = System.nanoTime();
//		long totalTime = endTime - startTime;
//		System.out.println(totalTime/100000000);

		/**
		 * This function creates every possibility using the same process as a
		 * possibility tree. There are six for loops (six regions) and each for loop
		 * starts from one and ends with five. For example, the first loop will be
		 * [1,1,1,1,1,1] and the final loop will be [5,5,5,5,5,5].
		 * 
		 * The last loop of this nested loop creates each possibility and checks to see
		 * if no two connecting regions share the same color. If the possibility has no
		 * connecting regions that share the same color and there are four colors or
		 * less present, then the variable "total" is increased by one
		 * 
		 * 
		 * A variable to count the number of each colors that a possibility has is also
		 * included, called color_number
		 * 
		 * The variable color_total adds up each possibility's total number of colors. This variable is then divided by the total number
		 * of possibilities to find the expected number of colors used. 
		 * 
		 */

		float total = 0;

		float color_total = 0;

		long startTime = System.nanoTime();

		for (int i = 1; i <= 5; i++) {
			for (int y = 1; y <= 5; y++) {
				for (int z = 1; z <= 5; z++) {
					for (int a = 1; a <= 5; a++) {
						for (int b = 1; b <= 5; b++) {
							for (int c = 1; c <= 5; c++) {
								ArrayList<Object> small = new ArrayList<>();
								small.add(i);
								small.add(y);
								small.add(z);
								small.add(a);
								small.add(b);
								small.add(c);

								int color_number = 0;

								for (int q = 1; q <= 5; q++) {
									if (small.contains(q)) {

										color_number += 1;

									}
								}

								color_total += color_number;

								if (c != b && b != a && a != z && z != y && y != i) {
									if (color_number >= 1 && color_number <= 4) {
										total += 1;
										System.out.println("\n" + small);
										System.out.println("Number of Colors: " + color_number);
										System.out.println("Total is now " + total);
									}
								}
							}
						}
					}
				}
			}
		}

		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("\nTime in seconds = " + (totalTime / 1000000000));
		System.out.println("Total = " + Float.toString(total));
		System.out.println("Percent = " + (total / 15625) * 100);
		System.out.println("Expect number of colors: " + color_total / 15625);

	}
}
