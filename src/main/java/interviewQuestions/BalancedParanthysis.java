package interviewQuestions;

public class BalancedParanthysis {

	public static void main(String[] args) {
		char[] charArray = { '{', '(', ')', '}', '[', ']' };
		if (areParanthesisBalanced(charArray)) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not Balanced");
		}
	}

	static class stackImpl {
		int top = -1;
		char items[] = new char[100];

		void push(char x) {
			if (top == 99) {
				System.out.println("Stack full");
			} else {
				items[++top] = x;
			}
		}

		char pop() {
			if (top == -1) {
				System.out.println("Underflow error");
				return '\0';
			} else {
				char element = items[top];
				top--;
				return element;
			}
		}

		boolean isEmpty() {
			return (top == -1) ? true : false;
		}
	}

	private static boolean areParanthesisBalanced(char[] charArray) {
		stackImpl stack = new stackImpl();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '(' || charArray[i] == '{' || charArray[i] == '[') { // push to stack
				stack.push(charArray[i]);
			}
			if (charArray[i] == ')' || charArray[i] == '}' || charArray[i] == ']') { // push to stack
				if (!checkForMatch(stack.pop(), charArray[i])) {
					return false;
				}
			}
		}

		if (stack.isEmpty())
			return true; /* balanced */
		else
			return false;

	}

	private static boolean checkForMatch(char pop, char c) {
		if (pop == '{' && c == '}') {
			return true;
		} else if (pop == '(' && c == ')') {
			return true;
		} else if (pop == '[' && c == ']') {
			return true;
		} else
			return false;
	}
}
