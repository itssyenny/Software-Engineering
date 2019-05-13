import java.util.*;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        condiment = new HashMap<String,Integer>();
        milkcount = 0;
        soycount = 0;
        mochacount = 0;
    }

    public float cost() {
        float cost = 0;
        cost = 0.96f + super.cost();
        return cost;
    }
}