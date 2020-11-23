import java.net.*;  
import java.io.*;  
import java.util.Properties;
import java.util.regex.Pattern;


public class ProgramClient{  

    public static Socket s;
    public static ServerSocket ss;
    public static DataOutputStream dout;
    public static DataInputStream dis;
    public static boolean isLogin = false;
    public static BufferedReader brLogin = new BufferedReader(new InputStreamReader(System.in)); 


    public static void main(String args[])throws Exception{  
        
        try {
            String fileConfig = args[0];
           // Config
            Properties prop = new Properties();
            // load a properties file
            prop.load(new FileInputStream(fileConfig));
           
            //Login
            while(isLogin != true) {
            System.out.println("Login Form");
            System.out.print("Masukan Username  : ");
            String username = brLogin.readLine();
            System.out.print("Masukkan Password : ");
            String password = brLogin.readLine();
            try {
                doLogin(username, password);
                if(isLogin) {
                    System.out.println("Menunggu terhubung ke Server...");
                    showMenu();
                } else {
                    System.out.println("Gagal Login");
                }
            } catch (Exception e) {
                System.out.println("Error Login : " + e);
            }
        }
  
            if (isLogin == true) {   
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
                String menu="";  // deklarasi variabel menu untuk case
                try {
                    while (!menu.equals("4")){
                        System.out.println("Pilih Menu yang tersedia : ");
                        menu = br.readLine(); // nilai variabel menu diisi berdasarkan nilai line yang diinput
                        switch (menu){ //switch menu
                            case "1":
                                connectSocket(prop);
                                showMenu();
                                break;
                            case "2":
                                System.out.print("Masukkan Nama File : ");
                                String file = br.readLine();
                                sendingData(file);
                                showMenu();
                                break;
                            case "3":
                                closeSocket(s);
                                showMenu();
                                break;
                        }
                    }
                } catch (Exception e){
                    System.out.println("Error Login at Menu: "+e);
                }
            }  else {
                System.out.println("Gagal terhubung..");
            }
        } catch (Exception e) {
            System.out.println("Error on Main Client: " +e);
        }
    }

	// Show List Menu 
    public static void showMenu(){
        System.out.println("\n");
        System.out.println("Menu");
        System.out.println("1. Connect ke Socket");
        System.out.println("2. Send Data ke Server");
        System.out.println("3. Close Socket");
        System.out.println("4. Keluar");
    }

    // Login Validation
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

    // Connecting Socket to Server
    public static void connectSocket(Properties prop){
        try {
            s = new Socket(prop.getProperty("server"),Integer.parseInt(prop.getProperty("port")));  
            System.out.println("Berhasil Terhubung : " + prop.getProperty("server") + "/" + prop.getProperty("port"));
        } catch (Exception e) {
            System.out.println("Error on Connect Socket : " + e);
        }
    }

    // Closing Connection
    public static void closeSocket(Socket s){
      try {
        s.close();   
        System.out.println("Disconnected..");
      } catch (Exception e) {
          System.out.println("Error on Close Socket : " + e);
      }
    }

    //Sending Data File to Server
    public static void sendingData(String file) {
        String fileData = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int i;
            while((i = br.read()) != -1) {
                fileData += (char) i;
            }
                br.close();
                dis = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                //Writing file data to Server
                dout.writeUTF(String.format(fileData));
                dout.flush();
                //Reading
                System.out.println("waiting the message ...");
                String serverStr = dis.readUTF();
                System.out.println(serverStr);
                //Close
                dis.close();
                dout.close();
                       
        } catch (Exception e) {
            System.out.println("Error on sendingData() : " + e);
        }

    }
}  