package com.employee.model;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


//Membuat Abstract Class & Method
public abstract class Worker {
    long id;
    String nama;
    String jabatan;
    int absensi = 20;
    int gaji;
    int tunjanganPulsa;

//    public abstract void setId(int id);

    public abstract long getId();

    public abstract void setNama(String nama);

    public abstract String getNama();

    public abstract void setJabatan(String jabatan);

    public abstract String getJabatan();

     public abstract void setGaji(int gaji);

     public abstract int getGaji();

     public abstract void setTunjanganPulsa(int tunjanganPulsa);

     public abstract int getTunjanganPulsa();

    public abstract void setAbsensi(int absensi);

    public abstract int getAbsensi();

    public abstract void tambahAbsensi(int id);

}
