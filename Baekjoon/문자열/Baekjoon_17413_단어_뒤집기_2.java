package Baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Baekjoon_17413_단어_뒤집기_2 {
	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();

		// 태그와 문자열 구분해서 추출
		Pattern pattern = Pattern.compile("<+[a-z ]+>|[a-z0-9 ]{1,}");
		Matcher matcher = pattern.matcher(S);
		while (matcher.find()) {
			String str = matcher.group();
			if (str.contains("<")) {	// 태그일 경우 그냥 출력 ("<"가 있으면 ">"도 있는거라 1개만 체크함)
				sb.append(str);
			} else {	// 문자열일 경우 띄어쓰기 기준으로 뒤집어서 출력
				String[] substr = str.split(" ");
				for (int i = 0; i < substr.length; i++) {
					sb.append(new StringBuffer(substr[i]).reverse().toString());
					if (i < substr.length-1) sb.append(" ");
				}
			}
		}
		System.out.println(sb.toString());
	}
}