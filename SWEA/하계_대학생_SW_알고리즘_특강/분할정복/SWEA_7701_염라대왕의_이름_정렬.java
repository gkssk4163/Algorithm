package SWEA.하계_대학생_SW_알고리즘_특강.분할정복;

import java.util.Scanner;

class SWEA_7701_염라대왕의_이름_정렬 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String[] names = new String[N];
			for (int i = 0; i < N; i++) {
				names[i] = sc.next();
			}

			quickSort(names, 0, N - 1);
			// 출력
			System.out.printf("#%d\n", test_case);
			String before = "";
			for (int i = 0; i < N; i++) {
				if (!before.equals(names[i])) {
					System.out.println(names[i]);
				}
				before = names[i];
			}
		}
	}

	private static void quickSort(String[] names, int left, int right) {
		if (left < right) {
			int p = left;
			int i = left + 1;
			int j = right;
			while (i <= j) {
				while (i < names.length) {
					if (compareTo(names[i], names[p]) <= 0) i++;
					else break;
				}
				while (compareTo(names[j], names[p]) > 0) j--;

				if (i < j) {
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
			String temp = names[p];
			names[p] = names[j];
			names[j] = temp;

			quickSort(names, left, j - 1);
			quickSort(names, j + 1, right);
		}
	}

	private static int compareTo(String name, String another) {
		if (name.length() != another.length()) {
			return name.length() - another.length();
		}
		return name.compareTo(another);
	}
}