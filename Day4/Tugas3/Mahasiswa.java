class Mahasiswa implements Comparable {
    private int id;
    private String nama;
    private int nilai;

    public Mahasiswa(){
    }

    int getId() {
        return id;
    }

    void setId(int id){
        this.id = id;
    }

    String getNama() {
    return nama;
    }

    void setNama(String nama){
        this.nama = nama;
    }

    int getNilai() {
        return nilai;
    }

    void setNilai(int nilai){
        this.nilai = nilai;
    }

    @Override
    public int compareTo(Object o) {
        int compare= ((Mahasiswa)o).getId();
        return this.id-compare;
    }
}
