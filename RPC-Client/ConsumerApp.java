

public class ConsumerApp {
    
    public static void main(String[] args) {
        CapitalizerAndTimeWorker worker = new CapitalizerAndTimeWorkerImpl();
        worker.sendString();
    }
}
