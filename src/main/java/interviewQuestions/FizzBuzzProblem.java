package interviewQuestions;

public class FizzBuzzProblem {

	public static void main(String[] args) {
		printFizzBuzz(100);
	}
	public static void printFizzBuzz(int n) {
		for(int i =1;i<n;i++) {
			if((i%3 ==0) && (i%5==0)) {
				System.out.println("Fizz Buzz ");
			}else if(i%3 == 0) {
				System.out.println("Fizz ");
			}else if(i%5 ==0) {
				System.out.println("Buzz ");
			}else {
				System.out.println(i+" ");
			}
		}
	} 
}
