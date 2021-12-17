package Programmers.Heap.이중우선순위큐;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Programmers_42628 {
	public static void main(String args[]) {
		Solution solution = new Solution();

		String[] operations = {"I 16", "D 1"};
		System.out.println(Arrays.toString(solution.solution(operations)));

		String[] operations2 = {"I 7","I 5","I -5","D -1"};
		System.out.println(Arrays.toString(solution.solution(operations2)));
	}
}

class Solution {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

		for (String operation : operations) {
			String[] op = operation.split(" ");
			char command = op[0].charAt(0);
			int number = Integer.parseInt(op[1]);

			switch (command) {
				case 'I':
					minHeap.add(number);
					maxHeap.add(number * -1);
					break;
				case 'D':
					if (minHeap.isEmpty()) break;
					if (number == 1) {
						int poll = maxHeap.poll();
						minHeap.remove(poll * -1);
					} else if (number == -1) {
						int poll = minHeap.poll();
						maxHeap.remove(poll * -1);
					}
					break;
			}
		}

		answer[0] = maxHeap.size() == 0 ? 0 : maxHeap.peek() * -1;
		answer[1] = minHeap.size() == 0 ? 0 : minHeap.peek();

		return answer;
	}
}