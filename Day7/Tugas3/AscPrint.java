import java.io.*;
import java.util.*;


public class AscPrint extends Thread {
    String file;

    public AscPrint(String file) {
        this.file = file;
    }

    public void run() {
        try {
            //Reader
            BufferedReader brf = new BufferedReader(new FileReader(file));
            // Writer
            BufferedWriter brw = new BufferedWriter(new FileWriter("Data_Asc.txt"));
            String line ="";
            while ((line=brf.readLine())!=null) {
                String[] data = line.split(",");
                Arrays.sort(data, Collections.reverseOrder());
                for (int i = 0; i < data.length; i++) {
                    brw.write(data[i] + "\n");
                }
            }
            brw.close();
            brf.close();
        } catch (Exception e) {
            System.out.println("ERROR!: " + e);
        }
    }
}
