package com.tugas1;

import java.util.ArrayList;

public class Manager extends Worker{
    String jabatan;
    int tunjanganTransport = 3000000;
    int tunjanganEntertainment = 1500000;
    ArrayList<String> noTelpManager = new ArrayList<>();


    Manager(int id, String nama, String jabatan, int gaji, String notelp ) {
        this.id = id;
        this.nama = nama;
        this.jabatan = "Manager";
        this.gaji = gaji;
        noTelpManager.add(notelp);
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


//    public int getAbsensi() {
//        return absensi;
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

    public void setTunjanganEntertainment(int tunjanganEntertainment) {
        this.tunjanganEntertainment = tunjanganEntertainment;
    }

    public int getTunjanganEntertainment(){
        return tunjanganEntertainment;
    }


    public void setTunjanganTransport(int tunjanganTransport) {
        this.tunjanganTransport = tunjanganTransport;
    }

    public int getTunjanganTransport(){
        return tunjanganTransport;
    }

    ArrayList<String> getNoTelp(){
        return noTelpManager;
    }

//    public void setTunjanganTransport(int absensi){
//        this.tunjanganTransport = absensi * 50000;
//    }
//
//    public int getTunjanganTransport(){
//        return tunjanganTransport;
//    }
//
//    public void setTunjanganEntertainment(int entertainment){
//        this.tunjanganEntertainment = entertainment * 500000;
//    }
//
//    public int getTunjanganEntertainment(){
//        return tunjanganEntertainment;
//    }
//
//    public void setTotalGaji(int gaji, int tunjanganTransport, int tunjanganEntertainment){
//        this.totalGaji = gaji + tunjanganTransport + tunjanganEntertainment ;
//    }
//
//    public int getTotalGaji(){
//        return totalGaji;
//    }

}
