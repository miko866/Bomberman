package server.observers;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private List<ObserverImpl> observers = new ArrayList<>();

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }


}
