package com.employee.service;

import com.employee.model.Staff;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.employee.controller.RestApiController;

import java.sql.DriverManager;
import java.util.*;
import java.sql.*;

@Service("staffService")
//Class StaffServiceImpl mengimplementasikan Interface Class StaffService
public class StaffServiceImpl implements StaffService {

    static Connection con; // inisialisasi
    static Statement stmt; //inisialisasi

    //HashMap untuk menyimpan data dari Input Api
    private static HashMap<Integer, Staff> staffs = new HashMap<>();
    private static HashMap <String, Integer> idNameHashMap = new HashMap<>();
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    //Retrieve semua data
    public List<Staff> findAllStaffs() {
        Connect();
        try {
            String query = "SELECT * FROM staff";
            ResultSet rs = stmt.executeQuery(query);
            String format = "| %-2d | %-20s | %-10s | %-7d | %-7d      | %-6d      | %-6d    | %-20s |%n";
            System.out.printf("+----+----------------------+------------+---------+--------------+-------------+-----------+----------------------+%n");
            System.out.printf("| ID | Fullname             | Jabatan    | Absensi | Gaji         | Tnj.Pulsa   | Tnj.Makan | Email                |%n");
            System.out.printf("+----+----------------------+------------+---------+--------------+-------------+-----------+----------------------+%n");
            while (rs.next()){
                System.out.printf(format, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
            }
            System.out.printf("+----+----------------------+------------+---------+--------------+-------------+-----------+----------------------+%n");
        }catch (Exception e){
            System.out.println(e);
        }
        return new ArrayList<>(staffs.values());
    }

    //Retrieve data sesuai target id
    public Staff findById(long id) {
        try {
            Connect();
            ResultSet rs = stmt.executeQuery("SELECT * FROM staff WHERE id='" + id + "'");
            while (rs.next())
                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getString(4) + " " +
                        rs.getString(5) + " " +
                        rs.getString(6) + " " +
                        rs.getString(7) + " " +
                        rs.getString(8));
        }catch (Exception e){
            System.out.println(e);
        }
        return staffs.get(id);
    }

    //Retrieve data sesuai target nama
    public Staff findByName(String nama) {
        if(idNameHashMap.get(nama) != null) { // jika target nama != null maka akan mereturn nama
             return staffs.get(idNameHashMap.get(nama));
        }
        return null; // Jika target nama =  null, akan return null juga
    }

    //Save data staff
    public void saveStaff(Staff staff) {
    //    synchronized (this) {    //  Critical section synchronized
            try {
        Connect();
                String query = "INSERT INTO staff(id, nama, jabatan, absensi, gaji, tunjanganPulsa, tunjanganMakan, emailsStaff)" +
                        " VALUES('" +
                        staff.getId() + "','" +
                        staff.getNama() + "','" +
                        staff.getJabatan() + "','" +
                        staff.getAbsensi() + "','" +
                        staff.getGaji() + "','" +
                        staff.getTunjanganPulsa() + "','" +
                        staff.getTunjanganMakan() + "','" +
                        staff.getEmailsStaff() + "')";

                stmt.executeUpdate(query);
                System.out.println("Input Data success!");
                con.close();
            } catch (Exception e){
                System.out.println("Error on saveStaff : " + e);
                System.out.println("Upss, failed to input data!");
            }
//        }
    }

    //Update Staff
    public void updateStaff(Staff staff) {
            Connect();
    //        synchronized (this) {    //  Critical section synchronized
                try {
                String query = "UPDATE staff SET " +
                        "nama = '" + staff.getNama() +  "','" +
                        "jabatan = '" + staff.getJabatan() +  "','" +
                        "absensi = '" + staff.getAbsensi() +  "','" +
                        "gaji = '" + staff.getGaji() +  "','" +
                        "tunjanganPulsa = '" + staff.getTunjanganPulsa() +  "','" +
                        "tunjanganMakan = '" + staff.getTunjanganMakan() +  "','" +
                        "emailsStaff = '" + staff.getEmailsStaff() + "";
                    stmt.executeUpdate(query);
                    System.out.println("Sukses Update Data!");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Gagal Update Data!");
                }
//        }
    }

    //Delete berdasarkan target id
    public void deleteStaffById(long id) {
    //    synchronized (this) {    //  Critical section synchronized
            Connect();
            idNameHashMap.remove(staffs.get(id).getNama());
            staffs.remove(id);
            try {
                String query = "DELETE FROM staff WHERE id = " + staffs.get(id)  + "";
                stmt.executeUpdate(query);
                System.out.println("Data deleted!");
                con.close();
            } catch (Exception e){
                System.out.println("Upss, data cannot deleted!");
                System.out.println("Error on saveStaff : " + e);
            }
    //    }
    }

    //Check isStaffExist
    public boolean isStaffExist(Staff staff) {
        return findByName(staff.getNama()) != null;
    }

    //Delete all data
    public void deleteAllStaffs() {
        Connect();
            try {
                String query = "DELETE FROM staff";
                stmt.executeUpdate(query);
                System.out.println("Data deleted!");
                con.close();
            } catch (Exception e){
                System.out.println("Error on saveStaff : " + e);
                System.out.println("Upss, data cannot deleted!");
            }
    }


    //Configure koneksi Database
    public static void Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myemployee?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","mypass");
            stmt = con.createStatement();
            System.out.println("Connected to Database");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
