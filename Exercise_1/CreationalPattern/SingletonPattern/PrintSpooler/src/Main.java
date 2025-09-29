public class Main {
    public static void main(String[] args) {
        PrinterSpooler spooler = PrinterSpooler.getInstance();
        PrinterInvoker invoker = new PrinterInvoker();

        invoker.setCommand(new AddPrintJob(spooler, "Document1.pdf"));
        invoker.executeCommand();

        invoker.setCommand(new AddPrintJob(spooler, "Report.docx"));
        invoker.executeCommand();

        invoker.setCommand(new AddPrintJob(spooler, "Invoice.xlsx"));
        invoker.executeCommand();

        invoker.setCommand(new ProcessPrintJob(spooler));
        invoker.executeCommand();

        invoker.setCommand(new ProcessPrintJob(spooler));
        invoker.executeCommand();

        invoker.setCommand(new ProcessPrintJob(spooler));
        invoker.executeCommand();

        invoker.setCommand(new ProcessPrintJob(spooler));
        invoker.executeCommand();
    }
}
