import java.util.ArrayList;

public class CurrentDisplay implements Observer {
   @Override
    public void update(ArrayList<Double> t, ArrayList<Double> h, ArrayList<Double> p) {
        int count = t.size();
        System.out.println("Temperature " + Math.round(t.get(count-1) * 10) / 10.0);
        System.out.println("Humidity " + Math.round(h.get(count-1) * 10) / 10.0);
        System.out.println("Pressure " + Math.round(p.get(count-1) * 10) / 10.0);
    }
}