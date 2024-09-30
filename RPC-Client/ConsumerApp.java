import java.io.IOException;
import java.util.Scanner;

public class ConsumerApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter IP address: ");
        String host = scanner.nextLine();
        CapitalizerAndTimeWorker worker = new CapitalizerAndTimeWorkerImpl();
        worker.sendString(host);
    }
}
