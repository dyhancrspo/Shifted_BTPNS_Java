package com.tugas1;

public abstract class Worker implements Comparable{
    int id;
    String nama;
    int absensi = 20;
    String jabatan;
    int gaji;
    int totalGaji;

    public abstract void setId(int id);

    public abstract int getId();

    public abstract void setNama(String nama);

    public abstract String getNama();

    public abstract void setJabatan(String jabatan);

    public abstract String getJabatan();

    public abstract void setGaji(int gaji);

    public abstract int getGaji();


    @Override
    public abstract int compareTo(Object o);
}