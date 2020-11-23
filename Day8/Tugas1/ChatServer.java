import java.net.*;  
import java.io.*;  
import java.util.Properties;

public class ChatServer{  
    public static void main(String args[])throws Exception{  

        try {

           String fileConfig = args[0];

            // Config
            Properties prop = new Properties();
            // load a properties file
            prop.load(new FileInputStream(fileConfig));
            // prop.load(new FileInputStream("config.properties"));

            //Buat Socket
            ServerSocket ss = new ServerSocket(Integer.parseInt(prop.getProperty("port")));  
            Socket s = ss.accept();  
            System.out.println("Berhasil Terhubung : " + prop.getProperty("server") + "/" + prop.getProperty("port"));
            DataInputStream dis = new DataInputStream(s.getInputStream());  
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());  
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
            
            String kataClient="";
            String kataServer="";  
            while(!kataClient.toLowerCase().equals("exit")){  
                kataServer=br.readLine();  
                dout.writeUTF(kataServer);  
                dout.flush();  
                kataClient=dis.readUTF();  
                System.out.println("Dari Client =:=> "+kataClient);  
            }  
            dis.close();  
            s.close();  
            ss.close();  

        } catch (Exception e) {
            System.out.println("Error on Chat Client: " +e);
        }
    
    }
}  