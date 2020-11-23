import java.io.*;

public class NewInputOutput {  
    public static void main(String args[]){
        try{
            // Outpuyt
            FileOutputStream fout = new FileOutputStream("mahasiswaku.txt");
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            Mahasiswa[] mhs = {
                new Mahasiswa(1234567, "Aturn", 90),
                new Mahasiswa(7654321, "Kasdullah", 75),
                new Mahasiswa(4321765, "Mandra", 75)
            };
            for (int i = 0; i < mhs.length; i++) {
               String s =  mhs[i].getId() + " - " + mhs[i].getNama() +" - "+ mhs[i].getNilai() + "\n";
               byte b[] = s.getBytes();
               bout.write(b);
            }
            bout.flush();
            bout.close();
            fout.close();

            // Input
            FileInputStream fin = new FileInputStream("mahasiswaku.txt");
            BufferedInputStream bin =new BufferedInputStream(fin);
            int i;
            while( ( i = bin.read() ) !=-1 ){
                System.out.print((char)i);
            }
            bin.close();
            fin.close();    

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

        