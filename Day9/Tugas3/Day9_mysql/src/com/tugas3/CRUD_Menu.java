package com.program2;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

public class CRUD_Menu {
    static InputStreamReader r = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(r);
    static Connection con; // inisialisasi
    static Statement stmt; //inisialisasi
    static boolean isLogin = false;

    // main method
    public static void main(String[] args) {
        Connect();//konfigurasi koneksi Datbase

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            //Login
            while(isLogin != true) {
                System.out.println("Login Form");
                System.out.print("Masukan Username  : ");
                String username = br.readLine();
                System.out.print("Masukkan Password : ");
                String password = br.readLine();
                try {
                    doLogin(username, password);
                    if (isLogin) {
                        showMenu();
                    } else {
                        System.out.println("Gagal Login");
                    }
                } catch (Exception e) {
                    System.out.println("Error Login : " + e);
                }
            }
        } catch (Exception err) {
            System.out.println("Error on Main : " + err);
        }
    }

    // Login Validation
    public static void doLogin(String username, String password) throws Exception {

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from user");
        rs.next();

        //RegEx Inisialisasi
        boolean isRegexUsername = Pattern.matches("^(.+)@(.+)$", username);
        boolean isRegexPassword = Pattern.matches("^(?=.*[0-9]).{8,}$", password);

        if(isRegexUsername == true && isRegexPassword == true) {
            if(username.toLowerCase().equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                isLogin = true;
                System.out.println("Login Berhasil");
            } else {
                System.out.println("Email atau Password salah");
            }
        } else {
            System.out.println("Format salah, mohon masukkan username / password kembali lagi !!");
        }
    }

    //Show Menu List
    public static void showMenu(){
        String menu = "";
        while (!menu.equals("99")){
            System.out.println("Menu\n");
            System.out.println("1. Input Data to Database");
            System.out.println("2. Edit Data From Database");
            System.out.println("3. Delete Data From Database");
            System.out.println();
            System.out.print("Input Menu : ");
            try {
                menu = br.readLine();
                switch (Integer.parseInt(menu)){
                    case 1:
                        addDataSiswa();
                        break;
                    case 2:
                        updateDataSiswa();
                        break;
                    case 3:
                        removeDataSiswa();
                        break;
                    default:
                        break;
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        try {
            con.close();//close koneksi
            System.out.println("Disconnected!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //Configure koneksi Database
    public static void Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystudent?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","mypass");
            stmt = con.createStatement();
            System.out.println("Connected to Database");
        }catch(Exception e){ System.out.println(e);}
    }


    //Input record ke dalam Database
    public static void addDataSiswa(){
        try {
            System.out.print("Input Data Baru\n\n");
            System.out.print("Fullname : ");
            String Fullname = br.readLine();
            System.out.print("Address : ");
            String Address = br.readLine();
            System.out.print("Status : ");
            String Status = br.readLine();
            System.out.println("Grades...");
            System.out.print("Physics : ");
            String Physics = br.readLine();
            System.out.print("Calculus : ");
            String Calculus = br.readLine();
            System.out.print("Biologi : ");
            String Biologi = br.readLine();
            String query = "INSERT INTO siswa(fullname, address, status, physics, calculus, biologi) VALUES('" +
                    Fullname + "','" +
                    Address + "','" +
                    Status + "','" +
                    Physics + "','" +
                    Calculus + "','" +
                    Biologi + "')";
            int res = stmt.executeUpdate(query);
            if(res==1){
                System.out.println("Sukses Input Data!");
            }else{
                System.out.println("Gagal Input Data!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //Edit record sesuai id target
    public static void updateDataSiswa(){
        showData();// tampilkan data dalam DB
        try {
            System.out.print("Update Data\n\n");
            System.out.print("Input ID : ");
            String id = br.readLine();
            System.out.print("Fullname : ");
            String Fullname = br.readLine();
            System.out.print("Address : ");
            String Address = br.readLine();
            System.out.print("Status : ");
            String Status = br.readLine();
            System.out.println("Grades...");
            System.out.print("Physics : ");
            String Physics = br.readLine();
            System.out.print("Calculus : ");
            String Calculus = br.readLine();
            System.out.print("Biologi : ");
            String Biologi = br.readLine();
            String query = "UPDATE siswa SET " +
                    "fullname = '" + Fullname + "'," +
                    "address = '" + Address + "'," +
                    "status = '" + Status + "'," +
                    "physics = '" + Physics + "'," +
                    "calculus = '" + Calculus + "'," +
                    "biologi = '" + Biologi + "' " +
                    "WHERE id = '"+ id +"'";
            int res = stmt.executeUpdate(query);
            if(res==1){
                System.out.println("Sukses Update Data!");
            }else{
                System.out.println("Gagal Update Data!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //Menghapus record sesuai id target
    public static void removeDataSiswa(){
        showData();// tampilkan data dalam DB
        try {
            System.out.print("Delete Data\n\n");
            System.out.print("Input ID : ");
            String id = br.readLine();
            String query = "DELETE FROM siswa WHERE id= '" + id + "'";
            int res = stmt.executeUpdate(query);
            if(res==1){
                System.out.println("Data deleted!");
            }else{
                System.out.println("Upss, data cannot deleted!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //Menampilkan semua record dalam Databasea
    public static void showData(){
        try {
            String query = "SELECT * FROM siswa";
            ResultSet rs = stmt.executeQuery(query);
            String format = "| %-2d | %-20s | %-10s | %-10s | %-2d      | %-2d       | %-2d      |%n";
            System.out.printf("+----+----------------------+------------+------------+---------+----------+---------+%n");
            System.out.printf("| ID |  Fullname            |   Adress   |   Status   | Physics | Calculus | Biology |%n");
            System.out.printf("+----+----------------------+------------+------------+---------+----------+---------+%n");
            while (rs.next()){
                System.out.printf(format, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
            }
            System.out.printf("+----+----------------------+------------+------------+---------+----------+---------+%n");
        }catch (Exception e){
            System.out.println(e);
        }
    }


}

