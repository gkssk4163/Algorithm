package Baekjoon.자료구조.Stack.Baekjoon_2504_괄호의_값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean valid = true;
		char[] bracketString = st.nextToken().toCharArray();

		Stack<String> stack = new Stack<>();
		for (int index = 0; index < bracketString.length; index++) {
			if (bracketString[index] == '(' && index + 1 < bracketString.length && bracketString[index + 1] == ')') {
				stack.push("2");
				index++;
			} else if (bracketString[index] == '[' && index + 1 < bracketString.length && bracketString[index + 1] == ']') {
				stack.push("3");
				index++;
			} else if (bracketString[index] == ')') {
				int sum = calcSum(stack);
				if (!stack.isEmpty() && stack.peek().equals("(")) {
					stack.pop();
					stack.push(String.valueOf(sum * 2));
				} else {
					valid = false;
					break;
				}
			} else if (bracketString[index] == ']') {
				int sum = calcSum(stack);
				if (!stack.isEmpty() && stack.peek().equals("[")) {
					stack.pop();
					stack.push(String.valueOf(sum * 3));
				} else {
					valid = false;
					break;
				}
			} else {
				stack.push(String.valueOf(bracketString[index]));
			}
		}

		int answer = calcSum(stack);
		if (stack.size() != 0) valid = false;

		if (valid) {
			System.out.println(answer);
		} else {
			System.out.println(0);
		}

	}

	private static int calcSum(Stack<String> stack) {
		int sum = 0;
		while (!stack.isEmpty()) {
			if (isBracket(stack.peek())) break;
			sum += Integer.parseInt(stack.pop());
		}
		return sum;
	}

	private static boolean isBracket(String peek) {
		return peek.equals("(") || peek.equals(")") ||peek.equals("[") ||peek.equals("]");
	}
}