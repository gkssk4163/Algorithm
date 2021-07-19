package SWEA.하계_대학생_SW_알고리즘_특강.비트연산;

import java.io.IOException;

public class SWEA_210720_표준입출력방법 {
	public static void main(String[] args) throws IOException {
		System.out.println("===== [비트연산] =====");
		/* 비트연산 */
		int a = 7;
		int b = 2;
		// & : 비트단위 AND 연산
		System.out.printf("%d & %d = %04d\n", a, b, Integer.parseInt(Integer.toBinaryString(a & b)));
		// | : 비트단위 OR 연산
		System.out.printf("%d | %d = %04d\n", a, b, Integer.parseInt(Integer.toBinaryString(a | b)));
		// ^ : 비트단위 XOR 연산 (같으면 0, 다르면 1)
		System.out.printf("%d ^ %d = %04d\n", a, b, Integer.parseInt(Integer.toBinaryString(a ^ b)));
		// ~ : 단항연산자. 피연산자의 모든 비트를 반전시킴
		System.out.printf("~%d = %s\n", a, Integer.toBinaryString(~a).substring(28));
		// << : 피연산자의 비트 열을 왼쪽으로 이동시킴
		System.out.printf("%d << 2 = %04d\n", a, Integer.parseInt(Integer.toBinaryString(a  << 2 )));
		// >> : 피연산자의 비트 열을 오른쪽으로 이동시킴
		System.out.printf("%d >> 2 = %04d\n", a, Integer.parseInt(Integer.toBinaryString(a  >> 2 )));

		/* 숫자 2진수로 표현하기 */
		System.out.println("===== [숫자 2진수로 표현하기] =====");
		for (int i = -5; i <= 5; i++) {
			System.out.printf("%2d = ", i);
			printBits(i);
			System.out.print("\n");
		}
	}

	private static void printBits(int n) {
		for (int i = 7; i >= 0; i--) {
			if ((n & (1 << i)) > 0) System.out.print("1");
			else System.out.print("0");
		}
	}
}