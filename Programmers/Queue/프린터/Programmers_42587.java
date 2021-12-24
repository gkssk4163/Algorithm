package Programmers.Queue.프린터;

import java.util.*;

public class Programmers_42587 {
	public static void main(String args[]) throws Exception {
		Solution solution = new Solution();

		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		System.out.println(solution.solution(priorities, location));

		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		int location2 = 0;
		System.out.println(solution.solution(priorities2, location2));
	}
}

class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 0;

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			list.add(i);
		}

		while (true) {
			int mostImportantIndex = -1;
			int mostImportance = 0;

			int moveCount = 0;
			for (int i = 0; i < list.size(); i++) {
				if (mostImportance < priorities[list.get(i)]) {
					mostImportantIndex = list.get(i);
					mostImportance = priorities[list.get(i)];
					moveCount = i;
				}
			}

			for (int i = 0; i < moveCount; i++) {
				list.add(list.removeFirst());
			}

			list.removeFirst();
			answer++;

			if (mostImportantIndex == location) break;
		}

		return answer;
	}
}