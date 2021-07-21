package SWEA.하계_대학생_SW_알고리즘_특강.비트연산;

import java.util.Scanner;

class SWEA_3316_동아리실_관리하기 {
	static int[][] dp;	// 각 일자별 경우의 수 저장할 배열

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] managers = sc.next().toCharArray();	// 일자별 책임자

			// dp를 초기화해주고, 첫날에는 A가 열쇠를 가지고 있으므로
			// 0번째날에 A가 참석하는 경우를 1로 변경해 줌
			dp = new int[managers.length+1][16];
			dp[0][1] = 1;	// 초기세팅

			// 다음 경우의 수 체크
			checkNextCase(managers, 0);

			int cases = 0;
			for (int i = 1; i < 16; i++) {
				cases = (cases + dp[managers.length][i]) % 1000000007;
			}
			System.out.printf("#%d %d\n", test_case, cases);
		}
	}

	private static void checkNextCase(char[] managers, int idx) {
		// 범위를 벗어날 경우 종료
		if (idx == managers.length) return;

		// 책임자를 숫자로 치환해 줌. A~D 까지 0~3번이 됨
		int manager = managers[idx] - 'A';
		// 전날의 경우의 수를 체크하여 1 이상인 경우에 대해서만 오늘 가능한 경우의 수를 구함
		for (int preCases = 1; preCases < 16; preCases++) {
			if (dp[idx][preCases] > 0) {
				for (int cases = 1; cases < 16; cases++) {
					int count = 0;
					// 당일 활동책임자가 없으면 건너뜀
					if ((cases & (1 << manager)) == 0) continue;
					// 전날 참여자 중 한명이라도 참여했는지 체크
					for (int j = 0; j < 4; j++) {
						// 전날 참여자가 있고 해당 참여자가 cases에도 있으면 count 증가 후 종료
						if (((preCases & (1 << j)) > 0) && ((cases & (1 << j)) > 0)) {
							count++;
							break;
						}
					}
					dp[idx+1][cases] = (dp[idx+1][cases] + dp[idx][preCases] * count) % 1000000007;
				}
			}
		}
		checkNextCase(managers, idx+1);
	}
}