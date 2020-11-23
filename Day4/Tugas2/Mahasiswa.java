public class Mahasiswa {
    int id;  
    String nama; 
	  int nilai; 

     // Constructors
	Mahasiswa(int id, String nama, int nilai){
        this.id = id;
        this.nama = nama;
        this.nilai = nilai;
   }


  public void setId(int id) {
    this.id = id;
  }

    // getId Method Declaration
    int getId() {
		return id;
  }
  
  public void setNama(String nama) {
    this.nama = nama; 
  }

    // getNama Method Declaration
    String getNama() {
		return nama;
  }
  
  public void setNilai(int nilai) {
    this.nilai = nilai; 
  }

    // getNilai Method Declaration
    int getNilai() {
		return nilai;
    }    

    public int compareTo(Mahasiswa mhs) {
      return this.id - mhs.getId();
  }


    // Print
    void printStates() {
        System.out.println("Data Mahasiswa : " + getId() + " - " + getNama() + " - " + getNilai());
        System.out.println("");
    }
}
