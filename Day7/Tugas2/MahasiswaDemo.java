import java.util.*;
// import java.util.regex.Pattern;
import java.io.*;

public class MahasiswaDemo extends Thread {
    static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<Mahasiswa>(); //ArrayList Mahasiswa

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        // Threading
        PrintDataMahasiswa thread1 = new PrintDataMahasiswa(dataMahasiswa);
        ExportDataMahasiwa thread2 = new ExportDataMahasiwa(dataMahasiswa);
        //Main Menu
        showMenu(); // Fungsi ShowMenu
        String menu="";  // deklarasi variabel menu untuk case
        try {
            while (!menu.equals("4")){
                System.out.println("Pilih Menu yang tersedia : ");
                menu=br.readLine(); // nilai variabel menu diisi berdasarkan nilai line yang diinput
                switch (menu){ //switch menu
                    case "1":
                        addMahasiswa(); // invoke method addMahasiswa
                        break;
                    case "2":
                        actionMahasiwa(); //invoke method edit/delete Mahasiswa
                        break;
                     case "3":
                        thread1.start();
                        thread2.start();
                        break;
                }
            }
        } catch (Exception e){
            System.out.println("Error Menu: "+e);   
        }
    }
 

    // Show List Menu 
    private static void showMenu(){
        System.out.println("Menu");
        System.out.println("1. Tambah Data Mahasiswa");
        System.out.println("2. Edit / Delete Data Mahasiswa");
        System.out.println("3. Tampilkan Data Mahasiswa");
        System.out.println("4. Keluar");
    }

    //Add Mahasiswa
    private static void addMahasiswa(){
        int id;
        String nama ="";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Masukan Id          : ");
            id = Integer.parseInt(br.readLine());
                for (int i=0;i<dataMahasiswa.size();i++){
                    if (dataMahasiswa.get(i).getId()==id){
                        System.out.println("Maaf, id sudah terdaftar pada sistem");
                        System.out.println("Mohon Masukan Id lainnya: ");
                        id = Integer.parseInt(br.readLine());
                    }
                }
            System.out.print("Masukan Nama         : ");
            nama = br.readLine();
            System.out.print("Nilai Bahasa Inggris : ");
            Double bing = Double.parseDouble(br.readLine());
            System.out.print("Nilai Fisika         : ");
            Double fisika = Double.parseDouble(br.readLine());
            System.out.print("Nilai Algoritma      : ");
            Double algo = Double.parseDouble(br.readLine());
            Mahasiswa mhs = new Mahasiswa(id, nama, fisika, bing, algo);
            mhs.setId(id);
            mhs.setNama(nama);
            dataMahasiswa.add(mhs);
            System.out.println("Success Add!!");
            showMenu();
        } catch (Exception e){
            System.out.println("Error on addMahasiswa: "+e);
            showMenu();
        }
    }

    // Action Mahasiswa
     private static void actionMahasiwa(){
        String pilihan = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Menu Action ");
            System.out.println("1. Edit ");
            System.out.println("2. Delete ");
            System.out.print("Pilih Action     : ");
            pilihan = br.readLine();

            switch (pilihan) {
                case "1":
                    editMahasiswa();
                    break;
                case "2":
                    removeMahasiswa();
                    break;
            }

            } catch (Exception e){
            System.out.println("error Menu Tambah Absensi: "+e);
        }
    }


    // Method removeMahasiswa
    private static void removeMahasiswa(){
        int id;
        try{
            // Insialisasi BufferedReADER
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Silahkan Masukan Id Mahasiswa: ");
            id = Integer.parseInt(br.readLine());
            for (int i=0;i<dataMahasiswa.size();i++){ //Looping cari data target
                if (dataMahasiswa.get(i).getId()==id){
                    dataMahasiswa.remove(i); //Remove data target
                    System.out.println("data Berhasil Dihapus!!!");
                    showMenu();
                }
            }

        } catch (Exception e){
            System.out.println("Error Menu removeMahasiswa: "+e);
        }
    }
    

    // Method EditMahasiswaa
    private static void editMahasiswa(){
        int id;
        String nama="";
      
        try{
            // Inisialsisasi BufferedReader yang berparameterkan InputStreamReADER
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Masukan Id Mahasiswa yang akan di Edit : ");
            id = Integer.parseInt(br.readLine());
            for (int i=0;i<dataMahasiswa.size();i++){ //Looping untuk Mencari data yang dicari / data target edit
                if (dataMahasiswa.get(i).getId()==id){
                    System.out.println("Nama : "+ dataMahasiswa.get(i).getNama());
                    System.out.println();
                    System.out.print("Ubah Nama            : ");
                    nama = br.readLine(); // input set nama
                    System.out.print("Nilai Bahasa Inggris : ");
                    Double bing = Double.parseDouble(br.readLine());
                    System.out.print("Nilai Fisika         : ");
                    Double fisika = Double.parseDouble(br.readLine());
                    System.out.print("Nilai Algoritma      : ");
                    Double algo = Double.parseDouble(br.readLine());
                    Mahasiswa mhs = new Mahasiswa(id, nama, fisika, bing, algo);
                    mhs.setId(id);
                    mhs.setNama(nama);
                    dataMahasiswa.set(i,mhs); // Set dataMahasiswa
                    System.out.println("Berhasil Edit!");
                    showMenu();
                }
            }
        } catch (Exception e){
            System.out.println("error edit mahasiswa: "+e);
        }
    }

   
    // Sorting Mahasiswa
    public static void bubbleSort(ArrayList<Mahasiswa> list)
    {
        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < list.size() - 1; j++)
            {
                if (list.get(j).compareTo(list.get(j + 1)) > 0)
                {
                    Collections.swap(list, j, j + 1);
                }
            }
    }

}
