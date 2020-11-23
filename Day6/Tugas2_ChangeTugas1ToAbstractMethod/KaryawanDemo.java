import java.util.*;
import java.io.*;

public class KaryawanDemo {
     static ArrayList<Staff> dataKaryawan=new ArrayList<Staff>(); //ArrayList Karyawan
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        showMenu(); // Fungsi ShowMenu
        String menu="";  // deklarasi variabel menu untuk case
        try {
            while (!menu.equals("4")){
                System.out.println("Pilih Menu yang tersedai : ");
                menu=br.readLine(); // nilai variabel menu diisi berdasarkan nilai line yang diinput
                switch (menu){ //switch menu
                    case "1":
                        addKaryawan(); // invoke method addKaryawan
                        break;
                    case "2":
                        addAbsensi(); //invoke method editKaryawan
                        break;
                    case "3":
                        readKaryawan(); //invoke method removeMahassiaswa
                        break;
                }
            }
        } catch (Exception e){
            System.out.println("Error: "+e);
        }
        
    }

    // Function 
    private static void showMenu(){
        System.out.println("Menu");
        System.out.println("1. Tambah Data Karyawan");
        System.out.println("2. Absensi Karyawan");
        System.out.println("3. Tampilkan Data Karyawan");
        System.out.println("4. Keluar");
    }

    private static void addKaryawan(){
        int id;
        String nama ="";
        String jabatan = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Masukan Id          : ");
            id = Integer.parseInt(br.readLine());
                for (int i=0;i<dataKaryawan.size();i++){
                    if (dataKaryawan.get(i).getId()==id){
                        System.out.println("Maaf, id sudah terdaftar pada sistem");
                        System.out.println("Mohon Masukan Id lainnya: ");
                        id = Integer.parseInt(br.readLine());
                    }
                }
            System.out.print("Masukan Nama        : ");
            nama = br.readLine();
            System.out.print("Masukan Jabatan     : ");
            jabatan = br.readLine();
            Staff krywn = new Staff(id, nama, 0, jabatan);
            krywn.setId(id);
            krywn.setNama(nama);
            krywn.setJabatan(jabatan);
            dataKaryawan.add(krywn);
            System.out.println("Success Add!!");
            showMenu();
        } catch (Exception e){
            System.out.println("Error on addKaryawan: "+e);
            showMenu();
        }
    }

//Tambah Absensi
private static void addAbsensi(){
        int id;
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Masukan Id Karyawan untuk Absensi : ");
            id = Integer.parseInt(br.readLine());
            for (int i = 0; i < dataKaryawan.size(); i++)
                {
                    dataKaryawan.get(i).tambahAbsensi(id);
                }
                    showMenu();
                
            } catch (Exception e){
            System.out.println("error Menu Tambah Absensi: "+e);
        }
    }

   
    public static void bubbleSort(ArrayList<Staff> list)
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

    private static void readKaryawan(){
        bubbleSort(dataKaryawan);
        try {
            int i=1;
            String leftAlignFormat = "| %-4d | %-4d | %-15s | %-15s | %-7d  |%n"; //Inisialisasi Format Table
            System.out.format("+------------------------------------------------------------+%n");
            System.out.format("| No   | Id   | Nama            | Jabatan         | Absensi  | %n");
            System.out.format("+------------------------------------------------------------+%n");
            for (Staff obj: dataKaryawan) { //Looping Data Karyawan
                System.out.format(leftAlignFormat, i , obj.getId(),obj.getNama(),obj.getJabatan(),obj.getAbsensi());
                i++;
            }
            System.out.format("+------------------------------------------------------------+%n");
            showMenu();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}
