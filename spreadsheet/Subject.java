import java.util.ArrayList;

public abstract class Subject {
    public ArrayList<Chart>charts = new ArrayList<Chart>();
    
    public void attach(Chart o) {
        charts.add(o);
    }

    public void detach(Chart o) {
        int index = charts.indexOf(o);
        charts.remove(index);
    }

    public void notifying() {
        for(Chart o : charts) {
            o.update();
        }
    }
}