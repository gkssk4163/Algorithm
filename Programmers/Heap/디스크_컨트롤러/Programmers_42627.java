package Programmers.Heap.디스크_컨트롤러;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class Programmers_42627 {
	Solution solution = new Solution();

	@Test
	public void testCase1() {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		assertEquals(9, solution.solution(jobs));
	}

	@Test
	public void testCase2() {
		int[][] jobs = {{0, 6}, {0, 3}, {1, 9}, {2, 6}};
		assertEquals(12, solution.solution(jobs));
	}

	@Test
	public void testCase3() {
		int[][] jobs = {{0, 3}, {4, 4}, {5, 3}, {4, 1}};
		assertEquals(3, solution.solution(jobs));
	}

	@Test
	public void testCase4() {
		int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
		assertEquals(72, solution.solution(jobs));
	}

	@Test
	public void testCase5() {
		int[][] jobs = {{0, 1000}, {250, 1000}, {500, 1000}, {750, 1000}, {1000, 1000}};
		assertEquals(2500, solution.solution(jobs));
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
		PriorityQueue<WaitingWork> waitingWorks = new PriorityQueue<>();
		while (!works.isEmpty() || !waitingWorks.isEmpty()) {
			// 대기중인 작업목록
			while (!works.isEmpty()) {
				Work work = works.peek();
				if (work.requestTime > time) break;

				works.poll();
				waitingWorks.add(new WaitingWork(work.requestTime, work.workTime));
			}

			// 대기중인 작업이 있으면 처리
			if (!waitingWorks.isEmpty()) {
				WaitingWork waitingWork = waitingWorks.poll();
				answer += time - waitingWork.requestTime + waitingWork.workTime;
				time += waitingWork.workTime;
			} else {	// 없으면 시간 1 증가
				time++;
			}
		}

		return answer / jobs.length;
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