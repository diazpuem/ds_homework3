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
        int numberOfClients = 0;
        while (true) {
            Socket socket = listener.accept();
            try {
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println("Hello you are client #" + ++numberOfClients);
                new ServerThread(socket).start();
            } catch (Exception e) {
            	System.out.println("error!");
            } 
        }
    } 
}
