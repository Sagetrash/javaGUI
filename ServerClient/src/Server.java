import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(8123);
            System.out.println("waiting for connection");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = br.readLine();
            System.out.println("Message from Client: " + message);
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
