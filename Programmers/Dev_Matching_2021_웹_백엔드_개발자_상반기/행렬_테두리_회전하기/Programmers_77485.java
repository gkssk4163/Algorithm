package Programmers.Dev_Matching_2021_웹_백엔드_개발자_상반기.행렬_테두리_회전하기;

import java.io.IOException;
import java.util.Arrays;

class Programmers_77485 {
	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();

		int rows1 = 6;
		int columns1 = 6;
		int[][] queries1 = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
		System.out.println(Arrays.toString(solution.solution(rows1, columns1, queries1)));

		int rows2 = 3;
		int columns2 = 3;
		int[][] queries2 = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		System.out.println(Arrays.toString(solution.solution(rows2, columns2, queries2)));

		int rows3 = 100;
		int columns3 = 97;
		int[][] queries3 = {{1,1,100,97}};
		System.out.println(Arrays.toString(solution.solution(rows3, columns3, queries3)));
	}
}

class Solution {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];

		int[][] matrix = new int[rows + 1][columns + 1];
		initMatrix(rows, columns, matrix);

		for (int i = 0; i < queries.length; i++) {
			answer[i] = spinMatrix(matrix, queries[i]);
		}

		return answer;
	}

	private void initMatrix(int rows, int columns, int[][] matrix) {
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				matrix[i][j] = (i - 1) * columns + j;
			}
		}
	}

	static int[][] dr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private int spinMatrix(int[][] matrix, int[] query) {
		int x1 = query[0];
		int y1 = query[1];
		int x2 = query[2];
		int y2 = query[3];

		int x = x1;
		int y = y1;
		int direction = 0;
		int curNum = matrix[x][y];
		int min = 10000;
		do {
			// 최소값 판별
			if (min > curNum) min = curNum;

			// 다음 좌표 설정
			if (isEdge(x, y, x1, y1, x2, y2)) direction++;
			x += dr[direction][0];
			y += dr[direction][1];
			int temp = matrix[x][y];
			matrix[x][y] = curNum;
			curNum = temp;
		} while (!(x == x1 && y == y1));

		return min;
	}

	private boolean isEdge(int x, int y, int x1, int y1, int x2, int y2) {
		return /*(x == x1 && y == y1) ||*/ (x == x1 && y == y2)
				|| (x == x2 && y == y2) || (x == x2 && y == y1);
	}
}