package Baekjoon.자료구조.Queue.Baekjoon_1966_프린터_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] importanceCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			importanceCnt = new int[10];
			int[] importance = new int[N];
			Queue<Integer> queue = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				importance[j] = num;
				importanceCnt[num]++;
				queue.offer(j);
			}

			int count = 0;
			int lastPoll = -1;
			while (!queue.isEmpty()) {
				if (lastPoll == M) break;

				int front = queue.poll();
				if (isMostImportant(importance[front])) {
					importanceCnt[importance[front]]--;
					lastPoll = front;
					count++;
				} else {
					queue.offer(front);
				}
			}

			System.out.println(count);
		}
	}

	private static boolean isMostImportant(int importance) {
		for (int i = importance + 1; i < 10; i++) {
			if (importanceCnt[i] > 0) return false;
		}
		return true;
	}
}