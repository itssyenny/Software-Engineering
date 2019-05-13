import java.util.*;
public class USWeatherData extends Subject {
    public ArrayList<Double>temperature;
    public ArrayList<Double>humidity;
    public ArrayList<Double>pressure;
    
    public USWeatherData() {
       observers = new ArrayList<Observer>();
       temperature = new ArrayList<Double>();
       humidity = new ArrayList<Double>();
       pressure = new ArrayList<Double>();
   }
    public ArrayList<Double> getTemperature() {
        return temperature;
    }
    public ArrayList<Double> getHumidity() {
        return humidity;
    }
    public ArrayList<Double> getPressure() {
        return pressure;
    }
   //setState()
   public void setComponents(double temperature, double humidity, double pressure) {
       this.temperature.add(temperature);
       this.humidity.add(humidity);
       this.pressure.add(pressure);
       notifyObservers();
   }
}