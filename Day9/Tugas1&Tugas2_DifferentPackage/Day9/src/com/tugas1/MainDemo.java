package com.tugas1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.*;
import java.io.*;

public class MainDemo {
    static ArrayList<Manager> dataManager=new ArrayList<Manager>(); //ArrayList Manager
    static ArrayList<Staff> dataStaff=new ArrayList<Staff>(); //ArrayList Staff

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        showMenu(); // Fungsi ShowMenu
        String menu="";  // deklarasi variabel menu untuk case

        try {
            while (!menu.equals("4")){
                System.out.println("Pilih Menu yang tersedia : ");
                menu = br.readLine(); // nilai variabel menu diisi berdasarkan nilai line yang diinput
                switch (menu){ //switch menu
                    case "1":
                        addKaryawan(); // invoke method addKaryawan
                        break;
                    case "2":
                        dataToJson(); // invoke method
                        break;
                    case "3":
                        readJsonFormat(); // invoke method
                        break;
                }
            }
        } catch (Exception e){
            System.out.println("Error: "+e);
        }

    }

    // ShowMenu
    private static void showMenu(){
        System.out.println("Menu");
        System.out.println("1. Add Data Worker");
        System.out.println("2. Create JSON Format and Write to File .txt");
        System.out.println("3. Read JSON Format from File .txt");
        System.out.println("4. Exit");
    }

    // Create Data Karyawan
    private static void addKaryawan(){
        int id;
        String nama = "";
        int gaji;
        String pilihan = "";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Menu add berdasarkan jabatan ");
            System.out.println("1. Manager ");
            System.out.println("2. Staff ");
            System.out.print("Pilih add jabatan             : ");
            pilihan = br.readLine();

            switch (pilihan) {
                case "1":
                    System.out.print("Masukan Id                    : ");
                    id = Integer.parseInt(br.readLine());
                    for (int i=0;i<dataManager.size();i++){
                        if (dataManager.get(i).getId()==id){
                            System.out.println("Maaf, id sudah terdaftar pada sistem");
                            System.out.println("Mohon Masukan Id lainnya: ");
                            id = Integer.parseInt(br.readLine());
                        }
                    }
                    System.out.print("Masukan Nama                  : ");
                    nama = br.readLine();
                    System.out.print("Masukkan No.Telepon           : ");
                    String telp = br.readLine();
                    System.out.print("Masukan Gaji Pokok            : ");
                    gaji = Integer.parseInt(br.readLine());
                    Manager manager = new Manager(id, nama, null, gaji, telp);
                    manager.setId(id);
                    manager.setNama(nama);
                    manager.setGaji(gaji);
                    // manager.setEntertainment(entertainment);
                    dataManager.add(manager);
                    System.out.println("Success Add!!");
                    showMenu();
                    break;

                case "2":
                    System.out.print("Masukkan Id          : ");
                    id = Integer.parseInt(br.readLine());
                    for (int i=0;i<dataStaff.size();i++){
                        if (dataStaff.get(i).getId()==id){
                            System.out.println("Maaf, id sudah terdaftar pada sistem");
                            System.out.println("Mohon Masukan Id lainnya: ");
                            id = Integer.parseInt(br.readLine());
                        }
                    }
                    System.out.print("Masukkan Nama        : ");
                    nama = br.readLine();
                    System.out.print("Masukkan Email       : ");
                    String email = br.readLine();
                    System.out.print("Masukkan Gaji Pokok  : ");
                    gaji = Integer.parseInt(br.readLine());
                    Staff staff = new Staff(id, nama, null, gaji, email);
                    staff.setId(id);
                    staff.setNama(nama);
                    staff.setGaji(gaji);
                    dataStaff.add(staff);
                    System.out.println("Success Add!!");
                    showMenu();
                    break;
            }
        } catch (Exception e){
            System.out.println("Error on addKaryawan: "+e);
            showMenu();
        }
    }

    // Convert to JSON
    private  static  void dataToJson() {
        System.out.println("Convert Data to JSON");
        //Object Array Manager
        JSONArray arrManager = new JSONArray();
        JSONObject myManager = new JSONObject();
        for(Manager manager: dataManager) {
            JSONObject objManager = new JSONObject();
            objManager.put("id", manager.getId());
            objManager.put("nama", manager.getNama());
            objManager.put("jabatan", manager.getJabatan());
            objManager.put("gaji", manager.getGaji());
            objManager.put("tunjangan transport", manager.getTunjanganTransport());
            objManager.put("tunjangan entertainment", manager.getTunjanganEntertainment());
            objManager.put("no telp", manager.getNoTelp().get(0));

            arrManager.add(objManager);
            myManager.put("manager", arrManager);
        }
            //Object Array Staff
            JSONArray arrStaff = new JSONArray();
            JSONObject myStaff = new JSONObject();
            for(Staff staff: dataStaff){
                JSONObject objStaff = new JSONObject();
                objStaff.put("id", staff.getId());
                objStaff.put("nama", staff.getNama());
                objStaff.put("jabatan", staff.getJabatan());
                objStaff.put("gaji", staff.getGaji());
                objStaff.put("tunjangan makan", staff.getTunjanganMakan());
                objStaff.put("email", staff.getEmail().get(0));

                arrStaff.add(objStaff);
                myStaff.put("staff", arrStaff);
        }
        try {
            FileWriter fw1 = new FileWriter("Manager.txt");
            BufferedWriter bw1 =  new BufferedWriter(fw1);
            FileWriter fw2 = new FileWriter("Staff.txt");
            BufferedWriter bw2 =  new BufferedWriter(fw2);
            String jsonText1 = JSONValue.toJSONString(myManager);
            System.out.println(jsonText1);
            String jsonText2 = JSONValue.toJSONString(myStaff);
            System.out.println(jsonText2);
            bw1.write(jsonText1);
            bw1.close();
            fw1.close();
            bw2.write(jsonText2);
            bw2.close();
            fw2.close();
        } catch (Exception e) {
            System.out.println("Error on ConvertJSON : "+ e);
        }
    }

    //Read JSON Format
    private  static  void readJsonFormat(){
        String file = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Input File Name : ");
            String filename = br.readLine();
            FileReader fr = new FileReader("C:\\Users\\btpnshifted\\IdeaProjects\\Day9\\Manager.txt");
            BufferedReader brf = new BufferedReader(fr);
            int i;
            while ((i = brf.read()) != -1) {
                file += (char) i;
            }
            Object obj = JSONValue.parse(file);
            JSONObject jsonObject = (JSONObject) obj;
            if(filename.equals("Manager.txt")) {
                JSONArray elm = (JSONArray) jsonObject.get("manager");
                for (int j = 0, size = elm.size(); j < size; j++) {
                    JSONObject objectInArray = (JSONObject)elm.get(j);
                    System.out.println("id                      : " + objectInArray.get("id"));
                    System.out.println("nama                    : " + objectInArray.get("nama"));
                    System.out.println("jabatan                 : " + objectInArray.get("jabatan"));
                    System.out.println("gaji                    : " + objectInArray.get("gaji"));
                    System.out.println("notelp                  : "+objectInArray.get("no telp"));
                    System.out.println("tunjangan transport     : "+objectInArray.get("tunjangan transport"));
                    System.out.println("tunjangan entertainment : "+objectInArray.get("tunjangan entertainment")+"\n");
                }
            } else {
                JSONArray elms = (JSONArray) jsonObject.get("staff");
                for (int j = 0, size = elms.size(); j < size; j++) {
                    JSONObject objectInArray = (JSONObject)elms.get(j);
                    System.out.println("id              : "+objectInArray.get("id"));
                    System.out.println("nama            : "+objectInArray.get("nama"));
                    System.out.println("jabatan         : "+objectInArray.get("jabatan"));
                    System.out.println("gaji            : "+objectInArray.get("gaji"));
                    System.out.println("email           : "+objectInArray.get("email"));
                    System.out.println("tunjangan makan : "+objectInArray.get("tunjangan makan"));
                }

                //Close
                fr.close();
                brf.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//
//    public static void bubbleSortManager(ArrayList<Manager> list)
//    {
//        for (int i = 0; i < list.size(); i++)
//            for (int j = 0; j < list.size() - 1; j++)
//            {
//                if (list.get(j).compareTo(list.get(j + 1)) > 0)
//                {
//                    Collections.swap(list, j, j + 1);
//                }
//            }
//    }
//
//    // Tampilkan Data Karyawan Staff
//    private static void readKaryawanManager(){
//        bubbleSortStaff(dataStaff);
//        try {
//            int i=1;
//            String leftAlignFormat = "| %-4d | %-4d | %-15s | %-11s | %-10d  | %-10d  | %-12d  | %-12s  |%n"; //Inisialisasi Format Table
//            System.out.format("+--------------------------------------------------------------------------------------------------------+%n");
//            System.out.format("| No   | Id   | Nama            | Jabatan     | Gaji Pokok  | Transport  | Entertainment | No.Telp       | %n");
//            System.out.format("+--------------------------------------------------------------------------------------------------------+%n");
//            for (Manager obj: dataManager) { //Looping Data Manager
//                System.out.format(leftAlignFormat, i , obj.getId(),obj.getNama(),obj.getJabatan(),obj.getGaji(),obj.getTunjanganTransport(),obj.getTunjanganEntertainment(),obj.getNoTelp().get(0));
//                i++;
//            }
//            System.out.format("+--------------------------------------------------------------------------------------------------------+%n");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public static void bubbleSortStaff(ArrayList<Staff> list)
//    {
//        for (int i = 0; i < list.size(); i++)
//            for (int j = 0; j < list.size() - 1; j++)
//            {
//                if (list.get(j).compareTo(list.get(j + 1)) > 0)
//                {
//                    Collections.swap(list, j, j + 1);
//                }
//            }
//    }
//
//    // Tampilkan Data Karyawan Staff
//    private static void readKaryawanStaff(){
//        bubbleSortStaff(dataStaff);
//        try {
//            int i=1;
//            String leftAlignFormat = "| %-4d | %-4d | %-15s | %-11s | %-10d  | %-10d  | %-15s %n"; //Inisialisasi Format Table
//            System.out.format("+-------------------------------------------------------------------------------------------+%n");
//            System.out.format("| No   | Id   | Nama            | Jabatan     | Gaji Pokok  | Uang Makan  | Emails          |%n");
//            System.out.format("+-------------------------------------------------------------------------------------------+%n");
//            for (Staff obj: dataStaff) { //Looping Data Staff
//                System.out.format(leftAlignFormat, i , obj.getId(),obj.getNama(),obj.getJabatan(),obj.getGaji(),obj.getTunjanganMakan(),obj.getEmail().get(0));
//                i++;
//            }
//            System.out.format("+-------------------------------------------------------------------------------------------+%n");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    //Export ke File .txt
//    private static void exportKaryawan(){
//        try {
//            // Inisialisasi BufferedWriter yg mempunyai parameter fileWriter
//            BufferedWriter br = new BufferedWriter(new FileWriter("Karyawan.txt"));
//            int i=1;
//            String leftAlignFormat = "| %-4d | %-4d | %-10s | %-10s |%n";
//            br.write(String.format("+---------------------------------------+%n"));
//            br.write(String.format("| No   | Id   | Nama       | Jabatan    |%n"));
//            br.write(String.format("+---------------------------------------+%n"));
//            for (Staff obj: dataStaff) { // Looping Data Staff
//                br.write(String.format(leftAlignFormat, i , obj.getId(),obj.getNama(),obj.getJabatan()));
//                i++;
//            }
//            for (Manager obj: dataManager) { // Looping Data Manager
//                br.write(String.format(leftAlignFormat, i , obj.getId(),obj.getNama(),obj.getJabatan()));
//                i++;
//            }
//            br.write(String.format("+------------------------------------------------------+%n"));
//            br.close();
//            System.out.println("Sukses Export file!!");
//            showMenu();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

}
