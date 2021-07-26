package SWEA.하계_대학생_SW_알고리즘_특강.그리디_완전탐색_DP;

import java.util.Scanner;

class SWEA_1970_쉬운_거스름돈 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int[] unitCount = new int[8];

		for (int test_case = 1; test_case <= T; test_case++) {
			int money = sc.nextInt();
			for (int i = 0; i < unit.length; i++) {
				int num = money / unit[i];
				unitCount[i] = num;
				money -= unit[i] * num;
			}

			System.out.printf("#%d\n", test_case);
			for (int i = 0; i < unitCount.length; i++) {
				System.out.printf("%d ", unitCount[i]);
			}
			System.out.println();
		}
	}
}