package com.company;

import java.net.*;
import java.io.*;
import java.util.Properties;
import java.util.regex.Pattern;


public class ProgramClient{

    public static String config;
    public static Socket s;
    public static ServerSocket ss;
    public static DataOutputStream dout;
    public static DataInputStream dis;
    public static String data;
    public static String strClient;
    public static String strServer;
    public static boolean isLogin = false;
    public static BufferedReader brLogin = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw;

    public static void main(String args[])throws Exception{

        try {
            config = args[0];
            // Config  load a properties file
            Properties prop = new Properties();
            prop.load(new FileInputStream(config));

            //Login
            while(isLogin != true) {
                System.out.println("Login Form");
                System.out.print("Masukan Username  : ");
                String username = brLogin.readLine();
                System.out.print("Masukkan Password : ");
                String password = brLogin.readLine();
                try {
                    doLogin(username, password);
                    if(isLogin) {
                        System.out.println("Menunggu terhubung ke Server...");
                        showMenu();
                    } else {
                        System.out.println("Gagal Login");
                    }
                } catch (Exception e) {
                    System.out.println("Error Login : " + e);
                }
            }

            if (isLogin == true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String menu="";  // deklarasi variabel menu untuk case
                try {
                    while (!menu.equals("6")){
                        System.out.println("Pilih Menu yang tersedia : ");
                        menu = br.readLine(); // nilai variabel menu diisi berdasarkan nilai line yang diinput
                        switch (menu){ //switch menu
                            case "1":
                                connectSocket(prop);
                                showMenu();
                                break;
                            case "2":
                                createFile(strServer);
                                showMenu();
                                break;
                            case "3":
                                DataPrint thread1 = new DataPrint(strServer);
                                FTPUpload thread2 = new FTPUpload();
                                CreateAverageFile thread3 = new CreateAverageFile(strServer);
                                thread1.start();
                                thread2.start();
                                thread3.start();
                                // showMenu();
                                break;
                            case "4":
                                System.out.println("Starting to Download file...");
                                FTPDownload Download = new FTPDownload();
                                Download.start();
                                System.out.println("Success...File downloaded!!!");
                                break;
                            case "5":
                                closeSocket(s);
                                showMenu();
                                break;
                        }
                    }
                } catch (Exception e){
                    System.out.println("Error Login at Menu: "+e);
                }
            }  else {
                System.out.println("Gagal terhubung..");
            }
        } catch (Exception e) {
            System.out.println("Error on Main Client: " +e);
        }
    }

    // Show List Menu
    public static void showMenu(){
        System.out.println("\n");
        System.out.println("Menu");
        System.out.println("1. Connect to Socket");
        System.out.println("2. Create FileProcess.txt");
        System.out.println("3. Print, Create File average.txt, and Upload to FTP Server");
        System.out.println("4. Download from FTP Server");
        System.out.println("5. Close All Connection");
        System.out.println("6. Exit");
    }

    // Login Validation
    public static void doLogin(String username, String password) throws Exception {
        //RegEx Inisialisasi
        boolean isRegexUsername = Pattern.matches("^(.+)@(.+)$", username);
        boolean isRegexPassword = Pattern.matches("^(?=.*[0-9]).{8,}$", password);

        if(isRegexUsername && isRegexPassword) {
            if(username.toLowerCase().equals("malih@gmail.com") && password.equals("Rahasia123.")) {
                isLogin = true;
                System.out.println("Login Berhasil");
            } else {
                System.out.println("Email atau Password salah");
            }
        } else {
            System.out.println("Format salah, mohon masukkan username / password kembali lagi !!");
        }
    }

    // Connecting Socket to Server
    public static void connectSocket(Properties prop){
        try {
            s = new Socket(prop.getProperty("server"),Integer.parseInt(prop.getProperty("port")));
            System.out.println("Berhasil Terhubung : " + prop.getProperty("server") + "/" + prop.getProperty("port"));
            dis = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Request Data");
            dout.flush();
        } catch (Exception e) {
            System.out.println("Error on Connect Socket : " + e);
        }
    }

    // Closing Connection
    public static void closeSocket(Socket s){
        try {
            dout.writeUTF("EXIT");
            dout.flush();
            dout.close();
            s.close();
            System.out.println("Disconnected..");
        } catch (Exception e) {
            System.out.println("Error on Close Socket : " + e);
        }
    }


    //Creating file Process
    public static void createFile(String data){
        try {
            bw = new BufferedWriter(new FileWriter("FileProcess.txt"));
            //Looping DATA
            String[] valueData = data.split("\n");
            for(String string : valueData) {
                String[] value = string.split(",");
                for(int j = 0; j < value.length; j++){
                    if(j==0){
                        bw.write("Nama          : " +value[j] + "\n");
                    } else if (j == 1){
                        bw.write("Nilai Fisika  : " +value[j] + "\n");
                    } else if (j == 2){
                        bw.write("Nilai Biologi : " +value[j] + "\n");
                    } else if (j == 3){
                        bw.write("Nilai Kimia   : " +value[j] + "\n\n");
                    }
                }
            }
            System.out.println("Success creating FileProses.txt\n");
            bw.close();
        } catch (Exception e) {
            System.out.println("Error on createFile() : " + e);
        }
    }
}  