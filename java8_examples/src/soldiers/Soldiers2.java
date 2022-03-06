package soldiers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Soldiers2 {
	
	public static void main(String[] args){
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18 , 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
		String[] soldiers = Arrays.toString(a).split("[\\[\\]]")[1].split(", ");
		Stream<String> soldiersStream = Arrays.stream(soldiers);
		
		System.out.println(intStreamMethod(List.of(soldiers)));
		}
	
	private static List<String> intStreamMethod(final List<String> soldiersList) {
		Predicate<Integer> isEven = i -> i % 2 == 0;
		Predicate<Integer> isOdd = Predicate.not(isEven);

		Predicate<String> isEvenIndex = str -> (soldiersList.indexOf(str)+1)%2 == 0;
		List<String> soldiersList1 = new ArrayList<>();

		if(soldiersList.size() == 2)
			return soldiersList;
		
		if(soldiersList.size() > 2) {
			soldiersList1 = soldiersList.stream().filter(Predicate.not(isEvenIndex)).collect(Collectors.toList());
		}
		
		if(soldiersList.size()%2 != 0)
			Collections.rotate(soldiersList1, 1);

		soldiersList1 = intStreamMethod(soldiersList1);

		return soldiersList1;
		}
}