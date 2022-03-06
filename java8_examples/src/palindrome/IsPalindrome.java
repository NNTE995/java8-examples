package palindrome;

import java.util.stream.IntStream;

public class IsPalindrome {

	public static void main(String[] args) {
		String input1 = "hello there!";
		boolean isPalindrome = isPalindromeIn(input1);
		System.out.println("Is " + input1 + " palindrome? " + isPalindrome);

		String input2 = "abccba";
		isPalindrome = isPalindromeIn(input2);
		System.out.println("Is " + input2 + " palindrome? " + isPalindrome);
	}

	private static boolean isPalindromeIn(String input) {
		return IntStream.range(0, input.length() / 2)
				.noneMatch(index -> input.charAt(index) != input.charAt(input.length() - index - 1));
	}
}