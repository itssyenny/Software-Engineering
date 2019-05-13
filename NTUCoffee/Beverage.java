import java.util.*;

public abstract class Beverage {
    // boolean for condiment
    public HashMap<String,Integer>condiment;
    public int milkcount;
    public int soycount;
    public int mochacount;

    public float cost() {
        float a = (condiment.containsKey("milk") == true) ? (float)condiment.get("milk") : 0;
        float b = (condiment.containsKey("soy") == true) ? (float)condiment.get("soy") : 0;
        float c = (condiment.containsKey("mocha") == true) ? (float)condiment.get("mocha") : 0;
        float cost = (a * 0.2f) + (b * 0.1f) + (c * 0.25f);
        return cost;
    }

    //milk
    public void setMilk() {
        milkcount += 1;
        condiment.put("milk", milkcount);
    }

    //soy
    public void setSoy() {
        soycount += 1;
        condiment.put("soy", soycount);
    }

    //mocha
    public void setMocha() {
        mochacount += 1;
        condiment.put("mocha", mochacount);
    }

    public void ClearAll() {
        condiment.clear();
    }
}