package printEveryThirdVowel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintVowels2 {
	
	public static void main(String[] args){
		findThirdPositionVowel();
	}
	
	private static void findThirdPositionVowel(){
		//String word = "happy new year 2022!";
		String word = "noe nicolas torres escobar";
		List<Character> chars = IntStream.iterate(2, num -> num < word.length(), num -> num+3).boxed()
				.filter(index -> {
					System.out.println("Char at every third index: " + word.charAt(index));
					return word.charAt(index) == ('a' | 'e' | 'i' | 'o' | 'u');
				})
				.peek(i -> System.out.println("here "+i))
				.map(index -> {
					System.out.println("----" + word.charAt(index));
					return word.charAt(index);
				})
				.collect(Collectors.toList());

		System.out.println(chars);
		}
}