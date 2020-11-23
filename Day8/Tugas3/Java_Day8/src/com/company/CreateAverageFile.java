package com.company;

import java.io.*;
import java.util.*;

public class CreateAverageFile extends Thread{
    public static String fileData;
    public CreateAverageFile(String strServer) {
        fileData = strServer;
    }

    public void run(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("FileAverage.txt"));
            bw.write("Nama,NilaiRata-Rata");
            bw.write("\n");
            //Looping
            String[] valueData = fileData.split("\n");
            for (String string : valueData) {
                String[] data = string.split(",");
                double average =(Double.parseDouble(data[1])+Double.parseDouble(data[2])+Double.parseDouble(data[3]))/3;
                bw.write(String.format(""+data[0]+","+Double.toString(average)));
                bw.write("\n");
            }
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
