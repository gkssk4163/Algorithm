package Baekjoon.탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_11724_연결_요소의_개수 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());    // 정점의 개수
		int M = Integer.parseInt(st.nextToken());    // 간선의 개수

		int[][] graph = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = 1;
			graph[v][u] = 1;
		}

		boolean[] visit = new boolean[N + 1];
		int network = 0;
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				findNetwork(graph, visit, i);
				network++;
			}
		}

		System.out.println(network);
	}

	private static void findNetwork(int[][] graph, boolean[] visit, int i) {
		Stack<Integer> point = new Stack<>();
		point.push(i);
		visit[i] = true;
		BFS(graph, visit, point);
	}

	private static void BFS(int[][] graph, boolean[] visit, Stack<Integer> point) {
		if (point.isEmpty()) return;

		Stack<Integer> next = new Stack<>();
		while (!point.isEmpty()) {
			int v1 = point.pop();
			for (int v2 = 1; v2 <= N; v2++) {
				if (graph[v1][v2] == 1 && !visit[v2]) {
					next.push(v2);
					visit[v2] = true;
				}
			}
		}
		BFS(graph, visit, next);
	}
}