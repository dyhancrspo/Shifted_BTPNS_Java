public class Staff extends Worker{
    private String jabatan;

    Staff(int id, String nama, int absensi, String jabatan) {
        this.id = id;
        this.nama = nama;
        this.absensi = absensi;
        this.jabatan = jabatan;
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

    public  void tambahAbsensi(int id){
        if (id == this.id){
            this.absensi = this.absensi + 1;
            System.out.println("Absensi Berhasil Tambah!!!");
        } else {
            System.out.println("Maaf, ID Tidak terdaftar");
        }
    }

    public int compareTo(Object o) {
        int compare= ((Worker)o).getId();
        return this.id-compare;
    }

}