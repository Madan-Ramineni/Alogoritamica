import java.util.Arrays;

public class ArraysCommonElement {
	int count;

	// common scenes based approach
	// n*n operations
	public static int findCommonElements(int a1[], int a2[]) {
		int count = 0;
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a2.length; j++) {
				if (a1[i] == a2[j]) {
					count++;
				}
			}
		}
		return count;
	}

	// Sorting the array and compare
	public static int findCommonElements1(int a1[], int a2[]) {
		// nlogn
		Arrays.sort(a1);
		// mlogm
		Arrays.sort(a2);
		int count = 0;
		// <=2N
		for (int i = 0; i < a1.length; i++) {
			for (int k = 0; k < a2.length; k++) {

				if (a1[i] == a2[k]) {
					++count;
				} else if (a1[i] < a2[k]) {
					break;
				}
			}
		}
		return count;
	}

	public static int findCommonElements2(int a1[], int a2[]) {
		// nlogn
		Arrays.sort(a1);
		// mlogm
		Arrays.sort(a2);
		int count = 0;
		int i = 0;
		int j = 0;

		// <= 2N
		while (i < a1.length && j < a2.length) {
			if (a1[i] > a2[j]) {
				j++;
			} else if (a1[i] < a2[j]) {
				i++;
			} else {
				count++;
				i++;
				j++;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		int in1[] = new int[n];
		int in2[] = new int[n];

		// Random r = new Random();
		// for (int i = 0; i < in2.length; i++) {
		// in2[i] = r.nextInt(10);
		// in1[i] = r.nextInt(10);
		// }

		for (int i = 0; i < in2.length; i++) {
			in1[i] = i + 1;
			in2[i] = i * 10;
		}

		System.out.println(Arrays.toString(in1));
		System.out.println(Arrays.toString(in2));

		long start = System.currentTimeMillis();
		// int common = findCommonElements(in1, in2);
		// int common = findCommonElements1(in1, in2);
		int common = findCommonElements2(in1, in2);
		long end = System.currentTimeMillis();
		System.out.println("total time takes is " + (end - start) / 1000 + " seconds");

		System.out.println(common);
	}
}
