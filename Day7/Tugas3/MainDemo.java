import java.util.concurrent.*;
import java.io.*;

public class MainDemo {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = args[0];
        int thread = Integer.parseInt(args[1]);
        String menu = "";
        try {
            while (!menu.equals("4")){
                System.out.println("Menu");
                System.out.println("1. Simple Thread");
                System.out.println("2. ThreadPool");
                System.out.println("3. Tampilkan dan Export ke file (Sort by asc/desc)");
                System.out.println("4. Exit");
                System.out.print("Pilih Menu yang tersedia : ");
                menu = br.readLine();
                switch (menu) {
                        case "1": 
                            SimpleThread t1 = new SimpleThread(file);
                            t1.start();
                            break;
        
                        case "2": //done
                            ExecutorService executor = Executors.newFixedThreadPool(thread);
                            BufferedReader brData = new BufferedReader(new FileReader("data.txt"));
                            String line = "";
                            while ((line = brData.readLine()) != null) {
                                String[] data = line.split(",");
                                for (int i = 0; i < data.length; i++) {
                                    Runnable worker = new ThreadPool("" + data[i]);
                                    executor.execute(worker);
                                }
                            }
                            executor.shutdown();   
                            break;
        
                        case "3":
                            SimpleThread simple = new SimpleThread(file);
                            simple.start();
                            AscPrint asc = new AscPrint(file);
                            asc.start();
                            DescPrint desc = new DescPrint(file);
                            desc.start();
                            break;
                        }
                        br.close();
             }
        } catch (Exception e) {
            System.out.println("Error Menu: "+ e);   
        }
    }
}