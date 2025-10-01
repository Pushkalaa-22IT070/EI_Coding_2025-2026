public class AddPrintJob implements Command {
    private PrinterSpooler spooler;
    private String document;

    public AddPrintJob(PrinterSpooler spooler, String document) {
        this.spooler = spooler;
        this.document = document;
    }

    @Override
    public void execute() {
        spooler.addJob(document);
    }
}
