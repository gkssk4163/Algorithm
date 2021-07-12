package Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class AC {
	List<Integer> num = new LinkedList<>();
	Boolean forward = true;	// 정방향인지		true:정방향/false:역방향

	AC(String num[]) {
		for (int i = 0; i < num.length; i++) {
			try {
				this.num.add(Integer.parseInt(num[i]));
			} catch (NumberFormatException e) {
			}
		}
	}

	public void reverse() {
		if (forward) forward = false;
		else forward = true;
	}

	public void delete() throws IndexOutOfBoundsException {
		if (forward) num.remove(0);
		else num.remove(num.size()-1);
	}

	// 실제 배열을 뒤집은 것이 아니라 forward 정방향인지를 체크하기 때문에
	// 출력할 때 forward=false이면 뒤집은 다음 출력해주어야 함
	public String print() {
		if (!forward) Collections.reverse(num);;
		return num.toString().replaceAll(" ", "");
	}
}

public class Baekjoon_5430_AC {
	static final char REVERSE = 'R';
	static final char DELETE = 'D';

	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		loop:
		for (int t = 0; t < T; t++) {
			// 수행할 함수
			st = new StringTokenizer(br.readLine());
			char[] command = st.nextToken().toCharArray();

			// 배열에 들어 있는 수의 개수
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			// 배열
			st = new StringTokenizer(br.readLine());
			String arrayString = st.nextToken()
					.replace("[", "")
					.replace("]", "");
			String num[] = arrayString.split(",");

			// 클래스 AC 초기화
			AC ac = new AC(num);
			// 함수 실행
			for (int i = 0; i < command.length; i++) {
				if (command[i] == REVERSE) ac.reverse();
				else if (command[i] == DELETE) {
					try {
						ac.delete();
					} catch (IndexOutOfBoundsException e) {
						sb.append("error").append("\n");
						continue loop;
					}
				}
			}
			sb.append(ac.print()).append("\n");
		}
		System.out.print(sb.toString());
	}
}