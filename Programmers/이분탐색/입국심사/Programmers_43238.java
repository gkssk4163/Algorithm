package Programmers.이분탐색.입국심사;

public class Programmers_43238 {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int n1 = 6;
		int[] times1 = {7, 10};
		System.out.println(solution.solution(n1, times1));

		int n2 = 6;
		int[] times2 = {6, 10};
		System.out.println(solution.solution(n2, times2));

		int n3 = 10;
		int[] times3 = {3, 10};
		System.out.println(solution.solution(n3, times3));

		int n4 = 3;
		int[] times4 = {1000000000, 1000000000, 1000000000};
		System.out.println(solution.solution(n4, times4));
	}
}

class Solution {
	public long solution(int n, int[] times) {
		long minTime = 0L;
		long maxTime = (long) n * getMax(times);	// 형변환 중요!!!
		long time = 0L;

		while (minTime < maxTime) {
			time = (minTime + maxTime) / 2;
			if (time <= minTime) break;

			long people = getNumberOfPeople(times, time);

			if (people >= n) {
				maxTime = time;
			} else {
				minTime = time;
			}
		}

		return time + 1;
	}

	private long getNumberOfPeople(int[] times, long time) {
		long people = 0;
		for (int i = 0; i < times.length; i++) {
			people += time / times[i];
		}
		return people;
	}

	private int getMax(int[] times) {
		int max = 0;
		for (int time : times) {
			max = time > max ? time : max;
		}
		return max;
	}
}