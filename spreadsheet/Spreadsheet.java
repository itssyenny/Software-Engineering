import java.util.*;

public class Spreadsheet implements Chart {
    public ApplicationData app;

    public Spreadsheet(ApplicationData app) {
        this.app = app;
    }
    
    @Override
    public void update() {
        for(int i = 0; i < app.items.size(); i++) {
            System.out.println(app.items.get(i) + " " + app.values.get(i));
        }
    }
}