import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File document = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(document));
        String line;
        
        ApplicationData apps = new ApplicationData();
        while((line = reader.readLine()) != null) {
            String[] cmd = line.split(" ");

            if(cmd[0].equals("data")) {
                int value = Integer.parseInt(cmd[2]);
                apps.setState(cmd[1], value);
            }
            else if(cmd[0].equals("addChart")) {
                if(cmd[1].equals("Spreadsheet")) {
                    apps.attach(new Spreadsheet(apps));
                }
                else if(cmd[1].equals("BarChart")) {
                    apps.attach(new BarChart(apps));
                }
                else if(cmd[1].equals("PieChart")) {
                    apps.attach(new PieChart(apps));
                }
            }
            else if(cmd[0].equals("change")) {
                System.out.println(cmd[1] + " change " + cmd[2] + " " + cmd[3] + ".");
                int value = Integer.parseInt(cmd[3]);
                apps.setState(cmd[2], value);
            }
        }
    }
}