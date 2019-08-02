package interviewQuestions;

import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Java8FunctionChallenge {

	public static void main(String[] args) {
		String starWars = "Renu Manu Abhi Lekhya is a family";
		String[] stringArray = {"Renu","Manu","Abhi","Lekhya","is", "a","family"};
		Function<String, Stream<String>> splitter = a -> Pattern.compile(" ").splitAsStream(a);
		Function<String, Stream<String>> arraySplitter = a -> Pattern.compile(",").splitAsStream(a);
		
		Stream.of(starWars).flatMap(splitter)
							.sorted((o1,o2) -> o2.compareTo(o1))
							.forEachOrdered(System.out::println);
		
		Stream.of(stringArray).flatMap(arraySplitter)
							.sorted((o1,o2) -> o2.compareTo(o1))
							.forEach(System.out::println);
	}
	
}
