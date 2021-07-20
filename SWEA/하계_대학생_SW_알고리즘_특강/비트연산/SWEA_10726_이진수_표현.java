package SWEA.하계_대학생_SW_알고리즘_특강.비트연산;

import java.util.Scanner;

public class SWEA_10726_이진수_표현 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();	// 켜져있어야할 비트 수
			int M = sc.nextInt();	// 이진수로 표현될 숫자
			boolean ON = true;
			for (int i = 0; i < N; i++) {
				// 1을 왼쪽으로 0~N-1번 움직이며 각 자리가 1인지 체크
				// 1이 아니면 스위치를 끄고 종료
				if ((M & (1 << i)) == 0) {
					ON = false;
					break;
				}
			}
			System.out.printf("#%d %s\n", test_case, (ON ? "ON" : "OFF"));
		}
	}
}