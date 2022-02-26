package Baekjoon.수학.Baekjoon_1978_소수_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		boolean[] isPrime = new boolean[1001];
		for (int i = 2; i <= 1000; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i <= 1000; i++) {
			if (isPrime[i]) {
				for (int j = 2; i * j <= 1000; j++) {
					isPrime[i * j] = false;
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int prime = 0;
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			if (isPrime[number]) prime++;
		}
		System.out.println(prime);
	}
}