package Baekjoon.자료구조.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2164_카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Queue<Integer> numbers = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			numbers.offer(i);
		}
		while (numbers.size() > 1) {
			numbers.poll();
			numbers.add(numbers.poll());
		}
		System.out.println(numbers.poll());
	}
}