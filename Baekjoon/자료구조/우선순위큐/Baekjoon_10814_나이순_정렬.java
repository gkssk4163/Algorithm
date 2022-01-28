package Baekjoon.자료구조.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_10814_나이순_정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		PriorityQueue<Person> people = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			people.offer(new Person(i, age, name));
		}

		while (!people.isEmpty()) {
			Person person = people.poll();
			System.out.printf("%d %s\n", person.age, person.name);
		}
	}

	static class Person implements Comparable<Person> {
		int no;
		int age;
		String name;

		public Person(int no, int age, String name) {
			this.no = no;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person other) {
			if (this.age == other.age) return this.no - other.no;
			return this.age - other.age;
		}
	}
}