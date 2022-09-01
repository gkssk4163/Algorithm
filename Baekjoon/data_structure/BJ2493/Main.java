package Baekjoon.data_structure.BJ2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int towerCount = Integer.parseInt(nextToken()); // 탑의 수
		int[] tower = new int[towerCount + 1];          // 탑들의 높이
		// 탑들의 높이 입력받기
		for (int i = 1; i <= towerCount; i++) tower[i] = Integer.parseInt(nextToken());

		int[] result = new int[towerCount + 1]; // 레이저 신호를 수신한 탑들의 번호
		Stack<Integer> stack = new Stack<>();
		for (int idx = towerCount; idx > 0; idx--) {
			if (stack.isEmpty()) {
				stack.push(idx);
				continue;
			}

			int towerHeight = tower[idx];
			while (!stack.isEmpty()) {
				int rightTowerHeight = tower[stack.peek()];
				if (towerHeight < rightTowerHeight) break;

				result[stack.peek()] = idx;
				stack.pop();
			}

			stack.push(idx);
		}

		StringBuffer sb = new StringBuffer();
		for (int idx = 1; idx <= towerCount; idx++)
			sb.append(result[idx]).append(" ");
		System.out.print(sb);
	}

	private static String nextToken() throws IOException {
		if (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}
