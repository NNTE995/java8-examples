package reverseString;

public class ReverseString {
	
	public static void main(String[] args) {
		String rev = "NoeTorres";
		System.out.println(reverse(rev));;
	}
	
	public static String reverse(String string) {
		String reversed = string.chars()
				.mapToObj(c -> (char)c)
			    .reduce("", (s,c) -> c+s, (s1,s2) -> s2+s1);
		return reversed;
	}
}