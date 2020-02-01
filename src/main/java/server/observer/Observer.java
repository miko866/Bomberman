package server.observer;

public class Observer{

    private int clientId;

    public void setClientId(int clientId){
        this.clientId = clientId;
    }

    public int getClientId(){
        return clientId;
    }

    public void update(String message) {
        System.out.println("Hallo Client " + getClientId() + " " + message);
    }
}
