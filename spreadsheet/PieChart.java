import java.util.*;

public class PieChart implements Chart {
    public ApplicationData app;

    public PieChart(ApplicationData app) {
        this.app = app;
    }
    
    @Override
    public void update() {
        float sum = 0;
        for(int i : app.values) {
            sum += (float)i;
        }
        
        for(int j = 0; j < app.items.size(); j++) {
            float value = 100f * (float)app.values.get(j)/sum;
            System.out.println(app.items.get(j) + " " + Math.round(value * 10.0)/10.0 +"%");
        }
    }
}