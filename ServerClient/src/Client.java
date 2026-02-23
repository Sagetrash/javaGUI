import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // connect to server
            Socket socket = new Socket("localhost", 8123);
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            pw.println("hello from ayush");
            socket.close();
            pw.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
