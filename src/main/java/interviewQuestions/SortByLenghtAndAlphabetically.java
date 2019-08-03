package interviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class SortByLenghtAndAlphabetically {

	public static void main(String[] args) {
		String name = "Renukeswar is java expert in concepts like spring spring boot hibernate jpa lua nodejs and etc";
		String[] words = name.split(" ");
		Collections.sort(Arrays.asList(words),new LengthAndStringComparator());
		for(String s: words) {
			System.out.println(s);
		}
	}
	
}
class LengthAndStringComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() != o2.length()) {
			return o1.length()-o2.length();
		}
		return o1.compareTo(o2);
	}
	
}
