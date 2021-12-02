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

		calculate(relation, price, parseLinkedHashMap(seller, amount));

		for (int i = 0; i < enroll.length; i++) {
			answer[i] = price.get(enroll[i]);
		}

		return answer;
	}

	private Map<String, LinkedList<Integer>> parseLinkedHashMap(String[] seller, int[] amount) {
		Map<String, LinkedList<Integer>> sellerInfo = new LinkedHashMap<>();
		for (int i = 0; i < seller.length; i++) {
			if (!sellerInfo.containsKey(seller[i])) {
				LinkedList<Integer> amountList = new LinkedList<>();
				amountList.push(amount[i] * 100);
				sellerInfo.put(seller[i], amountList);
			} else {
				sellerInfo.get(seller[i]).push(amount[i] * 100);
			}
		}
		return sellerInfo;
	}

	private void calculate(Map<String, String> relation, Map<String, Integer> price, Map<String, LinkedList<Integer>> sellerInfo) {
		while (!sellerInfo.isEmpty()) {
			Map<String, LinkedList<Integer>> nextSellerInfo = new LinkedHashMap<>();
			sellerInfo.forEach((seller, amountList) -> {
				String referral = relation.get(seller);

				amountList.forEach((amount) -> {
					int fee = amount / 10;
					price.replace(seller, price.get(seller) + amount - fee);

					if (fee == 0) return;
					if (!nextSellerInfo.containsKey(referral)) {
						if (referral.equals("-")) return;

						LinkedList<Integer> fees = new LinkedList<>();
						fees.push(fee);
						nextSellerInfo.put(referral, fees);
					} else {
						nextSellerInfo.get(referral).push(fee);
					}
				});
			});
			sellerInfo = nextSellerInfo;
		}
	}
}