import java.io.*;
import java.util.*;
public class Client {
    public static void main (String[] args) throws IOException {

        // VisualDisplay visual = new BorderDecorator(new ScrollDecorator(new TextView("Hello")));
        // visual.draw();
        // System.out.print("\n");
        File document = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(document));

        String line;
        
        Component[] components = new Component[100000];
        int count = 0;

        while((line = reader.readLine()) != null) {
            String[] cmd = line.split(" ");
            String TextViewName = cmd[0];
            int found = 0;
            if(cmd[1].equals("add")) {
                for(int i = 0; i < count; i++) {
                    if(components[i].name.equals(TextViewName)) {
                        for(int j = 2; j < cmd.length; j++) {
                            components[i].elements.add(cmd[j]);
                        }
                        found = 1;
                        break;
                    }
                }

                if(found == 0) {
                    System.out.println("No such " + TextViewName + " is available.");
                }

            }
            else if(cmd[1].equals("display")) {
                VisualDisplay visual; 
                for(int i = 0; i < count; i++) {
                    if(components[i].name.equals(TextViewName)) {
                        for(int j = 0; j < components[i].elements.size(); j++) {
                            
                            if(components[i].elements.get(j).equals("scrollBar")) {
                                visual = new ScrollDecorator(visual);
                            }
                            else if(components[i].elements.get(j).equals("thickBlackBorder")) {
                                visual = new BorderDecorator(visual);
                            }
                            else {
                                visual = new TextView(components[i].elements.get(j));
                            }
                        }
                        visual.draw();
                        break;
                    }                    
                }
            }
            else {
                components[count].name = TextViewName;
                components[count].elements.add(cmd[1]);
                count++;
            }
        }


    }
}