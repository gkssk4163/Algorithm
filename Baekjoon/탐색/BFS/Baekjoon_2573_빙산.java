package Baekjoon.탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_2573_빙산 {
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		meltBFS(map, getOutline(map), 0);

		System.out.println(answer);
	}

	static class Position {
		int n;
		int m;

		public Position(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}

	private static Stack<Position> getOutline(int[][] map) {
		Stack<Position> outline = new Stack<>();
		for (int n = 1; n < map.length - 1; n++) {
			for (int m = 1; m < map[n].length - 1; m++) {
				if (isOutline(map, n, m)) {
					outline.push(new Position(n, m));
				}
			}
		}
		return outline;
	}

	private static boolean isOutline(int[][] map, int n, int m) throws IndexOutOfBoundsException {
		if (map[n][m] == 0) return false;

		int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for (int[] direction : directions) {
			int row = n + direction[0];
			int col = m + direction[1];
			if (map[row][col] == 0) return true;
		}
		return false;
	}

	private static void meltBFS(int[][] map, Stack<Position> outline, int time) throws IndexOutOfBoundsException {
		if (splitTwo(map)) {
			answer = time;
			return;
		}
		if (outline.isEmpty()) return;

		Map<Position, Integer> minus = new HashMap<>();
		int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while (!outline.isEmpty()) {
			Position position = outline.pop();
			int minusCount = 0;
			for (int[] direction : directions) {
				int row = position.n + direction[0];
				int col = position.m + direction[1];
				if (map[row][col] == 0) minusCount++;
			}
			minus.put(position, minusCount);
		}

		for (Map.Entry<Position, Integer> entry : minus.entrySet()) {
			Position position = entry.getKey();
			map[position.n][position.m] -= Math.min(map[position.n][position.m], entry.getValue());
		}

		meltBFS(map, getOutline(map), time + 1);
	}

	private static boolean splitTwo(int[][] map) {
		int[][] copy = copy(map);
		int part = 0;
		for (int n = 1; n < map.length - 1; n++) {
			for (int m = 1; m < map[n].length - 1; m++) {
				if (copy[n][m] != 0) {
					if (part > 0) return true;
					Stack<Position> positions = new Stack<>();
					positions.push(new Position(n, m));
					checkPart(copy, positions);
					part++;
				}
			}
		}
		return false;
	}

	private static int[][] copy(int[][] map) {
		int[][] copy = new int[map.length][map[0].length];
		for (int n = 0; n < map.length; n++) {
			for (int m = 0; m < map[n].length; m++) {
				copy[n][m] = map[n][m];
			}
		}
		return copy;
	}

	private static void checkPart(int[][] map, Stack<Position> positions) throws IndexOutOfBoundsException {
		if (positions.isEmpty()) return;

		Stack<Position> next = new Stack<>();
		while (!positions.isEmpty()) {
			Position position = positions.pop();
			int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
			for (int[] direction : directions) {
				int row = position.n + direction[0];
				int col = position.m + direction[1];
				if (map[row][col] != 0) {
					map[row][col] = 0;
					next.push(new Position(row, col));
				}
			}
		}
		checkPart(map, next);
	}
}