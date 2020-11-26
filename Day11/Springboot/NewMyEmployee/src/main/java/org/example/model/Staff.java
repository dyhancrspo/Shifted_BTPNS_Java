package org.example.model;

import java.util.ArrayList;

public class Staff extends Worker {
    int tunjanganMakan;
    String email;


    public long getIDKaryawan() {
        return IDKaryawan;
    }
    public void setIDKaryawan(long IDKaryawan) {

        this.IDKaryawan = IDKaryawan;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getTunjanganPulsa() {
        return tunjanganPulsa;
    }
    public void setTunjanganPulsa(int tunjanganPulsa) {
        this.tunjanganPulsa = tunjanganPulsa;
    }

    public int getGaji() {
        return gaji;
    }
    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public int getTunjanganMakan() {
        return tunjanganMakan;
    }
    public void setTunjanganMakan(int tunjanganMakan) {
        this.tunjanganMakan = tunjanganMakan;
    }

    public int getAbsensi() {
        return absensi;
    }
    public void setAbsensi(int absensi) {
        this.absensi = absensi;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "IDKaryawan=" + IDKaryawan +
                ", nama='" + nama  +
                ", email='" + email  +
                ", gaji=" + gaji +
                ", tunjanganMakan=" + tunjanganMakan +
                ", tunjanganPulsa=" + tunjanganPulsa +
                ", absensi=" + absensi +
                '}';
    }
}
