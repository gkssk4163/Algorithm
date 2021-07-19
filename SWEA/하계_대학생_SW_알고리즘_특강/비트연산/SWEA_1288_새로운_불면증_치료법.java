package SWEA.하계_대학생_SW_알고리즘_특강.비트연산;

import java.util.Scanner;

public class SWEA_1288_새로운_불면증_치료법 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	// 테스트케이스

		for (int test_case = 1; test_case <= T; test_case++) {
			int num = sc.nextInt();	// 한 번에 셀 양의 수
			boolean[] seenNumber = new boolean[10];	// 본 숫자인지 체크할 배열
			int idx = 1;	// 양을 센 횟수

			// 전체 숫자를 다 볼 때까지 양 세기 반복
			while (!seeAllNumbers(seenNumber)) {
				char[] number = String.valueOf(num * idx).toCharArray();
				// number의 각 자리를 0~9와 비교하여 숫자를 봤는지 체크
				for (int i = 0; i < number.length; i++) {
					for (int j = 0; j < 10; j++) {
						// 비트연산자를 사용해서 일치하는지를 체크해 줌
						if ((j ^ (number[i] - '0')) == 0) {
							seenNumber[j] = true;
							break;
						}
					}
				}
				idx++;	// 양 센 횟수 증가
			}
			System.out.printf("#%d %d\n", test_case, num * (idx - 1));
		}
	}

	// 전체 숫자를 다 봤는지 체크
	private static boolean seeAllNumbers(boolean[] seenNumber) {
		for (int i = 0; i < 10; i++) {
			if (!seenNumber[i]) return false;
		}
		return true;
	}
}