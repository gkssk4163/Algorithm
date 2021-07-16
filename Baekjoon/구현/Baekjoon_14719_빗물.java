package Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14719_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int height = Integer.parseInt(st.nextToken());	// 높이
		int width = Integer.parseInt(st.nextToken());	// 너비
		int[][] map = new int[height][width];

		// 블록 입력받기
		int index = 0;
		st = new StringTokenizer(br.readLine());
		for (int col = 0; col < width; col++) {
			int blockCount = Integer.parseInt(st.nextToken());
			for (int row = height-1; row > height-blockCount-1; row--) {
				map[row][col] = 1;	// 블록 있는 부분 1로 표시
			}
		}

		// 전체 블록 탐색
		int rainAmount = 0;
		for (int row = 0; row < height; row++) {
			int prevCol = -1;
			for (int col = 0; col < width; col++) {
				if (map[row][col] == 1) {
					if (prevCol == -1) {	// 블록을 만났는데 이전 블록이 없으면
						prevCol = col;		// 현재 위치를 이전 블록으로 설정
					} else {	// 블록을 만났는데 이전 블록이 있으면
						rainAmount += col - prevCol - 1;	// 빗물양 누적
						prevCol = col;						// 현재 위치를 이전 블록으로 설정
					}
				}
			}
		}
		System.out.println(rainAmount);
	}
}