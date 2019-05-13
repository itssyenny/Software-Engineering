import java.util.ArrayList;
public abstract class Subject {
    public ArrayList<Observer> observers = new ArrayList<Observer>();
    public void attach(Observer obs) {
        observers.add(obs);
    }
    public void detach(Observer obs) {
        int index = observers.indexOf(obs);
        if(index >= 0) {
            observers.remove(index);
        }
    }
    public void notifyObservers() {
        for(Observer obs : observers) {
            obs.update(getTemperature(), getHumidity() ,getPressure());
        }
    }

    public abstract ArrayList<Double> getTemperature();
    public abstract ArrayList<Double> getHumidity();
    public abstract ArrayList<Double> getPressure();
}