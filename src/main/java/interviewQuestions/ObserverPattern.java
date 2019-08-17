package interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

}

interface Observerable{
	void add(Observer observer);
	void remove(Observer observer);
	void notifyObservers();
}

interface Observer{
	void update();
}

class ObserverableImpl implements Observerable{
	int temperature;
	List<Observer> listObservers = new ArrayList<>();
	@Override
	public void add(Observer observer) {
		listObservers.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		this.listObservers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		
		for(Observer observer: listObservers) {
			observer.update();
		}
	}
	public int getTEmperatur() {
		return this.temperature;
	}
	
}

class ObserverImpl implements Observer{
	private ObserverableImpl observerable;
	ObserverImpl(ObserverableImpl observable){
		this.observerable = observable;
	}
	@Override
	public void update() {
		this.observerable.getTEmperatur();
		
	}
	
}