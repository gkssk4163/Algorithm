package Baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_11650_좌표_정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		PriorityQueue<XY> minHeap = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			minHeap.add(new XY(x, y));
		}

		while (!minHeap.isEmpty()) {
			XY xy = minHeap.poll();
			System.out.println(xy.x + " " + xy.y);
		}
	}
}

class XY implements Comparable<XY> {
	int x;
	int y;

	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(XY other) {
		if (this.x == other.x) return this.y - other.y;
		return this.x - other.x;
	}
}