package Baekjoon.자료구조.Stack.Baekjoon_4949_균형잡힌_세상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String line = br.readLine();
			if (line.equals(".")) break;

			Stack<Character> brackets = new Stack<>();
			for (int index = 0; index < line.length(); index++) {
				char ch = line.charAt(index);
				if (ch == '.') break;

				if (ch == '(' || ch == '[') {
					brackets.push(ch);
				} else if (ch == ')') {
					if (!brackets.isEmpty() && brackets.peek() == '(') {
						brackets.pop();
					} else {
						brackets.push(ch);
					}
				} else if (ch == ']') {
					if (!brackets.isEmpty() && brackets.peek() == '[') {
						brackets.pop();
					} else {
						brackets.push(ch);
					}
				}
			}

			if (brackets.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}