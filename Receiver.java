import java.net.*;
import java.io.*;

/**
 * Receiver
 */
public class Receiver {

    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(7800);
        System.out.print("Server created");
        String msg;
        while (true) {
            System.out.println("Waiting for conenction....");
            Socket receive = s.accept();
            System.out.println("Connection received");
            InputStreamReader isr = new InputStreamReader(receive.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            msg = br.readLine();
            if(msg.equals("clip001")){
                    msg = br.readLine();
                    ProcessBuilder p = new ProcessBuilder("cmd","/c","echo|set/p="+msg+"|clip");
                    Process pi = p.start();
            }
            else{

                System.out.println("Android :" + msg);
            }
            
           
         
        }

    }

}