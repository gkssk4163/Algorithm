package Baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2696_중앙값_구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());	// 테스트케이스

		for (int i = 0; i < T; i++) {
			List<Integer> median = new LinkedList<>();	// 중앙값 저장할 List
			int M = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());	// 수열의 크기
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>();	// 최대힙 (중앙값보다 작거나 같은 값 저장)
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();	// 최소힙 (중앙값보다 큰 값 저장)

			for (int j = 1; j <= M; j++) {
				// 10개씩 끊어서 숫자 읽어오기
				if (j % 10 == 1) st = new StringTokenizer(br.readLine());

				int num = Integer.parseInt(st.nextToken());
				if (j == 1) maxHeap.offer(num * -1);	// 처음 숫자는 maxHeap에 저장
				else if (minHeap.size() == 0) maxHeap.offer(num * -1);
				else {
					if (num < minHeap.peek()) {
						maxHeap.offer(num * -1);
					} else {
						minHeap.offer(num);
					}
				}

				// maxHeap에는 최소값~중앙값까지를 저장하고 minHeap에는 중앙값 이상부터 최대값까지 저장하므로
				// maxHeap 사이즈는 minHeap 사이즈보다 1만큼 크거나 같아야 함
				if (maxHeap.size() - minHeap.size() == 2) {	// maxHeap - minHeap 이 2가 되면
					minHeap.offer(maxHeap.poll() * -1);	// maxHeap의 peek를 minHeap으로 옮겨줌
				} else if (minHeap.size() - maxHeap.size() == 1) {	// minHeap - maxHeap 이 1이 되면
					maxHeap.offer(minHeap.poll() * -1);			// minHeap의 peek를 maxHeap으로 옮겨줌
				}

//				System.out.println("[min]: " + minHeap.toString());
//				System.out.println("[max]: " + maxHeap.toString());
				if (j % 2 == 1) median.add(maxHeap.peek() * -1);
			}
			for (int idx = 0; idx < median.size(); idx++) {
				if (idx == 0) {	// 중앙값 개수 출력
					System.out.println(median.size());
				} else if (idx % 10 == 0) {	// 10개씩 끊어서 출력
					System.out.println();
				}
				System.out.print(median.get(idx) + " ");	// 중앙값 출력
			}
			System.out.println();
		}
	}
}
