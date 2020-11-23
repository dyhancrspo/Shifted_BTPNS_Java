import java.util.*;
import java.io.*;

public class ExportDataMahasiwa extends Thread{
    public ArrayList<Mahasiswa> dataMahasiswa;
    public ExportDataMahasiwa(ArrayList<Mahasiswa> dataMahasiswa){
        this.dataMahasiswa = dataMahasiswa;
    }

    //Export ke File .txt
    public void run(){
        try {
            // Inisialisasi BufferedWriter yg mempunyai parameter fileWriter
            BufferedWriter br = new BufferedWriter(new FileWriter("Mahasiswaku.txt"));
            int i=1;
            String leftAlignFormat = "| %-4d | %-4d | %-15s | %-6.02f | %-10.02f | %-10.02f |%n"; //Inisialisasi Format Table
            br.write(String.format("+------------------------------------------------------------------+%n"));
            br.write(String.format("| No   | Id   | Nama            | Fisika | B.Inggris  | Algoritma  |%n"));
            br.write(String.format("+------------------------------------------------------------------+%n"));
            for (Mahasiswa obj: dataMahasiswa) { //Looping Data Mahasiswa
                br.write(String.format(leftAlignFormat, i , obj.getId(),obj.getNama(),obj.getNilai().get(0),obj.getNilai().get(1),obj.getNilai().get(2)));
                i++;
            }
            br.write(String.format("+-------------------------------------------------------------------+%n"));
            br.close();
            System.out.println("Sukses Export file!!");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

	
    
}
