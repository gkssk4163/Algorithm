package Baekjoon.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11050_이항_계수_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int num = 1;
		for (int i = 0; i < K; i++) {
			num *= N - i;
		}
		for (int i = 0; i < K; i++) {
			num /= K - i;
		}

		System.out.println(num);
	}
}