import java.util.ArrayList;

public class TextView implements VisualDisplay {
    
    public TextView(String text) {
        this.text = text;
    }
    @Override
    public void draw() {
        System.out.print(text);
    }
}