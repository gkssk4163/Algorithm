package Baekjoon.탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_1012_유기농_배추 {
	private static final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				map[row][col] = 1;
			}

			int part = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 1) {
						checkPart(map, r, c);
						part++;
					}
				}
			}
			System.out.println(part);
		}
	}

	private static void checkPart(int[][] map, int row, int col) {
		Stack<Position> positions = new Stack<>();
		map[row][col] = 0;
		positions.push(new Position(row, col));

		BFS(map, positions);
	}

	private static void BFS(int[][] map, Stack<Position> positions) {
		if (positions.isEmpty()) return;

		Stack<Position> next = new Stack<>();
		while (!positions.isEmpty()) {
			Position position = positions.pop();
			for (int dr = 0; dr < direction.length; dr++) {
				int row = position.row + direction[dr][ROW];
				int col = position.col + direction[dr][COL];
				try {
					if (map[row][col] == 1) {
						map[row][col] = 0;
						next.push(new Position(row, col));
					}
				} catch (IndexOutOfBoundsException ignored) {
				}
			}
		}
		BFS(map, next);
	}

	static class Position {
		int row;
		int col;

		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}