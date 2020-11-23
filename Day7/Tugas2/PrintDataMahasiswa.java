import java.util.*;

public class PrintDataMahasiswa extends Thread {
    public ArrayList<Mahasiswa> dataMahasiswa;
    public PrintDataMahasiswa(ArrayList<Mahasiswa> dataMahasiswa){
        this.dataMahasiswa = dataMahasiswa;
    }
    
    
        // Read Mahasiswa
        public void run(){
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
            } catch (Exception e) {
                System.out.println(e);
            } 
        }

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
