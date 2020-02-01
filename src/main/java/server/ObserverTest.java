package server;

public class ObserverTest {

    public static void main(String[] args) {

        Subject subject = new Subject();

        Observer client1 = new Observer();
        Observer client2 = new Observer();

        subject.addObserver(client1);
        subject.addObserver(client2);

        for (int i = 0; i < 10; i++)
            subject.notifyAllObservers();
    }
}
