package Programmers.Heap.디스크_컨트롤러;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Programmers_42627 {
	public static void main(String args[]) {
		Solution solution = new Solution();

		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution.solution(jobs));

		int[][] jobs2 = {{0, 6}, {0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution.solution(jobs2));

		int[][] jobs3 = {{0, 3}, {4, 4}, {5, 3}, {4, 1}};
		System.out.println(solution.solution(jobs3));
	}
}

class Solution {
	public int solution(int[][] jobs) {
		int answer = 0;

		List<Work> works = new LinkedList<>();
		for (int[] job : jobs) {
			works.add(new Work(job[0], job[1]));
		}

		int time = 0;
		Disk disk = new Disk();
		PriorityQueue<Work> minHeap = new PriorityQueue<>();
		while (time <= 1000) {
			for (int i = works.size() - 1; i >= 0; i--) {
				if (works.get(i).requestTime == time) {
					minHeap.add(works.get(i));
					works.remove(i);
				}
			}

			if (disk.isWork()) {
				disk.work();
			} else {
				if (!minHeap.isEmpty()) {
					Work work = minHeap.remove();
					disk.assignWork(work);
					answer += time - work.requestTime + work.workTime;
				}
			}

			time++;
		}

		return answer / jobs.length;
	}

	class Disk {
		final String STOP = "STOP";
		final String WORK = "WORK";

		String status;
		int remainingTime;

		public Disk() {
			this.status = STOP;
			this.remainingTime = 0;
		}

		public boolean isWork() {
			return this.status.equals(WORK);
		}

		public void work() {
			this.remainingTime--;
			if (this.remainingTime == 0) this.status = STOP;
		}

		public void assignWork(Work work) {
			this.remainingTime = work.workTime;
			this.status = WORK;
			work();
		}
	}

	class Work implements Comparable<Work> {
		int requestTime;
		int workTime;

		public Work(int requestTime, int workTime) {
			this.requestTime = requestTime;
			this.workTime = workTime;
		}

		@Override
		public int compareTo(Work other) {
			if (this.workTime != other.workTime) return this.workTime - other.workTime;
			return this.requestTime - other.requestTime;
		}
	}
}