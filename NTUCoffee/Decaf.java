import java.util.*;

public class Decaf extends Beverage {
    public Decaf() {
        condiment = new HashMap<String,Integer>();
        milkcount = 0;
        soycount = 0;
        mochacount = 0;
    }

    public float cost() {
        float cost = 0;
        cost = 0.98f + super.cost();
        return cost;
    }
}