package org.example.database.entities;

import javax.persistence.*;

@Entity
@Table(name = "my_mhs")
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String fullname;
    String address;
    String status;
    int absensi;

    public Mahasiswa(){}

    public Mahasiswa(String fullname, String address, String status, int absensi){
        setFullname(fullname);
        setAddress(address);
        setStatus(status);
        setAbsensi(absensi);
    }

    //Gettersetter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + absensi;
        return result;
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
