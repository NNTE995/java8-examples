package printEveryThirdVowel;

public class PrintVowels {

	public static void main(String[] args) {
		Long countVowels = 0L;
		int countThirdVowel = 0;
		
		String stringList = "happy new year 2022!";
		countVowels = stringList.chars()
				 .filter(string -> (string == 'a' || string == 'e' || string == 'i' || string == 'o' || string == 'u')).count();
		 
		int count = countVowels.intValue();
		
		if(count % 3 == 1) {
			countThirdVowel++;
		}
		
		System.out.println("Total count of vowels: " + count + ". Every third vowel: " + countThirdVowel);
	}
}