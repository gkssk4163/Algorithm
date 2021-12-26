package Programmers.Queue.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_42583 {
	public static void main(String args[]) throws Exception {
		Solution solution = new Solution();

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		System.out.println(solution.solution(bridge_length, weight, truck_weights));

		int bridge_length2 = 100;
		int weight2 = 100;
		int[] truck_weights2 = {10};
		System.out.println(solution.solution(bridge_length2, weight2, truck_weights2));

		int bridge_length3 = 100;
		int weight3 = 100;
		int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};
		System.out.println(solution.solution(bridge_length3, weight3, truck_weights3));
	}
}

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		Queue<Integer> truckWeightsOnBridge = new LinkedList<>();

		for (int i = 0; i < bridge_length; i++) {
			truckWeightsOnBridge.offer(0);
		}

		for (int i = 0; i < truck_weights.length; i++) {
			// 트럭 한 칸 이동
			truckWeightsOnBridge.poll();

			// 트럭 추가 (최대 무게 초과되면 올리지 않음. 무게 0으로 설정)
			int truck_weight = truck_weights[i];
			if (totalWeight(truckWeightsOnBridge) + truck_weight <= weight) {
				truckWeightsOnBridge.offer(truck_weight);
			} else {
				truckWeightsOnBridge.offer(0);
				i--;
			}
			answer++;
		}

		return answer + bridge_length;
	}

	private int totalWeight(Queue<Integer> truck_weights) {
		int total_truck_weight = 0;
		for (int truck_weight : truck_weights) {
			total_truck_weight += truck_weight;
		}
		return total_truck_weight;
	}
}