package interviewQuestions;

public class InsertionSort {

	public void insertionSort(Object[] data) {
		for(int i=1,j;i<data.length;i++) {
			Comparable comparable = (Comparable) data[i];
			for(j= i;j>0  && comparable.compareTo(data[j-1]) <0 ;j--) {
				data[j] = data[j-1];
			}
			data[j] = comparable;
		}
		
	}
}
