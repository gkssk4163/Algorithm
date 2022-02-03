package Baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1259_팰린드롬수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			String strNumber = st.nextToken();
			if (strNumber.equals("0")) break;

			char[] number = strNumber.toCharArray();
			boolean palindrome = true;
			for (int i = 0; i < number.length / 2; i++) {
				if (number[i] != number[number.length-i-1]) {
					palindrome = false;
					break;
				}
			}

			if (palindrome) System.out.println("yes");
			else System.out.println("no");
		}
	}
}