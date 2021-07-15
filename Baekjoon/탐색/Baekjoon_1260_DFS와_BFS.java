package Baekjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1260_DFS와_BFS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int[][] graph = new int[N+1][N+1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1= Integer.parseInt(st.nextToken());
			int v2= Integer.parseInt(st.nextToken());
			graph[v1][v2] = -1;
		}
		DFS(copy(graph), V);
		System.out.println();

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		BFS(copy(graph), queue);
		System.out.println();
	}

	private static void DFS(int[][] graph, int from) {
		// 방문한 곳이면 종료
		if (graph[from][from] == 1) return;
		// 방문기록
		visit(graph, from);

		// 다음 DFS 반복
		for (int to = 1; to < graph.length; to++) {
			if (graph[from][to] == -1 || graph[to][from] == -1) {
				graph[from][to] = 1;
				graph[to][from] = 1;
				DFS(graph, to);
			}
		}
	}


	private static void BFS(int[][] graph, Queue<Integer> queue) {
		if (queue.isEmpty()) return;
		Queue<Integer> nextQueue = new LinkedList<>();
		while (!queue.isEmpty()) {
			// 방문한 곳이면 종료
			int from = queue.poll();
			if (graph[from][from] == 1) continue;

			// 방문기록
			visit(graph, from);

			for (int to = 1; to < graph.length; to++) {
				if (graph[from][to] == -1 || graph[to][from] == -1) {
					graph[from][to] = 1;
					graph[to][from] = 1;
					nextQueue.offer(to);
				}
			}
		}
		BFS(graph, nextQueue);
	}

	private static void visit(int[][] graph, int from) {
		// 방문기록
		System.out.print(from + " ");
		graph[from][from] = 1;
	}

	private static int[][] copy(int[][] graph) {
		int[][] copy = new int[graph.length][graph.length];
		for (int i = 1; i < graph.length; i++) {
			for (int j = 1; j < graph.length; j++) {
				copy[i][j] = graph[i][j];
			}
		}
		return copy;
	}
}