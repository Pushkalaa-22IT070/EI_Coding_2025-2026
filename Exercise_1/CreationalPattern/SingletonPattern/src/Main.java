import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrinterSpooler spooler = PrinterSpooler.getInstance();
        PrinterInvoker invoker = new PrinterInvoker();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n Printer Spooler Menu ");
            System.out.println("1. Add Print Job");
            System.out.println("2. Process All Print Jobs");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter document name: ");
                    String doc = scanner.nextLine();
                    invoker.setCommand(new AddPrintJob(spooler, doc));
                    invoker.executeCommand();
                    break;

                case 2:
                    invoker.setCommand(new ProcessPrintJob(spooler));
                    invoker.executeCommand();
                    break;

                case 3:
                    System.out.println("Exiting Printer Spooler...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
