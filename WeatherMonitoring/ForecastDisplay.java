import java.util.ArrayList;

public class ForecastDisplay implements Observer {
    @Override
    public void update(ArrayList<Double> t, ArrayList<Double> h, ArrayList<Double> p) {
        int count = t.size();
        if(h.get(count-1) > 0.8) {
            System.out.println("Forecast rain.");
        }
        else if(h.get(count-1) < 0.2) {
            System.out.println("Forecast sunny.");
        }
        else {
            System.out.println("Forecast cloudy.");
        }
    }
}