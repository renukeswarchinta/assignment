package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8StreamChallenges {
	static Function<Long, Person> personFunction = a -> new Person(10L,"Eswar","Chinta",34);
	static Person p2 = personFunction.apply(10L);
	
	public static void main(String[] args) {
		Person p1 = new Person(1L,"Renu","C",30);
		Person p2 = new Person(2L,"Eswar","Chinta",29);
		Person p3 = new Person(3L,"Manu","K",40);
		Person p4 = new Person(4L,"Renu","K",29);
		List<Person> listOfPersons = new ArrayList<>();
		Collections.addAll(listOfPersons, p1,p2,p3,p4);
		System.out.println("Is Perosn renu "+isRenu(p1));
		printAllPersons(listOfPersons);
		printMapFromList(listOfPersons);
		replaceNames(listOfPersons);
		//removeSomePresons(listOfPersons);
		checkEvenOrNot();	
		findEvenFrom2DimensionalArray();
	}

	private static void replaceNames(List<Person> listOfPersons) {
		listOfPersons.stream()
					 .filter(a -> a.getFirstName().equalsIgnoreCase("Renu"))
					 .forEach(a -> a.setFirstName("Renukeswar"));
		listOfPersons.stream()
		 .filter(a -> a.getFirstName().equalsIgnoreCase("Eswar"))
		 .forEach(a -> a.setFirstName("NewEswar"));
		
		listOfPersons.stream().forEach(a -> System.out.println(a.getFirstName()));
		
	}
	public static  void checkEvenOrNot() {
		List<Integer> list = Arrays.asList(4,33);
		list.stream().filter(a->a%2!=0)
		 .forEach(a->System.out.println("o"+a));
		System.out.println(list.toString());
		
	}
	//from a list of names, give me the total number of letters in all the names with more than 5 letters
	public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
	    List<String> namesList = Arrays.asList(names);
	    return namesList.stream().filter(a-> a.length()>5).mapToInt(a ->a.length()).sum();
	}
	public static List<String> transform(List<List<String>> collection) {
		List<String> newCollection = new ArrayList<>();
		List<String> strings = collection.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		 newCollection.addAll(strings);
		 return newCollection;
	}
	//Here we will use flatMap with array. I am creating a two dimensional array with integer data. Finally we will find out even numbers.
	public static void findEvenFrom2DimensionalArray() {
		Integer[][] data = {{1,2},{3,4},{5,6}};
		Arrays.stream(data).flatMap(row -> Arrays.stream(row)).filter(a -> a%2 ==0).forEach(System.out::println);
	}
	//Get the oldest person from the collection
	public static Person getOldestPerson(List<Person> person) {
		return person.stream().max(Comparator.comparing(Person::getAge)).get();
	}
	//Sum all elements of a collection, try to use the reduce operator with identity parameter instead of an IntStream
	public static int calculate(List<Integer> numbers) {
		//return numbers.stream().reduce(0, ((a1,a2) -> a1+a2));  // using Reducing
		return numbers.stream().mapToInt(a ->a).sum();
		
	}
	//Get the names of all kids under the age of 18
	public static Set<String> getKidNames(List<Person> people) {
		return people.stream().filter(p -> p.getAge() >18).map(person -> person.firstName).collect(Collectors.toSet());
	}
	//Partition these people into adults and kids, you'll need a special collector for this one
	public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
		Predicate <Person> predicate = p -> p.getAge() > 18 ;
		return people.stream().collect(Collectors.partitioningBy(predicate));
		
	}
	//Group these people by nationality, same kind as the previous exercise
	public static Map<String, List<Person>> groupByNationality(List<Person> people) {
		return people.stream().collect(Collectors.groupingBy(a -> a.firstName));
		
	}
	//Return a comma-separated string of all these people's names
	public static String namesToString(List<Person> people) {
		return people.stream().map(a->a.getFirstName()).collect(Collectors.joining(","));
	}
	
	//Write a method that returns a comma separated string based on a given list of integers. 
	//Each element should be preceded by the letter 'e' if the number is even, and preceded by the letter 'o' if the number is odd. 
	//For example, if the input list is (3,44), the output should be 'o3,e44'.
	public static String getString(List<Integer> list) {
		return list.stream().map(a ->a%2 ==0 ? "o"+a:"e"+a).collect(Collectors.joining(","));
	}
	
	private static void printMapFromList(List<Person> listOfPersons) {
		Map<Long,Person> mapOutOfStream = listOfPersons.stream()
					 .filter(a->a.getFirstName().equalsIgnoreCase("Renu"))
					 .collect(Collectors.toMap(a->a.getPersonId(), a->a));
		for(Map.Entry<Long, Person> it : mapOutOfStream.entrySet()) {
			System.out.println("Key is "+it.getKey()+" Value "+it.getValue());
		}
	}
	
	private static void printAllPersons(List<Person> listOfPersons) {
		listOfPersons.stream().forEach(a -> System.out.println(a.firstName));
	}

	private static boolean isRenu(Person p1) {
		return p1.firstName.equalsIgnoreCase("Renu");
	}

	

}


class Person{
	Long personId;
	String firstName;
	String lastName;
	int age;
	Person(Long personId,String firstName,String lastName,int age){
		this.personId = personId;
		this.firstName = firstName;
		this.lastName= lastName;
		this.age=age;
	}
	


	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}