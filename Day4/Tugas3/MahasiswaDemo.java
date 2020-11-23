import java.util.*;
import java.io.*;

public class MahasiswaDemo {
    static ArrayList<Mahasiswa> dataMhs = new ArrayList<Mahasiswa>(); //ArrayList Mahasiswa
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        showMenu(); // Invoke method ShowMenu
        String menu="";  //inisialsiasi var menu
        try {
            while (!menu.equals("6")){
                System.out.println("Pilih Menu yang tersedai : ");
                menu = br.readLine(); // Scanner menu
                switch (menu){ //switch berdasarkan  scanner menu
                    case "1":
                        addMahasiswa(); // invoke method addMahasiswa
                        break;
                    case "2":
                        editMahasiswa(); //invoke method editMahasiswa
                        break;
                    case "3":
                        removeMahasiswa(); //invoke method removeMahassiaswa
                        break;
                    case "4":
                        readMahasiswa(); //invoke method raedMhasasiswa
                        break;
                    case "5":
                        exportMahasiswa(); // Invoke method expportMahasiswa
                        break;
                }
            }
        } catch (Exception e){
            System.out.println("Error on showMENU: "+e);
        }
        
    }

    // Method ShowMenu 
    private static void showMenu(){
        System.out.println("Menu");
        System.out.println("1. Tambah Data Mahasiswa");
        System.out.println("2. Edit Data Mahasiswa");
        System.out.println("3. Hapus Data Mahasiswa");
        System.out.println("4. Tampilkan Data Mahasiswa");
        System.out.println("5. Export Data ke File .txt ");
        System.out.println("6. Keluar");
    }

    private static void addMahasiswa(){
        String id="";  // inisialisasi variabel awal id
        String nama=""; // inisialisasi variabel awal nama
        String nilai=""; // inisialisasi variabel awal nulai
        try {
            // Inisialisasi BufferedReader yang mempunyai params InputsStreamReader
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Masukan Id          : ");
            id = br.readLine(); //Scanner id
                for (int i=0;i<dataMhs.size();i++){
                    if (dataMhs.get(i).getId()==Integer.parseInt(id)){
                        System.out.println("Maaf, id sudah terdaftar pada sisyem");
                        System.out.println("Mohon Masukan Id lainnya: ");
                        id=br.readLine();
                    }
                }
            System.out.print("Masukan Nama        : ");
            nama = br.readLine(); //Scanner nama
            System.out.print("Masukan Nilai       : ");
            nilai = br.readLine(); //Scanner nilai
            Mahasiswa mhs = new Mahasiswa(); //Object Constructor mahasiswa
            mhs.setId(Integer.parseInt(id));  //set id berdasarkan value dari scanner
            mhs.setNama(nama); //set nama berdasarkan value dari scanner
            mhs.setNilai(Integer.parseInt(nilai)); //set nilai berdasarkan value dari scanner
            dataMhs.add(mhs); //Assign mhs kedalam arraylist dataMhs
            System.out.println("Success Add!!");
            showMenu(); //Invoke method showMenu 
        } catch (Exception e){
            System.out.println("Error on addMahasiswa: "+e);
            showMenu();
        }
    }


// Method editMahasiswas
    private static void editMahasiswa(){
        String id=""; //inisialisasi variabel awal
        String nama=""; //inisialisasi variabel awal
        String nilai=""; //inisialisasi variabel awal
        try{
            //Inisialisasi BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Masukan Id Mahasiswa yang akan di Edit : ");
            id = br.readLine(); // Scanner 
            for (int i = 0; i < dataMhs.size(); i++){ //Looping untuk mencari data target
                if (dataMhs.get(i).getId() == Integer.parseInt(id)){ // Cek kondisi target
                    System.out.println("Nama : "+ dataMhs.get(i).getNama()); // tampilkan data target
                    System.out.println("Nilai : "+ dataMhs.get(i).getNilai()); // tampilka data target
                    System.out.println();
                    System.out.print("Ubah Nama: ");
                    nama = br.readLine(); //Scanner nama
                    System.out.print("Ubah Nilai: ");
                    nilai = br.readLine(); //Scanner nama
                    Mahasiswa mhs = new Mahasiswa();
                    mhs.setId(Integer.parseInt(id)); 
                    mhs.setNama(nama); // Set state nama menjadi state nama baru, sesuai value scanner nama
                    mhs.setNilai(Integer.parseInt(nilai)); //Set state nilai menjadi state nilai baru, sesuai scanner nilai
                    dataMhs.set(i,mhs); // Set state baru kedalam arraylist
                    System.out.println("Berhasil mengubah!");
                    showMenu();
                }
            }
        } catch (Exception e){
            System.out.println("error editMahasiswa : "+ e);
        }
    }

// Method removeMahasiswa
    private static void removeMahasiswa(){
        String id=""; //inisialisasi id awal
        try{
            //BufferedReader berparameterkan InputStreamReader
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Masukan Id Mahasiswa yang akan di Hapus: ");
            id = br.readLine(); //Scanner
            for (int i=0;i < dataMhs.size(); i++){ //Looping mencari data target
                if (dataMhs.get(i).getId()==Integer.parseInt(id)){ //cek data target
                    dataMhs.remove(i); // remove data target
                    System.out.println("Data Terhapus!");
                    showMenu(); // invoke method showmenu
                }
            }
        } catch (Exception e){
            System.out.println("Error on removeMahasiswa: "+e);
        }
    }

//Method BUBBLESORT
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
// Method readMahasiswa
    private static void readMahasiswa(){
        bubbleSort(dataMhs); //Invoke method bubblesort, untuk mengurutkan arraylist dataMhs
        try {
            int i=1;
            for (Mahasiswa obj: dataMhs) { //Looping 
                System.out.println("No : "+i+"\nID : "+obj.getId()+"\nNama : "+obj.getNama()+"\nNilai : "+obj.getNilai()+"\n\n");
                i++;
            }
            showMenu();
        } catch (Exception e) {
            System.out.println("Error on readMahasiwa: "+e);
        } 
    }
    private static void exportMahasiswa(){
        try {
            FileWriter wr=new FileWriter("Mahasiswa.txt");
            BufferedWriter bw = new BufferedWriter(wr);
            for (Mahasiswa obj: dataMhs) { //Looping arrayList
                bw.write("ID : "+obj.getId()+"\nNama : "+obj.getNama()+"\nNilai : "+obj.getNilai()+"\n\n");
            }
            bw.close();
            System.out.println("Sukses!!");
            showMenu();
        } catch (Exception e) {
            System.out.println("Error on exportMahasiswa: "+e);
        }
    }
}
