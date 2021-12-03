package Programmers.Queue.기능개발;

import java.util.*;

public class Programmers_42586 {
	public static void main(String args[]) throws Exception {
		Solution solution = new Solution();

		int[] progresses1 = {93, 30, 55};
		int[] speeds1 = {1, 30, 5};
		System.out.println(Arrays.toString(solution.solution(progresses1, speeds1)));

		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution.solution(progresses2, speeds2)));
	}
}

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> publishCnt = new ArrayList<>();
		Queue<Integer> publish = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
			if (publish.isEmpty() || publish.peek() >= days) {
				publish.offer(days);
				continue;
			}

			publishCnt.add(publish.size());
			publish.clear();
			publish.offer(days);
		}

		publishCnt.add(publish.size());

		int[] answer = new int[publishCnt.size()];
		for (int i = 0; i < publishCnt.size(); i++) {
			answer[i] = publishCnt.get(i);
		}

		return answer;
	}
}