package Baekjoon.자료구조.Deque.Baekjoon_2346_풍선_터뜨리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] number = new int[N + 1];
		Deque<Integer> deque = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			deque.offer(i);
		}

		while (!deque.isEmpty()) {
			int nextIndex = deque.poll();
			int next = number[nextIndex];
			System.out.print(nextIndex + " ");
			if (deque.isEmpty()) break;

			if (next > 0) {
				for (int i = 1; i < next; i++) {
					deque.offer(deque.poll());
				}
			} else if (next < 0) {
				for (int i = -1; i >= next; i--) {
					deque.offerFirst(deque.pollLast());
				}
			}
		}
	}
}