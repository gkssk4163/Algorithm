package Programmers.정렬.K번째수;

import java.util.Arrays;

public class Programmers_42748 {
	public static void main(String args[]) {
		Solution solution = new Solution();

		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Arrays.toString(solution.solution(array, commands)));
	}
}

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0] - 1;
			int end = commands[i][1] - 1;
			int index = commands[i][2] - 1;

			int[] tempArray = new int[end - start + 1];
			for (int j = start; j <= end; j++) {
				tempArray[j-start] = array[j];
			}
			Arrays.sort(tempArray);
			answer[i] = tempArray[index];
		}

		return answer;
	}
}