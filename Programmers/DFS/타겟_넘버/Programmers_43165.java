package Programmers.DFS.타겟_넘버;

public class Programmers_43165 {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution.solution(numbers, target));
	}
}

class Solution {
	public int solution(int[] numbers, int target) {
		return DFS(numbers, 0, 0, target);
	}

	private int DFS(int[] numbers, int index, int sum, int target) {
		if (index == numbers.length) {
			if (sum == target) return 1;
			else return 0;
		}
		return DFS(numbers, index + 1, sum + numbers[index], target)
				+ DFS(numbers, index + 1, sum - numbers[index], target);
	}
}