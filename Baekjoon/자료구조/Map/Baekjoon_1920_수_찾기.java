package Baekjoon.자료구조.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon_1920_수_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Map<Integer, Boolean> isExist = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			isExist.put(number, true);
		}

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			if (isExist.containsKey(number)) System.out.println(1);
			else System.out.println(0);
		}
	}
}