package Baekjoon.탐색.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baekjoon_13706_제곱근 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BigInteger N = new BigInteger(st.nextToken());

		BigInteger num = BigInteger.valueOf(-1);
		BigInteger max = N.divide(BigInteger.valueOf(2));
		BigInteger min = BigInteger.valueOf(1);
		while (min.compareTo(max) < 0) {
			num = min.add(max).divide(BigInteger.valueOf(2));
			BigInteger squared = num.multiply(num);
			if (squared.equals(N)) break;

			if (squared.compareTo(N) < 0) {
				min = num;
			} else {
				max = num;
			}
		}

		System.out.println(num);
	}
}