package Programmers.Greedy.조이스틱;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Programmers_42860 {
	Solution solution = new Solution();

	@Test
	public void 처음부터끝까지이동하는경우() {
		String name = "JEROEN";
		assertEquals(56, solution.solution(name));
	}

	@Test
	public void 방향전환확인() {
		String name = "JAN";
		assertEquals(23, solution.solution(name));
	}

	@Test
	public void 방향전환확인2() {
		String name = "JAZ";
		assertEquals(11, solution.solution(name));
	}

	@Test
	public void 안움직이는경우() {
		String name = "AAA";
		assertEquals(0, solution.solution(name));
	}

	@Test
	public void 방향전환확인3() {
		String name = "ABAAAAAAAAABB";
		assertEquals(7, solution.solution(name));
	}

	@Test
	public void 방향전환확인4() {
		String name = "ABABAAAAAAABB";
		assertEquals(12, solution.solution(name));
	}
}

class Solution {
	final int FORWARD = 1;
	final int REVERSE = 2;
	int NAME_LEN;
	int MIN_MOVE_COUNT;

	public int solution(String name) {
		NAME_LEN = name.length();
		MIN_MOVE_COUNT = Integer.MAX_VALUE;

		if (name.matches("A*")) return 0;
		find(name, 0, FORWARD, name.length(), 0);

		return MIN_MOVE_COUNT;
	}

	private void find(String name, int index, int direction, int end, int moveCount) {
		if (index == end) {
			moveCount -= 1;    // 마지막 움직임 제외
			moveCount -= getLastACount(name, direction, end);	// 마지막 A 개수 제외
			MIN_MOVE_COUNT = moveCount < MIN_MOVE_COUNT ? moveCount : MIN_MOVE_COUNT;
			return;
		}

		if (direction == FORWARD && name.charAt(index) == 'A') {
			find(name, getNextIndex(REVERSE, index), REVERSE, index, moveCount);
		}

		if (direction == FORWARD) {
			find(name, getNextIndex(FORWARD, index), FORWARD, end, moveCount + alphabetChangeAndMove(name, index));
		} else {
			if (index < end) find(name, getNextIndex(REVERSE, index), REVERSE, end, moveCount + 1);	// 이미 알파벳 변경이 끝난 상태이므로 움직임 카운트만 추가
			else find(name, getNextIndex(REVERSE, index), REVERSE, end, moveCount + alphabetChangeAndMove(name, index));
		}
	}

	private int getLastACount(String name, int direction, int end) {
		int aCount = 0;
		if (direction == FORWARD) {
			for (int i = end - 1; i >= 0; i--) {
				if (name.charAt(i) == 'A') aCount++;
				else return aCount;
			}
		} else {
			for (int i = end; i < name.length(); i++) {
				if (name.charAt(i) == 'A') aCount++;
				else return aCount;
			}
		}
		return -1;
	}

	private int getNextIndex(int direction, int index) {
		if (direction == FORWARD) {
			return index + 1;
		} else if (direction == REVERSE) {
			return (index - 1) < 0 ? (index - 1) + NAME_LEN : (index - 1);
		}
		return -1;
	}

	private int alphabetChangeAndMove(String name, int index) {
		char cur = name.charAt(index);
		int move = Math.abs(cur - 'A');
		int minMove = move <= 13 ? move : 26 - move;
		return minMove + 1;
	}
}