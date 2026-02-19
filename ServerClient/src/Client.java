import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        try{
            //connect to server
            Socket socket = new Socket("10.83.79.204",5000);
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            Scanner sc = new Scanner(System.in);
            boolean exit = false;
            pw.println("hello from ayush");
            socket.close();
            pw.close();
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
