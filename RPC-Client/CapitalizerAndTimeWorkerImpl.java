import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CapitalizerAndTimeWorkerImpl implements CapitalizerAndTimeWorker {
    public static final int PORT = 9090;

    private RpcRequest generateRequest(String  input) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setInput(input);
        return rpcRequest;
    }

    public void sendString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter IP address: ");
        String host = scanner.nextLine();
        try (Socket socket = new Socket(host, PORT)) {
            String textInput;
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            do {
                System.out.println("Please enter an input: ");
                textInput = scanner.nextLine();
                System.out.println("GENERANDO REQUEST");
                RpcRequest rpcRequest = generateRequest(textInput);
                System.out.println(rpcRequest);
                System.out.println("LLEVANDO ENVIANDO AL SERVER REQUEST");
                objectOutputStream.writeObject(rpcRequest);
                System.out.println("RECIBIENDO RESPUESTA");
                Object response = objectInputStream.readObject();
                if (response instanceof String) {
                    System.out.println("ES UN STRING");
                    System.out.println(response);
                } else {
                    System.out.println("TIRANDO ERROR");
                    throw new InternalError();
                }
            } while (!textInput.isEmpty());
           scanner.close();
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + host + " error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
