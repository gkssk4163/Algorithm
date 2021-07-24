package SWEA.하계_대학생_SW_알고리즘_특강.연결리스트;

import java.util.Scanner;

class Cryptograph {
	int data;
	Cryptograph next;

	Cryptograph(int data) {
		this.data = data;
		this.next = null;
	}
}

class SWEA_1230_암호문3
{
	static final char INSERT = 'I';
	static final char DELETE = 'D';
	static final char APPEND = 'A';

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = sc.nextInt();	// 원본 암호문 길이

			// 헤드 초기화 및 암호문 입력받기
			Cryptograph head = new Cryptograph(-1);
			Cryptograph current = head;
			for (int i = 0; i < N; i++) {
				current.next = new Cryptograph(sc.nextInt());
				current = current.next;
			}

			int C = sc.nextInt();	// 명령어 개수
			// 명령어 실행
			for (int i = 0; i < C; i++) {
				char command = sc.next().charAt(0);
				int pos = -1;
				int cnt = -1;
				current = head;
				switch (command) {
					case INSERT:
						pos = sc.nextInt();
						cnt = sc.nextInt();
						for (int j = 0; j < pos; j++) {
							current = current.next;
						}
						for (int j = 0; j < cnt; j++) {
							Cryptograph crypt = new Cryptograph(sc.nextInt());
							crypt.next = current.next;
							current.next = crypt;
							current = current.next;
						}
						break;
					case DELETE:
						pos = sc.nextInt();
						cnt = sc.nextInt();
						for (int j = 0; j < pos; j++) {
							current = current.next;
						}
						for (int j = 0; j < cnt; j++) {
							current.next = current.next.next;
						}
						break;
					case APPEND:
						cnt = sc.nextInt();
						while (current.next != null) {
							current = current.next;
						}
						for (int j = 0; j < cnt; j++) {
							Cryptograph crypt = new Cryptograph(sc.nextInt());
							crypt.next = current.next;
							current.next = crypt;
							current = current.next;
						}
						break;
				}
			}

			System.out.printf("#%d ", test_case);
			current = head.next;
			for (int i = 0; i < 10; i++) {
				System.out.printf("%d ", current.data);
				current = current.next;
			}
			System.out.println();
		}
	}
}