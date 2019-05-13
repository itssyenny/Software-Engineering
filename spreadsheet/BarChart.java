import java.util.*;

public class BarChart implements Chart {
    public ApplicationData app;

    public BarChart (ApplicationData app) {
        this.app = app;
    }
    
    @Override
    public void update() {
        for(int i = 0; i < app.items.size(); i++) {
            for(int j = 0; j < app.values.get(i); j++) {
                System.out.print("=");
            }
            System.out.println(" " + app.items.get(i));
        }
    }
}