// Refined Abstraction
public class AdvancedRemote extends RemoteControl {

    public AdvancedRemote(Device device) {
        super(device);
    }

    public void pressOn() {
        System.out.print("[Remote] Turning ON -> ");
        device.turnOn();
    }

    public void pressOff() {
        System.out.print("[Remote] Turning OFF -> ");
        device.turnOff();
    }

    public void checkStatus() {
        device.showStatus();
    }
}
