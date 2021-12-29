package Programmers.Heap.디스크_컨트롤러;

import java.util.PriorityQueue;

public class Programmers_42627 {
	public static void main(String args[]) {
		Solution solution = new Solution();

		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution.solution(jobs));    // 9

		int[][] jobs2 = {{0, 6}, {0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution.solution(jobs2));    // 12

		int[][] jobs3 = {{0, 3}, {4, 4}, {5, 3}, {4, 1}};
		System.out.println(solution.solution(jobs3));    // 3

		int[][] jobs4 = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
		System.out.println(solution.solution(jobs4));    // 72

		int[][] jobs5 = {{0, 1000}, {250, 1000}, {500, 1000}, {750, 1000}, {1000, 1000}};
		System.out.println(solution.solution(jobs5));    // 2500
	}
}

class Solution {
	public int solution(int[][] jobs) {
		int answer = 0;

		PriorityQueue<Work> works = new PriorityQueue<>();
		for (int[] job : jobs) {
			works.add(new Work(job[0], job[1]));
		}

		int time = 0;
		Disk disk = new Disk();
		PriorityQueue<WaitingWork> waitingWorks = new PriorityQueue<>();
		while (!works.isEmpty() || !waitingWorks.isEmpty()) {
			for (int i = 0; i < works.size(); i++) {
				Work work = works.peek();
				WaitingWork incomingWork = new WaitingWork(work.requestTime, work.workTime);
				if (incomingWork.requestTime > time) break;

				waitingWorks.add(incomingWork);
				works.remove();
			}

			if (disk.isWork()) {
				time += disk.work();
				continue;
			} else {
				if (!waitingWorks.isEmpty()) {
					WaitingWork work = waitingWorks.remove();
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

		public int work() {
			this.status = STOP;
			return remainingTime - 1;
		}

		public void assignWork(WaitingWork work) {
			this.remainingTime = work.workTime;
			this.status = WORK;
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
			if (this.requestTime != other.requestTime) return this.requestTime - other.requestTime;
			return this.workTime - other.workTime;
		}
	}

	class WaitingWork implements Comparable<WaitingWork> {
		int requestTime;
		int workTime;

		public WaitingWork(int requestTime, int workTime) {
			this.requestTime = requestTime;
			this.workTime = workTime;
		}

		@Override
		public int compareTo(WaitingWork other) {
			if (this.workTime != other.workTime) return this.workTime - other.workTime;
			return this.requestTime - other.requestTime;
		}
	}
}