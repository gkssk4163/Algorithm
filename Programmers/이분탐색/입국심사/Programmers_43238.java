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

		int n3 = 6;
		int[] times3 = {8, 10};
		System.out.println(solution.solution(n3, times3));

		int n4 = 11;
		int[] times4 = {3, 4, 10};
		System.out.println(solution.solution(n4, times4));

		int n5 = 10;
		int[] times5 = {3, 7, 10};
		System.out.println(solution.solution(n5, times5));
	}
}

class Solution {
	public long solution(int n, int[] times) {
		long minTime = 0L;
		long maxTime = n * getMax(times);
		long time = 0L;

		while (minTime <= maxTime) {
			time = (minTime + maxTime) / 2;
			long people = getNumberOfPeople(times, time);

			if (people > n) {
				maxTime = time;
			} else if (people < n) {
				minTime = time;
			} else if (people == n) break;
		}

		while (getNumberOfPeople(times, time) == n) {
			time--;
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