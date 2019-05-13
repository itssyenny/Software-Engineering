import java.util.*;

public class ApplicationData extends Subject {
    public ArrayList<String>items;
    public ArrayList<Integer>values;

    public ApplicationData() {
        items = new ArrayList<String>();
        values = new ArrayList<Integer>();
    }

    public void setState(String item, int value) {
        int index = items.indexOf(item);
        if(index == -1) {
            items.add(item);
            values.add(value);
        }
        else {
            items.get(index);
            values.set(index, value);
        }
        
        notifying();
    }
}