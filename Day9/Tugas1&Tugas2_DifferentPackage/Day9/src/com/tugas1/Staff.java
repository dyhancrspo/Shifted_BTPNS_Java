package com.tugas1;

import java.util.*;

public class Staff extends Worker{
    String jabatan;
    int tunjanganMakan = 5000000;
    ArrayList<String> emailsStaff = new ArrayList<>();

    Staff(int id, String nama, String jabatan, int gaji, String email) {
        this.id = id;
        this.nama = nama;
        this.jabatan = "Staff";
        this.gaji = gaji;
        emailsStaff.add(email);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

//    public void setAbsensi(int absensi) {
//         this.absensi = absensi;
//     }
//
//    public int getAbsensi() {
//        return this.absensi;
//    }
//
//    public  void tambahAbsensi(int id){
//        if (id == this.id){
//            this.absensi = this.absensi + 1;
//            System.out.println("Absensi Berhasil Tambah!!!");
//        } else {
//            System.out.println("Maaf, ID Tidak terdaftar");
//        }
//    }

    public int compareTo(Object o) {
        int compare= ((Worker)o).getId();
        return this.id-compare;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public int getGaji(){
        return gaji;
    }

    public void setTunjanganMakan(int tunjanganMakan){
        this.tunjanganMakan = tunjanganMakan;
    }

    public int getTunjanganMakan(){
        return tunjanganMakan;
    }


    ArrayList<String> getEmail(){
        return emailsStaff;
    }


//    public void setTotalGaji(int gaji, int tunjanganMakan){
//        this.totalGaji = gaji + tunjanganMakan;
//    }
//
//    public int getTotalGaji(){
//        return totalGaji;
//    }

}
