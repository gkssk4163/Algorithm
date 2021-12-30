package Programmers.완전탐색.카펫;

import java.util.Arrays;

public class Programmers_42842 {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int brown = 10;
		int yellow = 2;
		System.out.println(Arrays.toString(solution.solution(brown, yellow)));

		int brown2 = 8;
		int yellow2 = 1;
		System.out.println(Arrays.toString(solution.solution(brown2, yellow2)));

		int brown3 = 24;
		int yellow3 = 24;
		System.out.println(Arrays.toString(solution.solution(brown3, yellow3)));
	}
}

class Solution {
	public int[] solution(int brown, int yellow) {
		int size = brown + yellow;
		int sero;
		int garo = -1;

		for (sero = 3; size / sero >= sero; sero++) {
			garo = size / sero;
			if (sero * garo != size) continue;

			int brownCount = (sero * 2) + ((garo - 2) * 2);
			if (brownCount == brown) break;
		}

		return new int[]{garo, sero};
	}
}