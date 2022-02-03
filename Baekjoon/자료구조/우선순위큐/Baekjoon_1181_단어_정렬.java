package Baekjoon.자료구조.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1181_단어_정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		PriorityQueue<Word> minHeap = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Word newWord = new Word(st.nextToken());
			if (!minHeap.contains(newWord)) minHeap.add(newWord);
		}

		while (!minHeap.isEmpty()) {
			System.out.println(minHeap.poll().string);
		}
	}

	static class Word implements Comparable<Word> {
		String string;

		Word(String string) {
			this.string = string;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Word word = (Word) o;
			return Objects.equals(string, word.string);
		}

		@Override
		public int hashCode() {
			return Objects.hash(string);
		}

		@Override
		public int compareTo(Word other) {
			if (this.string.length() == other.string.length()) return this.string.compareTo(other.string);
			return this.string.length() - other.string.length();
		}
	}
}