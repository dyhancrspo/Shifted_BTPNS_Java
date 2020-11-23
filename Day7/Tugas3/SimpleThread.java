import java.util.*;
import java.io.*;

public class SimpleThread extends Thread {
    String file;
    public SimpleThread(String file) {
        this.file = file;
    }
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line ="";
            while ((line = br.readLine())!=null) {
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) {
                    System.out.println(data[i]);
                }
            }
            br.close();
            System.out.print("Ketik menu yang ingin dilakukan: ");
        } catch (Exception e) {
            System.out.println("ERROR!: " + e);
        }
    }
}
