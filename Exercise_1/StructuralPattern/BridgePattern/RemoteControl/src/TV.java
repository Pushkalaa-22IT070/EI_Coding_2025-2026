// Concrete Implementor
public class TV implements Device {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("TV is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("TV is now OFF.");
    }

    public void showStatus() {
        System.out.println("TV status: " + (isOn ? "ON" : "OFF"));
    }
}
