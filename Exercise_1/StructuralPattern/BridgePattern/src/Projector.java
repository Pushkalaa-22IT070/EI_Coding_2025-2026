// Concrete Implementor
public class Projector implements Device {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("Projector is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Projector is now OFF.");
    }

    public void showStatus() {
        System.out.println("Projector status: " + (isOn ? "ON" : "OFF"));
    }
}
