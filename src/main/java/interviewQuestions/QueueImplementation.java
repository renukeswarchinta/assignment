package interviewQuestions;

public class QueueImplementation {
	public static void main(String[] args) {
		Queue queue = new Queue(19);
		queue.enqueue(1);queue.enqueue(2);queue.enqueue(3);queue.enqueue(4);
		queue.dequeue();
	}
	
}

class Queue{
	int array[];
	int front,rear;
	int capacity;
	int count ;
	Queue(int size){
		array = new int[size];
		front=0;rear=-1;
		capacity =size;
		count=0;
	}
	public void enqueue(int item) {
		if(isFull()) {
			System.out.println("Queue is full");
		}
		//while pushing the element we should increase rear element
		rear =(rear+1) % capacity; // -1+1%10 = 0 ; 0+1=1%10 ;1+1=2%10;2+1=3%10
		array[rear] = item;
		count++;
		System.out.println("Inserted element is "+item);
	}
	public void dequeue() {
		System.out.println("Poping out element  "+array[front]);
		front = (front+1)%capacity;
		count--;
	}
	private boolean isFull() {
		return capacity == front-1;
	}
			
}