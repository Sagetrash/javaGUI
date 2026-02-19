import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkInfo {
    public static void main(String[] args) {
        try {
            
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("--- Localhost Details ---");
            System.out.println("Host Name: " + localHost.getHostName());
            System.out.println("IP Address: " + localHost.getHostAddress());

            
            String website = "www.google.com";
            InetAddress webAddress = InetAddress.getByName(website);
            System.out.println("\n--- Website Details ---");
            System.out.println("Target: " + website);
            System.out.println("Resolved Host Name: " + webAddress.getHostName());
            System.out.println("Resolved IP Address: " + webAddress.getHostAddress());

        } catch (UnknownHostException e) {
            System.err.println("Could not find the host: " + e.getMessage());
        }
    }
}
