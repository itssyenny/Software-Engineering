import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File document = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(document));

        String line;

        while((line = reader.readLine()) != null) {
            String[] cmd = line.split(" ");
            int i = 0, len = 0;

            if(cmd[0].equals("HouseBlend")) {
                HouseBlend order = new HouseBlend();
                len = cmd.length;
                for(i = 1; i < len; i++) {
                    if(cmd[i].equals("Milk")) {
                        order.setMilk();
                    }
                    else if(cmd[i].equals("Soy")) {
                        order.setSoy();
                    }
                    else if(cmd[i].equals("Mocha")) {
                        order.setMocha();
                    }
                    else {
                        System.out.println("No condiment " + cmd[i] + " in beverage " + cmd[0]);
                    }
                }
                System.out.println("price: " + Math.round(order.cost() * 100.0f)/100.0f );
                order.ClearAll();
            }
            else if(cmd[0].equals("DarkRoast")) {
                DarkRoast order = new DarkRoast();
                len = cmd.length;
                for(i = 1; i < len; i++) {
                    if(cmd[i].equals("Milk")) {
                        order.setMilk();
                    }
                    else if(cmd[i].equals("Soy")) {
                        order.setSoy();
                    }
                    else if(cmd[i].equals("Mocha")) {
                        order.setMocha();
                    }
                    else {
                        System.out.println("No condiment " + cmd[i] + " in beverage " + cmd[0]);
                    }
                }
                System.out.println("price: " + Math.round(order.cost() * 100.0f)/100.0f );
                order.ClearAll();
            }
            else if(cmd[0].equals("Decaf")) {
                Decaf order = new Decaf();
                len = cmd.length;
                for(i = 1; i < len; i++) {
                    if(cmd[i].equals("Milk")) {
                        order.setMilk();
                    }
                    else if(cmd[i].equals("Soy")) {
                        order.setSoy();
                    }
                    else if(cmd[i].equals("Mocha")) {
                        order.setMocha();
                    }
                    else {
                        System.out.println("No condiment " + cmd[i] + " in beverage " + cmd[0]);
                    }
                }
                System.out.println("price: " + Math.round(order.cost() * 100.0f)/100.0f);
                order.ClearAll();
            }
            else if(cmd[0].equals("Espresso")) {
                Espresso order = new Espresso();
                len = cmd.length;
                for(i = 1; i < len; i++) {
                    if(cmd[i].equals("Milk")) {
                        order.setMilk();
                    }
                    else if(cmd[i].equals("Soy")) {
                        order.setSoy();
                    }
                    else if(cmd[i].equals("Mocha")) {
                        order.setMocha();
                    }
                    else {
                        System.out.println("No condiment " + cmd[i] + " in beverage " + cmd[0]);
                    }
                }
                System.out.println("price: " + Math.round(order.cost() * 100.0f)/100.0f);
                order.ClearAll();
            }
            else {
                System.out.println("There is no beverage with type '" + line + "'.");
            }
        }
        reader.close(); 
    }
}