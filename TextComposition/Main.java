import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        //open and read text in a document
        File document = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(document));

        int[] ComponentID =  new int[1000];
        int[] NaturalSize = new int[1000];
        int[] Shrinkability = new int[1000];
        int[] Stretchability = new int[1000];
        String[] Content = new String[1000];
        int  count = 0;
        String line;
        while((line = reader.readLine()) != null) {
            String[] cmd = line.split(" ");
            if(cmd[0].equals("Text") || cmd[0].equals("GraphicalElement")) {
                ComponentID[count] = Integer.parseInt(cmd[1]);
                NaturalSize[count] = Integer.parseInt(cmd[2]);
                Shrinkability[count] = Integer.parseInt(cmd[3]);
                Stretchability[count] = Integer.parseInt(cmd[4]);
                Content[count]= cmd[5];
                count++;
            }
            else if(cmd[0].equals("ChangeSize")) {
                int id = Integer.parseInt(cmd[1]);
                int id_found = -1;
                for(int h = 0; h < count; h++) {
                    if(id == ComponentID[h]) {
                        id_found = h;
                        break;
                    }
                }
                if(id_found != -1) {
                    int NewSize = Integer.parseInt(cmd[2]);

                    if(NewSize < Shrinkability[id_found] || Stretchability[id_found] < NewSize) {
                        System.out.println("component " + ComponentID[id_found] + " failed to change size");
                    }
                    else {
                        NaturalSize[id_found] = NewSize;
                        System.out.println("component " + ComponentID[id_found] + " size changed to " + NewSize);
                    }
                }
                else {
                    System.out.println("ComponentID " + id + " not found.");
                }
            }
            else if(cmd[0].equals("Require")) {
                String answer;
                if(cmd[1].equals("SimpleComposition")) {
                    Composition composition = new Composition(new SimpleCompositor());
                    composition.components = new Component[count];

                    for(int i = 0; i < count; i++) {
                        composition.components[i] = new Component(ComponentID[i], NaturalSize[i], Stretchability[i], Shrinkability[i], Content[i]);
                    }

                    answer = composition.arrange();
                    System.out.println(answer);

                }
                else if(cmd[1].equals("TexComposition")) {
                    Composition composition = new Composition(new TexCompositor());
                    composition.components = new Component[count];

                    for(int i = 0; i < count; i++) {
                        composition.components[i] = new Component(ComponentID[i], NaturalSize[i], Stretchability[i], Shrinkability[i], Content[i]);
                    }

                    answer = composition.arrange();
                    System.out.println(answer);

                }
                else if(cmd[1].equals("ArrayComposition")) {
                    Composition composition = new Composition(new ArrayCompositor());
                    composition.components = new Component[count];

                    for(int i = 0; i < count; i++) {
                        composition.components[i] = new Component(ComponentID[i], NaturalSize[i], Stretchability[i], Shrinkability[i], Content[i]);
                    }

                    answer = composition.arrange();
                    System.out.println(answer);
                }
                else {
                    System.out.println(("Command doesn't exist."));
                }
            }
        }
      
        reader.close();    
    }
}