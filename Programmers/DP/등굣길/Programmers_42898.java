package Programmers.DP.등굣길;

public class Programmers_42898 {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int m = 4;
		int n = 3;
		int[][] puddles = {{2, 2}};
		System.out.println(solution.solution(m, n, puddles));

		int m2 = 1;
		int n2 = 2;
		int[][] puddles2 = {};
		System.out.println(solution.solution(m2, n2, puddles2));

		int m3 = 2;
		int n3 = 1;
		int[][] puddles3 = {};
		System.out.println(solution.solution(m3, n3, puddles3));

		int m4 = 100;
		int n4 = 100;
		int[][] puddles4 = {};
		System.out.println(solution.solution(m4, n4, puddles4));

		int m5 = 5;
		int n5 = 5;
		int[][] puddles5 = {{2, 1}, {4, 1}};
		System.out.println(solution.solution(m5, n5, puddles5));

		int m6 = 5;
		int n6 = 5;
		int[][] puddles6 = {{1, 2}, {1, 4}};
		System.out.println(solution.solution(m6, n6, puddles6));
	}
}

class Solution {
	static final int PUDDLE = 0;

	public int solution(int m, int n, int[][] puddles) {
		int[][] routes = new int[n + 1][m + 1];
		initMap(m, n, routes);

		for (int i = 0; i < puddles.length; i++) {
			routes[puddles[i][1]][puddles[i][0]] = PUDDLE;
		}

		boolean meetFirstColPuddle = false;
		boolean meetFirstRowPuddle = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (isPuddle(routes[i][j])) {
					if (i == 1) meetFirstRowPuddle = true;
					if (j == 1) meetFirstColPuddle = true;
					continue;
				}

				// 첫번째 행에서 puddle을 만난 경우
				// 첫번째 행 puddle 이후 경로는 다 0이 되어야 함
				if (i == 1 && meetFirstRowPuddle) {
					routes[i][j] = PUDDLE;
					continue;
				}
				// 첫번째 열에서 puddle을 만난 경우
				// 첫번째 열 puddle 이후 경로는 다 0이 되어야 함
				if (j == 1 && meetFirstColPuddle) {
					routes[i][j] = PUDDLE;
					continue;
				}
				if (i == 1 || j == 1) {
					routes[i][j] = 1;
					continue;
				}

				routes[i][j] = (routes[i - 1][j] + routes[i][j - 1]) % 1000000007;
			}
		}

		return routes[n][m];
	}

	private boolean isPuddle(int route) {
		return route == PUDDLE;
	}

	private void initMap(int m, int n, int[][] dp) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = -1;
			}
		}
	}
}