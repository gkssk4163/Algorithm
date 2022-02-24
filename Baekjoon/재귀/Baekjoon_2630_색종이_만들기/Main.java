package Baekjoon.재귀.Baekjoon_2630_색종이_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int WHITE = 0;
	private static final int BLUE = 1;
	private static final int MIX = 2;
	private static int white = 0;
	private static int blue = 0;
	private static int[][] paper;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int color = check(0, 0, N - 1, N - 1, N / 2);
		addColor(color);

		System.out.println(white);
		System.out.println(blue);
	}

	private static int check(int row1, int col1, int row2, int col2, int size) {
		if (size == 0) return paper[row1][col1];

		int part1 = check(row1, col1, row2 - size, col2 - size, size / 2);
		int part2 = check(row1, col1 + size, row2 - size, col2, size / 2);
		int part3 = check(row1 + size, col1, row2, col2 - size, size / 2);
		int part4 = check(row1 + size, col1 + size, row2, col2, size / 2);
		if (equal(part1, part2, part3, part4)) {
			return part1;
		} else {
			addColor(part1);
			addColor(part2);
			addColor(part3);
			addColor(part4);
			return MIX;
		}
	}

	private static boolean equal(int part1, int part2, int part3, int part4) {
		return part1 == part2 && part2 == part3 && part3 == part4;
	}

	private static void addColor(int color) {
		if (color == WHITE) white++;
		else if (color == BLUE) blue++;
	}
}