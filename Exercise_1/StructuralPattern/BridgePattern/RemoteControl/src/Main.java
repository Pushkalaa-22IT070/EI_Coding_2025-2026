import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Map of devices
        Map<Integer, Device> devices = new HashMap<>();
        devices.put(1, new TV());
        devices.put(2, new Projector());

        System.out.println("Welcome to Smart Remote System ");
        System.out.println("Choose Device: 1. TV  2. Projector");

        int deviceChoice = sc.nextInt();
        Device device = devices.get(deviceChoice);

        if (device == null) {
            System.out.println("Invalid choice! Exiting...");
            sc.close();
            return;
        }

        RemoteControl remote = new AdvancedRemote(device);

        // Map of actions
        Map<Integer, Runnable> actions = new HashMap<>();
        actions.put(1, () -> remote.pressOn());
        actions.put(2, () -> remote.pressOff());
        actions.put(3, () -> remote.checkStatus());

        System.out.println("Choose Action: 1. Turn ON  2. Turn OFF  3. Check Status");
        int actionChoice = sc.nextInt();

        Runnable action = actions.get(actionChoice);
        if (action != null) action.run();
        else System.out.println("Invalid action!");
        sc.close();
    }
}
