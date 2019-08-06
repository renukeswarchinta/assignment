package interviewQuestions;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

	public static void main(String[] args) {
		try {
			ExecutorService executorSErvice = Executors.newCachedThreadPool();
			CountDownLatch countDownLatch = new CountDownLatch(5);
			for (int i = 0; i < 2; i++) {
				executorSErvice.execute(new Task(countDownLatch));
			}
			countDownLatch.await();
		} catch (InterruptedException e) {
			System.out.println("in interruppted execption");
		}

	}
}

class Task implements Runnable {
	private CountDownLatch countDownLatch;

	Task(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("In TAsk " + i);
		}
		countDownLatch.countDown();
	}

}