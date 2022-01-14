package Programmers.DP.도둑질;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Programmers_42897 {
	Solution solution = new Solution();

	@Test
	public void testCase1() {
		int[] money = {1, 2, 3, 1};
		assertEquals(4, solution.solution(money));
	}

	@Test
	public void testCase2() {
		int[] money = {5, 1, 1, 1, 5, 1, 1, 1, 5, 1};
		assertEquals(17, solution.solution(money));
	}

	@Test
	public void testCase3() {
		int[] money = {1, 1, 5, 1, 5, 1, 1, 5, 1, 5};
		assertEquals(20, solution.solution(money));
	}

	@Test
	public void testCase4() {
		int[] money = {1, 2, 3};
		assertEquals(3, solution.solution(money));
	}
}

class Solution {
	final int TEST = 0;
	final int DOUBLE_TEST = 1;
	final int JUMP = 2;
	final int DOUBLE_JUMP = 3;

	public int solution(int[] money) {
		int answer = 0;

		int[][] dp = new int[4][money.length];
		for (int i = 0; i < money.length; i++) {
			int beforeTest = i - JUMP < 0 ? 0 : Math.max(dp[TEST][i - JUMP], dp[DOUBLE_TEST][i - JUMP]);
			int beforeDoubleTest = i - DOUBLE_JUMP < 0 ? 0 : Math.max(dp[TEST][i - DOUBLE_JUMP], dp[DOUBLE_TEST][i - DOUBLE_JUMP]);
			int beforeJump = i - JUMP < 0 ? 0 : Math.max(dp[JUMP][i - JUMP], dp[DOUBLE_JUMP][i - JUMP]);
			int beforeDoubleJump = i - DOUBLE_JUMP < 0 ? 0 : Math.max(dp[JUMP][i - DOUBLE_JUMP], dp[DOUBLE_JUMP][i - DOUBLE_JUMP]);
			if (i > 0) {
				dp[TEST][i] = beforeTest + money[i];
				answer = dp[TEST][i] > answer ? dp[TEST][i] : answer;
			}
			if (i > 0 && i <= money.length - DOUBLE_TEST) {
				dp[DOUBLE_TEST][i] = beforeDoubleTest + money[i];
				answer = dp[DOUBLE_TEST][i] > answer ? dp[DOUBLE_TEST][i] : answer;
			}
			if (i <= money.length - JUMP) {
				dp[JUMP][i] = beforeJump + money[i];
				answer = dp[JUMP][i] > answer ? dp[JUMP][i] : answer;
			}
			if (i <= money.length - DOUBLE_JUMP) {
				dp[DOUBLE_JUMP][i] = beforeDoubleJump + money[i];
				answer = dp[DOUBLE_JUMP][i] > answer ? dp[DOUBLE_JUMP][i] : answer;
			}
		}

		return answer;
	}
}