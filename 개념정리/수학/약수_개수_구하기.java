package 개념정리.수학;

import java.io.IOException;

public class 약수_개수_구하기 {
	public static void main(String[] args) throws IOException {
		solution1();
		solution2();
	}

	/* 방법1
	 * N을 1~N 까지의 숫자로 나눈 뒤 나머지가 0인 숫자의 개수를 센다.
	 * 실행시간 : O(n)
	 */
	private static void solution1() {
		long startTime = System.currentTimeMillis();

		int N = 1000000000;

		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) count++;
		}

		System.out.println(count);

		long endTime = System.currentTimeMillis();
		System.out.println("[방법1 실행시간]:" + (endTime - startTime) / 1000.0);
	}

	/* 방법2
	 * N을 1~√n 까지의 숫자로 나눈 뒤 나머지가 0인 숫자의 개수를 센다.
	 * 실행시간 : O(√n)
	 */
	private static void solution2() {
		long startTime = System.currentTimeMillis();

		int N = 1000000000;

		int count = 0;
		for (int i = 1; i * i <= N; i++) {
			if (i * i == N) count++;
			else if (N % i == 0) count += 2;
		}

		System.out.println(count);

		long endTime = System.currentTimeMillis();
		System.out.println("[방법2 실행시간]:" + (endTime - startTime) / 1000.0);
	}
}
