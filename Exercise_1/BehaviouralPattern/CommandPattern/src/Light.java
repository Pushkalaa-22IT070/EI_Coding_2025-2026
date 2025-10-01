public class Light {
    private boolean isOn = false;

    public void turnOn() {
        if (isOn) {
            System.out.println("Light is already ON");
        } else {
            isOn = true;
            System.out.println("The light is ON");
        }
    }

    public void turnOff() {
        if (!isOn) {
            System.out.println("Light is already OFF");
        } else {
            isOn = false;
            System.out.println("The light is OFF");
        }
    }
}
