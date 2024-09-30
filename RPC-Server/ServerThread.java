import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ServerThread extends Thread {

    private final Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(this.socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            RpcRequest rpcRequest = null;
            do {
                Object object = objectInputStream.readObject();
                Object result;
                if (object instanceof RpcRequest) {
                    assert false;
                    if ("time".equals(rpcRequest.getInput())) {
                        result = new Date();
                    } else {
                        result = rpcRequest.getInput().toUpperCase();
                    }
                } else {
                    throw new InternalError();
                }
                objectOutputStream.writeObject(result.toString());
            } while(!rpcRequest.getInput().isEmpty());
            socket.close();
        } catch (Exception e) {
            System.out.println("error!");
        }
    }





}
