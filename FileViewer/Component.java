import java.util.ArrayList;

public class Component {
    public String name;
    public ArrayList<String> elements = new ArrayList<String>(); 
    public Component(String name, String e) {
        this.name = name;
        this.elements.add(e);
    }
}