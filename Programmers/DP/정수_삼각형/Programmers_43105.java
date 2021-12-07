package Programmers.DP.정수_삼각형;

public class Programmers_43105 {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution.solution(triangle));
	}
}

class Solution {
	public int solution(int[][] triangle) {
		int[] dp = {};

		int size = triangle.length;
		while (size > 0) {
			int row = size - 1;
			int[] nextDP = new int[size];
			for (int i = 0; i < nextDP.length; i++) {
				if (size == triangle.length) {
					nextDP[i] = triangle[row][i];
				} else {
					nextDP[i] = triangle[row][i] + Math.max(dp[i], dp[i + 1]);
				}
			}
			dp = nextDP;
			size--;
		}

		return dp[0];
	}
}