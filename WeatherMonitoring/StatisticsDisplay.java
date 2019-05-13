import java.util.ArrayList;

public class StatisticsDisplay implements Observer {
   @Override
   public void update(ArrayList<Double> t, ArrayList<Double> h, ArrayList<Double> p) {
       
    System.out.print("Temperature");
    for(int i = 0; i < t.size(); i++) {
        double temp = t.get(i);
        System.out.print(" " + Math.round(temp * 10) / 10.0);
    }

    System.out.print("\nHumidity");
    for(int i = 0; i < h.size(); i++) {
        double humid = h.get(i);
        System.out.print(" " + Math.round(humid * 10) / 10.0);
    }

    System.out.print("\nPressure");
    for(int i = 0; i < p.size(); i++) {
        double press = p.get(i);
        System.out.print(" " + Math.round(press * 10) / 10.0);
    }
    System.out.print("\n");
   }    
}