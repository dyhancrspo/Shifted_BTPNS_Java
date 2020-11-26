public abstract class Worker implements Comparable{
    int id;
    String nama;
    int absensi;
    String jabatan;
    // int tunjanganPulsa;
    
    public abstract void setId(int id);

    public abstract int getId();
    
    public abstract void setNama(String nama);
    
    public abstract String getNama();

    public abstract void setJabatan(String jabatan);

    public abstract String getJabatan();

    // public abstract void setTunjanganPulsa(String tunjanganPulsa);

    // public abstract String getTunjanganPulsa();
  
    public abstract void setAbsensi(int absensi);

    public abstract int getAbsensi();

    public abstract void tambahAbsensi(int id);

    @Override
    public abstract int compareTo(Object o); 

//     public void setId(int id) { 
//         this.id = id;
//     }

//     public int getId() {
//         return id;
//     }
//     public void setNama(String nama) {
//         this.nama = nama;
//     }

//     public String getNama() {
//         return nama;
//     }

//     public void setJabatan(String jabatan) {
//         this.jabatan = jabatan;
//     }

//     public String getJabatan() {
//         return jabatan;
//     }
  
//    public void setAbsensi(int absensi) {
//         this.absensi = absensi;
//     }

//     public int getAbsensi() {
//         return absensi;
//     }

//     public void tambahAbsensi(int id){
//         if (id == this.id){
//             this.absensi = this.absensi + 1;
//             System.out.println("Absensi Berhasil Tambah!!!");
//         } else {
//             System.out.println("Maaf, ID Tidak terdaftar");
//         }
//     }

//    @Override
//    public int compareTo(Object o) {
//        int compare= ((Worker)o).getId();
//        return this.id-compare;
//    }

}