package com.company;
import java.sql.*;
class FetchRecord{
    public static void main(String args[])throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/sonoo?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","root");
            //here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from emp");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

