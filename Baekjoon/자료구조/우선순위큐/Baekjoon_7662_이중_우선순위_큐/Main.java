package Baekjoon.자료구조.우선순위큐.Baekjoon_7662_이중_우선순위_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testCase = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < testCase; tc++) {
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

			st = new StringTokenizer(br.readLine());
			int commandCount = Integer.parseInt(st.nextToken());
			Map<Integer, Integer> countByNumber = new HashMap<>();
			for (int i = 0; i < commandCount; i++) {
				st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int number = Integer.parseInt(st.nextToken());

				switch (command) {
					case 'I':
						minHeap.add(number);
						maxHeap.add(number);
						countByNumber.put(number, countByNumber.getOrDefault(number, 0) + 1);
						break;
					case 'D':
						switch (number) {
							case 1:
								removeUnnecessaryNumbers(maxHeap, countByNumber);
								removeNumber(maxHeap, countByNumber);
								break;
							case -1:
								removeUnnecessaryNumbers(minHeap, countByNumber);
								removeNumber(minHeap, countByNumber);
						}
				}
			}

			removeUnnecessaryNumbers(maxHeap, countByNumber);
			removeUnnecessaryNumbers(minHeap, countByNumber);

			if (countByNumber.size() == 0) sb.append("EMPTY").append("\n");
			else sb.append(maxHeap.peek()).append(" ").append(minHeap.peek()).append("\n");
		}
		System.out.println(sb);
	}

	private static void removeNumber(PriorityQueue<Integer> maxHeap, Map<Integer, Integer> countByNumber) {
		if (!maxHeap.isEmpty()) {
			int max = maxHeap.poll();
			int count = countByNumber.getOrDefault(max, 0);
			if (count > 1)
				countByNumber.put(max, countByNumber.get(max) - 1);
			else
				countByNumber.remove(max);
		}
	}

	private static void removeUnnecessaryNumbers(PriorityQueue<Integer> heap, Map<Integer, Integer> countByNumber) {
		while (!heap.isEmpty()) {
			if (countByNumber.containsKey(heap.peek())) break;
			heap.poll();
		}
	}
}