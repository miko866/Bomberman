package server.observer;

public class ObserverTest {

    private static final int clientCount = 4;
    private static final int nofityCount = 5;

    public static void main(String[] args) {
        Subject subject = new Subject();

        for(int i = 0; i < clientCount;i++ ){
            subject.addObserver(new Observer());
        }
        notfier(subject);
    }

    private static void notfier(Subject subject){
        for (int i = 0; i < nofityCount; i++)
            subject.notifyAllObservers();
    }
}
