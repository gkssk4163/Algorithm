package Baekjoon.자료구조.Stack.Baekjoon_9012_괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char[] str = st.nextToken().toCharArray();

			Stack<Character> stack = new Stack<>();
			boolean correct = true;
			for (int j = 0; j < str.length; j++) {
				char now = str[j];
				if (now == '(') {
					stack.push(now);
				} else if (now == ')') {
					if (stack.isEmpty()) {
						correct = false;
						break;
					} else {
						stack.pop();
					}
				}
			}

			if (stack.isEmpty() && correct) {
				System.out.println("YES");
			} else  {
				System.out.println("NO");
			}
		}
	}
}