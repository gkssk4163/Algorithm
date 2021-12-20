package Programmers.DFS.네트워크;

public class Programmers_43162 {

	public static void main(String args[]) {
		Solution solution = new Solution();

		int n1 = 3;
		int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution.solution(n1, computers1));

		int n2 = 3;
		int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(solution.solution(n2, computers2));

		int n3 = 7;
		int[][] computers3 = {
				{1, 1, 1, 1, 0, 0, 0},
				{1, 1, 0, 0, 0, 0, 0},
				{1, 0, 1, 0, 0, 0, 0},
				{1, 0, 0, 1, 0, 1, 0},
				{0, 0, 0, 0, 1, 0, 1},
				{0, 0, 0, 1, 0, 1, 0},
				{0, 0, 0, 0, 1, 0, 1}
		};
		System.out.println(solution.solution(n3, computers3));

		int n4 = 7;
		int[][] computers5 = {
				{1, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 1, 0},
				{0, 0, 0, 0, 0, 0, 1}
		};
		System.out.println(solution.solution(n4, computers5));

		int n5 = 1;
		int[][] computers6 = {{1}};
		System.out.println(solution.solution(n5, computers6));
	}
}

class Solution {
	public int solution(int n, int[][] computers) {
		int answer = 0;

		boolean[] visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visitNetwork(n, computers, visit, i);
				answer++;
			}
		}

		return answer;
	}

	private void visitNetwork(int n, int[][] computers, boolean[] visit, int index) {
		visit[index] = true;
		for (int i = 0; i < n; i++) {
			if (!visit[i] && computers[index][i] == 1)
				visitNetwork(n, computers, visit, i);
		}
	}
}