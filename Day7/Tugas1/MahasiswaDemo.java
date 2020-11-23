import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class MahasiswaDemo {
     static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<Mahasiswa>(); //ArrayList Mahasiswa
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        boolean isLogin = false;
        

    //Login
        try {
            String username = "";
            String password = "";

            System.out.println("Login Form");
            System.out.print("Masukan Username  : ");
            username = br.readLine();
            boolean isRegex = Pattern.matches("^(.+)@(.+)$", username);
            // System.out.println("isRegex : " + isRegex);
            if(isRegex == true) {
                System.out.print("Masukan Password  : ");
                password = br.readLine();
            } else {
                System.out.println("Format username salah, mohon masukkan username lagi !!");
                System.out.print("Masukan Username  : ");
                username = br.readLine();
                System.out.print("Masukan Password  : ");
                password = br.readLine();
            }        

        // Reader
            String usernameLog = "";
            String passwordLog = "";

            BufferedReader brUsername = new BufferedReader(new FileReader("username.txt"));   
            BufferedReader brPassword = new BufferedReader(new FileReader("password.txt"));   
            int i;
            while((i = brUsername.read()) !=-1 ){
                usernameLog +=(char)i;
            }
            while((i = brPassword.read()) !=-1 ){
                passwordLog +=(char)i;
            }

            //Login Validation
            if(usernameLog.equals(username) && passwordLog.equals(password)) {
                isLogin = true;
                System.out.println("Login Berhasil \n\n");
            } else {
                System.out.println("Email atau Password salah");
            }
        brPassword.close();
        brUsername.close();
        
        //Main Menu
            if(isLogin == true) {
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
                                readMahasiswa(); //invoke method removeMahassiaswa
                                break;
                        }
                    }
                } catch (Exception e){
                    System.out.println("Error Menu: "+e);
                }
            } else {
                System.out.println("Harap Login telebih dahulu");
            }
    } catch (Exception e){
        System.out.println("Error Main: "+e);
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
                    System.out.println("data Berhasil Diedit!!!");
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

    // Read Mahasiswa
    private static void readMahasiswa(){
        bubbleSort(dataMahasiswa);
        try {
            int i=1;
            String leftAlignFormat = "| %-4d | %-4d | %-15s | %-6.02f | %-10.02f | %-10.02f |%n"; //Inisialisasi Format Table
            System.out.format("+------------------------------------------------------------------+%n");
            System.out.format("| No   | Id   | Nama            | Fisika | B.Inggris  | Algoritma  |%n");
            System.out.format("+------------------------------------------------------------------+%n");
            for (Mahasiswa obj: dataMahasiswa) { //Looping Data Mahasiswa
                System.out.format(leftAlignFormat, i , obj.getId(),obj.getNama(),obj.getNilai().get(0),obj.getNilai().get(1),obj.getNilai().get(2));
                i++;
            }
            System.out.format("+-------------------------------------------------------------------+%n");
            showMenu();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}
