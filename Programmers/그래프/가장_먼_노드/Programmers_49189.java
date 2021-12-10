package Programmers.그래프.가장_먼_노드;

import java.util.LinkedList;
import java.util.List;

public class Programmers_49189 {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int n1 = 6;
		int[][] edge1 = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution.solution(n1, edge1));
	}
}

class Solution {
	public int solution(int n, int[][] edge) {
		boolean[][] line = new boolean[n + 1][n + 1];
		boolean[] visit = new boolean[n + 1];
		initLine(line, edge);

		List<Integer> node = new LinkedList<>();
		visit(node, visit, 1);

		while (!node.isEmpty()) {
			List<Integer> nextNode = new LinkedList<>();

			for (int i = 0; i < node.size(); i++) {
				int curNode = node.get(i);
				for (int j = 1; j <= n; j++) {
					if (!visit[j] && line[curNode][j]) {
						visit(nextNode, visit, j);
					}
				}
			}

			if (nextNode.isEmpty()) break;
			node = nextNode;
		}

		return node.size();
	}

	private void initLine(boolean[][] line, int[][] edge) {
		for (int i = 0; i < edge.length; i++) {
			int nodeA = edge[i][0];
			int nodeB = edge[i][1];
			line[nodeA][nodeB] = true;
			line[nodeB][nodeA] = true;
		}
	}

	private void visit(List<Integer> node, boolean[] visit, int i) {
		visit[i] = true;
		node.add(i);
	}
}