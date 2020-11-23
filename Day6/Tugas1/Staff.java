public class Staff extends Worker{
    private String jabatan;

    Staff(int id, String nama, int absensi, String jabatan) {
        this.id = id;
        this.nama = nama;
        this.absensi = absensi;
        this.jabatan = jabatan;
    } 

    public String getJabatan() {
        return jabatan;
    }

    public void tambahAbsensi(int id){
        super.tambahAbsensi(id);
    }
}
