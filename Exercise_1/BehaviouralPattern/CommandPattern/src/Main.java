import java.util.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final Scanner sc = new Scanner(System.in);

    private static final Light light = new Light();
    private static final LightSwitchInvoker invoker = new LightSwitchInvoker();

    private static final Map<Integer, Command> options = new HashMap<>();

    public static void main(String[] args) {
        options.put(1, new LightOnCommand(light));
        options.put(2, new LightOffCommand(light));

        logger.info("Program started.");
        showMenu();
    }

    private static void showMenu() {
        System.out.println("\n=== Light Switch ===");
        System.out.println("1. Turn ON");
        System.out.println("2. Turn OFF");
        System.out.println("3. Exit");
        System.out.print("Choose: ");

        try {
            int choice = Integer.parseInt(sc.nextLine().trim());

            if (choice == 3) {
                System.out.println("Exiting...");
                logger.info("User exited program.");
                sc.close();
                return;
            }

            Command cmd = options.get(choice);
            if (cmd != null) {
                invoker.setCommand(cmd);
                invoker.pressButton();
            } else {
                System.out.println("Invalid choice.");
            }

            showMenu(); // recursion

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number (1-3).");
            showMenu(); // try again
        }
    }
}
