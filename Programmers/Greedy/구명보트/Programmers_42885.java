package Programmers.Greedy.구명보트;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

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

		Arrays.sort(people);

		LinkedList<Integer> remainPeople = new LinkedList<>();
		for (int index = 0; index < people.length; index++) {
			remainPeople.add(index);
		}

		while (!remainPeople.isEmpty()) {
			int firstPeople = remainPeople.removeFirst();
			for (int index = remainPeople.size() - 1; index >= 0; index--) {
				if (people[firstPeople] + people[remainPeople.get(index)] <= limit) {
					remainPeople.remove(index);
					break;
				}
			}
			answer++;
		}

		return answer;
	}
}