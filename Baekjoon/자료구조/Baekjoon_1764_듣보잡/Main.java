package Baekjoon.자료구조.Baekjoon_1764_듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Boolean> people = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String name = new StringTokenizer(br.readLine()).nextToken();
			people.put(name, false);
		}
		for (int i = 0; i < M; i++) {
			String name = new StringTokenizer(br.readLine()).nextToken();
			boolean result = !people.getOrDefault(name, true);
			people.put(name, result);
		}

		PriorityQueue<String> names = new PriorityQueue<>();
		for (Map.Entry<String, Boolean> entry : people.entrySet()) {
			if (entry.getValue()) {
				names.offer(entry.getKey());
			}
		}
		System.out.println(names.size());
		while (!names.isEmpty()) {
			System.out.println(names.poll());
		}
	}
}