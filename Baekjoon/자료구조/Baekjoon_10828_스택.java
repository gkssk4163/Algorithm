package Baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_10828_스택 {
	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());    // 테스트케이스

		List<Integer> stack = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			switch (command) {
				case "push":
					int number = Integer.parseInt(st.nextToken());
					stack.add(0, number);
					break;
				case "pop":
					if (stack.isEmpty()) {
						sb.append("-1").append("\n");
						break;
					}
					int remove = stack.remove(0);
					sb.append(remove).append("\n");
					break;
				case "size":
					sb.append(stack.size()).append("\n");
					break;
				case "empty":
					sb.append(stack.isEmpty() ? 1 : 0).append("\n");
					break;
				case "top":
					if (stack.isEmpty()) {
						sb.append("-1").append("\n");
						break;
					}
					int top = stack.get(0);
					sb.append(top).append("\n");
					break;
			}
		}
		System.out.println(sb);
	}
}