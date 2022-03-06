package Concatenate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConcatenateStrings {

	public static void main(String[] args) {
		List<String> planets = Arrays.asList("Mercury", "Venus", "Mars");
		String planetsCommaSeparated = planets.stream().collect(Collectors.joining(", "));
		System.out.println("Planets: " + planetsCommaSeparated);
	}
}