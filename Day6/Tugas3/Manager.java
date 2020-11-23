public class Manager extends Worker{
    String jabatan;
    int tunjanganTransport;
    int tunjanganEntertainment;
    int entertainment;

    Manager(int id, String nama, String jabatan, int gaji) {
        this.id = id;
        this.nama = nama;
        this.jabatan = "Manager";
        this.gaji = gaji;
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

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public int getGaji(){
        return gaji;
    }

    public void setTunjanganTransport(int absensi){
        this.tunjanganTransport = absensi * 50000;
    }
    
    public int getTunjanganTransport(){
        return tunjanganTransport;
    }

    public void setTunjanganEntertainment(int entertainment){
        this.tunjanganEntertainment = entertainment * 500000;
    }
    
    public int getTunjanganEntertainment(){
        return tunjanganEntertainment;
    }
    
    public void setTotalGaji(int gaji, int tunjanganTransport, int tunjanganEntertainment){
        this.totalGaji = gaji + tunjanganTransport + tunjanganEntertainment ;
    }

    public int getTotalGaji(){
        return totalGaji;
    }

}
