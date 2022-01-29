package Baekjoon.탐색.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2798_블랙잭 {
	static int answer = 0;
	static int MAX;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		MAX = M;

		int[] numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		findAnswer(numbers, 0, 0, 0);
		System.out.println(answer);
	}

	private static void findAnswer(int[] numbers, int index, int count, int sum) {
		if (count == 3) {
			if (answer < sum && sum <= MAX) answer = sum;
			return;
		}
		for (int i = index; i < numbers.length; i++) {
			findAnswer(numbers, i + 1, count + 1, sum + numbers[i]);
		}
	}
}