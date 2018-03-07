package HashTable;

import java.util.HashMap;

/**
 * Created by jianmei on 6/13/16.
 */
public class BullsandCows {
	public String getHint1(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		HashMap<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) bulls++;
			else {
				if (!map.containsKey(secret.charAt(i))) {
					map.put(secret.charAt(i), 1);
				} else {
					if (map.get(secret.charAt(i)) < 0) {
						cows++;
					}
					map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
				}
				if (!map.containsKey(guess.charAt(i))) {
					map.put(guess.charAt(i), -1);
				} else {
					if (map.get(guess.charAt(i)) > 0) {
						cows++;
					}
					map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
				}
			}
			}
		return bulls + "A" + cows + "B";
		}


	public String getHint2(String secret, String guess) {// Not using Hashing
		int bulls = 0;
		int cows = 0;
		int[] numbers = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) bulls++;
			else {
				if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
				if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
			}
		}
		return bulls + "A" + cows + "B";
	}

	public static void main(String[] argu) {
		BullsandCows test = new BullsandCows();
		System.out.println(test.getHint1("1807","7810"));
		System.out.println(test.getHint1("1123","0111"));
		System.out.println(test.getHint1("2233","3322"));
	}

}
