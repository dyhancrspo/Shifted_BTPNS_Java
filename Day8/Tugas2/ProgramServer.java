import java.net.*;  
import java.io.*;  
import java.util.*;
import java.util.regex.Pattern;


public class ProgramServer{  

    public static Socket s;
    public static ServerSocket ss;
    public static DataOutputStream dout;
    public static DataInputStream dis;
    public static boolean isLogin = false;
    public static BufferedReader br;
    public static String strClient="";

    public static void main(String args[]){  
        
        try {
            String fileConfig = args[0];
           // Config
            Properties prop = new Properties();
            // load a properties file
            prop.load(new FileInputStream(fileConfig));
           
            br = new BufferedReader(new InputStreamReader(System.in)); 
            //Login
            while(isLogin != true) {
            System.out.println("Login Form");
            System.out.print("Masukan Username  : ");
            String username = br.readLine();
            System.out.print("Masukkan Password : ");
            String password = br.readLine();
            try {
                doLogin(username, password);
                if(isLogin) {
                    System.out.println("Menunggu terhubung ke Client");
                } else {
                    System.out.println("Gagal Login");
                }
            } catch (Exception e) {
                System.out.println("Error Login : " + e);
            }
        }
      

            if (isLogin == true) {               
                //Buat Socket
                ServerSocket ss = new ServerSocket(Integer.parseInt(prop.getProperty("port")));  
                Socket s = ss.accept();  
                System.out.println("Berhasil Terhubung : " + prop.getProperty("server") + "/" + prop.getProperty("port"));
                dis = new DataInputStream(s.getInputStream());  
                dout = new DataOutputStream(s.getOutputStream());  
                
                //Receive From Client
                String fileData = (String)dis.readUTF();

                //Looping data from Client
                String[] valueData = fileData.split("\n");
                for(String string : valueData) {
                    String[] data = string.split(",");
                    for(int j = 0; j < data.length; j++){
                        if(j==0){
                            System.out.println("Nama          : " +data[j]);
                        } else if (j == 1){
                            System.out.println("Nilai Fisika  : " +data[j]);
                        } else if (j == 2){
                            System.out.println("Nilai Biologi : " +data[j]);
                        } else if (j == 3){
                            System.out.println("Nilai Kimia   : " +data[j]);
                        }
                    }
                }
                //Writing response to Client
                dout.writeUTF("\nDone : Data Processing...");
                ss.close();  
            } else {
                System.out.println("Gagal terhubung..");
            }

        } catch (Exception e) {
            System.out.println("Error on Main Server: " +e);
        }
    }

    // Method for Login Validation
    public static void doLogin(String username, String password) throws Exception { 
        //RegEx Inisialisasi
        boolean isRegexUsername = Pattern.matches("^(.+)@(.+)$", username);
        boolean isRegexPassword = Pattern.matches("^(?=.*[0-9]).{8,}$", password);
        
        if(isRegexUsername == true && isRegexPassword == true) {
            if(username.toLowerCase().equals("malih@gmail.com") && password.equals("Rahasia123.")) {
                isLogin = true;
                System.out.println("Login Berhasil");
            } else {
                System.out.println("Email atau Password salah");
            }
        } else {
            System.out.println("Format salah, mohon masukkan username / password kembali lagi !!");
        }        
    }


}  