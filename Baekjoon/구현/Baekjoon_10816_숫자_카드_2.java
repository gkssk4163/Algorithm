package Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10816_숫자_카드_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] plus = new int[10000001];
		int[] minus = new int[10000001];

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num >= 0) plus[num]++;
			else minus[num * -1]++;
		}

		StringBuffer sb = new StringBuffer();
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num >= 0) sb.append(plus[num]).append(" ");
			else sb.append(minus[num * -1]).append(" ");
		}

		System.out.println(sb);
	}
}