package com.alg.dp;

import java.util.Random;

public class MaxCoinsFromGrid {

	// Pre order recursion
	// T.C -> O(2^n) S.C -> O(N)
	public static int getMaxCoins1(int[][] in) {
		int maxSum = auxMaxCoins1(in.length - 1, in.length - 1, in);
		return maxSum;
	}

	// starting from last(n ,n) index and move to leaf(first) node, calculat
	// starts from leaf node.
	public static int auxMaxCoins1(int i, int j, int in[][]) {
		if (i < 0 || j < 0) {
			return 0;
		}

		int down;
		int right;
		down = auxMaxCoins1(i - 1, j, in);
		right = auxMaxCoins1(i, j - 1, in);

		return Math.max(down, right) + in[i][j];

	}

	// Post order recursion
	// T.C -> O(2^n) S.C -> O(N)
	public static int getMaxCoins2(int[][] in) {
		int maxSum = auxMaxCoins2(0, 0, in);
		return maxSum;
	}

	// starting from first (0, 0) index and move to leaf(last) node, calculate
	// starts from leaf node.
	public static int auxMaxCoins2(int i, int j, int in[][]) {
		if (i >= in.length || j >= in.length) {
			return 0;
		}
		int up = auxMaxCoins2(i + 1, j, in);
		int left = auxMaxCoins2(i, j + 1, in);

		return Math.max(up, left) + in[i][j];

	}
	// See note book for why we are using DP programming,
	// T.C -> 
	public static int getMaxCoins3(int[][] in) {
		int[][] tmp = new int[in.length][in.length];
		int maxSum = auxMaxCoins3(in.length - 1, in.length - 1, in, tmp);
		return maxSum;
	}

	public static int auxMaxCoins3(int i, int j, int in[][], int[][] tmp) {
		if (i < 0 || j < 0) {
			return 0;
		}
		if (tmp[i][j] != 0) {
			return tmp[i][j];
		}
		int up = auxMaxCoins3(i - 1, j, in, tmp);
		int left = auxMaxCoins3(i, j - 1, in, tmp);
		return tmp[i][j] = Math.max(up, left) + in[i][j];
	}
	
	public static int getMaxCoins4(int[][] in) {
		int[][] tmp = new int[in.length][in.length];
		int maxSum = auxMaxCoins3(in.length - 1, in.length - 1, in, tmp);
		return maxSum;
	}

	public static int auxMaxCoins4(int i, int j, int in[][], int[][] tmp) {
		if (i < 0 || j < 0) {
			return 0;
		}
		if (tmp[i][j] != 0) {
			return tmp[i][j];
		}
		int up = auxMaxCoins4(i - 1, j, in, tmp);
		int left = auxMaxCoins4(i, j - 1, in, tmp);
		return tmp[i][j] = Math.max(up, left) + in[i][j];
	}

	// display elements in matrix format
	public static void display(int in[][]) {
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in.length; j++) {
				System.out.print(in[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		int in[][] = new int[n][n];
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				in[i][j] = r.nextInt(10) + 1;
			}
		}
		// display(in);
		// System.out.println(getMaxCoins1(in));
		// System.out.println(getMaxCoins2(in));
		System.out.println(getMaxCoins3(in));

	}
}
