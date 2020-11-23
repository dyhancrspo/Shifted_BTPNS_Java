public class Luas {

    public static void main(String[] args) {
       int s = 4;
       double r = 9;
       int a = 2;
       int t = 5;
       int day = 2 ; //Deklarasi Integer Variable day
       int month = 12 ; //Deklarasi Integer Variable month
       int year = 1997 ; //Deklarasi Integer Variable year

     

       //Luas Persegi 
       int luas1 = luasBangun(s);       
       // Luas Lingkaran
       double luas2 = luasBangun(r);
       // Luas Segitiga
       double luas3 = luasBangun(a, t);
      //  Menghitung Umur
      int umur = getUmur(day,month,year);

       System.out.println("Luas Persegi   = " + luas1);
       System.out.println("Luas Lingkaran = " + luas2);
       System.out.println("Luas Segitiga  = " + luas3);
       System.out.println("Umur Saya      = " + umur);
       System.out.println("Tanggal Lahir  = " + day + " - " + month + " - " + year);
    }
 
    // Persegi
    public static int luasBangun(int n1) {
       int hasil;
       hasil = n1 * n1;
       return hasil; 
    }
    
    // Segitiga
    public static double luasBangun(double n1, double n2) {
       double hasil;
       hasil = (n1 * n2) / 2;
       return hasil; 
    }
    
    // Lingkaran
    public static double luasBangun(double n1) {
       double hasil;
       hasil = 3.14 * (n1 * n1);
       return hasil; 
    }

    public static int getUmur(int n1, int n2, int n3){
        // Proses pengurangan 2020 (tahun sekarang) dengan value dari variable year 
        int hasil;
        hasil= 2020 - n3; 
        return hasil;
        // mereturn hasil perngurangan kedalam variable umur
    } 

}

 