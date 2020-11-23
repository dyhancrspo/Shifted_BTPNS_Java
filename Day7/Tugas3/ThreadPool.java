import java.util.*;
import java.io.*;

public class ThreadPool implements Runnable {
    String mydata;
    public ThreadPool(String data) {
        mydata = data;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Data = " + mydata);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
