package org.example.model;

import java.util.Objects;

public class Mahasiswa {
    long id;
    String fullname;
    String address;
    String status;
    int absensi;

    public Mahasiswa(long idMhs, String fullname, String address, String status, int absensi){
        setId(idMhs);
        setFullname(fullname);
        setAddress(address);
        setStatus(status);
        setAbsensi(absensi);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAbsensi() {
        return absensi;
    }

    public void setAbsensi(int absensi) {
        this.absensi = absensi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Mahasiswa mahasiswa = (Mahasiswa) o;
        return id == mahasiswa.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", absensi=" + absensi +
                '}';
    }
}
