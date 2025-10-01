public class CarClient {
    private CarFactory factory;

    public CarClient(CarFactory factory) {
        this.factory = factory;
    }

    public void orderCar(String type, String variant) {
        Car car = factory.getCar(type);
        if (car != null) {
            System.out.println("\nCar Created: " + type.toUpperCase() + " (" + variant.toUpperCase() + ")");
            car.drive();
            car.specs(variant);
        } else {
            System.out.println("\nSorry! '" + type + "' is not available in our factory.");
        }
    }
}
