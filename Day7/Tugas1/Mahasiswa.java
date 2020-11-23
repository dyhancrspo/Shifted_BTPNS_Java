import java.util.*;

public class Mahasiswa extends Student{

    ArrayList<Double> nilai = new ArrayList<>();

    Mahasiswa(int id, String nama, Double fisika,  Double bahasaInggris,  Double algoritma) {
        this.id = id;
        this.nama = nama;
        nilai.add(fisika);
        nilai.add(bahasaInggris);
        nilai.add(algoritma);
    } 

    ///AbSTARTC
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


    ArrayList<Double> getNilai(){
        return nilai;
    }


    public int compareTo(Object o) {
        int compare= ((Student)o).getId();
        return this.id-compare;
    }

}