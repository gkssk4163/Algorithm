package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_12026_BOJ거리 {
	final static int IMPOSSIBLE = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		char[] blocks = st.nextToken().toCharArray();

		int[] index = new int[]{0, 0, 0};

		int[] dp = new int[blocks.length];
		for (int i = 1; i < blocks.length; i++) {
			BOJ now = BOJ.valueOf(String.valueOf(blocks[i]));
			BOJ prev = now.prev();
			BOJ next = now.next();

			int minIndex = index[prev.ordinal()];
			int minEnergy = IMPOSSIBLE;
			for (int j = index[next.ordinal()]; j < i; j++) {
				if (blocks[j] == prev.toChar()) {
					if (dp[j] == IMPOSSIBLE) continue;
					int energy = dp[j] + (i - j) * (i - j);
					if (minEnergy == IMPOSSIBLE || energy < minEnergy) {
						minEnergy = energy;
						minIndex = j;
					}
				}
			}
			index[prev.ordinal()] = minIndex;
			dp[i] = minEnergy;
		}

		System.out.print(dp[blocks.length - 1] == IMPOSSIBLE ? -1 : dp[blocks.length - 1]);
	}

	enum BOJ {
		B, O, J;

		public char toChar() {
			return this.toString().charAt(0);
		}

		public BOJ prev() {
			if (this == B) return J;
			if (this == O) return B;
			if (this == J) return O;
			throw new IllegalArgumentException();
		}

		public BOJ next() {
			if (this == B) return O;
			if (this == O) return J;
			if (this == J) return B;
			throw new IllegalArgumentException();
		}
	}
}