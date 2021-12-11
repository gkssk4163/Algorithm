package 개념정리.수학.소수의_개수;

/*
 * 문제 URL : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2079&sca=2040
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		long startTime;
		long endTime;

		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		startTime = System.currentTimeMillis();
		System.out.println(solution1(M, N));
		endTime = System.currentTimeMillis();
		System.out.println("[방법1 실행시간]:" + (endTime - startTime) / 1000.0);

		startTime = System.currentTimeMillis();
		System.out.println(solution2(M, N));
		endTime = System.currentTimeMillis();
		System.out.println("[방법2 실행시간]:" + (endTime - startTime) / 1000.0);

		startTime = System.currentTimeMillis();
		System.out.println(solution3(M, N));
		endTime = System.currentTimeMillis();
		System.out.println("[방법3 실행시간]:" + (endTime - startTime) / 1000.0);
	}

	/* 방법1
	 * M~N 까지 숫자를 i(2 < i < 자기자신)로 나눠 0으로 나누어 떨어지면 소수개수 누적
	 */
	private static int solution1(int M, int N) {
		int primeCount = 0;
		for (int num = M; num <= N; num++) {
			if (num == 1) continue;
			if (isPrime(num)) {
				primeCount++;
			}
		}

		return primeCount;
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}

	/* ============================================ */

	/* 방법2
	 * 1~N 까지의 숫자 중 작은 수부터 소수를 판별하고 소수의 배수를 제거해 나감
	 * 5가 소수이면 10,15,20,25,...,(N보다 작은 5의 최대 배수)까지 제거
	 */
	private static int solution2(int M, int N) {
		boolean[] isPrime = initPrime(N);

		for (int num = 1; num <= N; num++) {
			if (num == 1) isPrime[num] = false;
			if (!isPrime[num]) continue;
			for (int i = 2; num * i <= N; i++) {
				isPrime[num * i] = false;
			}
		}

		int prime = 0;
		for (int i = M; i <= N; i++) {
			if (isPrime[i]) prime++;
		}

		return prime;
	}

	private static boolean[] initPrime(int N) {
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			isPrime[i] = true;
		}
		return isPrime;
	}

	/* ============================================ */

	/* 방법3
	 * 방법2와 동일하지만 배수를 제거하는 범위 축소
	 * 5가 소수이면 10,15,20은 5보다 작은 소수 판별에서 이미 제거되므로
	 * 5의 제곱인 25부터 (N보다 작은 5의 최대 배수)까지 제거
	 */
	private static int solution3(int M, int N) {
		boolean[] isPrime = initPrime(N);

		for (int num = 1; num <= N; num++) {
			if (num == 1) isPrime[num] = false;
			if (!isPrime[num]) continue;
			for (int i = num; (long) num * i <= N; i++) {
				isPrime[num * i] = false;
			}
		}

		int prime = 0;
		for (int i = M; i <= N; i++) {
			if (isPrime[i]) prime++;
		}

		return prime;
	}
}