package Baekjoon.탐색.BFS.Baekjoon_2606_바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] matrix;
	private static boolean[] visit;
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		matrix = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			matrix[v1][v2] = 1;
			matrix[v2][v1] = 1;
		}

		virusCheck(1);

		System.out.println(count);
	}

	private static void virusCheck(int start) {
		Stack<Integer> stack = new Stack<>();
		checkVisit(start);
		stack.push(start);
		BFS(stack);
	}

	private static void BFS(Stack<Integer> stack) {
		if (stack.isEmpty()) return;

		Stack<Integer> next = new Stack<>();
		while (!stack.isEmpty()) {
			int start = stack.pop();
			for (int i = 0; i <= N; i++) {
				if (!visit(i) && matrix[start][i] == 1) {
					checkVisit(i);
					next.push(i);
					count++;
				}
			}
		}
		BFS(next);
	}

	private static boolean visit(int i) {
		return visit[i];
	}

	private static void checkVisit(int i) {
		visit[i] = true;
	}
}