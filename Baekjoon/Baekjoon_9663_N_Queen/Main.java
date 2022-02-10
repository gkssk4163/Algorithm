package Baekjoon.Baekjoon_9663_N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int totalCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		totalCount = 0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				boolean[][] canPlaced = new boolean[N][N];
				init(canPlaced);
				place(canPlaced, row, col, 1);
			}
		}
		System.out.println(totalCount);
	}

	private static void init(boolean[][] canPlaced) {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				canPlaced[row][col] = true;
			}
		}
	}

	private static void place(boolean[][] canPlaced, int row, int col, int count) {
		if (count == N) totalCount++;
		canPlaced[row][col] = false;    // 말 배치
		checkAttackRange(canPlaced, row, col);    // 공격범위 체크
		int r = (col + 1) == N ? row + 1 : row;
		int c = (col + 1) == N ? 0 : (col + 1);
		while (r < N && c < N) {
			if (canPlaced[r][c]) {
				place(copy(canPlaced), r, c, count + 1);
			}
			c++;
			r = (c == N) ? r + 1 : r;
			c = (c == N) ? 0 : c;
		}
	}

	private static boolean[][] copy(boolean[][] canPlaced) {
		boolean[][] copy = new boolean[N][N];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				copy[row][col] = canPlaced[row][col];
			}
		}
		return copy;
	}

	private static final int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

	private static void checkAttackRange(boolean[][] canPlaced, int row, int col) {
		for (int i = 0; i < direction.length; i++) {
			setImpossible(canPlaced, row, col, direction[i]);
		}
	}

	private static void setImpossible(boolean[][] canPlaced, int prevRow, int prevCol, int[] direction) {
		int row = prevRow + direction[0];
		int col = prevCol + direction[1];
		if (outOfRange(row) || outOfRange(col)) return;

		canPlaced[row][col] = false;
		setImpossible(canPlaced, row, col, direction);
	}

	private static boolean outOfRange(int index) {
		return index < 0 || index >= N;
	}
}