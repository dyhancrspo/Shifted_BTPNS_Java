package org.example.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

// Pertama, buat abstract class Worker
public abstract class Worker {
    static final AtomicLong counter = new AtomicLong();
    long IDKaryawan;
    String nama;
    int tunjanganPulsa;
    int gaji;
    int absensi;

    public abstract long getIDKaryawan();
    public abstract String getNama();
//    public abstract String getEmail();
    public abstract int getTunjanganPulsa();
    public abstract int getGaji();
    public abstract int getAbsensi();
}

// Setelahnya, buat class Staff