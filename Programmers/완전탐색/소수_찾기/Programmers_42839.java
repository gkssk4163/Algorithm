package Programmers.완전탐색.소수_찾기;

import java.util.HashSet;
import java.util.Set;

public class Programmers_42839 {
	public static void main(String[] args) {
		Solution solution = new Solution();

		String numbers = "17";
		System.out.println(solution.solution(numbers));

		String numbers2 = "011";
		System.out.println(solution.solution(numbers2));
	}
}

class Solution {
	final int MAX_NUMBER = 10000000;
	boolean[] isPrime = new boolean[MAX_NUMBER];
	Set<Integer> foundNumber = new HashSet<>();

	public int solution(String numbers) {
		init();
		findPrimeNumber("0", numbers);

		return foundNumber.size();
	}

	private void init() {
		for (int i = 2; i < MAX_NUMBER; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i < MAX_NUMBER; i++) {
			if (!isPrime[i]) continue;

			for (int j = 2; i * j < MAX_NUMBER; j++) {
				isPrime[i * j] = false;
			}
		}

		foundNumber.clear();
	}

	private void findPrimeNumber(String stringNumber, String deck) {
		int number = Integer.parseInt(stringNumber);
		if (isPrime[number]) foundNumber.add(number);

		for (int i = 0; i < deck.length(); i++) {
			findPrimeNumber(
					number + deck.substring(i, i + 1),
					deck.substring(0, i) + deck.substring(i + 1));
		}
	}
}