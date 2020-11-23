package com.company;

import java.io.*;


public class DataPrint extends Thread {
    public static String fileData;
    public DataPrint(String strServer) {
        fileData = strServer;
    }

    public void run() {
        String[] valueData = fileData.split("\n");
        for(String string : valueData) {
            String[] data = string.split(",");
            for(int j = 0; j < data.length; j++){
                if(j==0){
                    System.out.println("Nama          : " +data[j]);
                } else if (j == 1){
                    System.out.println("Nilai Fisika  : " +data[j]);
                } else if (j == 2){
                    System.out.println("Nilai Biologi : " +data[j]);
                } else if (j == 3){
                    System.out.println("Nilai Kimia   : " +data[j]);
                }
            }
        }
    }
}
