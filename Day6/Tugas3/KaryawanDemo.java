import java.util.*;
import java.io.*;

public class KaryawanDemo {
     static ArrayList<Manager> dataManager=new ArrayList<Manager>(); //ArrayList Manager
     static ArrayList<Staff> dataStaff=new ArrayList<Staff>(); //ArrayList Staff
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        showMenu(); // Fungsi ShowMenu
        String menu="";  // deklarasi variabel menu untuk case
        try {
            while (!menu.equals("7")){
                System.out.println("Pilih Menu yang tersedia : ");
                menu = br.readLine(); // nilai variabel menu diisi berdasarkan nilai line yang diinput
                switch (menu){ //switch menu
                    case "1":
                        addKaryawan(); // invoke method addKaryawan
                        break;
                    case "2":
                        addAbsensi(); //invoke method addAbsensi
                        break;
                    case "3":
                        sumTunjanganKaryawan(); //invoke method sumTunjangan
                        break;
                    case "4":
                        sumTotalGajiKaryawan(); //invoke method sumTotalGaji
                        break;
                    case "5":
                        System.out.println("List Staff");
                        readKaryawanStaff(); //invoke method readKaryawanStaff
                        System.out.println("List Manager");
                        readKaryawanManager(); //invoke method readKaryawanManager
                        showMenu();
                        break;
                    case "6":
                        exportKaryawan();
                        break;
                }
            }
        } catch (Exception e){
            System.out.println("Error: "+e);
        }
        
    }

    // ShowMenu 
    private static void showMenu(){
        System.out.println("Menu");
        System.out.println("1. Tambah Data Karyawan");
        System.out.println("2. Absensi Karyawan");
        System.out.println("3. Hitung Tunjangan  per Karyawan");
        System.out.println("4. Hitung Total Gaji per Karyawan");
        System.out.println("5. Tampilkan Data Karyawan");
        System.out.println("6. Export Laporan Data Karyawan dalam bentuk file.txt");
        System.out.println("7. Keluar");
    }
    
    // Create Data Karyawan
    private static void addKaryawan(){
        int id;
        String nama = "";
        int gaji;
        String pilihan = "";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Menu add berdasarkan jabatan ");
            System.out.println("1. Manager ");
            System.out.println("2. Staff ");
            System.out.print("Pilih add jabatan             : ");
            pilihan = br.readLine();

            switch (pilihan) {
                case "1":
                System.out.print("Masukan Id                    : ");
                 id = Integer.parseInt(br.readLine());
                    for (int i=0;i<dataManager.size();i++){
                        if (dataManager.get(i).getId()==id){
                            System.out.println("Maaf, id sudah terdaftar pada sistem");
                            System.out.println("Mohon Masukan Id lainnya: ");
                            id = Integer.parseInt(br.readLine());
                        }
                    }
                System.out.print("Masukan Nama                  : ");
                 nama = br.readLine();
                System.out.print("Masukan Gaji Pokok            : ");
                 gaji = Integer.parseInt(br.readLine());
                Manager manager = new Manager(id, nama, null, gaji);
                manager.setId(id);
                manager.setNama(nama);
                manager.setGaji(gaji);
                // manager.setEntertainment(entertainment);
                dataManager.add(manager);
                System.out.println("Success Add!!");
                showMenu();
                    break;
            
                case "2":
                System.out.print("Masukan Id          : ");
                 id = Integer.parseInt(br.readLine());
                    for (int i=0;i<dataStaff.size();i++){
                        if (dataStaff.get(i).getId()==id){
                            System.out.println("Maaf, id sudah terdaftar pada sistem");
                            System.out.println("Mohon Masukan Id lainnya: ");
                            id = Integer.parseInt(br.readLine());
                        }
                    }
                System.out.print("Masukan Nama        : ");
                 nama = br.readLine();
                System.out.print("Masukan Gaji Pokok  : ");
                 gaji = Integer.parseInt(br.readLine());
                Staff staff = new Staff(id, nama, null, gaji, 0);
                staff.setId(id);
                staff.setNama(nama);
                staff.setGaji(gaji);
                dataStaff.add(staff);
                System.out.println("Success Add!!");
                showMenu();
                    break;
            }

            
        } catch (Exception e){
            System.out.println("Error on addKaryawan: "+e);
            showMenu();
        }
    }

    
    //Tambah Absensi
    private static void addAbsensi(){
        int id;
        String pilihan = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Menu add berdasarkan jabatan ");
            System.out.println("1. Manager ");
            System.out.println("2. Staff ");
            System.out.print("Pilih jabatan                     : ");
            pilihan = br.readLine();
            System.out.print("Masukan Id Karyawan untuk Absensi : ");
            id = Integer.parseInt(br.readLine());

            switch (pilihan) {
                case "1":
                    for (int i = 0; i < dataManager.size(); i++) {
                        dataManager.get(i).tambahAbsensi(id);
                    }
                    showMenu();
                    break;
                case "2":
                    for (int i = 0; i < dataStaff.size(); i++) {
                        dataStaff.get(i).tambahAbsensi(id);
                    }
                    showMenu();
                    break;
            }
            
            } catch (Exception e){
            System.out.println("error Menu Tambah Absensi: "+e);
        }
    }

    //Hitung Tunjangan  perKaryawan
    private static void sumTunjanganKaryawan() {
        int id;
        int entertainment;
        String pilihan = "";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Menu add berdasarkan jabatan ");
            System.out.println("1. Manager ");
            System.out.println("2. Staff ");
            System.out.print("Pilih add jabatan             : ");
            pilihan = br.readLine();

            switch (pilihan) {
                case "1":
                System.out.print("Masukan Id                    : ");
                 id = Integer.parseInt(br.readLine());
                System.out.print("Masukan Jumlah Entertainment  : ");
                 entertainment = Integer.parseInt(br.readLine());
                //Looping data target    
                for (int i=0;i<dataManager.size();i++){
                        if (dataManager.get(i).getId()==id){
                            dataManager.get(i).setTunjanganTransport(dataManager.get(i).getAbsensi()); 
                            dataManager.get(i).setTunjanganEntertainment(entertainment); 
                        }
                    }               
                System.out.println("Success Hitung Tunjangan!!");
                showMenu();
                    break;
            
                case "2":
                System.out.print("Masukan Id          : ");
                 id = Integer.parseInt(br.readLine());
                    for (int i=0;i<dataStaff.size();i++){
                        if (dataStaff.get(i).getId()==id){
                            dataStaff.get(i).setTunjanganMakan(dataStaff.get(i).getAbsensi());
                        }
                    }
                System.out.println("Success Hitung Tunjangan!!");
                showMenu();
                    break;
            }

        } catch (Exception e){
            System.out.println("Error on sumTunjanganKaryawan: "+e);
            showMenu();
        }
    }
    
    //Hitung Total Gaji perKaryawan
    private static void sumTotalGajiKaryawan() {
        int id;
        String pilihan = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Menu add berdasarkan jabatan ");
            System.out.println("1. Manager ");
            System.out.println("2. Staff ");
            System.out.print("Pilih jabatan                 : ");

            pilihan = br.readLine();

            switch (pilihan) {
                case "1":
                System.out.print("Masukan Id                    : ");
                 id = Integer.parseInt(br.readLine());
                //Looping data target    
                for (int i=0;i<dataManager.size();i++){
                        if (dataManager.get(i).getId()==id){
                            dataManager.get(i).setTotalGaji(dataManager.get(i).getGaji(),dataManager.get(i).getTunjanganTransport(),dataManager.get(i).getTunjanganEntertainment()); 
                        }
                    }               
                System.out.println("Success Hitung!!");
                showMenu();
                    break;
            
                case "2":
                System.out.print("Masukan Id          : ");
                 id = Integer.parseInt(br.readLine());
                    for (int i=0;i<dataStaff.size();i++){
                        if (dataStaff.get(i).getId()==id){
                            dataStaff.get(i).setTotalGaji(dataStaff.get(i).getGaji(),dataStaff.get(i).getTunjanganMakan());
                        }
                    }
                System.out.println("Success Hitung!!");
                showMenu();
                    break;
            }

        } catch (Exception e){
            System.out.println("Error on sumTotalGaji: "+e);
            showMenu();
        }
    }
   
    public static void bubbleSortManager(ArrayList<Manager> list)
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

    // Tampilkan Data Karyawan Staff
    private static void readKaryawanManager(){
        bubbleSortStaff(dataStaff);
        try {
            int i=1;
            String leftAlignFormat = "| %-4d | %-4d | %-15s | %-11s | %-7d  | %-10d  | %-10d  | %-12d  | %-10d  |%n"; //Inisialisasi Format Table
            System.out.format("+-----------------------------------------------------------------------------------------------------------------+%n");
            System.out.format("| No   | Id   | Nama            | Jabatan     | Absensi  | Gaji Pokok  | Transport  | Entertainment | Total Gaji  | %n");
            System.out.format("+-----------------------------------------------------------------------------------------------------------------+%n");
            for (Manager obj: dataManager) { //Looping Data Manager
                System.out.format(leftAlignFormat, i , obj.getId(),obj.getNama(),obj.getJabatan(),obj.getAbsensi(),obj.getGaji(),obj.getTunjanganTransport(),obj.getTunjanganEntertainment(),obj.getTotalGaji());
                i++;
            }
            System.out.format("+-----------------------------------------------------------------------------------------------------------------+%n");
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    
    public static void bubbleSortStaff(ArrayList<Staff> list)
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

    // Tampilkan Data Karyawan Staff
    private static void readKaryawanStaff(){
        bubbleSortStaff(dataStaff);
        try {
            int i=1;
            String leftAlignFormat = "| %-4d | %-4d | %-15s | %-11s | %-7d  | %-10d  | %-10d  | %-10d  |%n"; //Inisialisasi Format Table
            System.out.format("+--------------------------------------------------------------------------------------------------+%n");
            System.out.format("| No   | Id   | Nama            | Jabatan     | Absensi  | Gaji Pokok  | Uang Makan  | Total Gaji  | %n");
            System.out.format("+--------------------------------------------------------------------------------------------------+%n");
            for (Staff obj: dataStaff) { //Looping Data Staff
                System.out.format(leftAlignFormat, i , obj.getId(),obj.getNama(),obj.getJabatan(),obj.getAbsensi(),obj.getGaji(),obj.getTunjanganMakan(),obj.getTotalGaji());
                i++;
            }
            System.out.format("+--------------------------------------------------------------------------------------------------+%n");
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    //Export ke File .txt
    private static void exportKaryawan(){
        try {
            // Inisialisasi BufferedWriter yg mempunyai parameter fileWriter
            BufferedWriter br = new BufferedWriter(new FileWriter("Karyawan.txt"));
            int i=1;
            String leftAlignFormat = "| %-4d | %-4d | %-10s | %-10s | %-12d |%n";
            br.write(String.format("+------------------------------------------------------+%n"));
            br.write(String.format("| No   | Id   | Nama       | Jabatan    | Total Gaji   |%n"));
            br.write(String.format("+------------------------------------------------------+%n"));
            for (Staff obj: dataStaff) { // Looping Data Staff
                br.write(String.format(leftAlignFormat, i , obj.getId(),obj.getNama(),obj.getJabatan(),obj.getTotalGaji()));
                i++;
            }
            for (Manager obj: dataManager) { // Looping Data Manager
                br.write(String.format(leftAlignFormat, i , obj.getId(),obj.getNama(),obj.getJabatan(),obj.getTotalGaji()));
                i++;
            }
            br.write(String.format("+------------------------------------------------------+%n"));
            br.close();
            System.out.println("Sukses Export file!!");
            showMenu();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
