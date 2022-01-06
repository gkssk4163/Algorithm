package Programmers.Greedy.구명보트;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Programmers_42885 {
	Solution solution = new Solution();

	@Test
	public void testCase1() {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		assertEquals(3, solution.solution(people, limit));
	}

	@Test
	public void testCase2() {
		int[] people = {70, 80, 50};
		int limit = 100;
		assertEquals(3, solution.solution(people, limit));
	}
}

class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;

		int[] peopleCount = new int[241];
		for (int i = 0; i < people.length; i++) {
			peopleCount[people[i]]++;
		}

		for (int i = 0; i < people.length; i++) {
			int weight = people[i];
			if (peopleCount[weight] == 0) continue;
			peopleCount[weight]--;

			for (int nextWeight = limit - weight; nextWeight >= 40; nextWeight--) {
				if (peopleCount[nextWeight] > 0) {
					peopleCount[nextWeight]--;
					break;
				}
			}
			answer++;
		}

		return answer;
	}
}