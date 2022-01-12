package Baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2470_두_용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] value = new int[N];
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(value);

		int left = 0;
		int right = N - 1;
		int minAnswer = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		while (left < right) {
			int answer = Math.abs(value[left] + value[right]);
			if (answer < minAnswer) {
				min = value[left];
				max = value[right];
				minAnswer = answer;
			}

			int nextLeft = Math.abs(value[left + 1] + value[right]);
			int nextRight = Math.abs(value[left] + value[right - 1]);
			if (nextLeft < nextRight) left++;
			else right--;
		}

		int[] solution = new int[2];
		solution[0] = min;
		solution[1] = max;

		Arrays.sort(solution);
		System.out.println(Arrays.toString(solution)
				.replace("[", "")
				.replace("]", "")
				.replace(",", ""));
	}
}