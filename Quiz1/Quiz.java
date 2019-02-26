import java.io.*;
class PatientsData {
    public String name;
    public int period;
    public String d_category;
    public String d_name;
    public String dataset;
    public int low;
    public int high;
    public int readn;
    PatientsData(String name, int period, 
    String d_category, String d_name, String dataset,int low, int high) {
        this.name = name;
        this.period = period;
        this.d_category = d_category;
        this.d_name = d_name;
        this.dataset = dataset;
        this.low = low;
        this.high = high;
        this.readn = 0;
    }
}
public class Quiz{
    public static void main(String args[]) throws IOException {
        // System.out.println(args[0]);
        PatientsData[] arr;
        arr = new PatientsData[16];
        File files = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(files)); 
        
        String monitor = reader.readLine();
        int monitor_period = Integer.parseInt(monitor);

        int count = 0;
        String c;
        while((c = reader.readLine()) != null) {
           String[] line1 = c.split(" ");
           c = reader.readLine();
           String[] line2 = c.split(" "); 
           int inperiod = Integer.parseInt(line1[2]);
           int inlow = Integer.parseInt(line2[3]);
           int inhigh = Integer.parseInt(line2[4]);
           arr[count] =  new PatientsData(line1[1], inperiod, line2[0], line2[1], line2[2], inlow, inhigh);
           
        //Print Testing
        //    System.out.println("Term " + count + arr[count].name + 
        //    " " + arr[count].period + 
        //    " " + arr[count].d_category +
        //    " " + arr[count].d_name + 
        //    " " + arr[count].dataset + 
        //    " " + arr[count].low + 
        //    " " + arr[count].high);
           count++;
        }

        // Process Starts      
        for(int timestamp = 0; timestamp <= monitor_period; timestamp++) {
            for(int i = 0; i < count; i++) {
                if((timestamp % arr[i].period) == 0) {
                    File filedataset = new File(arr[i].dataset);
                    BufferedReader reader1 = new BufferedReader(new FileReader(filedataset)); 
                    int value = -1;
                    
                    String datasetline = null;
                    int j = arr[i].readn;
                    while((datasetline = reader1.readLine()) != null) {
                        if(j < 0) break;
                        j--;
                        value =  Integer.parseInt(datasetline); 
                    }
                    arr[i].readn++;

                    if(value == -1) {
                        System.out.println("[" + timestamp + "] " + arr[i].d_name
                        + " " + "falls");
                    }
                    else if(value < arr[i].low || value > arr[i].high) {
                        System.out.println("[" + timestamp + "] " + arr[i].name + " " + "is in danger! "
                        + "Cause: "+ arr[i].d_name + " "
                        + (double)value);
                    }
                }
            }
        }

        for(int person = 0; person < count; person++) {
            arr[person].readn = 0;
            System.out.println("patient " + arr[person].name);
            System.out.println(arr[person].d_category + " " + arr[person].d_name);
            for(int timestamp = 0; timestamp <= monitor_period; timestamp++) {
                if((timestamp % arr[person].period) == 0) {
                    File filedataset = new File(arr[person].dataset);
                    BufferedReader reader1 = new BufferedReader(new FileReader(filedataset));
                    int value = -1;
                    String datasetline = null;
                    int j = arr[person].readn;
                    while((datasetline = reader1.readLine()) != null) {
                        if(j < 0) break;
                        j--;
                        value =  Integer.parseInt(datasetline); 
                    }
                    arr[person].readn++;
                    System.out.println("[" + timestamp + "] "  + (double)value);
                }
            }
        }
        
    }
}
