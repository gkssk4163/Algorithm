package Programmers.완전탐색.모의고사;

import java.util.*;

public class Programmers_42840 {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] answers1 = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(solution.solution(answers1)));

		int[] answers2 = {1, 3, 2, 4, 2};
		System.out.println(Arrays.toString(solution.solution(answers2)));
	}
}

class Solution {
	private static final int[][] person = {
			{1, 2, 3, 4, 5, 1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

	public int[] solution(int[] answers) {
		int[] score = new int[person.length];

		for (int i = 0; i < person.length; i++) {
			int[] person_answer = person[i];
			score[i] = getScore(answers, person_answer);

		}

		return getTopScorer(score);
	}

	private int getScore(int[] answers, int[] person_answer) {
		int score = 0;
		for (int j = 0; j < answers.length; j++) {
			if (answers[j] == person_answer[j % person_answer.length]) {
				score++;
			}
		}
		return score;
	}

	private int[] getTopScorer(int[] score) {
		List<Integer> topScorerIndex = new LinkedList<>();

		for (int i = 0; i < score.length; i++) {
			if (!topScorerIndex.isEmpty()) {
				if (score[topScorerIndex.get(0)] > score[i]) continue;
				if (score[topScorerIndex.get(0)] < score[i]) topScorerIndex.clear();
			}

			topScorerIndex.add(i);
		}

		int[] topScorer = new int[topScorerIndex.size()];
		for (int i = 0; i < topScorerIndex.size(); i++) {
			topScorer[i] = topScorerIndex.get(i) + 1;
		}

		return topScorer;
	}
}