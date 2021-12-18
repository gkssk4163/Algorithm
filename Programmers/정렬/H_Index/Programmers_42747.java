package Programmers.정렬.H_Index;

import java.util.Arrays;
import java.util.Collections;

public class Programmers_42747 {
	public static void main(String args[]) {
		Solution solution = new Solution();

		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution.solution(citations));

		int[] citations2 = {3, 0, 6, 1, 5, 9, 8, 10};
		System.out.println(solution.solution(citations2));

		int[] citations3 = {0, 0, 0, 0, 0};
		System.out.println(solution.solution(citations3));
	}
}

class Solution {
	public int solution(int[] citations) {
		int answer = 0;

		Integer[] citation = Arrays.stream(citations).boxed().toArray(Integer[]::new);
		Arrays.sort(citation, Collections.reverseOrder());

		for (int h = citation[0]; h >= 0; h--) {
			int hCount = 0;
			for (int i = 0; i < citation.length; i++) {
				if (citation[i] >= h) {
					hCount++;
				} else break;
			}
			if (hCount >= h) {
				answer = h;
				break;
			}
		}

		return answer;
	}
}