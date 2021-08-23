package SWEA.하계_대학생_SW_알고리즘_특강.Tree;

import java.util.Scanner;

class SWEA_1231_중위순회 {
	static class Node {
		char data;
		int left;
		int right;

		Node(char data, int left, int right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int vertexCnt = sc.nextInt();
			sc.nextLine();

			// 입력된 정보로 트리만들기
			Node[] tree = new Node[vertexCnt + 1];
			for (int i = 1; i <= vertexCnt; i++) {
				String line = sc.nextLine();
				String[] info = line.split(" ");
				char data = info[1].charAt(0);
				int left = info.length >= 3 ? Integer.parseInt(info[2]) : -1;
				int right = info.length >= 4 ? Integer.parseInt(info[3]) : -1;
				Node node = new Node(data, left, right);
				tree[i] = node;
			}

			// 트리 중위순회로 조회
			String result = trace(tree, 1);

			System.out.printf("#%d %s\n", test_case, result);
		}
	}

	private static String trace(Node[] tree, int i) {
		Node node = tree[i];
		String result = "";
		if (node.left != -1) result += trace(tree, node.left);
		result += node.data;
		if (node.right != -1) result += trace(tree, node.right);
		return result;
	}
}