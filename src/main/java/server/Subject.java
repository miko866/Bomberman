package server;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    int clientId = 1;

    private List<Observer> observers = new ArrayList<Observer>();

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void addObserver(Observer observer){
        observers.add(observer);
        observer.setClientId(clientId);
        clientId++;
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update("das ist eine message an alle");
        }
    }
}
