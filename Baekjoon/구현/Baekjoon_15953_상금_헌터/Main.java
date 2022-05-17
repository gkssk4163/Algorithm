package Baekjoon.구현.Baekjoon_15953_상금_헌터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int rank1 = Integer.parseInt(st.nextToken());
			int rank2 = Integer.parseInt(st.nextToken());

			sb.append(getFestival1Reward(rank1) + getFestival2Reward(rank2)).append("\n");
		}

		System.out.println(sb);
	}

	private static int getFestival1Reward(int rank) {
		if (rank == 0) return 0;
		if (rank <= 1) return 5000000;
		if (rank <= 3) return 3000000;
		if (rank <= 6) return 2000000;
		if (rank <= 10) return 500000;
		if (rank <= 15) return 300000;
		if (rank <= 21) return 100000;
		else return 0;
	}

	private static int getFestival2Reward(int rank) {
		if (rank == 0) return 0;
		if (rank <= 1) return 5120000;
		if (rank <= 3) return 2560000;
		if (rank <= 7) return 1280000;
		if (rank <= 15) return 640000;
		if (rank <= 31) return 320000;
		else return 0;
	}
}