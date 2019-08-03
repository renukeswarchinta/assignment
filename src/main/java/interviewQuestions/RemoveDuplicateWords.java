package interviewQuestions;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicateWords {

	public static void main(String[] args) {
		String duplicateWords = "Renu is java expert Manu also expert in java Lekya and Abhi are kids kids";
		Function<String, Stream<String>> splitter = a -> Pattern.compile(" ").splitAsStream(a);
		Stream.of(duplicateWords).flatMap(splitter)
								.distinct().forEach(System.out::println);
		
	}
}
