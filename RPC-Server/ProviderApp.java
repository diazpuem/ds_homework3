import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ProviderApp {

    public static void main(String[] args) throws IOException {
        new ProviderApp().begin();
    }

    private void begin() throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        System.out.println("The Server is running");
        while (true) {
            Socket socket = listener.accept();
            try {
                new ServerThread(socket).start();
            } catch (Exception e) {
            	System.out.println("error!");
            } 
        }
    } 
}
