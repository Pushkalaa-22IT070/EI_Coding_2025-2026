import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        CarClient client = new CarClient(factory);
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Car Factory!");
        System.out.println("Available Cars: Sedan | SUV | Truck");
        System.out.println("Variants: Base | Mid | Top");
        System.out.println("Type 'exit' to quit.\n");

        System.out.print("Enter the car type you want: ");
        String type = sc.nextLine();

        if (type.equalsIgnoreCase("exit")) {
            System.out.println("Thanks for visiting Car Factory. Drive Safe!");
        } else {
            System.out.print("Enter the variant (Base/Mid/Top): ");
            String variant = sc.nextLine();

            client.orderCar(type, variant);
        }

        sc.close();
    }
}
