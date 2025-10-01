import java.util.LinkedList;
import java.util.Queue;

public class PrinterSpooler {
    private static PrinterSpooler instance;
    private Queue<String> jobs = new LinkedList<>();

    private PrinterSpooler() {}

    // Singleton instance
    public static synchronized PrinterSpooler getInstance() {
        if (instance == null) {
            instance = new PrinterSpooler();
        }
        return instance;
    }

    public void addJob(String document) {
        jobs.add(document);
        System.out.println("Added to spooler: " + document);
    }

    // process all jobs at once
    public void processAllJobs() {
        if (jobs.isEmpty()) {
            System.out.println("No jobs in the queue!");
        } else {
            System.out.println("Processing all jobs...");
            while (!jobs.isEmpty()) {
                String doc = jobs.poll();
                System.out.println("   Printing: " + doc);
            }
            System.out.println("All jobs completed!");
        }
    }
}
