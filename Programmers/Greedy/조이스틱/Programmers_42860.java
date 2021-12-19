package Programmers.Greedy.조이스틱;

public class Programmers_42860 {
	public static void main(String[] args) {
		Solution solution = new Solution();

		String name = "JEROEN";
		System.out.println(solution.solution(name));

		String name2 = "JAN";
		System.out.println(solution.solution(name2));

		String name3 = "JAZ";
		System.out.println(solution.solution(name3));
	}
}

class Solution {
	public int solution(String name) {
		int answer = 0;

		for (int i = 0; i < name.length(); i++) {
			char cur = name.charAt(i);
			int move = Math.abs(cur - 'A');
			int minMove = move <= 13 ? move : 26 - move;
			answer += minMove;
			if (i != name.length() - 1) answer += 1;
		}

		return answer;
	}
}