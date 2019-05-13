import java.util.*;

public class Espresso extends Beverage {
    public Espresso() {
        condiment = new HashMap<String,Integer>(); 
        milkcount = 0;
        soycount = 0;
        mochacount = 0;       
    }

    public float cost() {
        float cost = 0;
        cost = 0.99f + super.cost();
        return cost;
    }
}