package Baekjoon.자료구조.Stack.Baekjoon_10799_쇠막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] info = st.nextToken().toCharArray();

		int high = 0;
		int answer = 0;
		for (int i = 0; i < info.length; i++) {
			if (isLaser(info, i)) {
				answer += high;
				i++;
			}
			else if (info[i] == '(') {
				high++;
			} else if (info[i] == ')'){
				answer++;
				high--;
			}
		}
		System.out.println(answer);
	}

	private static boolean isLaser(char[] info, int index) {
		return (info[index] == '(' && info[index + 1] == ')');
	}
}