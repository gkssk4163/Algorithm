package Programmers.Heap.더_맵게;

import java.util.*;

public class Programmers_42626 {
	public static void main(String args[]) throws Exception {
		Solution solution = new Solution();

		int[] scoville1 = {1, 2, 3, 9, 10, 12};
		int K1 = 7;
		System.out.println(solution.solution(scoville1, K1));

		int[] scoville2 = {12, 10, 9, 3, 2, 1};
		int K2 = 7;
		System.out.println(solution.solution(scoville2, K2));
	}
}

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> minHeap = new PriorityQueue();
		for (int scov : scoville) minHeap.add(scov);

		while (!isComplete(minHeap, K)) {
			if (minHeap.size() == 1) return -1;

			int mostLower = minHeap.poll();
			int lower = minHeap.poll();
			minHeap.add(mostLower + (lower * 2));
			answer++;
		}

		return answer;
	}

	private boolean isComplete(PriorityQueue<Integer> minHeap, int K) {
		return minHeap.peek() >= K;
	}
}