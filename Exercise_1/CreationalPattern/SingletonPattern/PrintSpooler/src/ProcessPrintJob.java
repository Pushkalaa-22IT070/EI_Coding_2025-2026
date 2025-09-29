public class ProcessPrintJob implements Command {
    private PrinterSpooler spooler;

    public ProcessPrintJob(PrinterSpooler spooler) {
        this.spooler = spooler;
    }

    @Override
    public void execute() {
        spooler.processJob();
    }
}
