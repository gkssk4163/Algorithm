package Programmers.Dev_Matching_2021_웹_백엔드_개발자_상반기.로또의_최고_순위와_최저_순위;

import java.io.IOException;
import java.util.Arrays;

class Programmers_77484 {
	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();

		int[] lottos1 = {44, 1, 0, 0, 31, 25};
		int[] win_nums1 = {31, 10, 45, 1, 6, 19};
		System.out.println(Arrays.toString(solution.solution(lottos1, win_nums1)));

		int[] lottos2 = {0, 0, 0, 0, 0, 0};
		int[] win_nums2 = {38, 19, 20, 40, 15, 25};
		System.out.println(Arrays.toString(solution.solution(lottos2, win_nums2)));

		int[] lottos3 = {45, 4, 35, 20, 3, 9};
		int[] win_nums3 = {20, 9, 3, 45, 4, 35};
		System.out.println(Arrays.toString(solution.solution(lottos3, win_nums3)));
	}
}

class Solution {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		final int COUNT = 6;
		int zeroCount = 0;
		int machCount = 0;
		for (int i = 0; i < COUNT; i++) {
			if (lottos[i] == 0) {
				zeroCount++;
			} else {
				for (int j = 0; j < COUNT; j++) {
					if (lottos[i] == win_nums[j]) machCount++;
				}
			}
		}

		answer[0] = rank(machCount + zeroCount);
		answer[1] = rank(machCount);

		return answer;
	}

	private int rank(int machCount) {
		switch (machCount) {
			case 6:
				return 1;
			case 5:
				return 2;
			case 4:
				return 3;
			case 3:
				return 4;
			case 2:
				return 5;
			default:
				return 6;
		}
	}
}