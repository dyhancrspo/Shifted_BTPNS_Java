package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    public Connection con;
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String db = "jdbc:mysql://localhost:3306/newemployee?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC";
    public String uname = "root";
    public String pass = "mypass";

    public Connection connect() {
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(db, uname, pass);

        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
        return con;
    }

    public void disconnect() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
}
