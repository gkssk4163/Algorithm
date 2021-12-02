package Programmers.Dev_Matching_2021_웹_백엔드_개발자_상반기.다단계_칫솔_판매;

import java.io.IOException;
import java.util.*;

public class Programmers_77486 {
	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();

		String[] enroll1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller1 = {"young", "john", "tod", "emily", "mary"};
		int[] amount1 = {12, 4, 2, 5, 10};
		System.out.println(Arrays.toString(solution.solution(enroll1, referral1, seller1, amount1)));

		String[] enroll2 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral2 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller2 = {"sam", "emily", "jaimie", "edward"};
		int[] amount2 = {2, 3, 5, 4};
		System.out.println(Arrays.toString(solution.solution(enroll2, referral2, seller2, amount2)));

		String[] enroll3 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral3 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller3 = {"sam", "sam", "jaimie", "jaimie"};
		int[] amount3 = {2, 3, 5, 4};
		System.out.println(Arrays.toString(solution.solution(enroll3, referral3, seller3, amount3)));
	}
}

class Solution {
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];

		Map<String, String> relation = new HashMap<>();
		Map<String, Integer> price = new HashMap<>();

		for (int i = 0; i < enroll.length; i++) {
			relation.put(enroll[i], referral[i]);
			price.put(enroll[i], 0);
		}

		for (int i = 0; i < seller.length; i++) {
			calculate(relation, price, seller[i], amount[i] * 100);
		}

		for (int i = 0; i < enroll.length; i++) {
			answer[i] = price.get(enroll[i]);
		}

		return answer;
	}

	private void calculate(Map<String, String> relation, Map<String, Integer> price, String seller, int amount) {
		while (relation.containsKey(seller) && amount != 0) {
			int sellerAmount = (int) Math.ceil(amount * 0.9);
			price.replace(seller, price.get(seller) + sellerAmount);

			seller = relation.get(seller);
			amount -= sellerAmount;
		}
	}
}