package interviewQuestions;

import java.util.Scanner;

public class MinimumSwaps {
	static int minimumSwaps(int[] arr) {
		int swap=0;
		boolean visited[]=new boolean[arr.length];

		for(int i=0;i<arr.length;i++){
			int j=i,cycle=0;

			while(!visited[j]){
				visited[j]=true;
				j=arr[j]-1;
				cycle++;
			}
			
			if(cycle!=0)
				swap+=cycle-1;
		}
		return swap;
	}

	public static void main(String[] args) {
		
		
		int res = minimumSwaps(new int[] {2,4,1,3,5});
		System.out.println(res);
		
	}

}
