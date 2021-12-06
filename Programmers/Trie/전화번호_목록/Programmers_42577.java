package Programmers.Trie.전화번호_목록;

public class Programmers_42577 {
	public static void main(String args[]) throws Exception {
		Solution solution = new Solution();

		String[] phone_book1 = {"119", "97674223", "1195524421"};
		System.out.println(solution.solution(phone_book1));

		String[] phone_book2 = {"123","456","789"};
		System.out.println(solution.solution(phone_book2));

		String[] phone_book3 = {"12","123","1235","567","88"};
		System.out.println(solution.solution(phone_book3));

		String[] phone_book4 = {"1195524421","97674223","119"};
		System.out.println(solution.solution(phone_book4));
	}
}

class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;

		Trie root = new Trie();

		for (String phoneNumber : phone_book) {
			root.addPhoneNumber(phoneNumber);
		}

		for (String phoneNumber : phone_book) {
			if (root.findPrefix(phoneNumber)) return false;
		}

		return answer;
	}

	class Trie {
		Trie[] next;
		boolean prefix;

		public Trie() {
			this.next = new Trie[10];
			this.prefix = false;
		}

		public void addPhoneNumber(String phoneNumber) {
			if (phoneNumber.length() == 0) {
				prefix = true;
				return;
			}

			int number = phoneNumber.charAt(0) - '0';
			if (next[number] == null) {
				next[number] = new Trie();
			}
			next[number].addPhoneNumber(phoneNumber.substring(1));
		}

		public boolean findPrefix(String phoneNumber) {
			if (phoneNumber.length() == 0) return false;
			if (this.prefix) return true;
			int number = phoneNumber.charAt(0) - '0';
			return next[number].findPrefix(phoneNumber.substring(1));
		}
	}
}
