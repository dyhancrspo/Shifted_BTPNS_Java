import java.io.*;

public class InputAndOutput {
        public static void main(String args[]){
            try{
                // Outpuyt
                FileOutputStream fout = new FileOutputStream(args[0]);
                String t = args[1];
                byte c[] = t.getBytes();
                fout.write(c);
                fout.close();
   
                // Input
                FileInputStream fin=new FileInputStream(args[0]);
                int i=0;
                while((i=fin.read())!=-1){
                    System.out.print((char)i);
                }
                fin.close();

            } catch (Exception e) {
                System.out.println(e);
            }
    }
}
    
