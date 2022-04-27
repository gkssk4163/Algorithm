package Baekjoon.자료구조.Stack.Baekjoon_1935_후위_표기식2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		char[] command = st.nextToken().toCharArray();

		int[] number = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			number[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Double> variables = new Stack<>();
		for (int i = 0; i < command.length; i++) {
			if (isOperation(command[i])) {
				double x2 = variables.pop();
				double x1 = variables.pop();
				variables.push(operation(x1, command[i], x2));
			} else {
				int num = number[command[i] - 'A'];
				variables.push((double) num);
			}
		}

		System.out.printf("%.2f", variables.pop());
	}

	private static boolean isOperation(char command) {
		return command == '+' || command == '-' || command == '*' || command == '/';
	}

	private static double operation(double x1, char command, double x2) {
		switch (command) {
			case '+':
				return x1 + x2;
			case '-':
				return x1 - x2;
			case '*':
				return x1 * x2;
			case '/':
				return x1 / x2;
		}

		throw new RuntimeException();
	}
}