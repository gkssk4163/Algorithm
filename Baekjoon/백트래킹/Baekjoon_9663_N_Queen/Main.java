package Baekjoon.백트래킹.Baekjoon_9663_N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int totalCount = 0;
	private static int[] positions;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		positions = new int[N];
		backtracking(0);

		System.out.println(totalCount);
	}

	private static void backtracking(int row) {
		if (row == N) {
			totalCount++;
			return;
		}

		for (int col = 0; col < N; col++) {
			positions[row] = col;
			if (!checkmate(row)) {
				backtracking(row + 1);
			}
		}
	}

	private static boolean checkmate(int row1) {
		int col1 = positions[row1];
		for (int row2 = 0; row2 < row1; row2++) {
			int col2 = positions[row2];
			if (col1 == col2) return true;
			int rowDiff = Math.abs(row1 - row2);
			int colDiff = Math.abs(col1 - col2);
			if (rowDiff == colDiff) return true;
		}
		return false;
	}
}