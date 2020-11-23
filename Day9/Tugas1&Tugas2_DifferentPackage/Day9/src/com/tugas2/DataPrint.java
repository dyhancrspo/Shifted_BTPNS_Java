package com.tugas2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;

public class DataPrint extends Thread {
    public static String fileData;
    public DataPrint(String strServer) {
        fileData = strServer;
    }

    public void run() {
        Object obj= JSONValue.parse(fileData);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray elm = (JSONArray) jsonObject.get("siswa");
        for (int i = 0; i < elm.size(); i++) {
            JSONObject objectInArray = (JSONObject)elm.get(i);
            System.out.println("\nNama   : "+objectInArray.get("nama")+
                               "\nNilai Fisika  : "+objectInArray.get("fisika")+
                               "\nNilai Kimia   : "+objectInArray.get("kimia")+
                               "\nNilai Biologi : "+objectInArray.get("biologi")+
                               "\n");
        }
    }
}
