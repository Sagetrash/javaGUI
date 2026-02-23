package Client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        int portNumber = 8123;
        try (Socket conn = new Socket("localhost", portNumber);
                PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the Message: ");
            out.println(sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
