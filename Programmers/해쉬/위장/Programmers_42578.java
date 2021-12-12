package Programmers.해쉬.위장;

import java.util.HashMap;
import java.util.Map;

public class Programmers_42578 {

	public static void main(String args[]) {
		Solution solution = new Solution();

		String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution.solution(clothes1));

		String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution.solution(clothes2));
	}
}

class Solution {
	public int solution(String[][] clothes) {
		Map<String, Integer> clothesCount = new HashMap<>();

		for (String[] cloth : clothes) {
			String clothType = cloth[1];
			clothesCount.put(clothType, clothesCount.getOrDefault(clothType, 0) + 1);
		}

		return getClothesCombination(clothesCount);
	}

	private int getClothesCombination(Map<String, Integer> clothesCount) {
		int combination = 1;
		for (Integer count : clothesCount.values()) {
			combination *= count + 1;
		}
		return combination - 1;
	}
}