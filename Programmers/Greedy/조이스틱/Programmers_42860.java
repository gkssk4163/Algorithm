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

		String name4 = "AAA";
		System.out.println(solution.solution(name4));

		String name5 = "ABAAAAAAAAABB";
		System.out.println(solution.solution(name5));	// 7 : 실패
	}
}

class Solution {
	public int solution(String name) {
		int answer = 0;

		// 이름변경할 방향설정
		int frontACount = 0;
		int backACount = 0;

		for (int i = 1; i <= Math.floor((name.length() - 1) / 2); i++) {
			if (name.charAt(i) != 'A') break;
			frontACount++;
		}

		for (int i = (int) Math.ceil((double) name.length() / 2); i < name.length(); i++) {
			if (name.charAt(i) != 'A') break;
			backACount++;
		}

		boolean forward = frontACount <= backACount;

		// 이름변경
		final int MOVE = 1;
		int lastACount = 0;
		if (forward) {
			answer += getAlphabetChangeCount(name, 0)  + MOVE;
			for (int i = 1; i < name.length(); i++) {
				answer += getAlphabetChangeCount(name, i);
				if (i != name.length() - 1) answer += MOVE;

				char cur = name.charAt(i);
				if (cur == 'A') lastACount++;
				else lastACount = 0;
			}
		} else {
			answer += getAlphabetChangeCount(name, 0)  + MOVE;
			for (int i = name.length() - 1; i > 0; i--) {
				answer += getAlphabetChangeCount(name, i);
				if (i != name.length() - 1) answer += 1;

				char cur = name.charAt(i);
				if (cur == 'A') lastACount++;
				else lastACount = 0;
			}
		}

		return answer - lastACount;
	}

	private int getAlphabetChangeCount(String name, int index) {
		char cur = name.charAt(index);
		int move = Math.abs(cur - 'A');
		return move <= 13 ? move : 26 - move;
	}
}