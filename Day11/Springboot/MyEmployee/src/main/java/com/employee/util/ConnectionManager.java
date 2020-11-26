package com.employee.util;

import java.sql.*;

public class ConnectionManager {
    static Connection con; // inisialisasi
    static Statement stmt; //inisialisasi

    //Configure koneksi Database
    public Connection Connect() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myemployee?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","mypass");
            stmt = con.createStatement();
            System.out.println("Connected to Database");
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
}
