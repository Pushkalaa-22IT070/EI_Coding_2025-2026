import java.util.LinkedList;
import java.util.Queue;

public class PrinterSpooler {
    private static PrinterSpooler instance;
    private Queue<String> jobs = new LinkedList<>();

    private PrinterSpooler() {}
    public static synchronized PrinterSpooler getInstance() {
        if (instance == null) {
            instance = new PrinterSpooler();
        }
        return instance;
    }

    public void addJob(String document) {
        jobs.add(document);
        System.out.println("Added: " + document);
    }

    public void processJob() {
        if (jobs.isEmpty()) {
            System.out.println("No jobs in queue!");
        } else {
            String doc = jobs.poll();
            System.out.println("Printing: " + doc);
        }
    }
}
