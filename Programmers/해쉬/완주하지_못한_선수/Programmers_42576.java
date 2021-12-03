package Programmers.해쉬.완주하지_못한_선수;

import java.util.HashMap;
import java.util.Map;

public class Programmers_42576 {
	public static void main(String args[]) throws Exception {
		Solution solution = new Solution();
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println(solution.solution(participant, completion));
	}
}

class Solution {
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> athlete = new HashMap<>();
		for (String name : participant) {
			athlete.put(name, athlete.getOrDefault(name, 0) + 1);
			/*
			if (athlete.containsKey(name)) {
				athlete.replace(name, athlete.get(name) + 1);
				continue;
			}

			athlete.put(name, 1);
			*/
		}

		for (String name : completion) {
			int cnt = athlete.get(name);
			if (cnt != 1) {
				athlete.replace(name, cnt - 1);
				continue;
			}

			athlete.remove(name);
		}

		return athlete.keySet().toString()
				.replace("[", "")
				.replace("]", "");
	}
}