package interviewQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumToATargetInArray {
	
	public static void main(String[] args) {
		int[] numbers= {2,3,7,4,6,5};
		int target =8;
		int[] result = sumToTarget(numbers, target);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] sumToTarget(int[] numbers,int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i =0;i<numbers.length;i++) {
			int delta = target - numbers[i];
			if(map.containsKey(delta)) {
				return new int[] {i,map.get(delta)};
			}
			map.put(numbers[i], i);
			
		
		}
		return new int[] {0};
		
	}

}
