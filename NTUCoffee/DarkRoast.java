import java.util.*;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        condiment = new HashMap<String,Integer>();  
        milkcount = 0;
        soycount = 0;
        mochacount = 0;      
    }

    public float cost() {
        float cost = 0;
        cost = 0.97f + super.cost();
        return cost;
    }
}