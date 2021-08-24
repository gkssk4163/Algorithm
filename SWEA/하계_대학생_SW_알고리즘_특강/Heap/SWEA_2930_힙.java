package SWEA.하계_대학생_SW_알고리즘_특강.Heap;

import java.util.Scanner;

class SWEA_2930_힙 {
	private static final int ADD = 1;
	private static final int DELETE = 2;
	private static final int NONE = -1;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuffer sb = new StringBuffer();
			int N = sc.nextInt();	// 수행할 연산의 개수
			int maxHeapCnt = 0;		// maxHeap 노드 수
			int[] maxHeap = new int[N+1];	// maxHeap

			// maxHeap 초기화
			init(maxHeap);

			// 연산 수행
			for (int i = 0; i < N; i++) {
				int command = sc.nextInt();
				if (command == ADD) {
					// maxHeap에 노드 추가 후 정렬
					int num = sc.nextInt();
					maxHeap[++maxHeapCnt] = num;
					heapSortAfterAdd(maxHeap, maxHeapCnt);
				} else if (command == DELETE) {
					// root 노드 삭제 목록에 추가
					sb.append(maxHeap[1]).append(" ");
					// maxHeap root 노드 삭제 후 정렬
					if (maxHeapCnt > 0) {
						maxHeap[1] = maxHeap[maxHeapCnt];
						maxHeap[maxHeapCnt] = NONE;
						heapSortAfterDelete(maxHeap, 1);
						maxHeapCnt--;
					}
				}
			}
			System.out.printf("#%d %s\n", test_case, sb.toString());
		}
	}

	private static void init(int[] maxHeap) {
		for (int i = 0; i < maxHeap.length; i++) {
			maxHeap[i] = NONE;
		}
	}

	public static void heapSortAfterAdd(int[] maxHeap, int child) {
		if (child == 1) return;

		int parent = child / 2;
		if (maxHeap[parent] < maxHeap[child]) {
			swap(maxHeap, parent, child);
			heapSortAfterAdd(maxHeap, parent);
		}
	}

	public static void heapSortAfterDelete(int[] maxHeap, int parent) {
		if (parent != 1 && maxHeap[parent] == NONE) return;

		int leftChild = parent * 2;
		int rightChild = (parent * 2) + 1;
		try {
			int next = maxHeap[leftChild] > maxHeap[rightChild] ? leftChild : rightChild;
			if (maxHeap[next] > maxHeap[parent]) {
				swap(maxHeap, parent, next);
				heapSortAfterDelete(maxHeap, next);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}

	}

	private static void swap(int[] maxHeap, int index1, int index2) {
		int temp = maxHeap[index1];
		maxHeap[index1] = maxHeap[index2];
		maxHeap[index2] = temp;
	}
}