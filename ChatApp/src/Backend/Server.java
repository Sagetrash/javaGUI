package Backend;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        int portNumber = 8123;
        boolean listening = true;

        try (ServerSocket server = new ServerSocket(portNumber);) {
            System.out.println("Server is listening on port: " + portNumber);
            while (listening) {
                Socket clientSocket = server.accept();
                System.out.println("Client Connected, ip: " + clientSocket.getRemoteSocketAddress());
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try (
                Socket socket = this.clientSocket;
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received From Client: \n" + inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                System.out.println("Client Disconnected " + clientSocket.getRemoteSocketAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}