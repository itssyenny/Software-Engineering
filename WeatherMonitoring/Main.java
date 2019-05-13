import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        //open and read text in a document
        File document = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(document));

        String line;
        AsiaWeatherData w1 = new AsiaWeatherData();
        USWeatherData w2 = new USWeatherData();
        CurrentDisplay cur = new CurrentDisplay();
        StatisticsDisplay stats = new StatisticsDisplay();
        ForecastDisplay cast = new ForecastDisplay();
        ArrayList<SaveInput>storeInput = new ArrayList<SaveInput>();

        while((line = reader.readLine()) != null) {
            String[] cmd = line.split(" ");

            if(cmd[0].equals("data")) {
                double t = Double.parseDouble(cmd[2]);
                double h = Double.parseDouble(cmd[3]);
                double p = Double.parseDouble(cmd[4]);

                if(cmd[1].equals("Asia")) {
                    w1.setComponents(t, h, p);
                }
                else if(cmd[1].equals("US")) {
                    w2.setComponents(t, h, p);
                }
                else {
                    System.out.println("Country doesn't exist.");
                }
            } 
            else if(cmd[0].equals("attach")) {
                int error = -1;
                // System.out.println("size: " + storeInput.size());
                for(int h = 0; h < storeInput.size(); h++) {
                    SaveInput a = storeInput.get(h);
                    if(cmd[1].equals(a.country) && cmd[2].equals(a.displayType)) {
                        // System.out.println("Masuk attach loop error: " + a.country + " " + a.displayType);                        
                        error = 1;
                        break;
                    }
                }
                
                if(error == 1) {
                    System.out.println("Country " + cmd[1] + " with display type " + cmd[2] + " has already been attached.");
                }
                else if(error != 1) {
                    if(cmd[1].equals("Asia")) {
                        if(cmd[2].equals("Current")) {
                            SaveInput newinput = new SaveInput(cmd[1],cmd[2]);
                            storeInput.add(newinput);
                            w1.attach(cur);
                        }
                        else if(cmd[2].equals("Statistics")) {
                            SaveInput newinput = new SaveInput(cmd[1],cmd[2]);
                            storeInput.add(newinput);
                            w1.attach(stats);
                        } 
                        else if(cmd[2].equals("Forecast")) {
                            SaveInput newinput = new SaveInput(cmd[1],cmd[2]);
                            storeInput.add(newinput);
                            w1.attach(cast);
                        }
                        else {
                            System.out.println("DisplayType doesn't exist.");
                        }
                    }
                    else if(cmd[1].equals("US")) {
                        if(cmd[2].equals("Current")) {
                            SaveInput newinput = new SaveInput(cmd[1],cmd[2]);
                            storeInput.add(newinput);
                            w2.attach(cur);
                        }
                        else if(cmd[2].equals("Statistics")) {
                            SaveInput newinput = new SaveInput(cmd[1],cmd[2]);
                            storeInput.add(newinput);
                            w2.attach(stats);
                        } 
                        else if(cmd[2].equals("Forecast")) {
                            SaveInput newinput = new SaveInput(cmd[1],cmd[2]);
                            storeInput.add(newinput);
                            w2.attach(cast);
                        }
                        else {
                            System.out.println("DisplayType doesn't exist.");
                        }
                    }
                    else {
                        System.out.println("Country doesn't exist.");
                    }
                }
            }
            else if(cmd[0].equals("detach")) {
                int error = 1;
                // System.out.println("REMAINING SIZE: " + storeInput.size());                
                for(int h = 0; h < storeInput.size(); h++) {
                    SaveInput a = storeInput.get(h);
                    if(cmd[1].equals(a.country) && cmd[2].equals(a.displayType)) {
                        // System.out.println("Masuk detach loop: " + a.country + " " + a.displayType);                        
                        storeInput.remove(h);                        
                        error = -1;
                        break;
                    }
                    else {
                        error = 1;
                    }
                }

                if(error == 1) {
                    System.out.println("Country " + cmd[1] + " with display type " + cmd[2] + " has already been detached.");
                }
                else if(error != 1) {
                    if(cmd[1].equals("Asia")) {
                        if(cmd[2].equals("Current")) {
                            w1.detach(cur);
                        }
                        else if(cmd[2].equals("Statistics")) {
                            w1.detach(stats);
                        } 
                        else if(cmd[2].equals("Forecast")) {
                            w1.detach(cast);
                        }
                        else {
                            System.out.println("DisplayType doesn't exist.");
                        }
                    }
                    else if(cmd[1].equals("US")) {
                        if(cmd[2].equals("Current")) {
                            w2.detach(cur);
                        }
                        else if(cmd[2].equals("Statistics")) {
                            w2.detach(stats);
                        } 
                        else if(cmd[2].equals("Forecast")) {
                            w2.detach(cast);
                        }
                        else {
                            System.out.println("DisplayType doesn't exist.");
                        }
                    }
                }
            }
            else {
                System.out.println("Command doesn't exist.");
            }
        }
        reader.close();
    }
}