package org.example.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.example.model.Staff;
import org.example.util.ConnectionManager;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

@Service("staffService")
public class StaffServiceImpl implements StaffService {

    public static HashMap<Long, Staff> staffs = new HashMap<>();
    public static HashMap<String, Long> nameStaff = new HashMap<>();
    public static Connection con;
    public static Statement stmt;
    public static ConnectionManager myConnection = new ConnectionManager();

    // -------------------------- Retrieve All Data Staff --------------------------
    public ArrayList<Staff> findAllStaff() {
        ArrayList<Staff> myStaff = new ArrayList<Staff>();
        try {
            con = myConnection.connect();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM staff");
            while (rs.next()) {
                Staff stf = new Staff();
                stf.setIDKaryawan(rs.getLong(1));
                stf.setNama(rs.getString(2));
                stf.setEmail(rs.getString(3));
                stf.setTunjanganPulsa(rs.getInt(4));
                stf.setTunjanganMakan(rs.getInt(5));
                stf.setGaji(rs.getInt(6));
                stf.setAbsensi(rs.getInt(7));
                myStaff.add(stf);
            }
        } catch (Exception e) {
            System.out.println("ERROR on findAllStaff : " + e);
        }
        myConnection.disconnect();
        return myStaff;
    }

    // -------------------------- Retrieve Staff by Id --------------------------
    public Staff findById(long IDKaryawan) {
        Staff stf = new Staff();
        try {
            con = myConnection.connect();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM staff WHERE id = '"+IDKaryawan+"'");
            while (rs.next()) {
                stf.setIDKaryawan(rs.getLong(1));
                stf.setNama(rs.getString(2));
                stf.setEmail(rs.getString(3));
                stf.setTunjanganPulsa(rs.getInt(4));
                stf.setTunjanganMakan(rs.getInt(5));
                stf.setGaji(rs.getInt(6));
                stf.setAbsensi(rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println("ERROR on findById : " + e);
        }
        myConnection.disconnect();
        return stf;
    }

    // -------------------------- Find Staff by Name --------------------------
    public Staff findByName(String nama) {
        if (nameStaff.get(nama) != null) {
            return staffs.get(nameStaff.get(nama));
        }
        return null;
    }

    // -------------------------- Create Staff --------------------------
    public void saveStaff(Staff staff) {
        synchronized (this) {
            try {
                con = myConnection.connect();
                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO staff VALUES (null, " +
                        "'"+staff.getNama()+"', " +
                        "'"+staff.getEmail()+"', " +
                        "'"+staff.getTunjanganPulsa()+"', " +
                        "'"+staff.getTunjanganMakan()+"', " +
                        "'"+staff.getGaji()+"'," +
                        "'"+staff.getAbsensi()+"')");
            } catch (Exception e) {
                System.out.println("ERROR on saveStaff : " + e);
            }
        }
        myConnection.disconnect();
    }

    // -------------------------- Uodate Data Staff --------------------------
    public void updateStaff(Staff staff) {
        synchronized (this) {
            try {
                con = myConnection.connect();
                stmt = con.createStatement();
                stmt.executeUpdate("UPDATE staff SET " +
                        "nama = '"+staff.getNama()+"', " +
                        "email = '"+staff.getEmail()+"', " +
                        "tunjanganPulsa = '"+staff.getTunjanganPulsa()+"', " +
                        "tunjanganMakan = '"+staff.getTunjanganMakan()+"', " +
                        "gajiPokok = '"+staff.getGaji()+"'," +
                        "absensi = '"+staff.getAbsensi()+"'" +
                        "WHERE id = '"+staff.getIDKaryawan()+"'");
            } catch (Exception e) {
                System.out.println("ERROR on updateStaffById : " + e);
            }
            myConnection.disconnect();
        }
    }

    // -------------------------- Delete Staff by id --------------------------
    public void deletStaffById(long IDKaryawan) {
        synchronized (this) {
            try {
                con = myConnection.connect();
                stmt = con.createStatement();
                stmt.executeUpdate("DELETE FROM staff WHERE id = '"+IDKaryawan+"' ");
            } catch (Exception e) {
                System.out.println("ERROR on deleteStaffById : " + e);
            }
            myConnection.disconnect();
        }
    }

    // -------------------------- Delete All Staff-------------------------
    public void deletAll() {
        try {
            con = myConnection.connect();
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM staff");
        } catch (Exception e) {
            System.out.println("ERROR on deleteAll :  " + e);
        }
        myConnection.disconnect();
    }

    // -------------------------- Check isStaffExisrtsad --------------------------
    public boolean isStaffExist(Staff staff) {
        return findByName(staff.getNama()) != null;
    }
}


