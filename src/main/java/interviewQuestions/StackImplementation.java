package interviewQuestions;

public class StackImplementation {

	public static void main(String[] args) {
		CustomStack stack = new CustomStack(10);
		stack.push(1);stack.push(10);stack.push(2);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}
}


class CustomStack{
	int array[];
	int top;
	int capacity ;
	CustomStack(int size){
		array = new int[size];
		top = -1;
		capacity = size;
	}
	public void push(int x) {
		if(isFull()) {
			System.out.println("Stack is full");
			System.exit(1);
		}
		System.out.println("Pushing element on the top "+x);
		array[++top] = x;
	}
	private boolean isFull() {
		return capacity == top -1;
	}
	public int pop() {
		if(isEmpty()) {
			System.out.println("This is empty");
			System.exit(1);
		}
		System.out.println("Poping element from the top ");
		return array[top--];
	}
	private boolean isEmpty() {
		return top == -1;
	}
	public int peek() {
		return array[top];
	}
	public int size() {
		return top+1;
	}
}
