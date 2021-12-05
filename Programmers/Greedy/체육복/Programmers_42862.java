package Programmers.Greedy.체육복;

public class Programmers_42862 {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int n1 = 5;
		int[] lost1 = {2, 4};
		int[] reserve1 = {1, 3, 5};
		System.out.println(solution.solution(n1, lost1, reserve1));

		int n2 = 5;
		int[] lost2 = {2, 4};
		int[] reserve2 = {3};
		System.out.println(solution.solution(n2, lost2, reserve2));

		int n3 = 3;
		int[] lost3 = {3};
		int[] reserve3 = {1};
		System.out.println(solution.solution(n3, lost3, reserve3));
	}
}

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		Student[] student = new Student[n + 1];
		for (int i = 1; i <= n; i++) {
			student[i] = new Student();
		}

		for (int i = 0; i < lost.length; i++) {
			student[lost[i]].lost();
		}

		for (int i = 0; i < reserve.length; i++) {
			student[reserve[i]].reserve();
		}

		for (int i = 1; i <= n; i++) {
			if (!student[i].haveGymSuit) {
				if ((i - 1) >= 1 && student[i - 1].haveSpare) {
					student[i].borrowFrom(student[i - 1]);
				} else if ((i + 1) <= n && student[i + 1].haveSpare) {
					student[i].borrowFrom(student[i + 1]);
				}
			}
			answer += student[i].haveGymSuit ? 1 : 0;
		}

		return answer;
	}

	class Student {
		boolean haveGymSuit;
		boolean haveSpare;

		public Student() {
			this.haveGymSuit = true;
			this.haveSpare = false;
		}

		public void lost() {
			this.haveGymSuit = false;
		}

		public void reserve() {
			if (!this.haveGymSuit) this.haveGymSuit = true;
			else this.haveSpare = true;
		}

		public void borrowFrom(Student friend) {
			if (friend.haveSpare) {
				friend.haveSpare = false;
				this.haveGymSuit = true;
			}
		}
	}
}