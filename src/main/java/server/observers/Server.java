package server.observers;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private List<ObserverImpl> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObserver(Observer observer){
        for (observer : observers) {

        }
    }
}
