package Baekjoon.구현.Baekjoon_11723_집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		boolean[] exist = new boolean[21];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int number;
			switch (command) {
				case "add":
					number = Integer.parseInt(st.nextToken());
					exist[number] = true;
					break;
				case "remove":
					number = Integer.parseInt(st.nextToken());
					exist[number] = false;
					break;
				case "check":
					number = Integer.parseInt(st.nextToken());
					if (exist[number]) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				case "toggle":
					number = Integer.parseInt(st.nextToken());
					exist[number] = !exist[number];
					break;
				case "all":
					for (int n = 1; n <= 20; n++) {
						exist[n] = true;
					}
					break;
				case "empty":
					for (int n = 1; n <= 20; n++) {
						exist[n] = false;
					}
					break;
			}
		}
		System.out.println(sb);
	}
}