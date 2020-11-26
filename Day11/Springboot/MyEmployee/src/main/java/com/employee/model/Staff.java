package com.employee.model;

import java.util.*;

// Class Staff mengextends class Worker
public class Staff extends Worker{
    int tunjanganMakan;
    String emailsStaff;

    public Staff(){

    }

//        public Staff() {
//            this.id = counter.incrementAndGet();
//        }

//    //Constructor Staff
//    Staff(int id, String nama, int absensi, String jabatan, int gaji, int tunjanganPulsa, int tunjanganMakan, String emailsStaff) {
////        this.id = counter.incrementAndGet();
//        this.id = id;
//        this.nama = nama;
//        this.absensi = absensi;
//        this.jabatan = "Staff";
//        this.gaji = gaji;
//        this.tunjanganMakan = tunjanganMakan;
//        this.tunjanganPulsa = tunjanganPulsa;
//        this.emailsStaff = emailsStaff;
//    }


    // -- Implementasi Method Abstract yang sudah di extends dari Abstract Class Worker -- //
    //Setter ID
    public void setId(long id) {
        this.id = id;
    }

    //Getter ID
    public long getId() {
        return id;
    }

    //Setter Nama
    public void setNama(String nama) {
            this.nama = nama;
    }

    //Getter Nama
    public String getNama() {
        return nama;
    }

    //Setter Jabatan
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    //Getter Jabatan
    public String getJabatan() {
        return jabatan;
    }

    //Setter Gaji
    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    //Getter Gaji
    public int getGaji() {
        return gaji;
    }

    //Setter TunjangaPulsa
    public void setTunjanganPulsa(int tunjanganPulsa) {
        this.tunjanganPulsa = tunjanganPulsa;
    }

    //Getter TunjanganPulsa
    public int getTunjanganPulsa() {
        return tunjanganPulsa;
    }

    //Setter TunjanganMakan
    public void setTunjanganMakan(int tunjanganMakan) {
        this.tunjanganMakan = tunjanganMakan;
    }

    //Getter TunjanganMakan
    public int getTunjanganMakan() {
        return tunjanganMakan;
    }

    //Setter Absensi
    public void setAbsensi(int absensi) {
        this.absensi = absensi;
    }

    //Getter Absensi
    public int getAbsensi() {
        return absensi;
    }

    public void tambahAbsensi(int id){
        if (id == this.id){
            this.absensi = this.absensi + 1;
            System.out.println("Absensi Berhasil Tambah!!!");
        } else {
            System.out.println("Maaf, ID Tidak terdaftar");
        }
    }

    public void hitungTunjanganMakan(int absensi){
        this.tunjanganMakan = 100000 * this.absensi;
    }

    //Getter  Email
    public void setEmailsStaff(String emailsStaff) {
        this.emailsStaff = emailsStaff;
    }

    //Getter Email
    public String getEmailsStaff() {
        return emailsStaff;
    }


    @Override
    public String toString() {
        return "Staff [id=" + id + ", name=" + nama + ", jabatan=" + jabatan
                + ", absensi=" + absensi + ", gaji=" + gaji + ", tunjanganPulsa=" + tunjanganPulsa +  ", tunjanganMakan=" + tunjanganMakan + ", emailsStaff=" + emailsStaff + "]";
    }

}