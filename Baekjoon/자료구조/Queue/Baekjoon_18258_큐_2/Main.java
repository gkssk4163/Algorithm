package Baekjoon.자료구조.Queue.Baekjoon_18258_큐_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			switch (command) {
				case "push":
					int num = Integer.parseInt(st.nextToken());
					queue.offer(num);
					break;
				case "pop":
					if (queue.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(queue.poll()).append("\n");
					}
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "empty":
					sb.append(queue.isEmpty() ? "1" : "0").append("\n");
					break;
				case "front":
					if (queue.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(queue.peek()).append("\n");
					}
					break;
				case "back":
					if (queue.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(((LinkedList<Integer>) queue).peekLast()).append("\n");
					}
					break;
			}
		}

		System.out.println(sb);
	}
}