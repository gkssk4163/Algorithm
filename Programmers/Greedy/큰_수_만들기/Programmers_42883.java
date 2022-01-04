package Programmers.Greedy.큰_수_만들기;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Programmers_42883 {
	@Test
	public static void main(String[] args) {
		Solution solution = new Solution();

		String number = "1924";
		int k = 2;
		assertEquals(solution.solution(number, k), "94");

		String number2 = "1231234";
		int k2 = 3;
		assertEquals(solution.solution(number2, k2), "3234");

		String number3 = "4177252841";
		int k3 = 4;
		assertEquals(solution.solution(number3, k3), "775841");
	}
}

class Solution {
	public String solution(String number, int k) {
		String max = number.substring(0, number.length() - k);

		for (int i = number.length() - k; i < number.length(); i++) {
			String checkNumber = number.substring(i, i + 1);

			String tempMax = Integer.toString(Integer.MIN_VALUE);
			for (int j = 0; j < max.length(); j++) {
				String tempNumber = max.substring(0, j) + max.substring(j + 1) + checkNumber;
				if (tempNumber.compareTo(tempMax) > 0) tempMax = tempNumber;
			}

			if (tempMax.compareTo(max) > 0) max = tempMax;
		}

		return max;
	}
}