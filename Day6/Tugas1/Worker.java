public class Worker implements Comparable{
    int id;
    String nama;
    int absensi;
    String jabatan;
    int absensiAkhir;
    
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
  
   public void setAbsensi(int absensi) {
        this.absensi = absensi;
    }

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

   @Override
   public int compareTo(Object o) {
       int compare= ((Worker)o).getId();
       return this.id-compare;
   }

}