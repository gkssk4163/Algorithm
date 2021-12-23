package Programmers.DFS.단어_변환;

public class Programmers_43163 {

	public static void main(String args[]) {
		Solution solution = new Solution();

		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution.solution(begin, target, words));

		String begin2 = "hit";
		String target2 = "cog";
		String[] words2 = {"hot", "dot", "dog", "lot", "log"};
		System.out.println(solution.solution(begin2, target2, words2));
	}
}

class Solution {
	int MIN = Integer.MAX_VALUE;

	public int solution(String begin, String target, String[] words) {
		if (!isContains(words, target)) return 0;

		boolean[] use = new boolean[words.length];
		DFS(begin, target, words, use, 1);

		return MIN;
	}

	private void DFS(String begin, String target, String[] words, boolean[] use, int count) {
		for (int i = 0; i < words.length; i++) {
			if (use[i]) continue;

			if (oneLetterDifferent(begin, words[i])) {
				if (words[i].equals(target)) {
					MIN = count < MIN ? count : MIN;
					return;
				}

				DFS(words[i], target, words, copy(use, i), count + 1);
			}
		}
	}

	private boolean isContains(String[] words, String word) {
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word)) return true;
		}
		return false;
	}

	private boolean oneLetterDifferent(String begin, String word) {
		int match = 0;
		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) == word.charAt(i)) match++;
		}
		return match == begin.length() - 1;
	}

	private boolean[] copy(boolean[] use, int used) {
		boolean[] copy = new boolean[use.length];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = use[i];
		}
		copy[used] = true;
		return copy;
	}

}