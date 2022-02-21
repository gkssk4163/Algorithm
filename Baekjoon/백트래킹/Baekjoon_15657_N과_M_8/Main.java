package Baekjoon.백트래킹.Baekjoon_15657_N과_M_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] numbers;
	private static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		stack = new Stack<>();
		backtracking(0, 0);
	}

	private static void backtracking(int index, int count) {
		if (count == M) {
			System.out.println(stack.toString()
					.replace("[", "")
					.replace("]", "")
					.replace(",", ""));
			return;
		}

		for (int i = index; i < N; i++) {
			stack.push(numbers[i]);
			backtracking(i, count + 1);
			stack.pop();
		}
	}
}