public class Siswa {
    String nama; // Deklarasi String Variable nama
    String gender;  // Deklarasi String Variable gender
    int nilai;  // Deklarasi Integer Variable nilai
    int umur; // Deklarasi Integer Variable umur
    String grade;  // Deklarasi String Variable gender
    int day; // Deklarasi Integer Variable day
    int month; // Deklarasi Integer Variable month
    int year; // Deklarasi Integer Variable year

    // Constructors
	public Siswa(String nama, String gender, int nilai, int day, int month,int year){
        this.nama = nama;
        this.gender = gender;
        this.nilai = nilai;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    


// Grade
public String getGrade(int nilai){  // arguments/parameter (int nilai) diambil berdasarkan variable nilai
    if (nilai >= 80) {
        return grade = "A"; //Mereturn variable grade yang barusaja di inisialisasi
        } else if (nilai >= 70) { 
            return grade = "B"; //Mereturn variable grade yang barusaja di inisialisasi
        } else if (nilai >= 60) {
            return grade = "C"; //Mereturn variable grade yang barusaja di inisialisasi
        } else if (nilai >= 50) {
            return grade = "D"; //Mereturn variable grade yang barusaja di inisialisasi
        } else {
            return grade = "F"; //Mereturn variable grade yang barusaja di inisialisasi
        }
   }

// Umur
public int getUmur(){
    // Proses pengurangan 2020 (tahun sekarang) dengan value dari variable year 
    return umur = 2020 - year; 
    // mereturn hasil perngurangan kedalam variable umur
} 

// Format Tanggal
public String formatToString() {
    String changeMonthToString; // Deklarasi Local Variable String changeMonthToString
    switch (month) { // Switch Case berdasarkan value dari month
        case 1:  changeMonthToString = "Januari";
                 break;
        case 2:  changeMonthToString = "Februari";
                 break;
        case 3:  changeMonthToString = "Maret";
                 break;
        case 4:  changeMonthToString = "April";
                 break;
        case 5:  changeMonthToString = "Mei";
                 break;
        case 6:  changeMonthToString = "Juni";
                 break;
        case 7:  changeMonthToString = "Juli";
                 break;
        case 8:  changeMonthToString = "Agustus";
                 break;
        case 9:  changeMonthToString = "September";
                 break;
        case 10: changeMonthToString = "Oktober";
                 break;
        case 11: changeMonthToString = "November";
                 break;
        case 12: changeMonthToString = "Desember";
                 break;
        default: changeMonthToString = "Invalid month";
                 break;
    }
    // Menginisialisasi String Variable makeDateString
    String makeDateString = changeMonthToString + " " + day +", " + year;
    return makeDateString; // mereturn variable makeDateString
}


// Looping Umur (History Umur)
public void historyUmur(int year) {
    int count = year; // inisialisasi local variable count berdasarkan variable year
    int tahun = 0; //inisialisasi local variable tahun
    for (int i = count; i <= 2020; i++) { // Looping For 
        System.out.println("Pada tahun " + count + " berumur : " + tahun + " tahun.");
        count++; // iterasi count
        tahun++; // iterasi umur
    }
} 

//Method klasifikasi kelas berdasarkan umur
public void classAge(int umur) { // arguments/parameter (int umur) diambil berdasarkan variable umur
    if (umur < 8) {
        System.out.println(nama + " masih KECIL"); // Jika Kondisi Terpenuhi maka melakukan print
    } else  if (umur < 12) {
        System.out.println( nama + " pada saat ini bersekolah di SD"); // Jika Kondisi Terpenuhi maka melakukan print
    } else  if (umur < 15) {
        System.out.println( nama + " pada saat ini bersekolah di SMP"); // Jika Kondisi Terpenuhi maka melakukan print
    } else  if (umur == 15) {
        System.out.println( nama + " pada saat ini bersekolah di tingkat kelas 1 SMA."); // Jika Kondisi Terpenuhi maka melakukan print
    } else if (umur == 16) {
        System.out.println( nama + " pada saat ini bersekolah di tingkat kelas 2 SMA."); // Jika Kondisi Terpenuhi maka melakukan print
    } else if (umur == 17) {
        System.out.println( nama + " pada saat ini bersekolah di tingkat kelas 3 SMA."); // Jika Kondisi Terpenuhi maka melakukan print
    } else if (umur == 18) {
        System.out.println( nama + " pada saat ini Kuliah Tingkat 1."); // Jika Kondisi Terpenuhi maka melakukan print
    } else if (umur == 19) {
        System.out.println( nama + " pada saat ini Kuliah Tingkat 2."); // Jika Kondisi Terpenuhi maka melakukan print
    } else if (umur == 20) {
        System.out.println( nama + " pada saat ini Kuliah Tingkat 3."); // Jika Kondisi Terpenuhi maka melakukan print
    } else if (umur == 21) {
        System.out.println( nama + " pada saat ini Kuliah Tingkat 4."); // Jika Kondisi Terpenuhi maka melakukan print
    } else if (umur == 22) {
        System.out.println( nama + " pada saat ini sudah Lulus dan sedang mencari pekerjaan."); // Jika Kondisi Terpenuhi maka melakukan print
    } else { 
        System.out.println( nama + " pada saat ini sedang bekerja atau menikmati hidup."); // Jika Semua Kondisi Tidak Terpenuhi maka melakukan print
    }
}

// Print 
void printStates() {
        System.out.println("Nama : " + nama + ", Umur:  " + getUmur() +  ", Jenis Kelamin : " + gender );
        System.out.println("Tanggal Lahir : "+ formatToString());
        System.out.println("Nilai : " + nilai + ",  Grade : " + getGrade(nilai) ); 
        historyUmur(year);           
        classAge(umur);       
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
   }
}

