// Abstraction
public abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void pressOn();
    public abstract void pressOff();
    public abstract void checkStatus();
}
