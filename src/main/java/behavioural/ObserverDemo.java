package behavioural;

import java.util.*;

public class ObserverDemo {
    public static void main(String[] args) {
        ConcreteObservable observable = new ConcreteObservable();
        ConcreteObserver observer = new ConcreteObserver(observable);
        observable.notifyObservers();
    }
}

abstract class Observable {
    abstract void addObserver(Observer obj);

    abstract void removeObserver(Observer obj);

    abstract void notifyObservers();
}

abstract class Observer {
    abstract void update();
}

class ConcreteObservable extends Observable {

    List<Observer> observers = new ArrayList<>();

    @Override
    void addObserver(Observer obj) {
        observers.add(obj);
    }

    @Override
    void removeObserver(Observer obj) {
        observers.remove(obj);
    }

    @Override
    void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}

class ConcreteObserver extends Observer {

    Observable observable;

    public ConcreteObserver(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    void update() {
        System.out.println("Observer notified");
    }

}