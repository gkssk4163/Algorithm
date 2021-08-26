package SWEA.하계_대학생_SW_알고리즘_특강.Hash;

import java.util.Scanner;

class SWEA_2948_문자열_교집합 {
	private static int HASH_TABLE_SIZE;

	static class Node {
		String value;
		Node next;

		Node(String value) {
			this.value = value;
			this.next = null;
		}

		void add(String str) {
			Node newNode = new Node(str);
			if (next != null) newNode.next = next;
			next = newNode;
		}

		public boolean contain(String str) {
			Node cur = next;
			while (cur != null) {
				if (cur.value.equals(str)) return true;
				cur = cur.next;
			}
			return false;
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int count = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int MAX = N > M ? N : M;

			HASH_TABLE_SIZE = 2 * MAX;
			Node[] hashTable = new Node[HASH_TABLE_SIZE];
			initHashTable(hashTable);

			// 문자열 hashTable 에 저장
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				int key = getHash(str);
				hashTable[key].add(str);
			}

			// 문자열 hashTable 에 있는지 체크
			for (int i = 0; i < M; i++) {
				String str = sc.next();
				int key = getHash(str);
				if (hashTable[key].contain(str)) {
					count++;
				}
			}
			System.out.printf("#%d %d\n", test_case, count);
		}
	}

	private static void initHashTable(Node[] hashTable) {
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new Node("");
		}
	}

	public static int getHash(String str) {
		int hash = 0;
		for (int i = 0; i < str.length(); i++) {
			hash = (((hash << 5) + hash) + (str.charAt(i) - 'a' + 1)) % HASH_TABLE_SIZE;
		}
		return hash % HASH_TABLE_SIZE;
	}
}