package SWEA.하계_대학생_SW_알고리즘_특강.Trie;

import java.util.Scanner;

class SWEA_1256_K번째_접미어 {
	static class Trie {
		int count;
		Trie[] tries;

		Trie() {
			count = 0;
			this.tries = new Trie[26];
		}

		void add(String word) {
			if (word.length() > 0) {
				int index = word.charAt(0) - 'a';
				if (tries[index] == null) tries[index] = new Trie();
				tries[index].count++;
				tries[index].add(word.substring(1));
			}
		}

		String search(int K) {
			int childSum = 0;
			for (int i = 0; i < 26; i++) {
				int childCnt = tries[i] == null ? 0 : tries[i].count;
				if (childSum < K && K <= (childSum + childCnt)) {
					if (childCnt == 1) {
						return (char) (i + 'a') + tries[i].getFirst();
					} else {
						return (char) (i + 'a') + tries[i].search(K - childSum);
					}
				}
				childSum += childCnt;
			}
			return "none";
		}

		String getFirst() {
			for (int i = 0; i < 26; i++) {
				if (tries[i] != null) return (char) (i + 'a') + tries[i].getFirst();
			}
			return "";
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int K = sc.nextInt();
			String str = sc.next();

			Trie root = new Trie();
			for (int i = 0; i < str.length(); i++) {
				root.add(str.substring(i));
			}

			String result = root.search(K);
			System.out.printf("#%d %s\n", test_case, result);
		}
	}
}