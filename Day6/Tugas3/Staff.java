public class Staff extends Worker{
    String jabatan;
    int tunjanganMakan;

    Staff(int id, String nama, String jabatan, int gaji, int tunjanganMakan) {
        this.id = id;
        this.nama = nama;
        this.jabatan = "Staff";
        this.gaji = gaji;
        this.tunjanganMakan = tunjanganMakan;
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
  
//    public void setAbsensi(int absensi) {
//         this.absensi = absensi;
//     }

    public int getAbsensi() {
        return this.absensi;
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

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public int getGaji(){
        return gaji;
    }
    
    public void setTunjanganMakan(int absensi){
        this.tunjanganMakan = absensi * 20000;
    }
    
    public int getTunjanganMakan(){
        return tunjanganMakan;
    }
    
    public void setTotalGaji(int gaji, int tunjanganMakan){
        this.totalGaji = gaji + tunjanganMakan;
    }
    
    public int getTotalGaji(){
        return totalGaji;
    }

}