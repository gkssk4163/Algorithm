package Baekjoon.탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_7569_토마토 {
	final static int UNRIPE = 0;
	final static int RIPE = 1;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());    // 가로 칸의 수
		int N = Integer.parseInt(st.nextToken());    // 세로 칸의 수
		int H = Integer.parseInt(st.nextToken());    // 쌓아올려지는 상자의 수

		int[][][] box = new int[H][N][M];
		Stack<Position> ripeTomatoes = new Stack<>();
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					box[h][n][m] = Integer.parseInt(st.nextToken());
					if (box[h][n][m] == RIPE) {
						ripeTomatoes.add(new Position(h, n, m));
						box[h][n][m] = RIPE;
					}
				}
			}
		}

		BFS(box, ripeTomatoes, 0);

		if (allRipe(box)) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}

	private static boolean allRipe(int[][][] box) {
		for (int h = 0; h < box.length; h++) {
			for (int n = 0; n < box[h].length; n++) {
				for (int m = 0; m < box[h][n].length; m++) {
					if (box[h][n][m] == UNRIPE) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static void BFS(int[][][] box, Stack<Position> ripeTomatoes, int days) {
		Stack<Position> nextRipeTomatoes = new Stack<>();
		int[][] direction = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
		while (!ripeTomatoes.isEmpty()) {
			Position pos = ripeTomatoes.pop();
			for (int di = 0; di < direction.length; di++) {
				int h = pos.h + direction[di][0];
				int n = pos.n + direction[di][1];
				int m = pos.m + direction[di][2];
				try {
					if (box[h][n][m] == UNRIPE) {
						nextRipeTomatoes.add(new Position(h, n, m));
						box[h][n][m] = RIPE;
					}
				} catch (IndexOutOfBoundsException e) {
				}
			}
		}

		if (nextRipeTomatoes.isEmpty()) {
			answer = days;
			return;
		}

		BFS(box, nextRipeTomatoes, days + 1);
	}

	static class Position {
		int h;
		int n;
		int m;

		public Position(int h, int n, int m) {
			this.h = h;
			this.n = n;
			this.m = m;
		}
	}
}