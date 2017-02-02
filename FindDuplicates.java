import java.util.Arrays;
import java.util.Random;

public class FindDuplicates {
	public static int[] findDulplicates(int[] in) {
		int element = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] != Integer.MIN_VALUE) {
				element++;
				for (int k = i + 1; k < in.length; k++) {
					if (in[i] == in[k]) {
						in[k] = Integer.MIN_VALUE;
					}
				}
			}
		}
		int out[] = new int[element];
		outputArray(in, out);
		return out;
	}

	private static void outputArray(int[] in, int[] out) {
		
		for (int i = 0, m=0; i < in.length-1; i++) {
			if (in[i] != Integer.MIN_VALUE) {
				out[m] = in[i];
				m++;
			}

		}
	}

	public static int[] findDulplicates2(int[] in) {

		Arrays.sort(in);
		int j = 1;
		int i = 0;
		int element = 1;
		while (i < in.length && j < in.length) {
			if (in[i] != Integer.MIN_VALUE) {
				
				if (in[i] == in[j]) {
					in[j] = Integer.MIN_VALUE;
					j++;
				} else {
					element++;
					i = j;
					j++;
				}
			}

		}
		//System.out.println(element);
		//System.out.println(Arrays.toString(in));
		int out[] = new int[element];
		outputArray(in, out);
		return out;

	}

	public static void main(String[] args) {

		Random r = new Random();
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for (int i = 0; i < n; i++) {
			in[i] = r.nextInt(n);
		}
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		int out[] = findDulplicates(in);
		long end = System.currentTimeMillis();
		System.out.println("total time takes is " + (end - start) / 1000 + " seconds");
		//System.out.println(Arrays.toString(out));
	}
}
