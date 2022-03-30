package Baekjoon.수학.Baekjoon_1929_소수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean[] isPrime = new boolean[N+1];
		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= N; i++) {
			if (isPrime[i]) {
				for (int mul = 2; i * mul <= N; mul++) {
					isPrime[i * mul] = false;
				}
			}
		}

		for (int i = M; i <= N; i++) {
			if (isPrime[i]) System.out.println(i);
		}
	}
}